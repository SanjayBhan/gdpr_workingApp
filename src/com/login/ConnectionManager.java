package com.login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;


public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/gdprapp";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "sanjay";   
    private static String password = "sanjay";
    
    /*
    ServletContext ctx = getServletContext();
    String url = ctx.getInitParameter("url");	    
	String driverName = ctx.getInitParameter("driverName");
	String username = ctx.getInitParameter("username");  
	String password = ctx.getInitParameter("password");
    */
    
    private static Connection con;
    
    public static Connection getConnection() {
        try {        	
        	Class.forName(driverName);
            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
                //st = con.createStatement();
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
    public static void closeCallableStatementConnection(Connection connection, CallableStatement statement, ResultSet rs)
	   {
	      closeResultSet(rs);
	      closeStatement(statement);
	      closeConnection(connection);
	   }
    
	public static void closeAll(Connection connection, Statement statement, ResultSet rs)
	   {
	      closeResultSet(rs);
	      closeStatement(statement);
	      closeConnection(connection);
	   }


	   private static void closeConnection(Connection connection)
	   {
	      if (connection != null)
	         try
	         {
	            connection.close();
	         }
	         catch (SQLException e)
	         {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	   }

	   private static void closeStatement(Statement statement)
	   {
	      if (statement != null)
	         try
	         {
	            statement.close();
	         }
	         catch (SQLException e)
	         {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	   }

	   private static void closeResultSet(ResultSet rs)
	   {
	      if (rs != null)
	         try
	         {
	            rs.close();
	         }
	         catch (SQLException e)
	         {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	   }
}



