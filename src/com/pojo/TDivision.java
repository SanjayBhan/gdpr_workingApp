package com.pojo;

public class TDivision {
		
	private int ID;
	private String divisionName;
	private String divisionMnemonic;
	
	public TDivision(int iD, String divisionName, String divisionMnemonic) {
		super();
		ID = iD;
		this.divisionName = divisionName;
		this.divisionMnemonic = divisionMnemonic;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionMnemonic() {
		return divisionMnemonic;
	}

	public void setDivisionMnemonic(String divisionMnemonic) {
		this.divisionMnemonic = divisionMnemonic;
	}
	
	
}
