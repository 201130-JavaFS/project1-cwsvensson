package com.rev_cws.models;

public class ErsReimbType {

	private int    typeId;
	private String typeDesc;
	
	// Constructors //
	
	public ErsReimbType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeDesc = typeName;
	}

	// Setters and Getters //
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeId;
		result = prime * result + ((typeDesc == null) ? 0 : typeDesc.hashCode());
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
		ErsReimbType other = (ErsReimbType) obj;
		if (typeId != other.typeId)
			return false;
		if (typeDesc == null) {
			if (other.typeDesc != null)
				return false;
		} else if (!typeDesc.equals(other.typeDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimbType [typeId=" + typeId + ", typeName=" + typeDesc + "]";
	}
	
	
}
