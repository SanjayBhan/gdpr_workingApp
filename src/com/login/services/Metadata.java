package com.login.services;

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

/**
 * Servlet implementation class Metadata
 */
@WebServlet("/Metadata")
public class Metadata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
        {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "nocache");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
			
			//System.out.println("Reached to JSON.....");
			
			//send a db request to check the entry with same username and password are valid
			LoginDao dao = new LoginDao();
			
			Map<String, Object> map = new HashMap<>();
			map.put("success", "true");
			map.put("tcompany", dao.getTCompanyData());
			map.put("tuser", dao.getAllTUser());
			map.put("tsystem", dao.getTSystem());
			map.put("tstatusType", dao.getTStatusType());
			map.put("tcompanysystem", dao.getTCompanySystem());
			map.put("tscope", dao.getTScope());
			map.put("tdivision", dao.getTDivision());
			map.put("tddrstatus", dao.getTDdrStatus());
			map.put("tscopecosystem", dao.getTScopeCoSystemData());
						
			Gson json = new Gson();
	        String stringJson = json.toJson(map);
	        json = null;
	        out.print(stringJson);
			out.flush();
	        
        }
        catch(Exception e){System.out.print( "ERROR - "+e.getMessage());} 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
