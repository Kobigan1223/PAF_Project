package model;
import java.sql.*;
public class Inquiry {
	//A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Inquiry", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		
		//Insert Query
		public String insertinquirymanagement(String account_no, String address, String phone, String subject, String message)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for inserting."; 
		 }
		 
		 // create a prepared statement
		 String query = " insert into inquiry (`inquiry_id`,`account_no`,`address`,`phone`, `subject`, `message`)" + " values (?, ?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, account_no);
		 preparedStmt.setString(3, address);
		 preparedStmt.setString(4, phone);
		 preparedStmt.setString(5, subject);
		 preparedStmt.setString(6, message);
		
		// execute the statement
		
		 preparedStmt.execute();
		 con.close();
		 output = "Inserted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		//Get Query
		public String readInquiry()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
			 
		 {return "Error while connecting to the database for reading."; }
		 
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Account Number</th>" +
		 "<th>Address</th>" +
		 "<th>Phone Number</th>" +
		 "<th>Subject</th>"+
		 "<th>Message</th>"+
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from inquiry";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String inquiry_id = Integer.toString(rs.getInt("inquiry_id"));
		 String account_no = rs.getString("account_no");
		 String address = rs.getString("address");
		 String phone = rs.getString("phone");
		 String subject = rs.getString("subject");
		 String message = rs.getString("message");
		
		 
		 
		 output += "<tr><td>" + account_no + "</td>";
		 output += "<td>" + address + "</td>";
		 output += "<td>" + phone + "</td>";
		 output += "<td>" + subject + "</td>";
		 output += "<td>" + message + "</td>";	
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td><form method='post' action=''>"
				 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
				 + "<input name='inquiry_id' type='hidden' value='" + inquiry_id
				 + "'>" + "</form></td></tr>";
				 }
				 con.close();
				
				 output += "</table>";
				 } 
		 catch (Exception e)
		 {
		 output = "Error while reading the Datas.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		//Update Query
		public String updateinquirymanagement(String inquiry_id, String account_no, String address, String phone, String subject, String message )
		
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE inquiry SET account_no=?, address=?, phone=?, subject=?, message=? WHERE inquiry_id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 
		 preparedStmt.setString(1, account_no);
		 preparedStmt.setString(2, address);
		 preparedStmt.setString(3, phone);
		 preparedStmt.setString(4, subject);
		 preparedStmt.setString(5, message);
		 preparedStmt.setInt(6, Integer.parseInt(inquiry_id));
		 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the item.";
		 System.out.println(e.getMessage());
		 }
		 return output;
		 }
		
		//Delete Query
		public String deleteinquirymanagement(String inquiry_id)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from inquiry where inquiry_id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(inquiry_id));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while deleting the item.";
		 System.out.println(e.getMessage());
		 }
		 return output;
		 }
		} 

