package com.pojo;

public class TSystem {
	private int ID;
	private String systemName;
	private String systemDescription;
	private String systemEntryPoint;
	
	public TSystem(int iD, String systemName, String systemDescription, String systemEntryPoint) {
		super();
		ID = iD;
		this.systemName = systemName;
		this.systemDescription = systemDescription;
		this.systemEntryPoint = systemEntryPoint;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemDescription() {
		return systemDescription;
	}

	public void setSystemDescription(String systemDescription) {
		this.systemDescription = systemDescription;
	}

	public String getSystemEntryPoint() {
		return systemEntryPoint;
	}

	public void setSystemEntryPoint(String systemEntryPoint) {
		this.systemEntryPoint = systemEntryPoint;
	}
	
	
}
