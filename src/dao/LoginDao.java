package dao;

import java.sql.*;

import com.sun.corba.se.pept.transport.Connection;

import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
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
			System.out.println("I am able to connect");
			Statement myStatement= myConnection.createStatement();
			ResultSet myresult = myStatement.executeQuery("select * from person where UserEmail='" 
			+ username+"' and Pass='"+password+"'");
			
			if(myresult.next()) {
				Login login = new Login();
				login.setRole(myresult.getString("PersonRole"));
				 try {
			            myConnection.close();
			        } catch (SQLException e) {
			        	
			        }
				return login;
			}else {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Did not connect");
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
		/*Sample data begins*/
		/*Sample data ends*/
		
		System.out.println("Login not successfull");
		return null;
	}
	
	public String addMyUser(String firstName, String lastName, String ssn, String address, String city, String state, String zipcode, String number, String email, String userEmail, String password) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
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
			System.out.println("I am able to connect");
			Statement myStatement= myConnection.createStatement();
			ResultSet myresult = myStatement.executeQuery("insert into person VALUES('" 
			+ ssn+"', '"+lastName+"', '"+firstName+"', ' "+address+"', '"+city+"', '"+state+"', '" +
					zipcode+"', '"+number+"', '"+email+"', '"+userEmail+"', '"+password+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Did not connect");
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
	
	public String addUser(Login login) {
		return "success";
	}

}
