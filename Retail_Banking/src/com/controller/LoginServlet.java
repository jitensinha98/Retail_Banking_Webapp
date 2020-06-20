package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession; 

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID =1L;
	
	// JDBC parameters
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/retail_banking";
	
	// Database username and password
	static final String USER = "root";
	static final String PASS = "admin";
	
	
	
	public void doPost(HttpServletRequest request ,HttpServletResponse response ) throws IOException
	{
		
		// database parameters to denote connection and query
		Connection conn = null;
		Statement stmt = null;
		
		// set the type of response that this method will send
		response.setContentType("text/html");
		
		// creating an object which will be used to send text to the client
		PrintWriter out = response.getWriter();
		
		String accno = request.getParameter("accno");
		String ifsc = request.getParameter("ifsc");
		String pass = request.getParameter("pass");
		
		
		try
		{
			// Registering JDBC driver
			Class.forName(JDBC_DRIVER);
			
			// Establishing a connection
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			// Will bw used to execute statements in SQL
			stmt = conn.createStatement();
			
			// fetching data
			String query =  "SELECT * from users WHERE Account_no = '" + accno + "' AND IFSC_code = '" + ifsc + "' AND Password = '" + pass + "'";
			ResultSet rs = stmt.executeQuery(query);
			
			// will return true for an existing entry
			if (rs.next())
				{	
		         String Account_no  = rs.getString("Account_no");
		         String IFSC_code  = rs.getString("IFSC_code");
		         String Firstname  = rs.getString("Firstname");
		         String LastName  = rs.getString("Lastname");
		         String DOB  = rs.getString("DOB");
		         String Gender  = rs.getString("Gender");
		         String City  = rs.getString("City");
		         String Country  = rs.getString("Country");
		         String EmailID  = rs.getString("EmailID");
		         String Phone_Number  = rs.getString("Phone_Number");
		         int Balance_Amount  = rs.getInt("Balance_Amount");
		         String full_name = Firstname + " " + LastName ;		  
		         
				// close connection
				conn.close();
					
				//Redirecting to Login.jsp
				
				
				HttpSession session=request.getSession(true);  
				session.setAttribute("full_name",full_name);
				session.setAttribute("Country",Country);
				session.setAttribute("City",City);
				session.setAttribute("Phone_Number",Phone_Number);
				session.setAttribute("Account_no",Account_no);
				session.setAttribute("IFSC",IFSC_code);
				session.setAttribute("Balance_Amount",Balance_Amount);
			
		        response.sendRedirect("UserView.jsp");
				
				}
				else
				{
				out.println("<p style='color:red'>");
		    	out.println("ERROR : Incorrect Credentials");
				out.println("</p>");
				}
				}
				catch(Exception e)
				{ 
					System.out.println(e);
				}
	}
		         
		
	}
