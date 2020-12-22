package com.rev_cws.models;

public class ErsUser {

	private int         userId;
	private String      userName;
	private String      userPassword;
	private String      userFname;
	private String      userLname;
	private String      userEmail;
	private ErsUserRole ersUserRoleId;

	// Constructors //

	public ErsUser() {
		super();
	}

	public ErsUser(String userName, String userPassword, String userFname, String userLname, String userEmail,
			ErsUserRole ersUserRoleId) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userEmail = userEmail;
		this.ersUserRoleId = ersUserRoleId;
	}

	public ErsUser(int userId, String userName, String userPassword, String userFname, String userLname,
			String userEmail, ErsUserRole ersUserRoleId) {
		super();
		this.userId    = userId;
		this.userName  = userName;
		this.userPassword = userPassword;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userEmail = userEmail;
		this.ersUserRoleId = ersUserRoleId;
	}

	// Setters and Getters //

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ErsUserRole getErsUserRoleId() {
		return ersUserRoleId;
	}

	public void setErsUserRoleId(ErsUserRole ersUserRoleId) {
		this.ersUserRoleId = ersUserRoleId;
	}

	// hashCode //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersUserRoleId == null) ? 0 : ersUserRoleId.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFname == null) ? 0 : userFname.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLname == null) ? 0 : userLname.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	// equals //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUser other = (ErsUser) obj;
		if (ersUserRoleId == null) {
			if (other.ersUserRoleId != null)
				return false;
		} else if (!ersUserRoleId.equals(other.ersUserRoleId))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFname == null) {
			if (other.userFname != null)
				return false;
		} else if (!userFname.equals(other.userFname))
			return false;
		if (userId != other.userId)
			return false;
		if (userLname == null) {
			if (other.userLname != null)
				return false;
		} else if (!userLname.equals(other.userLname))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	// toString //
	
	@Override
	public String toString() {
		return "ErsUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFname=" + userFname + ", userLname=" + userLname + ", userEmail=" + userEmail
				+ ", ersUserRoleId=" + ersUserRoleId + "]";
	}
}