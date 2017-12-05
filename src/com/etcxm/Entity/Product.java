package com.etcxm.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {

	private BigDecimal ID;
	private BigDecimal CID;
	private String NAME;
	private String TITLE;
	private BigDecimal PRICE;
	private BigDecimal DISCOUNTPRICE;
	private BigDecimal STOCK;
	private Timestamp CREATEDATE;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(BigDecimal iD, BigDecimal cID, String nAME, String tITLE,
			BigDecimal pRICE, BigDecimal dISCOUNTPRICE, BigDecimal sTOCK,
			Timestamp cREATEDATE) {
		super();
		ID = iD;
		CID = cID;
		NAME = nAME;
		TITLE = tITLE;
		PRICE = pRICE;
		DISCOUNTPRICE = dISCOUNTPRICE;
		STOCK = sTOCK;
		CREATEDATE = cREATEDATE;
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
	public BigDecimal getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(BigDecimal sTOCK) {
		STOCK = sTOCK;
	}
	public Timestamp getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(Timestamp cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", CID=" + CID + ", NAME=" + NAME
				+ ", TITLE=" + TITLE + ", PRICE=" + PRICE + ", DISCOUNTPRICE="
				+ DISCOUNTPRICE + ", STOCK=" + STOCK + ", CREATEDATE="
				+ CREATEDATE + "]";
	}

	
	
}