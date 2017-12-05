package com.etcxm.Entity;

import java.math.BigDecimal;

public class Property {
	private BigDecimal ID;
	private BigDecimal CID;
	private String NAME;

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(BigDecimal iD, BigDecimal cID, String name) {
		super();
		ID = iD;
		CID = cID;
		this.NAME = name;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public BigDecimal getCID() {
		return CID;
	}

	public void setCID(BigDecimal cID) {
		CID = cID;
	}

	public String getName() {
		return NAME;
	}

	public void setName(String name) {
		this.NAME = name;
	}

	@Override
	public String toString() {
		return "Property [ID=" + ID + ", CID=" + CID + ", name=" + NAME + "]";
	}

}
