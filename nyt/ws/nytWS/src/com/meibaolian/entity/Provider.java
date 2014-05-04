package com.meibaolian.entity;

import java.math.BigDecimal;


/**
 * 出售单
 * llm
 */

public class Provider implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer proid;
	private Integer userid;
	private String addtime;
	private Integer coaltype;
	private String coalname;
	private String buyername;
	private Integer heating;
	private Integer coalsize;
	private String coalsizename;
	private BigDecimal sulphur;
	private BigDecimal ash;
	private BigDecimal moisture;
	private BigDecimal price;
	private BigDecimal taxprice;
	private Integer transportype;
	private String sendoutplace;
	private String place;
	private String validdate;
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
	// Constructors

	/** default constructor */
	public Provider() {
	}

	/** minimal constructor */
	public Provider(Integer userid, String addtime, Integer coaltype,
			String coalname, String validdate, Integer quantity,
			Integer sortnumber, Integer status, String phone) {
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.validdate = validdate;
		this.quantity = quantity;
		this.sortnumber = sortnumber;
		this.status = status;
		this.phone = phone;
	}

	/** full constructor */
	public Provider(Integer userid, String addtime, Integer coaltype,
			String coalname, String buyername, Integer heating,
			Integer coalsize, BigDecimal sulphur, BigDecimal ash,
			BigDecimal moisture, BigDecimal price, BigDecimal taxprice,
			Integer transportype, String sendoutplace, String place,
			String validdate, Integer quantity, Integer sortnumber,
			Integer status, String phone) {
		super();
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.buyername = buyername;
		this.heating = heating;
		this.coalsize = coalsize;
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
	}
	
	public Provider(Integer userid, Integer coaltype, String coalname,
			Integer heating, Integer coalsize, String coalsizename,
			BigDecimal sulphur, BigDecimal ash, BigDecimal moisture,
			BigDecimal price, BigDecimal taxprice, Integer transportype,
			String place, String validdate, Integer quantity,
			Integer sortnumber, Integer status, Integer placeid,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			String startshortname) {
		super();
		this.userid = userid;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.heating = heating;
		this.coalsize = coalsize;
		this.coalsizename = coalsizename;
		this.sulphur = sulphur;
		this.ash = ash;
		this.moisture = moisture;
		this.price = price;
		this.taxprice = taxprice;
		this.transportype = transportype;
		this.place = place;
		this.validdate = validdate;
		this.quantity = quantity;
		this.sortnumber = sortnumber;
		this.status = status;
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
		return proid;
	}

	

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Integer getCoaltype() {
		return coaltype;
	}

	public void setCoaltype(Integer coaltype) {
		this.coaltype = coaltype;
	}

	public String getCoalname() {
		return coalname;
	}

	public void setCoalname(String coalname) {
		this.coalname = coalname;
	}

	public String getBuyername() {
		return buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public Integer getHeating() {
		return heating;
	}

	public void setHeating(Integer heating) {
		this.heating = heating;
	}

	public Integer getCoalsize() {
		return coalsize;
	}

	public void setCoalsize(Integer coalsize) {
		this.coalsize = coalsize;
	}

	public BigDecimal getSulphur() {
		return sulphur;
	}

	public void setSulphur(BigDecimal sulphur) {
		this.sulphur = sulphur;
	}

	public BigDecimal getAsh() {
		return ash;
	}

	public void setAsh(BigDecimal ash) {
		this.ash = ash;
	}

	public BigDecimal getMoisture() {
		return moisture;
	}

	public void setMoisture(BigDecimal moisture) {
		this.moisture = moisture;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTaxprice() {
		return taxprice;
	}

	public void setTaxprice(BigDecimal taxprice) {
		this.taxprice = taxprice;
	}

	public Integer getTransportype() {
		return transportype;
	}

	public void setTransportype(Integer transportype) {
		this.transportype = transportype;
	}

	public String getSendoutplace() {
		return sendoutplace;
	}

	public void setSendoutplace(String sendoutplace) {
		this.sendoutplace = sendoutplace;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSortnumber() {
		return sortnumber;
	}

	public void setSortnumber(Integer sortnumber) {
		this.sortnumber = sortnumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCoalsizename() {
		return coalsizename;
	}

	public void setCoalsizename(String coalsizename) {
		this.coalsizename = coalsizename;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Integer placeid) {
		this.placeid = placeid;
	}

	public Integer getStartcountyid() {
		return startcountyid;
	}

	public void setStartcountyid(Integer startcountyid) {
		this.startcountyid = startcountyid;
	}

	public String getStartcountyname() {
		return startcountyname;
	}

	public void setStartcountyname(String startcountyname) {
		this.startcountyname = startcountyname;
	}

	public Integer getStartcityid() {
		return startcityid;
	}

	public void setStartcityid(Integer startcityid) {
		this.startcityid = startcityid;
	}

	public String getStartcityname() {
		return startcityname;
	}

	public void setStartcityname(String startcityname) {
		this.startcityname = startcityname;
	}

	public Integer getStartprvid() {
		return startprvid;
	}

	public void setStartprvid(Integer startprvid) {
		this.startprvid = startprvid;
	}

	public String getStartprvname() {
		return startprvname;
	}

	public void setStartprvname(String startprvname) {
		this.startprvname = startprvname;
	}

	public String getStartshortname() {
		return startshortname;
	}

	public void setStartshortname(String startshortname) {
		this.startshortname = startshortname;
	}
}