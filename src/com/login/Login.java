package com.login;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.login.dao.LoginDao;

import java.sql.*; 

////@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
	        
	        //send a db request to check the entry with same username and password are valid
			LoginDao dao = new LoginDao();
			
			//response.getWriter().append("Is user valid : "+dao.checkUser(username, password)).append(request.getContextPath());			
			//File file = new File("c:\\Jar_files\\connection.prop");	
			//System.out.println(file.getAbsoluteFile());
			
			HttpSession session = request.getSession();
			if(dao.checkUser(username, password)) {
				session.setAttribute("username", username);	
				session.setAttribute("message", "Login successfully.....");
				
				response.sendRedirect("index.jsp");
				
				System.out.println("Login successfully.....");
				
			} else {
				System.out.println("Failed to login, user dosent exist....");
				session.setAttribute("message", "Failed to login, user doesn't exist....");
				
	        	response.sendRedirect("login.jsp");
			}
        }
        catch(Exception e){System.out.print( "ERROR - "+e.getMessage());} 		
	}

}
