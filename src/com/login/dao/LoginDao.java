package com.login.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.login.ConnectionManager;
import com.pojo.TCompany;
import com.pojo.TCompanySystem;
import com.pojo.TDdrStatus;
import com.pojo.TDivision;
import com.pojo.TScope;
import com.pojo.TScopeCoSystem;
import com.pojo.TStatusType;
import com.pojo.TSystem;
import com.pojo.TUser;

public class LoginDao {	

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement preparedStmt;
	
	//===============>[ Get data from different tables - metadata ]===========\\
		
	public boolean checkUser(String username, String password) throws SQLException
	{
		int out = 0;
	    String prepStatement = "{ call pCheckPassword(?,?,?) } ";
	    Boolean _result = true;
	    con = ConnectionManager.getConnection();
	    
	    try {	
	    	cs = con.prepareCall(prepStatement);
	        cs.setString(1, username);
	        cs.setString(2, password);
	        	        
	        cs.registerOutParameter(3, java.sql.Types.INTEGER);
	        cs.execute();	  
	        
	        out = cs.getInt(3);
	        //System.out.println("Stored procedure execution = "+cs.getString(3));
	        
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	System.out.println("Something went wrong.");
	    	out = 0;
	    }
	    finally {
			//System.out.println("Please close all the connections.");
			ConnectionManager.closeCallableStatementConnection(con, cs, rs);
		}
	    
	    if(out == 1) {
	    	_result = true;//User exists
	    }else if(out == 0) {
	    	_result = false; //User dosen't exist
	    }
	    return _result;
	}
		
