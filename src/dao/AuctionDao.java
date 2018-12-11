package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Auction;
import model.Bid;
import model.Customer;
import model.Employee;
import model.Item;

public class AuctionDao {
	
	public List<Auction> getAllAuctions() {
		System.out.println("Code goes here");
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions should be implemented
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
			ResultSet resultSet = myStatement.executeQuery("select * from auction;");
			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println(columnsNumber);
			while(resultSet.next()) {
					int auctionId = resultSet.getInt("AuctionId");
					double minBid = resultSet.getDouble("MinimumBid");
					double bidInc = resultSet.getDouble("BidIncrement");
					int copiesSold = resultSet.getInt("CopiesSold");
					int monitor = resultSet.getInt("Monitor");
					int itemId = resultSet.getInt("ItemId");
					double maxBid = resultSet.getDouble("MaxBetValue");
					double reservePrice = resultSet.getDouble("ReservePrice");
					Auction myAuction = new Auction();
					myAuction.setItemID(itemId);
					myAuction.setMinimumBid((float) minBid);
					myAuction.setBidIncrement((float) bidInc);
					myAuction.setAuctionID(auctionId);
					myAuction.setCopiesSold(copiesSold);
					myAuction.setCurrentHighBid((int) maxBid);
					myAuction.setReserve((int) reservePrice);
					myAuction.setMonitor(monitor);
					auctions.add(myAuction);
					
			}
		
			System.out.println("I am able to connect in customer and print all");
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
		
		return auctions;

	}

	public List<Auction> getAuctions(String customerID) {
		System.out.println("Code goes here");
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions in which a customer participated should be implemented
		 * customerID is the customer's primary key, given as method parameter
		 */
		
		/*Sample data begins*/
		for (int i = 0; i < 5; i++) {
			Auction auction = new Auction();
			auction.setAuctionID(1);
			auction.setBidIncrement(10);
			auction.setMinimumBid(10);
			auction.setCopiesSold(12);
			auction.setItemID(1234);
			auction.setClosingBid(120);
			auction.setCurrentBid(120);
			auction.setCurrentHighBid(120);
			auction.setReserve(10);
			auctions.add(auction);
		}
		/*Sample data ends*/
		
		return auctions;

	}

	public List<Auction> getOpenAuctions(String employeeEmail) {
		List<Auction> auctions = new ArrayList<Auction>();
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the open auctions monitored by a customer representative should be implemented
		 * employeeEmail is the email ID of the customer representative, which is given as method parameter
		 */
		
		/*Sample data begins*/
		AuctionDao myAuction = new AuctionDao();
		auctions = myAuction.getAllAuctions();
		
		/*Sample data ends*/
		//
		return auctions;

		
		
	}

	public String recordSale(String auctionID) {
		/*/
		 * The students code to update data in the database will be written here
		 * Query to record a sale, indicated by the auction ID, should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * The method should return a "success" string if the update is successful, else return "failure"
		 */
		/* Sample data begins */
		System.out.println(auctionID);
		return "success";
		/* Sample data ends */
	}

	public List getAuctionData(String auctionID, String itemID) {
		
		List output = new ArrayList();
		Item item = null;
		Bid bid = null;
		Auction auction = null;
		Customer customer = null;
		List<Auction> auctions = new ArrayList<Auction>();
		List<Item> items = new ArrayList<Item>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The item details are required to be encapsulated as a "Item" class object
		 * The bid details are required to be encapsulated as a "Bid" class object
		 * The auction details are required to be encapsulated as a "Auction" class object
		 * The customer details are required to be encapsulated as a "Customer" class object
		 * Query to get data about auction indicated by auctionID and itemID should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * itemID is the Item's ID, given as method parameter
		 * The customer details must include details about the current winner of the auction
		 * The bid details must include details about the current highest bid
		 * The item details must include details about the item, indicated by itemID
		 * The auction details must include details about the item, indicated by auctionID
		 * All the objects must be added in the "output" list and returned
		 */
		
		/*Sample data begins*/
		
		auctions = getAllAuctions();
		for(int i=0; i<auctions.size(); i++) {
			if(auctions.get(i).getAuctionID() == Integer.parseInt(auctionID)) {
				auction = auctions.get(i);
				break;
			}
		}
		if(auction != null) {
			System.out.println("Auction Found");
			System.out.println(auction.getAuctionID());
		}
		ItemDao myitem = new ItemDao();
		items = myitem.getItems();
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getItemID() == Integer.parseInt(itemID)) {
				item = items.get(i);
				break;
			}
		}
		if(item != null) {
			System.out.println("Item Found");
			System.out.println(item.getItemID());
		}
		
		double maxBetValue = auction.getCurrentHighBid();
		System.out.println(maxBetValue);
		List<Bid> bids = new ArrayList<Bid>();
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
			String query = "SELECT * FROM bid where AuctionId='"+auction.getAuctionID()+"';";
			ResultSet rs = myStatement.executeQuery(query);

			while(rs.next()) {
				Bid myBid = new Bid();
				myBid.setCustomerID(Integer.toString(rs.getInt("CustomerID")));
				myBid.setBidPrice((int) rs.getDouble("BidPrice"));
				bids.add(myBid);
			}
			System.out.println("my bid array is " + bids.size());
			myConnection.close();
			for(int i=0; i<bids.size(); i++) {
				if(maxBetValue <= bids.get(i).getBidPrice()) {
					bid = bids.get(i);
					break;
				}
			}
			if(bid != null) {
				System.out.println("Bid Found");
				System.out.println(bid.getBidPrice());
				System.out.println(bid.getCustomerID());
				CustomerDao myCustomer = new CustomerDao();
				customer = myCustomer.getCustomer(bid.getCustomerID());
			}
			if(customer != null) {
				System.out.println("Customer Found");
			}
			output.add(item);
			output.add(bid);
			output.add(auction);
			output.add(customer);
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*Sample data ends*/
		
		
		return output;

	}

	
}
