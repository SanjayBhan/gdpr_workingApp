package com.pojo;

public class TCompany {
	
	private int ID;
	private String companyName;
	private String divisionID;
	private String companyMnemonic;
	
	public TCompany(int iD, String companyName, String divisionID, String companyMnemonic) {
		super();
		ID = iD;
		this.companyName = companyName;
		this.divisionID = divisionID;
		this.companyMnemonic = companyMnemonic;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDivisionID() {
		return divisionID;
	}

	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}

	public String getCompanyMnemonic() {
		return companyMnemonic;
	}

	public void setCompanyMnemonic(String companyMnemonic) {
		this.companyMnemonic = companyMnemonic;
	}
	
	
	
	
}
