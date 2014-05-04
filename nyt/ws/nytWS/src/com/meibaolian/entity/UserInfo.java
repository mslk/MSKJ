package com.meibaolian.entity;

import java.io.Serializable;


/**
 * 用户表
 * @author Administrator
 *
 */
public class UserInfo implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String loginname;
	private String password;
	private String phone;
	private String realname;
	private String companyname;
	private String address;
	private int status;
	private int type;
	private int pushstatus;
	private String registertime;
	
	
	private String place_receipt;
	private String telephone ;
	private String fax;
	private String qq;
	private String logo;
	private String province;
	private String 	city;
	private String county;
	private String  park;

	
	
	/**
	 * 以下为物流会员必填项
	 */
	private String cardid;
	private String carnumber;
	private String frame;
	private String engine;

	
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
	
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getPushstatus() {
		return pushstatus;
	}
	public void setPushstatus(int pushstatus) {
		this.pushstatus = pushstatus;
	}
	
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	
	
	public String getPlace_receipt() {
		return place_receipt;
	}
	public void setPlace_receipt(String place_receipt) {
		this.place_receipt = place_receipt;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPark() {
		return park;
	}
	public void setPark(String park) {
		this.park = park;
	}
	public UserInfo() {
	}
	
	public UserInfo(int id, String loginname, String password, String phone,
			String realname, String companyname, String address, int status,
			int type, int pushstatus, String registertime, String cardid,
			String carnumber, String frame, String engine) {
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.phone = phone;
		this.realname = realname;
		this.companyname = companyname;
		this.address = address;
		this.status = status;
		this.type = type;
		this.pushstatus = pushstatus;
		this.registertime = registertime;
		this.cardid = cardid;
		this.carnumber = carnumber;
		this.frame = frame;
		this.engine = engine;
	}
	
	
	
	
	
	


	
	
}
