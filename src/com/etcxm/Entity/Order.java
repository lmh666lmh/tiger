package com.etcxm.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {

	private BigDecimal ID;
	private String ORDERCODE;
	private String ADDRESS;
	private String POST;
	private String RECEVIER;
	private String MOBILE;
	private String USERMESSAGE;
	private Timestamp CREATEDATE;
	private Timestamp PAYDATE;
	private Timestamp DELIVERYDATE;
	private Timestamp CONFIRMDATE;
	private String STATUS;
	private BigDecimal USERID;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(BigDecimal iD, String oRDERCODE, String aDDRESS, String pOST,
			String rECEVIER, String mOBILE, String uSERMESSAGE,
			Timestamp cREATEDATE, Timestamp pAYDATE, Timestamp dELIVERYDATE,
			Timestamp cONFIRMDATE, String sTATUS, BigDecimal uSERID) {
		super();
		ID = iD;
		ORDERCODE = oRDERCODE;
		ADDRESS = aDDRESS;
		POST = pOST;
		RECEVIER = rECEVIER;
		MOBILE = mOBILE;
		USERMESSAGE = uSERMESSAGE;
		CREATEDATE = cREATEDATE;
		PAYDATE = pAYDATE;
		DELIVERYDATE = dELIVERYDATE;
		CONFIRMDATE = cONFIRMDATE;
		STATUS = sTATUS;
		USERID = uSERID;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public String getORDERCODE() {
		return ORDERCODE;
	}

	public void setORDERCODE(String oRDERCODE) {
		ORDERCODE = oRDERCODE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getPOST() {
		return POST;
	}

	public void setPOST(String pOST) {
		POST = pOST;
	}

	public String getRECEVIER() {
		return RECEVIER;
	}

	public void setRECEVIER(String rECEVIER) {
		RECEVIER = rECEVIER;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public String getUSERMESSAGE() {
		return USERMESSAGE;
	}

	public void setUSERMESSAGE(String uSERMESSAGE) {
		USERMESSAGE = uSERMESSAGE;
	}

	public Timestamp getCREATEDATE() {
		return CREATEDATE;
	}

	public void setCREATEDATE(Timestamp cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}

	public Timestamp getPAYDATE() {
		return PAYDATE;
	}

	public void setPAYDATE(Timestamp pAYDATE) {
		PAYDATE = pAYDATE;
	}

	public Timestamp getDELIVERYDATE() {
		return DELIVERYDATE;
	}

	public void setDELIVERYDATE(Timestamp dELIVERYDATE) {
		DELIVERYDATE = dELIVERYDATE;
	}

	public Timestamp getCONFIRMDATE() {
		return CONFIRMDATE;
	}

	public void setCONFIRMDATE(Timestamp cONFIRMDATE) {
		CONFIRMDATE = cONFIRMDATE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public BigDecimal getUSERID() {
		return USERID;
	}

	public void setUSERID(BigDecimal uSERID) {
		USERID = uSERID;
	}

	@Override
	public String toString() {
		return "Order [ID=" + ID + ", ORDERCODE=" + ORDERCODE + ", ADDRESS="
				+ ADDRESS + ", POST=" + POST + ", RECEVIER=" + RECEVIER
				+ ", MOBILE=" + MOBILE + ", USERMESSAGE=" + USERMESSAGE
				+ ", CREATEDATE=" + CREATEDATE + ", PAYDATE=" + PAYDATE
				+ ", DELIVERYDATE=" + DELIVERYDATE + ", CONFIRMDATE="
				+ CONFIRMDATE + ", STATUS=" + STATUS + ", USERID=" + USERID
				+ "]";
	}

}
