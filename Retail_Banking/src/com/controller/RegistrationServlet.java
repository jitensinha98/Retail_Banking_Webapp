package com.controller;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// Annotation
@WebServlet("/RegistrationServlet")

// extending Servlet API class
public class RegistrationServlet extends HttpServlet
{

	private static final long serialVersionUID =1L;
	
	// JDBC parameters
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/retail_banking";
	
	// Database username and password
	static final String USER = "root";
	static final String PASS = "admin";
	
	// overriding doPost() method to receive and custom data to or from Registration.jsp file
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// database parameters to denote connection and query
		Connection conn = null;
		Statement stmt = null;
		
		// set the type of response that this method will send
		response.setContentType("text/html");
		
		// creating an object which will be used to send text to the client
		PrintWriter out = response.getWriter();
		
		// Accepting parameters from Registration.jsp
		String FNAME = request.getParameter("fname");
		String LNAME = request.getParameter("lname");
		String ACCNO = request.getParameter("accno");
		String IFSC = request.getParameter("ifsc");
		String PASSWORD = request.getParameter("pass");
		String DOB = request.getParameter("dob");
		String GENDER =request.getParameter("gender");
		String CITY = request.getParameter("city");
		String COUNTRY = request.getParameter("country");
		String EMAIL = request.getParameter("email");
		String PHONE = request.getParameter("phone");
		
		String errorMsg = null;
		
		
		if(PASSWORD == null || PASSWORD.equals("") ||FNAME == null || FNAME.equals("") || LNAME == null || LNAME.equals("") || ACCNO == null || ACCNO.equals("") || IFSC == null || IFSC.equals("") || FNAME == null || FNAME.equals("") || DOB == null || DOB.equals("") || CITY == null || CITY.equals("") || COUNTRY == null || COUNTRY.equals("") || EMAIL == null || EMAIL.equals("") || EMAIL == null || EMAIL.equals("") )
		{
			errorMsg = "* Error : Field(s) cannot be null or empty";
		}
		if (errorMsg == null)
		{
			try
			{
				// Registering JDBC driver
				Class.forName(JDBC_DRIVER);
				
				// Establishing a connection
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				// Will bw used to execute statements in SQL
				stmt = conn.createStatement();
				
				// to check if an entry exists
				String queryCheck =  "SELECT * from users WHERE Account_no = '" + ACCNO + "' OR IFSC_code = '" + IFSC + "' OR EmailID = '" + EMAIL + "' OR Phone_Number = '" + PHONE + "' OR Password = '" + PASSWORD + "'" ;
				ResultSet rs = stmt.executeQuery(queryCheck);
				
				// will return true for an existing entry
				if (rs.next())
					{	
				    out.println("<p style='color:red'>");
					out.println("ERROR : Duplicate Data Already Registered");
					out.println("</p>");
					}
				else
					{
				// Executing Query
				String sql="insert into users(Account_no,IFSC_code,Firstname,Lastname,DOB,Gender,City,Country,EmailID,Phone_Number,Password) values('" + ACCNO + "','" + IFSC + "','" + FNAME + "','" + LNAME +"','" + DOB + "','" + GENDER + "','" + CITY + "','" + COUNTRY + "','" + EMAIL + "','" + PHONE + "','" + PASSWORD +"')";
				stmt.executeUpdate(sql);
				
				// close connection
				conn.close();
				
				//Redirecting to Login.jsp
				request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			}
		}
	}
}
				