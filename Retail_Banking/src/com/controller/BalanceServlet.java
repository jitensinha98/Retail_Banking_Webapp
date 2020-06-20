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

@WebServlet("/BalanceServlet")

public class BalanceServlet extends HttpServlet {
	
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
		
		try
		{
			// Registering JDBC driver
			Class.forName(JDBC_DRIVER);
			
			// Establishing a connection
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			// Will bw used to execute statements in SQL
			stmt = conn.createStatement();
			
			HttpSession session = request.getSession();
			String Account_no = (String) session.getAttribute("Account_no");
			
			// fetching data
			String query =  "SELECT Balance_Amount from users WHERE Account_no = '" + Account_no + "'";
			ResultSet rs = stmt.executeQuery(query);
			
			// will return true for an existing entry
			if (rs.next())
				{	

		         int Balance_Amount  = rs.getInt("Balance_Amount");	   
				// close connection
				conn.close();
				request.setAttribute("Balance_Amount",Balance_Amount);
				request.getRequestDispatcher("UserView.jsp").forward(request, response);
				}
				}
				catch(Exception e)
				{ 
					System.out.println(e);
				}
	}
		         
		
	}
