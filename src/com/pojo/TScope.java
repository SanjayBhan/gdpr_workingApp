package com.pojo;

public class TScope {
	private int ID;
	private String scopeName;

	public TScope(int iD, String scopeName) {
		super();
		ID = iD;
		this.scopeName = scopeName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	
}
