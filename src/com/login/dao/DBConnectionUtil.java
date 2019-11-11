package com.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnectionUtil {
	
	public DBConnectionUtil(Connection connection, Statement statement, ResultSet rs) {
		closeResultSet(rs);
	    closeStatement(statement);
	    closeConnection(connection);
	}
	
	public void close(Connection connection, Statement statement, ResultSet rs)
	   {
	      closeResultSet(rs);
	      closeStatement(statement);
	      closeConnection(connection);
	   }


	   private void closeConnection(Connection connection)
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

	   private void closeStatement(Statement statement)
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

	   private void closeResultSet(ResultSet rs)
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
