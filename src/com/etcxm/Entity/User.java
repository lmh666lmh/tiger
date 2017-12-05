package com.etcxm.Entity;

import java.math.BigDecimal;

public class User {
	private BigDecimal ID;
	private String USERNAME;
	private String PASSWORD;
	private String EMAIL;
	private String ADDRESS;
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", USERNAME=" + USERNAME + ", PASSWORD="
				+ PASSWORD + ", EMAIL=" + EMAIL + ", ADDRESS=" + ADDRESS + "]";
	}
	public User(BigDecimal iD, String uSERNAME, String pASSWORD, String eMAIL,
			String aDDRESS) {
		super();
		ID = iD;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		EMAIL = eMAIL;
		ADDRESS = aDDRESS;
	}
	public BigDecimal getID() {
		return ID;
	}
	public void setID(BigDecimal iD) {
		ID = iD;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	
}
