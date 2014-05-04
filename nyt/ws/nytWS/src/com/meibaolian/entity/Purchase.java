package com.meibaolian.entity;

import java.math.BigDecimal;


/**
 * 求购单
 * llm 
 */

public class Purchase implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fields

	private Integer purid;
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
	private String place;
	private String receiptplace;
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
	private Integer receiptplaceid;
	private Integer stopcityid;
	private String stopcityname;
	private Integer stopprvid;
	private String stopprvname;
	private String stopshortname;
	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(Integer userid, String addtime, Integer coaltype,
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
	public Purchase(Integer userid, String addtime, Integer coaltype,
			String coalname, String buyername, Integer heating,
			Integer coalsize, BigDecimal sulphur, BigDecimal ash, BigDecimal moisture,
			BigDecimal price, BigDecimal taxprice, Integer transportype, String place,
			String receiptplace, String validdate, Integer quantity,
			Integer sortnumber, Integer status, String phone) {
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
		this.place = place;
		this.receiptplace = receiptplace;
		this.validdate = validdate;
		this.quantity = quantity;
		this.sortnumber = sortnumber;
		this.status = status;
		this.phone = phone;
	}

	public Purchase(Integer userid, Integer coaltype, String coalname,
			Integer heating, Integer coalsize, String coalsizename,
			BigDecimal sulphur, BigDecimal ash, BigDecimal moisture,
			BigDecimal price, BigDecimal taxprice, String place,
			String receiptplace, String validdate, Integer quantity,
			Integer sortnumber, Integer status, Integer placeid,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			String shortname, Integer receiptplaceid, Integer stopcityid,
			String stopcityname, Integer stopprvid, String stopprvname, String stopshortname) {
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
		this.place = place;
		this.receiptplace = receiptplace;
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
		this.startshortname = shortname;
		this.receiptplaceid = receiptplaceid;
		this.stopcityid = stopcityid;
		this.stopcityname = stopcityname;
		this.stopprvid = stopprvid;
		this.stopprvname = stopprvname;
		this.stopshortname = stopshortname;
	}

	// Property accessors
	
	public Integer getPurid() {
		return this.purid;
	}

	public void setPurid(Integer purid) {
		this.purid = purid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
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

	public BigDecimal getSulphur() {
		return this.sulphur;
	}

	public void setSulphur(BigDecimal sulphur) {
		this.sulphur = sulphur;
	}

	public BigDecimal getAsh() {
		return this.ash;
	}

	public void setAsh(BigDecimal ash) {
		this.ash = ash;
	}

	public BigDecimal getMoisture() {
		return this.moisture;
	}

	public void setMoisture(BigDecimal moisture) {
		this.moisture = moisture;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTaxprice() {
		return this.taxprice;
	}

	public void setTaxprice(BigDecimal taxprice) {
		this.taxprice = taxprice;
	}

	public Integer getTransportype() {
		return this.transportype;
	}

	public void setTransportype(Integer transportype) {
		this.transportype = transportype;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReceiptplace() {
		return this.receiptplace;
	}

	public void setReceiptplace(String receiptplace) {
		this.receiptplace = receiptplace;
	}

	public String getValiddate() {
		return this.validdate;
	}

	public void setValiddate(String validdate) {
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

	public Integer getReceiptplaceid() {
		return receiptplaceid;
	}

	public void setReceiptplaceid(Integer receiptplaceid) {
		this.receiptplaceid = receiptplaceid;
	}

	public Integer getStopcityid() {
		return stopcityid;
	}

	public void setStopcityid(Integer stopcityid) {
		this.stopcityid = stopcityid;
	}

	public String getStopcityname() {
		return stopcityname;
	}

	public void setStopcityname(String stopcityname) {
		this.stopcityname = stopcityname;
	}

	public Integer getStopprvid() {
		return stopprvid;
	}

	public void setStopprvid(Integer stopprvid) {
		this.stopprvid = stopprvid;
	}

	public String getStopprvname() {
		return stopprvname;
	}

	public void setStopprvname(String stopprvname) {
		this.stopprvname = stopprvname;
	}

	public String getStopshortname() {
		return stopshortname;
	}

	public void setStopshortname(String stopshortname) {
		this.stopshortname = stopshortname;
	}

}