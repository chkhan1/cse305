package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Customer;

import java.util.stream.IntStream;

import javax.xml.transform.Result;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @param String searchKeyword
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers(String searchKeyword) {
		/*
		 * This method fetches one or more customers based on the searchKeyword and returns it as an ArrayList
		 */
		//System.out.println(searchKeyword);
		List<Customer> customers = new ArrayList<Customer>();
		System.out.println("getCustomer is called String");

		/*
		 * The students code to fetch data from the database based on searchKeyword will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
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
			ResultSet resultSet = myStatement.executeQuery("select * from customer;");
			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println(columnsNumber);
			while(resultSet.next()) {
					int customerSNN = resultSet.getInt("CustomerId");
					String creditCard = resultSet.getString("CreditCardNum");
					int rating = resultSet.getInt("Rating");
					Customer myCustomer = new Customer();
					myCustomer.setCustomerID(Integer.toString(customerSNN));
					myCustomer.setCreditCard(creditCard);
					myCustomer.setRating(rating);
					customers.add(myCustomer);
			}
			
			for(int i=0; i<customers.size(); i++) {
				Customer myCustomer = customers.get(i);
				int customerSNN = Integer.parseInt(myCustomer.getCustomerID());
				ResultSet myPersonTable;
				if(searchKeyword == null) {
					 myPersonTable = myStatement.executeQuery("select * from person where SSN ='"+customerSNN+"';");
				}else {
					 myPersonTable = myStatement.executeQuery("select * from person where (SSN ='"+customerSNN+"' AND firstName LIKE '%"+searchKeyword+"%') OR (SSN ='"+customerSNN+"' AND lastName LIKE '%"+searchKeyword+"%');");
				}
				if(myPersonTable.next()) {
					String lastName = myPersonTable.getString("LastName");
					String firstName = myPersonTable.getString("FirstName");
					String address = myPersonTable.getString("Address");
					String city = myPersonTable.getString("City");
					String state = myPersonTable.getString("State");
					String zipcode = myPersonTable.getString("ZipCode");
					String telephone = myPersonTable.getString("Telephone");
					String email = myPersonTable.getString("Email");
					myCustomer.setFirstName(firstName);
					myCustomer.setLastName(lastName);
					myCustomer.setAddress(address);
					myCustomer.setCity(city);
					myCustomer.setState(state);
					myCustomer.setZipCode(Integer.parseInt(zipcode));
					myCustomer.setTelephone(telephone);
					myCustomer.setEmail(email);
				}
			}
					
			for(int i=0; i<customers.size(); i++) {
				if(customers.get(i).getFirstName() == null) {
					customers.remove(i);
				}
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
		
		return customers;
	}


	public Customer getHighestRevenueCustomer() {
		/*
		 * This method fetches the customer who generated the highest total revenue and returns it
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */


		/*Sample data begins*/
		Customer customer = new Customer();
		customer.setCustomerID("111-11-1111");
		customer.setLastName("Lu");
		customer.setFirstName("Shiyong");
		customer.setEmail("shiyong@cs.sunysb.edu");
		/*Sample data ends*/
	
		return customer;
		
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		
		List<Customer> customers = new ArrayList<Customer>();
		
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
			ResultSet resultSet = myStatement.executeQuery("select * from customer;");
			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println(columnsNumber);
			while(resultSet.next()) {
					int customerSNN = resultSet.getInt("CustomerId");
					String creditCard = resultSet.getString("CreditCardNum");
					int rating = resultSet.getInt("Rating");
					Customer myCustomer = new Customer();
					myCustomer.setCustomerID(Integer.toString(customerSNN));
					myCustomer.setCreditCard(creditCard);
					myCustomer.setRating(rating);
					customers.add(myCustomer);
			}
			
			for(int i=0; i<customers.size(); i++) {
				Customer myCustomer = customers.get(i);
				int customerSNN = Integer.parseInt(myCustomer.getCustomerID());
				ResultSet myPersonTable = myStatement.executeQuery("select * from person where SSN ='"+customerSNN+"';");
				if(myPersonTable.next()) {
					String lastName = myPersonTable.getString("LastName");
					String firstName = myPersonTable.getString("FirstName");
					String address = myPersonTable.getString("Address");
					String city = myPersonTable.getString("City");
					String state = myPersonTable.getString("State");
					String zipcode = myPersonTable.getString("ZipCode");
					String telephone = myPersonTable.getString("Telephone");
					String email = myPersonTable.getString("Email");
					myCustomer.setFirstName(firstName);
					myCustomer.setLastName(lastName);
					myCustomer.setAddress(address);
					myCustomer.setCity(city);
					myCustomer.setState(state);
					myCustomer.setZipCode(Integer.parseInt(zipcode));
					myCustomer.setTelephone(telephone);
					myCustomer.setEmail(email);
				}
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
		
		
			return customers;
	}

	public Customer getCustomer(String customerID) {
		//System.out.println("Search customer is called GETCUSTOMER");

		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		Customer customer = new Customer();
		
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
			int customer1 = Integer.parseInt(customerID);
			ResultSet resultSet = myStatement.executeQuery("select * from customer where CustomerId='"+customer1+"';");
			String creditCardNum = "";
			int rating = 0;
			
			while(resultSet.next()) {
				rating = resultSet.getInt("Rating");
				creditCardNum = resultSet.getString("CreditCardNum");
			}
			resultSet = myStatement.executeQuery("select * from person where ssn='"+customer1+"';");
			while(resultSet.next()) {
				String email = resultSet.getString("email");
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String address = resultSet.getString("Address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("ZipCode");
				String telephone = resultSet.getString("Telephone");
				customer.setEmail(email);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setAddress(address);
				customer.setCity(city);
				customer.setCreditCard(creditCardNum);
				customer.setState(state);
				customer.setZipCode(Integer.parseInt(zipcode));
				customer.setTelephone(telephone);
				customer.setCustomerID(Integer.toString(customer1));
				customer.setRating(rating);
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
		
		return customer;
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
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
			int customerid = Integer.parseInt(customerID);
			String query = " delete from customer WHERE CustomerId = ?";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setInt(1, customerid);
			preparedStmt.execute();
			
			query = " delete from person WHERE ssn = ?";
			preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setInt(1, customerid);
			preparedStmt.execute();
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
		return "success";
		/*Sample data ends*/
		
	}


	public String getCustomerID(String username) {
		
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */
		
		java.sql.Connection myConnection = null;
		String email = "";
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
			ResultSet resultSet = myStatement.executeQuery("select * from person where UserEmail='"+username+"';");
			while(resultSet.next()) {
				email = resultSet.getString("SSN");
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

		return email;
	
	}


	public List<Customer> getSellers() {
		
		/*
		 * This method fetches the all seller details and returns it
		 * The students code to fetch data from the database will be written here
		 * The seller (which is a customer) record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		List<Customer> customers = new ArrayList<Customer>();
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setCustomerID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);			
		}
		/*Sample data ends*/
		
		return customers;

	}


	public String addCustomer(Customer customer, String password, String role) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
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
			int ssn1= Integer.parseInt(customer.getCustomerID());
			String zipcode1 = Integer.toString(customer.getZipCode());
			System.out.println("I am able to connect in customer and store");
			/*
			 myStatement.executeUpdate("insert into person" + "VALUES("+ssn1+", '" +lastName+ "', '" +firstName+ "', '" +address+ "', '" +city+ "', '"+state+"', '" +
					zipcode1+"', '"+telephone+"', '"+email+"', '"+email+"', '"+password+"')");
					*/
			String query = " insert into person (SSN, lastName, firstName, Address, city, state, zipcode, telephone, email, UserEmail, Pass, PersonRole)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			 preparedStmt.setInt(1, ssn1);
			 preparedStmt.setString (2, customer.getLastName());
			 preparedStmt.setString (3, customer.getFirstName());
			 preparedStmt.setString (4, customer.getAddress());
			 preparedStmt.setString (5, customer.getCity());
			 preparedStmt.setString (6, customer.getState());
			 preparedStmt.setString (7, zipcode1);
			 preparedStmt.setString (8, customer.getTelephone());
			 preparedStmt.setString (9, customer.getEmail());
			 preparedStmt.setString (10, customer.getEmail());
			 preparedStmt.setString (11, password);
			 preparedStmt.setString (12, role);
			 preparedStmt.executeUpdate();
			
			System.out.println("person is good");
			myStatement.executeUpdate("insert into customer VALUES("+ssn1+", '"+customer.getCreditCard()+"', "+
			customer.getRating()+")");
			//myStatement.executeUpdate("insert into person VALUES(111111111,'k','k','k','k','k','11111','11','ch@gmail.com','ch@gmail.com','1234')");
			System.out.println("I am able to connect in customer and store");
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
		
		return "success";
		/*Sample data ends*/

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
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
			int ssn1= Integer.parseInt(customer.getCustomerID());
			String zipcode1 = Integer.toString(customer.getZipCode());
			System.out.println("I am able to connect in customer and store");
			/*
			 myStatement.executeUpdate("insert into person" + "VALUES("+ssn1+", '" +lastName+ "', '" +firstName+ "', '" +address+ "', '" +city+ "', '"+state+"', '" +
					zipcode1+"', '"+telephone+"', '"+email+"', '"+email+"', '"+password+"')");
					*/
			String query = " UPDATE person SET lastName = ?, firstName = ?, Address = ?,  city = ?, state = ?, zipcode = ?, telephone = ?, email = ?, UserEmail =? WHERE ssn = ?";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			 preparedStmt.setString (1, customer.getLastName());
			 preparedStmt.setString (2, customer.getFirstName());
			 preparedStmt.setString (3, customer.getAddress());
			 preparedStmt.setString (4, customer.getCity());
			 preparedStmt.setString (5, customer.getState());
			 preparedStmt.setString (6, zipcode1);
			 preparedStmt.setString (7, customer.getTelephone());
			 preparedStmt.setString (8, customer.getEmail());
			 preparedStmt.setString (9, customer.getEmail());
			 preparedStmt.setInt(10, ssn1);
			 preparedStmt.executeUpdate();
			System.out.println("person is good");
			query = " UPDATE customer SET CreditCardNum = ?, Rating = ?  WHERE CustomerId = ?";
			preparedStmt = myConnection.prepareStatement(query);
			int cust = Integer.parseInt(customer.getCustomerID());
			int rating1 = customer.getRating();
			preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setString (1, customer.getCreditCard());
			preparedStmt.setDouble(2, rating1);
			preparedStmt.setInt (3, cust);
			preparedStmt.executeUpdate();
			System.out.println("I am able to connect in customer and update");
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
		
		return "success";

	}

}
