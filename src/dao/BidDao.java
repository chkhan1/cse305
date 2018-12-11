package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Bid;
import model.Customer;

public class BidDao {

	public List<Bid> getBidHistory(String auctionID) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * auctionID, which is the Auction's ID, is given as method parameter
		 * Query to get the bid history of an auction, indicated by auctionID, must be implemented
		 */

		/*Sample data begins*/
		java.sql.Connection myConnection = null;
		try {
			String mysJDBCDriver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/auction_house";
			String userID = "root";
			String password1 = "root";
			
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties mysys = System.getProperties();
			mysys.put("user", userID);
			mysys.put("password", password1);
			myConnection = DriverManager.getConnection(url, mysys);
			Statement myStatement= myConnection.createStatement();
			ResultSet rs = myStatement.executeQuery("select * from bid WHERE AuctionId= '"+Integer.parseInt(auctionID)+"';");
			while(rs.next()) {
				Bid bid = new Bid();
				bid.setAuctionID(rs.getInt("AuctionID"));
				bid.setCustomerID(Integer.toString(rs.getInt("CustomerID")));
				bid.setBidTime(rs.getString("BidTime"));
				bid.setBidPrice((int) rs.getDouble("BidPrice"));
				//bid.setMaxBid(rs.getInt("MaxBid"));
				bids.add(bid);			
			}
			try {
	            myConnection.close();
	        } catch (SQLException e) {
	        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Did not connect or put");
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Sample data ends*/
		
		return bids;
	}

	public List<Bid> getAuctionHistory(String customerID) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * customerID, which is the Customer's ID, is given as method parameter
		 * Query to get the bid history of all the auctions in which a customer participated, indicated by customerID, must be implemented
		 */

		/*Sample data begins*/
		java.sql.Connection myConnection = null;
		try {
			String mysJDBCDriver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/auction_house";
			String userID = "root";
			String password1 = "root";
			
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties mysys = System.getProperties();
			mysys.put("user", userID);
			mysys.put("password", password1);
			myConnection = DriverManager.getConnection(url, mysys);
			Statement myStatement= myConnection.createStatement();
			ResultSet resultSet = myStatement.executeQuery("select * from bid WHERE customerId= '"+Integer.parseInt(customerID)+"';");
			while(resultSet.next()) {
				int auctionId = resultSet.getInt("AuctionId");
				//int customerid = Integer.parseInt(customerID);
				String bidTime = resultSet.getString("BidTime");
				double bidPrice = resultSet.getDouble("BidPrice");
				double maxBid = resultSet.getDouble("MaxBid");
				Bid myBid = new Bid();
				myBid.setAuctionID(auctionId);
				myBid.setCustomerID(customerID);
				myBid.setBidTime(bidTime);
				myBid.setBidPrice((float) bidPrice);
				myBid.setMaxBid((float) maxBid);
				bids.add(myBid);
			}
			
			try {
	            myConnection.close();
	        } catch (SQLException e) {
	        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Did not connect or put");
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Sample data ends*/
		
		return bids;
	}

	public Bid submitBid(String auctionID, String itemID, Float currentBid, Float maxBid, String customerID) {
		
		Bid bid = new Bid();

		/*
		 * The students code to insert data in the database
		 * auctionID, which is the Auction's ID for which the bid is submitted, is given as method parameter
		 * itemID, which is the Item's ID for which the bid is submitted, is given as method parameter
		 * currentBid, which is the Customer's current bid, is given as method parameter
		 * maxBid, which is the Customer's maximum bid for the item, is given as method parameter
		 * customerID, which is the Customer's ID, is given as method parameter
		 * Query to submit a bid by a customer, indicated by customerID, must be implemented
		 * After inserting the bid data, return the bid details encapsulated in "bid" object
		 */

		/*Sample data begins*/
		/*Sample data begins*/
		
		java.sql.Connection myConnection = null;
		try {
			String mysJDBCDriver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/auction_house";
			String userID = "root";
			String password1 = "root";
			
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties mysys = System.getProperties();
			mysys.put("user", userID);
			mysys.put("password", password1);
			myConnection = DriverManager.getConnection(url, mysys);
			Statement myStatement= myConnection.createStatement();
			String query = "insert into bid (CustomerId, AuctionId, BidTime, BidPrice, MaxBid) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(customerID));
			preparedStmt.setInt (2, Integer.parseInt(auctionID));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			//bid.setBidTime(dtf.format(now));
			String time = dtf.format(now);
			preparedStmt.setString (3, time);
			preparedStmt.setDouble (4, (double) maxBid);
			bid.setAuctionID(Integer.parseInt(auctionID));
			bid.setCustomerID(customerID);
			bid.setBidTime(time);
			bid.setBidPrice(currentBid);
			bid.setMaxBid(maxBid);
			preparedStmt.executeUpdate();
			/*
			query = "SELECT B.MaxBid, A.BidIncrement,A.MaxBetValue"
			+" FROM Bid B, Auction A"
			+" WHERE A.MaxBetValue = B.bidprice;";

			ResultSet rs = myStatement.executeQuery(query);
			double maxOfCurrentHigh =0;
			double bidInc = 0;
			double newHigh = 0;
			double maxBet = 0;
			while(rs.next()) {
				maxOfCurrentHigh = rs.getDouble("MaxBid");
				bidInc = rs.getDouble("BidIncrement");
				maxBet = rs.getDouble("MaxBetValue");
				newHigh = maxBet;
			}
			
			if(maxOfCurrentHigh == bid.getMaxBid()){
				newHigh = maxOfCurrentHigh;
			}else if(bid.getMaxBid() > maxBet) {
				
			}else{
				newHigh = maxOfCurrentHigh + bidInc;
			}
			
			query = "UPDATE auction SET MaxBetValue = ? where AuctionId = ?";
			preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setDouble (1, newHigh);
			preparedStmt.setInt (2, Integer.parseInt(auctionID));
			preparedStmt.executeUpdate();
			*/
			try {
	            myConnection.close();
	        } catch (SQLException e) {
	        	
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Did not connect or put");
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bid;
	}

	public List<Bid> getSalesListing(String searchKeyword) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * searchKeyword, which is the search parameter, is given as method parameter
		 * Query to  produce a list of sales by item name or by customer name must be implemented
		 * The item name or the customer name can be searched with the provided searchKeyword
		 */

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Bid bid = new Bid();
			bid.setAuctionID(123);
			bid.setCustomerID("123-12-1234");
			bid.setBidTime("2008-12-11");
			bid.setBidPrice(100);
			bids.add(bid);			
		}
		/*Sample data ends*/
		
		return bids;
	}

}
