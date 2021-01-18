package com.rev_cws.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ErsReimb {
	
	private int        reimbId;
	private BigDecimal reimbAmount;
	private Timestamp  reimbSubmitted;
	private Timestamp  reimbResolved;
	private String     reimbDesc;
	private String	   reimbReceipt;
	private ErsUser	       ersUserAuthorId;
	private ErsUser        ersUserResolverId;
	private ErsReimbStatus ersStatusId;
	private ErsReimbType   ersTypeId;
	
	//Constructors //
	
	public ErsReimb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimb(int reimbId, BigDecimal reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDesc, String reimbReceipt, ErsUser ersUserAuthorId, ErsUser ersUserResolverId,
			ErsReimbStatus ersStatusId, ErsReimbType ersTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDesc = reimbDesc;
		this.reimbReceipt = reimbReceipt;
		this.ersUserAuthorId = ersUserAuthorId;
		this.ersUserResolverId = ersUserResolverId;
		this.ersStatusId = ersStatusId;
		this.ersTypeId = ersTypeId;
	}

	public ErsReimb(int reimbId, BigDecimal reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDesc, String reimbReceipt) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDesc = reimbDesc;
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbId() {
		return reimbId;
	}


	public BigDecimal getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(BigDecimal reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public String getReimbDesc() {
		return reimbDesc;
	}

	public void setReimbDesc(String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}

	public String getReimbReceipt() {
		return reimbReceipt;
	}

	public ErsUser getErsUserAuthorId() {
		return ersUserAuthorId;
	}

	public void setErsUserAuthorId(ErsUser ersUserAuthorId) {
		this.ersUserAuthorId = ersUserAuthorId;
	}

	public ErsUser getErsUserResolverId() {
		return ersUserResolverId;
	}

	public void setErsUserResolverId(ErsUser ersUserResolverId) {
		this.ersUserResolverId = ersUserResolverId;
	}

	public ErsReimbStatus getErsStatusId() {
		return ersStatusId;
	}

	public void setErsStatusId(ErsReimbStatus ersStatusId) {
		this.ersStatusId = ersStatusId;
	}

	public ErsReimbType getErsTypeId() {
		return ersTypeId;
	}

	public void setErsTypeId(ErsReimbType ersTypeId) {
		this.ersTypeId = ersTypeId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsReimb other = (ErsReimb) obj;
		if (ersStatusId == null) {
			if (other.ersStatusId != null)
				return false;
		} else if (!ersStatusId.equals(other.ersStatusId))
			return false;
		if (ersTypeId == null) {
			if (other.ersTypeId != null)
				return false;
		} else if (!ersTypeId.equals(other.ersTypeId))
			return false;
		if (ersUserAuthorId == null) {
			if (other.ersUserAuthorId != null)
				return false;
		} else if (!ersUserAuthorId.equals(other.ersUserAuthorId))
			return false;
		if (ersUserResolverId == null) {
			if (other.ersUserResolverId != null)
				return false;
		} else if (!ersUserResolverId.equals(other.ersUserResolverId))
			return false;
		if (reimbAmount == null) {
			if (other.reimbAmount != null)
				return false;
		} else if (!reimbAmount.equals(other.reimbAmount))
			return false;
		if (reimbDesc == null) {
			if (other.reimbDesc != null)
				return false;
		} else if (!reimbDesc.equals(other.reimbDesc))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbReceipt == null) {
			if (other.reimbReceipt != null)
				return false;
		} else if (!reimbReceipt.equals(other.reimbReceipt))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimb [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDesc=" + reimbDesc + ", reimbReceipt=" + reimbReceipt
				+ ", ersUserAuthorId=" + ersUserAuthorId + ", ersUserResolverId=" + ersUserResolverId + ", ersStatusId="
				+ ersStatusId + ", ersTypeId=" + ersTypeId + "]";
	}
}