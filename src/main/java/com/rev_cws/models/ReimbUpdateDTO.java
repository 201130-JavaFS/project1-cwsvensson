package com.rev_cws.models;

public class ReimbUpdateDTO {

	public String reimbIdFE;  			// Won't need Setters and Getters
	public String reimbResolverIdFE;
	public String reimbStatusIdFE;
	
	public ReimbUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbUpdateDTO(String reimbIdFE, String reimbResolverIdFE, String reimbStatusIdFE) {
		super();
		this.reimbIdFE = reimbIdFE;
		this.reimbResolverIdFE = reimbResolverIdFE;
		this.reimbStatusIdFE = reimbStatusIdFE;
	}

	@Override
	public String toString() {
		return "ReimbUpdateDTO [reimbIdFE=" + reimbIdFE + ", reimbResolverIdFE=" + reimbResolverIdFE
				+ ", reimbStatusIdFE=" + reimbStatusIdFE + "]";
	}
	
}