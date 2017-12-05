package com.etcxm.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Shoppingent {

	private int ID;
	private String  IMG;
	private String ORDERCODE;
	private Timestamp CREATEDATE;
	private int NUM;
	private String TITLE;
	private double PRICE;
	
	private double TOTAL;//总数ONETOTAL1+ONETOTAL2
	private double ONETOTAL;//当个总价PRICE*NUM
	public Shoppingent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shoppingent(int iD, String iMG, String oRDERCODE, Timestamp cREATEDATE, int nUM, String tITLE,
			double pRICE) {
		super();
		ID = iD;
		IMG = iMG;
		ORDERCODE = oRDERCODE;
		CREATEDATE = cREATEDATE;
		NUM = nUM;
		TITLE = tITLE;
		PRICE = pRICE;
		
		TOTAL = nUM*pRICE;
		ONETOTAL += TOTAL;
	}
	public double getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public String getORDERCODE() {
		return ORDERCODE;
	}
	public void setORDERCODE(String oRDERCODE) {
		ORDERCODE = oRDERCODE;
	}
	public Timestamp getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(Timestamp cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}
	public double getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	public double getTOTAL() {
		return TOTAL= NUM*PRICE;
	}
	public double getONETOTAL() {
		return ONETOTAL;
	}
	@Override
	public String toString() {
		return "Shoppingent [ID=" + ID + ", IMG=" + IMG + ", ORDERCODE=" + ORDERCODE + ", CREATEDATE=" + CREATEDATE
				+ ", NUM=" + NUM + ", TITLE=" + TITLE + ", PRICE=" + PRICE + ", TOTAL=" + TOTAL + ", ONETOTAL="
				+ ONETOTAL + "]\n";
	}
	
	

	
	
}
