package com.pojo;

public class TDdrStatus {
		
	private int ID;
	private int statusType;
	private String statusDescription;
	
	public TDdrStatus(int iD, int statusType, String statusDescription) {
		super();
		ID = iD;
		this.statusType = statusType;
		this.statusDescription = statusDescription;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getStatusType() {
		return statusType;
	}

	public void setStatusType(int statusType) {
		this.statusType = statusType;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	
}
