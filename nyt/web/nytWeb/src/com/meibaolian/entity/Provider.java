package com.meibaolian.entity;

import java.sql.Timestamp;

/**
 * Provider entity. @author MyEclipse Persistence Tools
 */

public class Provider implements java.io.Serializable {

	// Fields

	private Integer proid;
	private Integer userid;
	private Timestamp addtime;
	private Integer coaltype;
	private String coalname;
	private String buyername;
	private Integer heating;
	private Integer coalsize;
	private String coalsizename;
	private String sulphur;
	private String ash;
	private String moisture;
	private String price;
	private String taxprice;
	private Integer transportype;
	private String sendoutplace;
	private String place;
	private Timestamp validdate;
	private Integer quantity;
	private Integer sortnumber;
	private Integer status;
	private String phone;
	private String company;
	private Integer placeid;
	private Integer startcountyid;
	private String startcountyname;
	private Integer startcityid;
	private String startcityname;
	private Integer startprvid;
	private String startprvname;
	private String startshortname;
	private Integer validstatus;
	// Constructors

	/** default constructor */
	public Provider() {
	}

	/** minimal constructor */
	public Provider(Integer userid, Timestamp addtime, Integer coaltype,
			String coalname, Timestamp validdate, Integer quantity,
			Integer sortnumber, Integer status) {
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.validdate = validdate;
		this.quantity = quantity;
		this.sortnumber = sortnumber;
		this.status = status;
	}

	/** full constructor */
	public Provider(Integer userid, Timestamp addtime, Integer coaltype,
			String coalname, String buyername, Integer heating,
			Integer coalsize, String coalsizename, String sulphur, String ash,
			String moisture, String price, String taxprice,
			Integer transportype, String sendoutplace, String place,
			Timestamp validdate, Integer quantity, Integer sortnumber,
			Integer status, String phone, String company, Integer placeid,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			String startshortname) {
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.buyername = buyername;
		this.heating = heating;
		this.coalsize = coalsize;
		this.coalsizename = coalsizename;
		this.sulphur = sulphur;
		this.ash = ash;
		this.moisture = moisture;
		this.price = price;
		this.taxprice = taxprice;
		this.transportype = transportype;
		this.sendoutplace = sendoutplace;
		this.place = place;
		this.validdate = validdate;
		this.quantity = quantity;
		this.sortnumber = sortnumber;
		this.status = status;
		this.phone = phone;
		this.company = company;
		this.placeid = placeid;
		this.startcountyid = startcountyid;
		this.startcountyname = startcountyname;
		this.startcityid = startcityid;
		this.startcityname = startcityname;
		this.startprvid = startprvid;
		this.startprvname = startprvname;
		this.startshortname = startshortname;
	}

	// Property accessors

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getCoaltype() {
		return this.coaltype;
	}

	public void setCoaltype(Integer coaltype) {
		this.coaltype = coaltype;
	}

	public String getCoalname() {
		return this.coalname;
	}

	public void setCoalname(String coalname) {
		this.coalname = coalname;
	}

	public String getBuyername() {
		return this.buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public Integer getHeating() {
		return this.heating;
	}

	public void setHeating(Integer heating) {
		this.heating = heating;
	}

	public Integer getCoalsize() {
		return this.coalsize;
	}

	public void setCoalsize(Integer coalsize) {
		this.coalsize = coalsize;
	}

	public String getCoalsizename() {
		return this.coalsizename;
	}

	public void setCoalsizename(String coalsizename) {
		this.coalsizename = coalsizename;
	}

	public String getSulphur() {
		return this.sulphur;
	}

	public void setSulphur(String sulphur) {
		this.sulphur = sulphur;
	}

	public String getAsh() {
		return this.ash;
	}

	public void setAsh(String ash) {
		this.ash = ash;
	}

	public String getMoisture() {
		return this.moisture;
	}

	public void setMoisture(String moisture) {
		this.moisture = moisture;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTaxprice() {
		return this.taxprice;
	}

	public void setTaxprice(String taxprice) {
		this.taxprice = taxprice;
	}

	public Integer getTransportype() {
		return this.transportype;
	}

	public void setTransportype(Integer transportype) {
		this.transportype = transportype;
	}

	public String getSendoutplace() {
		return this.sendoutplace;
	}

	public void setSendoutplace(String sendoutplace) {
		this.sendoutplace = sendoutplace;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Timestamp getValiddate() {
		return this.validdate;
	}

	public void setValiddate(Timestamp validdate) {
		this.validdate = validdate;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSortnumber() {
		return this.sortnumber;
	}

	public void setSortnumber(Integer sortnumber) {
		this.sortnumber = sortnumber;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Integer placeid) {
		this.placeid = placeid;
	}

	public Integer getStartcountyid() {
		return this.startcountyid;
	}

	public void setStartcountyid(Integer startcountyid) {
		this.startcountyid = startcountyid;
	}

	public String getStartcountyname() {
		return this.startcountyname;
	}

	public void setStartcountyname(String startcountyname) {
		this.startcountyname = startcountyname;
	}

	public Integer getStartcityid() {
		return this.startcityid;
	}

	public void setStartcityid(Integer startcityid) {
		this.startcityid = startcityid;
	}

	public String getStartcityname() {
		return this.startcityname;
	}

	public void setStartcityname(String startcityname) {
		this.startcityname = startcityname;
	}

	public Integer getStartprvid() {
		return this.startprvid;
	}

	public void setStartprvid(Integer startprvid) {
		this.startprvid = startprvid;
	}

	public String getStartprvname() {
		return this.startprvname;
	}

	public void setStartprvname(String startprvname) {
		this.startprvname = startprvname;
	}

	public String getStartshortname() {
		return this.startshortname;
	}

	public void setStartshortname(String startshortname) {
		this.startshortname = startshortname;
	}

	public Integer getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(Integer validstatus) {
		this.validstatus = validstatus;
	}

}