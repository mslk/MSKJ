package com.meibaolian.entity.nyt;

import com.meibaolian.entity.UserInfo;

/**
 * 
 * 淀粉/原木/胶合板 供应实体类
 * @author zhaojian
 * @version 1.0[2014.05.05 15:07]
 * 
 */
public class WoodSupplyBean {
	private int id; 
	private UserInfo userinfo;
	private String length;
	private String width;
	private String thickness;
	private int number;
	private int price;
	private String valid;
	private String description;
	private String cultivated;
	private String tail_directly;
	private String unit;
	private String brand;
	private String level;
	private String producer;
	private int type;
	private String addtime;
	private int orderid;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
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
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
