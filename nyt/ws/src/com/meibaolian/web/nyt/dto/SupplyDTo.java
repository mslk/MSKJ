package com.meibaolian.web.nyt.dto;


public class SupplyDTo 
{

	private int type;
	private String key;
	private int priceOrder;
	private int numOrder;
	private String length;
	private String width;
	private String thickness;
	
	private String cultivated;
	private String tail_directly;
	
	private String brand;
	private Integer level;
	
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(int priceOrder) {
		this.priceOrder = priceOrder;
	}
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getCultivated() {
		return cultivated;
	}
	public void setCultivated(String cultivated) {
		this.cultivated = cultivated;
	}
	public String getTail_directly() {
		return tail_directly;
	}
	public void setTail_directly(String tail_directly) {
		this.tail_directly = tail_directly;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
}
