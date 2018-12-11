package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee, String role, String password) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
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
			int ssn1= Integer.parseInt(employee.getEmployeeID());
			String zipcode1 = Integer.toString(employee.getZipCode());
			System.out.println("I am able to connect in customer and store");
			/*
			 myStatement.executeUpdate("insert into person" + "VALUES("+ssn1+", '" +lastName+ "', '" +firstName+ "', '" +address+ "', '" +city+ "', '"+state+"', '" +
					zipcode1+"', '"+telephone+"', '"+email+"', '"+email+"', '"+password+"')");
					*/
			String query = " insert into person (SSN, lastName, firstName, Address, city, state, zipcode, telephone, email, UserEmail, Pass, PersonRole)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			 preparedStmt.setInt(1, ssn1);
			 preparedStmt.setString (2, employee.getLastName());
			 preparedStmt.setString (3, employee.getFirstName());
			 preparedStmt.setString (4, employee.getAddress());
			 preparedStmt.setString (5, employee.getCity());
			 preparedStmt.setString (6, employee.getState());
			 preparedStmt.setString (7, zipcode1);
			 preparedStmt.setString (8, employee.getTelephone());
			 preparedStmt.setString (9, employee.getEmail());
			 preparedStmt.setString (10, employee.getEmail());
			 preparedStmt.setString (11, password);
			 preparedStmt.setString (12, role);
			 preparedStmt.executeUpdate();
			 int level = Integer.parseInt(employee.getLevel());
			System.out.println("person is good");
			myStatement.executeUpdate("insert into employee VALUES("+ssn1+", '"+employee.getStartDate()+"', "+
			employee.getHourlyRate()+ ", "+level+")");
			//myStatement.executeUpdate("insert into person VALUES(111111111,'k','k','k','k','k','11111','11','ch@gmail.com','ch@gmail.com','1234')");
			System.out.println("I am able to connect in employee and store");
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

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
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
			int ssn1= Integer.parseInt(employee.getEmployeeID());
			String zipcode1 = Integer.toString(employee.getZipCode());
			System.out.println("I am able to connect in customer and store");
			/*
			 myStatement.executeUpdate("insert into person" + "VALUES("+ssn1+", '" +lastName+ "', '" +firstName+ "', '" +address+ "', '" +city+ "', '"+state+"', '" +
					zipcode1+"', '"+telephone+"', '"+email+"', '"+email+"', '"+password+"')");
					*/
			String query = " UPDATE person SET lastName = ?, firstName = ?, Address = ?,  city = ?, state = ?, zipcode = ?, telephone = ?, email = ?, UserEmail =? WHERE ssn = ?";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			 preparedStmt.setString (1, employee.getLastName());
			 preparedStmt.setString (2, employee.getFirstName());
			 preparedStmt.setString (3, employee.getAddress());
			 preparedStmt.setString (4, employee.getCity());
			 preparedStmt.setString (5, employee.getState());
			 preparedStmt.setString (6, zipcode1);
			 preparedStmt.setString (7, employee.getTelephone());
			 preparedStmt.setString (8, employee.getEmail());
			 preparedStmt.setString (9, employee.getEmail());
			 preparedStmt.setInt(10, ssn1);
			 preparedStmt.executeUpdate();
			System.out.println("person is good");
			query = " UPDATE employee SET StartDate = ?, HourlyRate = ?  WHERE EmployeeID = ?";
			preparedStmt = myConnection.prepareStatement(query);
			int emp = Integer.parseInt(employee.getEmployeeID());
			double rate = (double) employee.getHourlyRate();
			preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setString (1, employee.getStartDate());
			preparedStmt.setDouble(2, rate);
			preparedStmt.setInt (3, emp);
			preparedStmt.executeUpdate();
			System.out.println("I am able to connect in employee and update");
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

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
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
			int employeeid = Integer.parseInt(employeeID);
			String query = " delete from employee WHERE EmployeeID = ?";
			
			PreparedStatement preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setInt(1, employeeid);
			preparedStmt.execute();
			
			query = " delete from person WHERE ssn = ?";
			preparedStmt = myConnection.prepareStatement(query);
			preparedStmt.setInt(1, employeeid);
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

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
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
			ResultSet resultSet = myStatement.executeQuery("select * from employee;");
			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println(columnsNumber);
			while(resultSet.next()) {
					int employeeSNN = resultSet.getInt("EmployeeId");
					String startDate = resultSet.getString("StartDate");
					Float hourlyrate = (float) resultSet.getDouble("HourlyRate");
					Employee myEmployee = new Employee();
					myEmployee.setEmployeeID(Integer.toString(employeeSNN));
					myEmployee.setStartDate(startDate);
					myEmployee.setHourlyRate(hourlyrate);
					employees.add(myEmployee);
			}
			
			for(int i=0; i<employees.size(); i++) {
				Employee myEmployee = employees.get(i);
				int employeeSNN = Integer.parseInt(myEmployee.getEmployeeID());
				ResultSet myPersonTable = myStatement.executeQuery("select * from person where SSN ='"+employeeSNN+"';");
				if(myPersonTable.next()) {
					String lastName = myPersonTable.getString("LastName");
					String firstName = myPersonTable.getString("FirstName");
					String address = myPersonTable.getString("Address");
					String city = myPersonTable.getString("City");
					String state = myPersonTable.getString("State");
					String zipcode = myPersonTable.getString("ZipCode");
					String telephone = myPersonTable.getString("Telephone");
					String email = myPersonTable.getString("Email");
					myEmployee.setFirstName(firstName);
					myEmployee.setLastName(lastName);
					myEmployee.setAddress(address);
					myEmployee.setCity(city);
					myEmployee.setState(state);
					myEmployee.setZipCode(Integer.parseInt(zipcode));
					myEmployee.setTelephone(telephone);
					myEmployee.setEmail(email);
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
		
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		Employee employee = new Employee();
		
		
		
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
			int employee1 = Integer.parseInt(employeeID);
			ResultSet resultSet = myStatement.executeQuery("select * from employee where EmployeeId='"+employee1+"';");
			float hourlyRate = 0;
			String startDate = "";
			while(resultSet.next()) {
				hourlyRate = resultSet.getFloat("HourlyRate");
				startDate = resultSet.getString("StartDate");
			}
			resultSet = myStatement.executeQuery("select * from person where ssn='"+employee1+"';");
			while(resultSet.next()) {
				String email = resultSet.getString("email");
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String address = resultSet.getString("Address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("ZipCode");
				String telephone = resultSet.getString("Telephone");
				employee.setEmail(email);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setAddress(address);
				employee.setCity(city);
				employee.setStartDate(startDate);
				employee.setState(state);
				employee.setZipCode(Integer.parseInt(zipcode));
				employee.setTelephone(telephone);
				employee.setEmployeeID(Integer.toString(employee1));
				employee.setHourlyRate(hourlyRate);
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
		
		return employee;
	}
	
	public Employee getHighestRevenueEmployee() {
		
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		Employee employee = new Employee();
		
		/*Sample data begins*/
		employee.setEmail("shiyong@cs.sunysb.edu");
		employee.setFirstName("Shiyong");
		employee.setLastName("Lu");
		employee.setEmployeeID("631-413-5555");
		/*Sample data ends*/
		
		return employee;
	}

	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
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
			int id = 0;
			while(resultSet.next()) {
				id = resultSet.getInt("SSN");
				System.out.println(id);
				break;
			}
		email = Integer.toString(id);
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

}
