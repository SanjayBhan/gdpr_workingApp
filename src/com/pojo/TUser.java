package com.pojo;

public class TUser {
	private int ID;
	private String userName;
	private String userDisplayName;
	private String userPassword;
	
	private int userIsAdmin;
	private int userIsActive;
	
	public TUser(int iD, String userName, String userDisplayName, String userPassword, int userIsAdmin, int userIsActive) { 
		super();
		ID = iD;
		this.userName = userName;
		this.userDisplayName = userDisplayName;
		this.userPassword = userPassword;		
		this.userIsAdmin = userIsAdmin;
		this.userIsActive = userIsActive;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserIsAdmin() {
		return userIsAdmin;
	}

	public void setUserIsAdmin(int userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

	public int getUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(int userIsActive) {
		this.userIsActive = userIsActive;
	}
	

	
}



//SELECT tddrstatus.ID, tddrstatus.statusDescription, tstatustype.levelDescription FROM tddrstatus LEFT JOIN tstatustype ON ( tstatustype.ID = tddrstatus.statusType )