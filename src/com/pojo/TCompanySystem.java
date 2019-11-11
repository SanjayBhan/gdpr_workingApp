package com.pojo;

public class TCompanySystem {
	
	private int ID;
	private String companyID;
	private String systemID;
	private String responsiblePersonID;

	public TCompanySystem(int iD, String companyID, String systemID, String responsiblePersonID) {
		super();
		ID = iD;
		this.companyID = companyID;
		this.systemID = systemID;
		this.responsiblePersonID = responsiblePersonID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public String getResponsiblePersonID() {
		return responsiblePersonID;
	}

	public void setResponsiblePersonID(String responsiblePersonID) {
		this.responsiblePersonID = responsiblePersonID;
	}
	
}
