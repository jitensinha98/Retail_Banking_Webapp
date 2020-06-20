package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession; 

@WebServlet("/LogoutServlet")

public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID =1L;
	
	public void doGet(HttpServletRequest request ,HttpServletResponse response ) throws IOException
	{
		
		
		// set the type of response that this method will send
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
    	if(session != null)
    		session.invalidate();
    	response.sendRedirect("index.html");
    	
		
	}
		         
		
	}
