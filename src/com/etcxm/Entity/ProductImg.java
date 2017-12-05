package com.etcxm.Entity;

import java.math.BigDecimal;

public class ProductImg {
	private BigDecimal ID;
	private BigDecimal PID;
	private String TYPE;

	public ProductImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImg(BigDecimal iD, BigDecimal pID, String tYPE) {
		super();
		ID = iD;
		PID = pID;
		TYPE = tYPE;
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

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	@Override
	public String toString() {
		return "ProductImg [ID=" + ID + ", PID=" + PID + ", TYPE=" + TYPE + "]";
	}

}