	public List<TUser> getAllTUser() throws SQLException
	{
		TUser tuser;
		List<TUser> userList = new ArrayList<>();
		
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		
		try {
			String query = "select * from tuser";
			rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("userName");
				String userDisplayName = rs.getString("userDisplayName");
				String userPassword = rs.getString("userPassword");
				int userIsAdmin = rs.getInt("userIsAdmin");
				int userIsActive = rs.getInt("userIsActive");
				
				tuser = new TUser(id, userName, userDisplayName, userPassword, userIsAdmin, userIsActive);
				userList.add(tuser);
			}
		}catch(Exception ex) {
			System.out.println("Error on file 1 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		
		return userList;
	}
	
	public TUser getTUserById() throws SQLException
	{
		//TUser tuser;
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tuser where ID=1";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("userName");
				String userDisplayName = rs.getString("userDisplayName");
				String userPassword = rs.getString("userPassword");
				int userIsAdmin = rs.getInt("userIsAdmin");
				int userIsActive = rs.getInt("userIsActive");	
				
				return new TUser(id, userName, userDisplayName, userPassword, userIsAdmin, userIsActive);
			}
		}catch(Exception ex) {
			System.out.println("Error on file 2 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		
		return null;
	}
	
	public List<TCompany> getTCompanyData() throws SQLException
	{
		TCompany tcompany;
		List<TCompany> companyList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tcompany";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String companyName = rs.getString("companyName");
				String companyMnemonic = rs.getString("companyMnemonic");
				String divisionID = rs.getString("divisionID");
				
				//System.out.println("ID = "+id+", Company Name = "+companyName+", Company Mnemonic = "+companyMnemonic+", divisionID = "+divisionID);
				
				tcompany = new TCompany(id, companyName, divisionID, companyMnemonic);
				companyList.add(tcompany);
			}
		}catch(Exception ex) {
			System.out.println("Error on file 3 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return companyList;
	}
		
	public List<TScopeCoSystem> getTScopeCoSystemData() throws SQLException
	{
		TScopeCoSystem tscopecosystem;
		List<TScopeCoSystem> tscopecosystemList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tscopecosystem";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String scopeID = rs.getString("scopeID");
				String coSystemID = rs.getString("coSystemID");
				
				tscopecosystem = new TScopeCoSystem(id, scopeID, coSystemID);
				tscopecosystemList.add(tscopecosystem);
			}
		}catch(Exception ex) {
			System.out.println("Error on file 4 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return tscopecosystemList;
	}
	
	public List<TDdrStatus> getTDdrStatus() throws SQLException
	{
		TDdrStatus tddrstatus;
		List<TDdrStatus> tddrstatusList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tddrstatus";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				int statusType = rs.getInt("statusType");
				String statusDescription = rs.getString("statusDescription");
				
				tddrstatus = new TDdrStatus(id, statusType, statusDescription);
				tddrstatusList.add(tddrstatus);
			}
		}catch(Exception ex) {
			System.out.println("Error on file 5 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return tddrstatusList;
	}
	
	public List<TDivision> getTDivision() throws SQLException
	{
		TDivision tdivision;
		List<TDivision> tdivisionList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tdivision";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String divisionName = rs.getString("divisionName");
				String divisionMnemonic = rs.getString("divisionMnemonic");
				
				tdivision = new TDivision(id, divisionName, divisionMnemonic);
				tdivisionList.add(tdivision);
			}
			//st.close();
			//con.close();
		}catch(Exception ex) {
			System.out.println("Error on file 6 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return tdivisionList;
	}
	
	public List<TScope> getTScope() throws SQLException
	{
		TScope tscope;
		List<TScope> tscopeList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tscope";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String scopeName = rs.getString("scopeName");
				
				tscope = new TScope(id, scopeName);
				tscopeList.add(tscope);
			}
			//st.close();
			//con.close();
		}catch(Exception ex) {
			System.out.println("Error on file 7 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return tscopeList;
	}
	
	public List<TCompanySystem> getTCompanySystem() throws SQLException
	{
		TCompanySystem tcompanysystem;
		List<TCompanySystem> companysystemList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tcompanysystem";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String companyID = rs.getString("companyID");
				String systemID = rs.getString("systemID");
				String responsiblePersonID = rs.getString("responsiblePersonID");
				
				tcompanysystem = new TCompanySystem(id, companyID, systemID, responsiblePersonID);
				companysystemList.add(tcompanysystem);
			}
			//st.close();
			//con.close();
		}catch(Exception ex) {
			System.out.println("Error on file 8 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return companysystemList;
	}
	
	public List<TStatusType> getTStatusType() throws SQLException
	{
		TStatusType tstatustype;
		List<TStatusType> statustypeList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tstatustype";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String levelDescription = rs.getString("levelDescription");
				
				tstatustype = new TStatusType(id, levelDescription);
				statustypeList.add(tstatustype);
			}
			//st.close();
			//con.close();
		}catch(Exception ex) {
			System.out.println("Error on file 9 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return statustypeList;
	}
	
	public List<TSystem> getTSystem() throws SQLException
	{
		TSystem tsystem;
		List<TSystem> systemList = new ArrayList<>();
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		try {						
			String query = "select * from tsystem";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String systemName = rs.getString("systemName");
				String systemDescription = rs.getString("systemDescription");
				String systemEntryPoint = rs.getString("systemEntryPoint");
				
				tsystem = new TSystem(id, systemName, systemDescription, systemEntryPoint);
				systemList.add(tsystem);
			}
			//st.close();
			//con.close();
		}catch(Exception ex) {
			System.out.println("Error on file 10 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, st, rs);
		}
		return systemList;
	}
	
	//===============>[ Insert Records to the tables ]===========\\
	
	public void insertTableTCompany(TCompany tc)
	{				
		con = ConnectionManager.getConnection();		
		try {
			String query = "INSERT INTO `tcompany` (`companyName`, `companyMnemonic`, `divisionID`) VALUES ('"+tc.getCompanyName()+"', '"+tc.getCompanyMnemonic()+"', '"+tc.getDivisionID()+"');";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 11 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTCompanySystem(TCompanySystem tc)
	{				
		con = ConnectionManager.getConnection();		
		try {
			String query = "INSERT INTO `tcompanysystem` (`companyID`, `systemID`, `responsiblePersonID`) VALUES ('"+tc.getCompanyID()+"', '"+tc.getSystemID()+" ', '" +tc.getResponsiblePersonID()+ "');";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 12 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTDivision(TDivision tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tdivision` (`divisionName`, `divisionMnemonic`) VALUES ( '"+tc.getDivisionName()+"', '"+tc.getDivisionMnemonic()+ "' );";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 13 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTDdrStatus(TDdrStatus tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tddrstatus` (`statusType`, `statusDescription`) VALUES ( "+tc.getStatusType()+", '"+tc.getStatusDescription()+ "' );";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 14 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}	
	
	public void insertTableTScope(TScope tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tscope` (`scopeName`) VALUES ('"+tc.getScopeName()+"');";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 15 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTScopeCoSystem(TScopeCoSystem tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tscopecosystem` (`scopeID`, `coSystemID`) VALUES ("+tc.getScopeID()+", "+tc.getCoSystemID()+");";
						
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 16 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTStatusType(TStatusType tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tstatustype` (`levelDescription`) VALUES ('"+tc.getLevelDescription()+"');";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 17 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void insertTableTSystem(TSystem tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "INSERT INTO `tsystem` (`systemName`, `systemDescription`, `systemEntryPoint`) VALUES ('"+tc.getSystemName()+"', '"+tc.getSystemDescription()+"', '"+tc.getSystemEntryPoint()+"');";
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 18 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public String insertTableTUser(TUser tc)
	{				
		int out = 0;
	    String prepStatement = "{ call pAddUser(?,?,?,?,?,?) } ";
	    con = ConnectionManager.getConnection();
	        
	    try {
	        cs = con.prepareCall(prepStatement);	        
	        cs.setString(1, tc.getUserName());
	        cs.setString(2, tc.getUserDisplayName());
	        cs.setString(3, tc.getUserPassword());	        
	        cs.setInt(4, tc.getUserIsActive());
	        cs.setInt(5, tc.getUserIsActive());
	        	        
	        cs.registerOutParameter(6, java.sql.Types.INTEGER);
	        cs.execute();	  
	        
	        out = cs.getInt(6);
	        
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	out = 2;
            System.out.println(ex.getMessage());
	    }
	    finally {
			//System.out.println("Please close all the connections.");
			ConnectionManager.closeCallableStatementConnection(con, cs, rs);
		}
	    
	    if(out == 1) {
	    	return "success"; //user created
	    }else if(out == 0) {
	    	return "duplicate"; //already present
	    }else {
	    	return "fail";
	    }
	}
	
	//===============> [Save data to the tables] <==================\\
	
	public void updateTableTUser(TUser tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tuser` SET `userName` = '"+tc.getUserName()+"', `userDisplayName` = '"+tc.getUserDisplayName()+"', `userIsActive` = '"+tc.getUserIsActive()+"', `userIsAdmin` = '"+tc.getUserIsAdmin()+"' WHERE `tuser`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 19 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void updateTableTSystem(TSystem tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tsystem` SET `systemName` = '"+tc.getSystemName()+"', `systemDescription` = '"+tc.getSystemDescription()+"', `systemEntryPoint` = '"+tc.getSystemDescription()+"' WHERE `tsystem`.`ID` = "+tc.getID()+";";
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 20 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
		
	}
	
	public void updateTableTStatusType(TStatusType tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tstatustype` SET `levelDescription` = '"+tc.getLevelDescription()+"' WHERE `tstatustype`.`ID` = "+tc.getID()+";";
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 21 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
		
	}
	
	public void updateTableTScopeCoSystem(TScopeCoSystem tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tscopecosystem` SET `scopeID` = "+tc.getScopeID()+", `coSystemID` = "+tc.getCoSystemID()+" WHERE `tscopecosystem`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 22 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
		
	}
	
	public void updateTableTScope(TScope tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tscope` SET `scopeName` = '"+tc.getScopeName()+"' WHERE `tscope`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
			//System.out.println("Records updated successfully -"+query);
		}catch(Exception ex) {
			System.out.println("Error on file 23 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void updateTableTDdrStatus(TDdrStatus tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tddrstatus` SET `statusType` = "+tc.getStatusType()+", `statusDescription` = '"+tc.getStatusDescription()+"' WHERE `tddrstatus`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 24 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void updateTableTDivision(TDivision tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tdivision` SET `divisionName` = '"+tc.getDivisionName()+"', `divisionMnemonic` = '"+tc.getDivisionMnemonic()+"' WHERE `tdivision`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 25 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}
	
	public void updateTableTCompanySystem(TCompanySystem tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tcompanysystem` SET `companyID` = '"+tc.getCompanyID()+"', `systemID` = '"+tc.getSystemID()+"', `responsiblePersonID` = '"+tc.getResponsiblePersonID()+"' WHERE `tcompanysystem`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 26 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
		
	}
	
	public void updateTableTCompany(TCompany tc)
	{				
		con = ConnectionManager.getConnection();
		try {
			String query = "UPDATE `tcompany` SET `companyName` = '"+tc.getCompanyName()+"', `companyMnemonic` = '"+tc.getCompanyMnemonic()+"', `divisionID` = '"+tc.getDivisionID()+"' WHERE `tcompany`.`ID` = "+tc.getID()+";";
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 27 :  "+ex);
		}	
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	}	

	//===============> [ Detele data from the tables] ==============\\
	
	public void deleteRecordFromTable(int ID, String tableName)
	{
		con = ConnectionManager.getConnection();
		try {
			String query = "delete from "+tableName+" where ID="+ID;						
			preparedStmt = con.prepareStatement(query);
		    //preparedStmt.setInt(1, 3);
		    preparedStmt.execute();	
		    
		    preparedStmt.close();
		    con.close();
		    
		}catch(Exception ex) {
			System.out.println("Error on file 28 :  "+ex);
		}
		finally {
			ConnectionManager.closeAll(con, preparedStmt, rs);
		}
	} 
}

