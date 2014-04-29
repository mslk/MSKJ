package com.meibaolian.entity;

import java.sql.Timestamp;

import com.meibaolian.util.ConfigUtil;

public class PurchaseInfo {
	
	private Integer purid;
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
	private String place;
	private String receiptplace;
	private Timestamp validdate;
	private Integer quantity;
	private Integer sortnumber;
	private Integer status;
	private String phone;
	private String company;
	private Integer validstatus;
	// Constructors

	/** default constructor */
	public PurchaseInfo() {
	}
	
	public PurchaseInfo(Purchase purchase, UserInfo userInfo){
		this.purid = purchase.getPurid();
		this.userid = purchase.getUserid();
//		this.addtime = purchase.getAddtime();
		this.coaltype = purchase.getCoaltype();
		this.coalname = purchase.getCoalname();
		this.buyername = userInfo.getRealname();
		this.heating = purchase.getHeating();
		this.coalsize = purchase.getCoalsize();
//		this.coalsizename = ConfigUtil.coalSizeNameMap.get(purchase.getCoalsize());
		this.sulphur = purchase.getSulphur();
		this.ash = purchase.getAsh();
		this.moisture = purchase.getMoisture();
		this.price = purchase.getPrice();
		this.taxprice = purchase.getTaxprice();
		this.transportype = purchase.getTransportype();
		this.place = purchase.getPlace();
		this.receiptplace = purchase.getReceiptplace();
//		this.validdate = purchase.getValiddate();
		this.quantity = purchase.getQuantity();
		this.sortnumber = purchase.getSortnumber();
		this.status = purchase.getStatus();
		this.phone = userInfo.getPhone();
		this.company = userInfo.getCompanyname();
	}
	
	

	// Property accessors
	

	public Integer getUserid() {
		return userid;
	}

	public Integer getPurid() {
		return purid;
	}


	public void setPurid(Integer purid) {
		this.purid = purid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
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

	public String getCoalsizename() {
		return coalsizename;
	}


	public void setCoalsizename(String coalsizename) {
		this.coalsizename = coalsizename;
	}


	public String getSulphur() {
		return sulphur;
	}

	public void setSulphur(String sulphur) {
		this.sulphur = sulphur;
	}

	public String getAsh() {
		return ash;
	}


	public void setAsh(String ash) {
		this.ash = ash;
	}


	public String getMoisture() {
		return moisture;
	}


	public void setMoisture(String moisture) {
		this.moisture = moisture;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTaxprice() {
		return taxprice;
	}

	public void setTaxprice(String taxprice) {
		this.taxprice = taxprice;
	}

	public Integer getTransportype() {
		return transportype;
	}

	public void setTransportype(Integer transportype) {
		this.transportype = transportype;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReceiptplace() {
		return receiptplace;
	}


	public void setReceiptplace(String receiptplace) {
		this.receiptplace = receiptplace;
	}


	public Timestamp getValiddate() {
		return validdate;
	}

	public void setValiddate(Timestamp validdate) {
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


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(Integer validstatus) {
		this.validstatus = validstatus;
	}

	
}
