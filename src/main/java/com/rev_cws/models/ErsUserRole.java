package com.rev_cws.models;

public class ErsUserRole {

	private String roleId;
	private String roleDesc;
	
	// Constructors //
	
	public ErsUserRole() {
		super();
	}

	public ErsUserRole(String roleID, String roleDesc) {
		super();
		this.roleId = roleID;
		this.roleDesc = roleDesc;
	}
	
	// Setters and Getters //

	public String getRoleID() {
		return roleId;
	}

	public void setRoleID(String roleID) {
		this.roleId = roleID;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUserRole other = (ErsUserRole) obj;
		if (roleDesc == null) {
			if (other.roleDesc != null)
				return false;
		} else if (!roleDesc.equals(other.roleDesc))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsUserRole [roleID=" + roleId + ", roleDesc=" + roleDesc + "]";
	}
	
}
