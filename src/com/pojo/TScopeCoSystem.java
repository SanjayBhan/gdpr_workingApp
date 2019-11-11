package com.pojo;

public class TScopeCoSystem { 	
	
	private int ID;
	private String scopeID;
	private String coSystemID;
	
	public TScopeCoSystem(int iD, String scopeID, String coSystemID) {
		super();
		ID = iD;
		this.scopeID = scopeID;
		this.coSystemID = coSystemID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getScopeID() {
		return scopeID;
	}

	public void setScopeID(String scopeID) {
		this.scopeID = scopeID;
	}

	public String getCoSystemID() {
		return coSystemID;
	}

	public void setCoSystemID(String coSystemID) {
		this.coSystemID = coSystemID;
	}
	
}
