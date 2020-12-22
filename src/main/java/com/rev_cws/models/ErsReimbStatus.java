package com.rev_cws.models;

public class ErsReimbStatus {

	private int    statusId;
	private String statusDesc;
	
	// Constructors //
	
	public ErsReimbStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbStatus(int statusId, String statusDesc) {
		super();
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}
	
	// Setters and Getters //
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
		result = prime * result + statusId;
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
		ErsReimbStatus other = (ErsReimbStatus) obj;
		if (statusDesc == null) {
			if (other.statusDesc != null)
				return false;
		} else if (!statusDesc.equals(other.statusDesc))
			return false;
		if (statusId != other.statusId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimbStatus [statusId=" + statusId + ", statusDesc=" + statusDesc + "]";
	}
	

}