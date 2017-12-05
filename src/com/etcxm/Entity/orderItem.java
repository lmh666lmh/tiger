package com.etcxm.Entity;

import java.math.BigDecimal;

public class orderItem {
	private BigDecimal ID;
	private BigDecimal PID;
	private BigDecimal USERID;
	private BigDecimal OID;
	private BigDecimal NUM;

	public orderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderItem(BigDecimal iD, BigDecimal pID, BigDecimal uSERID,
			BigDecimal oID, BigDecimal nUM) {
		super();
		ID = iD;
		PID = pID;
		USERID = uSERID;
		OID = oID;
		NUM = nUM;
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

	public BigDecimal getUSERID() {
		return USERID;
	}

	public void setUSERID(BigDecimal uSERID) {
		USERID = uSERID;
	}

	public BigDecimal getOID() {
		return OID;
	}

	public void setOID(BigDecimal oID) {
		OID = oID;
	}

	public BigDecimal getNUM() {
		return NUM;
	}

	public void setNUM(BigDecimal nUM) {
		NUM = nUM;
	}

	@Override
	public String toString() {
		return "orderItem [ID=" + ID + ", PID=" + PID + ", USERID=" + USERID
				+ ", OID=" + OID + ", NUM=" + NUM + "]";
	}

}
