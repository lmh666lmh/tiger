package com.etcxm.Entity;

import java.math.BigDecimal;

public class Category {
private BigDecimal ID;
private String NAME;
public Category() {
	super();
	// TODO Auto-generated constructor stub
}
public Category(BigDecimal id, String name) {
	super();
	this.ID = id;
	this.NAME = name;
}
public BigDecimal getId() {
	return ID;
}
public void setId(BigDecimal id) {
	this.ID = id;
}
public String getName() {
	return NAME;
}
public void setName(String name) {
	this.NAME = name;
}
@Override
public String toString() {
	return "Category [id=" + ID + ", name=" + NAME + "]";
}


}
