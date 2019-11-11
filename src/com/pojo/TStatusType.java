package com.pojo;

public class TStatusType {
	
	private int ID;
	private String levelDescription;

	public TStatusType(int iD, String levelDescription) {
		super();
		ID = iD;
		this.levelDescription = levelDescription;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}
	
	
	
}
