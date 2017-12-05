package com.etcxm.Entity;

import java.math.BigDecimal;

public class ProductValue {
	private BigDecimal ID;
	private BigDecimal PID;
	private String NAME;
	private String VALUE;

	public ProductValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductValue(BigDecimal iD, BigDecimal pID, String nAME, String vALUE) {
		super();
		ID = iD;
		PID = pID;
		NAME = nAME;
		VALUE = vALUE;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public BigDecimal getPID() {
		return PID;
	}

	public void setPID(BigDecimal pID) {
		PID = pID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getVALUE() {
		return VALUE;
	}

	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}

	@Override
	public String toString() {
		return "ProductValue [ID=" + ID + ", PID=" + PID + ", NAME=" + NAME
				+ ", VALUE=" + VALUE + "]";
	}

}
