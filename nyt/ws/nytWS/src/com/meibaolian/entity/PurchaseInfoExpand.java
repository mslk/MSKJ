package com.meibaolian.entity;


/**
 * SupplyInfo entity. @author MyEclipse Persistence Tools
 */

public class PurchaseInfoExpand implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userid;
	private String length;
	private String width;
	private String thickness;
	private Integer number;
	private Integer price;
	private String valid;
	private String description;
	private String cultivated;
	private String tailDirectly;
	private Integer unit;
	private String brand;
	private Integer level;
	private String producer;
	private Integer type;
	private String addtime;
	private String logo;
	private String phone;
	private String realname;
	private String companyname;
	private String place_receipt;
	private String province;
	private String city;
	private String county;
	private String park;
	

	// Constructors

	/** default constructor */
	public PurchaseInfoExpand() {
	}

	/** minimal constructor */
	public PurchaseInfoExpand(Integer userid, Integer number, Integer price,
			String valid, Integer type, String addtime) {
		this.userid = userid;
		this.number = number;
		this.price = price;
		this.valid = valid;
		this.type = type;
		this.addtime = addtime;
	}

	/** full constructor */
	public PurchaseInfoExpand(Integer id, Integer userid, String length,
			String width, String thickness, Integer number, Integer price,
			String valid, String description, String cultivated,
			String tailDirectly, Integer unit, String brand, Integer level,
			String producer, Integer type, String addtime, String logo,
			String phone, String realname, String companyname,
			String place_receipt, String province, String city, String county,
			String park) {
		super();
		this.id = id;
		this.userid = userid;
		this.length = length;
		this.width = width;
		this.thickness = thickness;
		this.number = number;
		this.price = price;
		this.valid = valid;
		this.description = description;
		this.cultivated = cultivated;
		this.tailDirectly = tailDirectly;
		this.unit = unit;
		this.brand = brand;
		this.level = level;
		this.producer = producer;
		this.type = type;
		this.addtime = addtime;
		this.logo = logo;
		this.phone = phone;
		this.realname = realname;
		this.companyname = companyname;
		this.place_receipt = place_receipt;
		this.province = province;
		this.city = city;
		this.county = county;
		this.park = park;
	}

	
	
	// Property accessors
	
	public Integer getId() {
		return this.id;
	}

	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public String getPlace_receipt() {
		return place_receipt;
	}

	public void setPlace_receipt(String place_receipt) {
		this.place_receipt = place_receipt;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getThickness() {
		return this.thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getValid() {
		return this.valid;
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
		return this.cultivated;
	}

	public void setCultivated(String cultivated) {
		this.cultivated = cultivated;
	}

	public String getTailDirectly() {
		return this.tailDirectly;
	}

	public void setTailDirectly(String tailDirectly) {
		this.tailDirectly = tailDirectly;
	}

	public Integer getUnit() {
		return this.unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

}