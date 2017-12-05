package com.etcxm.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order1 {
	private BigDecimal ID;
	private String ORDERCODE;
	private String ADDRESS;
	private String MOBILE;
	private String USERMESSAGE;
	private Timestamp CREATEDATE;
	private Timestamp PAYDATE;
	private Timestamp DELIVERYDATE;
	private Timestamp CONFIRMDATE;
	private String STATUS;
	private String USERNAME;
	private BigDecimal PRODUCT_ID;
	private BigDecimal NUM;
	private BigDecimal PRICE;
	private BigDecimal DISCOUNTPRICE;
	private String NAME;
	private String TITLE;
	private BigDecimal STOCK;
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
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public BigDecimal getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(BigDecimal pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public BigDecimal getNUM() {
		return NUM;
	}
	public void setNUM(BigDecimal nUM) {
		NUM = nUM;
	}
	public BigDecimal getPRICE() {
		return PRICE;
	}
	public void setPRICE(BigDecimal pRICE) {
		PRICE = pRICE;
	}
	public BigDecimal getDISCOUNTPRICE() {
		return DISCOUNTPRICE;
	}
	public void setDISCOUNTPRICE(BigDecimal dISCOUNTPRICE) {
		DISCOUNTPRICE = dISCOUNTPRICE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public BigDecimal getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(BigDecimal sTOCK) {
		STOCK = sTOCK;
	}
	@Override
	public String toString() {
		return "Order1 [ID=" + ID + ", ORDERCODE=" + ORDERCODE + ", ADDRESS="
				+ ADDRESS + ", MOBILE=" + MOBILE + ", USERMESSAGE="
				+ USERMESSAGE + ", CREATEDATE=" + CREATEDATE + ", PAYDATE="
				+ PAYDATE + ", DELIVERYDATE=" + DELIVERYDATE + ", CONFIRMDATE="
				+ CONFIRMDATE + ", STATUS=" + STATUS + ", USERNAME=" + USERNAME
				+ ", PRODUCT_ID=" + PRODUCT_ID + ", NUM=" + NUM + ", PRICE="
				+ PRICE + ", DISCOUNTPRICE=" + DISCOUNTPRICE + ", NAME=" + NAME
				+ ", TITLE=" + TITLE + ", STOCK=" + STOCK + "]";
	}
	public Order1(BigDecimal iD, String oRDERCODE, String aDDRESS,
			String mOBILE, String uSERMESSAGE, Timestamp cREATEDATE,
			Timestamp pAYDATE, Timestamp dELIVERYDATE, Timestamp cONFIRMDATE,
			String sTATUS, String uSERNAME, BigDecimal pRODUCT_ID,
			BigDecimal nUM, BigDecimal pRICE, BigDecimal dISCOUNTPRICE,
			String nAME, String tITLE, BigDecimal sTOCK) {
		super();
		ID = iD;
		ORDERCODE = oRDERCODE;
		ADDRESS = aDDRESS;
		MOBILE = mOBILE;
		USERMESSAGE = uSERMESSAGE;
		CREATEDATE = cREATEDATE;
		PAYDATE = pAYDATE;
		DELIVERYDATE = dELIVERYDATE;
		CONFIRMDATE = cONFIRMDATE;
		STATUS = sTATUS;
		USERNAME = uSERNAME;
		PRODUCT_ID = pRODUCT_ID;
		NUM = nUM;
		PRICE = pRICE;
		DISCOUNTPRICE = dISCOUNTPRICE;
		NAME = nAME;
		TITLE = tITLE;
		STOCK = sTOCK;
	}
	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
