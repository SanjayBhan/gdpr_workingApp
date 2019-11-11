package com.postdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.login.dao.LoginDao;
import com.login.services.TDivision;
import com.pojo.TCompany;
import com.pojo.TCompanySystem;

@WebServlet("/Postdata")
public class Postdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int String = 0;
	private static final Class TCompany = null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		
		//response.getWriter().append("{success: true}").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		String reqjson = request.getParameter("reqjson");
		String type = request.getParameter("type");
		String masterTableId = request.getParameter("masterTableId");
		String gridTitle = request.getParameter("gridTitle");
		
		masterTableId = masterTableId.toLowerCase();
		
		//send a db request to check the entry with same username and password are valid
		LoginDao dao = new LoginDao();
		Gson json = new Gson();
		//String obj = json.toJson(reqjson);
		Map<String, Object> map = new HashMap<>();
		
		Boolean successResult = false;
		String msgOutput = "Failed to update record for table "+ masterTableId;
				
		if(type.equals("deleteRecord")) {
			
			//if(masterTableId.equals("tcompany")) {
				// Convert JSON File to Java Object
				TCompany tcompanyObj = json.fromJson(reqjson, TCompany.class);	            
				try {
					//Call Delete method from DAO class
					dao.deleteRecordFromTable(tcompanyObj.getID(), masterTableId);
					successResult = true;
					msgOutput = "Record deleted successfully";
				} 
				catch(Exception e){
					System.out.print( "Delete Error - "+e.getMessage());
					msgOutput += " & ID="+tcompanyObj.getID();
				}
			//}
			
		} 
		else if(type.equals("saveRecord"))			
		{       
			try {				
				if(masterTableId.equals("tcompany")) {
					TCompany tcompanyObj = json.fromJson(reqjson, TCompany.class);	
					dao.updateTableTCompany(tcompanyObj);
				}
				else if(masterTableId.equals("tcompanysystem")) {
					TCompanySystem tcompanysystemObj = json.fromJson(reqjson, TCompanySystem.class);
					dao.updateTableTCompanySystem(tcompanysystemObj);
				}
				else if(masterTableId.equals("tddrstatus")) {
					com.pojo.TDdrStatus tddrstatus = json.fromJson(reqjson, com.pojo.TDdrStatus.class);
					dao.updateTableTDdrStatus(tddrstatus);
				}
				else if(masterTableId.equals("tdivision")) {
					com.pojo.TDivision tdivision = json.fromJson(reqjson, com.pojo.TDivision.class);
					dao.updateTableTDivision(tdivision);					
				}
				else if(masterTableId.equals("tscope")) {					
					com.pojo.TScope tscope = json.fromJson(reqjson, com.pojo.TScope.class);
					dao.updateTableTScope(tscope);
				}
				else if(masterTableId.equals("tscopecosystem")) {
					com.pojo.TScopeCoSystem tscopecosystem = json.fromJson(reqjson, com.pojo.TScopeCoSystem.class);
					dao.updateTableTScopeCoSystem(tscopecosystem);
				}
				else if(masterTableId.equals("tstatustype")) {
					com.pojo.TStatusType tstatustype = json.fromJson(reqjson, com.pojo.TStatusType.class);
					dao.updateTableTStatusType(tstatustype);
				}
				else if(masterTableId.equals("tsystem")) {
					com.pojo.TSystem tsystem = json.fromJson(reqjson, com.pojo.TSystem.class);
					dao.updateTableTSystem(tsystem);
				}
				else if(masterTableId.equals("tuser")) {
					com.pojo.TUser tuser = json.fromJson(reqjson, com.pojo.TUser.class);
					dao.updateTableTUser(tuser);
				}
				
				successResult = true;
				msgOutput = "Record saved successfully";
			} 
			catch(Exception e){
				System.out.print( "Saved Error - "+e.getMessage());
				//msgOutput += " & ID="+tcompanyObj.getID();
			}
		}
		else if(type.equals("addRecord"))			
		{
			msgOutput = "Record added successfully";
			try {
				
				if(masterTableId.equals("tcompany")) {
					com.pojo.TCompany tcompanyObj = json.fromJson(reqjson, com.pojo.TCompany.class);
					dao.insertTableTCompany(tcompanyObj);
				}
				else if(masterTableId.equals("tcompanysystem")) {
					com.pojo.TCompanySystem tcompanysystemObj = json.fromJson(reqjson, com.pojo.TCompanySystem.class);
					dao.insertTableTCompanySystem(tcompanysystemObj);
				}
				else if(masterTableId.equals("tddrstatus")) {
					com.pojo.TDdrStatus tddrstatus = json.fromJson(reqjson, com.pojo.TDdrStatus.class);
					dao.insertTableTDdrStatus(tddrstatus);
				}
				else if(masterTableId.equals("tdivision")) {
					com.pojo.TDivision tdivision = json.fromJson(reqjson, com.pojo.TDivision.class);
					dao.insertTableTDivision(tdivision);
				}
				else if(masterTableId.equals("tscope")) {
					com.pojo.TScope tscope = json.fromJson(reqjson, com.pojo.TScope.class);
					dao.insertTableTScope(tscope);
				}
				else if(masterTableId.equals("tscopecosystem")) {
					com.pojo.TScopeCoSystem tscopecosystem = json.fromJson(reqjson, com.pojo.TScopeCoSystem.class);
					dao.insertTableTScopeCoSystem(tscopecosystem);
				}
				else if(masterTableId.equals("tstatustype")) {
					com.pojo.TStatusType tstatustype = json.fromJson(reqjson, com.pojo.TStatusType.class);
					dao.insertTableTStatusType(tstatustype);
				}
				else if(masterTableId.equals("tsystem")) {
					com.pojo.TSystem tsystem = json.fromJson(reqjson, com.pojo.TSystem.class);
					dao.insertTableTSystem(tsystem);
				}
				else if(masterTableId.equals("tuser")) {
					com.pojo.TUser tuser = json.fromJson(reqjson, com.pojo.TUser.class);
					String ret = dao.insertTableTUser(tuser);
					if(ret == "success") {
						msgOutput = "Record added successfully.";
					}else if(ret == "duplicate") {
						msgOutput = "Duplicate record already present";
					}else {
						msgOutput = "Failed to update record.";
					}
					
					System.out.print( "SP OUTPUT -> "+msgOutput);
				}
				
				successResult = true;
				
			} 
			catch(Exception e){
				System.out.print( "Added record Error - "+e.getMessage());
				//msgOutput += " & ID="+tcompanyObj.getID();
			}
		}
		
		map.put("success", successResult);
		map.put("message", msgOutput);		
        String stringJson = json.toJson(map);
        json = null;
        out.print(stringJson);
		out.flush();
	}

}
