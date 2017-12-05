package com.etcxm.Entity;

import com.etcxm.Utils.StringUtil;

public class ProductQueryObject extends QueryObject{
	
	private String TITLE;
	private Double minPrice;
	private Double maxPrice;
	private Long ID;
	public Long getID() {
		return ID;
	}
	public void setDir_id(Long ID) {
		this.ID = ID;
	}
	public void customQuery(){
		if(StringUtil.hasLength(TITLE)){
			super.addQuery(" TITLE LIKE ?", "%"+TITLE+"%");	
		}
		if(minPrice!=null){
			super.addQuery(" PRICE >= ?", minPrice);
		}
		if(maxPrice!=null){
			super.addQuery(" PRICE <= ?", maxPrice);
		}
		if(ID!=null ){
			super.addQuery(" ID = ?", ID);
		}
	}
	public ProductQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductQueryObject(String tITLE, Double minPrice, Double maxPrice) {
		super();
		TITLE = tITLE;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	

}
