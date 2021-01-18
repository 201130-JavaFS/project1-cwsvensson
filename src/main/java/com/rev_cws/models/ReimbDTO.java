package com.rev_cws.models;


// Gives the stub information for one new reimbursement request.
// The rest is taken care of by the postgres database.

public class ReimbDTO {
	
	public String reimbAmountFE;  // Won't need Setters and Getters
	public String reimbDescFE;
	public String reimbAuthorFE;
	public String reimbStatusFE;
	public String reimbTypeFE;
	
	public ReimbDTO() {
		super();
	}

	public ReimbDTO(String reimbAmountFE, String reimbDescFE, String reimbAuthorFE, String reimbStatusFE,
			String reimbTypeFE) {
		super();
		this.reimbAmountFE = reimbAmountFE;
		this.reimbDescFE = reimbDescFE;
		this.reimbAuthorFE = reimbAuthorFE;
		this.reimbStatusFE = reimbStatusFE;
		this.reimbTypeFE = reimbTypeFE;
	}

	@Override
	public String toString() {
		return "ReimbDTO [reimbAmountFE=" + reimbAmountFE + ", reimbDescFE=" + reimbDescFE + ", reimbAuthorFE="
				+ reimbAuthorFE + ", reimbStatusFE=" + reimbStatusFE + ", reimbTypeFE=" + reimbTypeFE + "]";
	}
}
