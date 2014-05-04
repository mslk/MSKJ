package com.meibaolian.entity;

import java.math.BigDecimal;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class VennerInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public String getThicknessint() {
		return thicknessint;
	}

	public void setThicknessint(String thicknessint) {
		this.thicknessint = thicknessint;
	}

	public BigDecimal getAverage_thickness() {
		return average_thickness;
	}

	public void setAverage_thickness(BigDecimal average_thickness) {
		this.average_thickness = average_thickness;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getHole_panel() {
		return hole_panel;
	}

	public void setHole_panel(String hole_panel) {
		this.hole_panel = hole_panel;
	}

	public String getMoisture() {
		return moisture;
	}

	public void setMoisture(String moisture) {
		this.moisture = moisture;
	}

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}

	public String getMildew() {
		return mildew;
	}

	public void setMildew(String mildew) {
		this.mildew = mildew;
	}

	public String getLead_time() {
		return lead_time;
	}

	public void setLead_time(String lead_time) {
		this.lead_time = lead_time;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getDescribed() {
		return described;
	}

	public void setDescribed(String described) {
		this.described = described;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	private Integer id;
	private Integer userid;
	private String length;
	private String width;
	private String thicknessint;
	private BigDecimal average_thickness;
	private String level;
	private String reference;
	private String panel;
	private String hole_panel;
	private String moisture;
	private String bark;
	private String mildew;
	private String lead_time;
	private Integer number;
	private BigDecimal price;
	private String valid;
	private String described;
	private Integer type;
	private String addtime;
	private String datenum;//有效时间
	private String logo;
	
    public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDatenum() {
		return datenum;
	}

	public void setDatenum(String datenum) {
		this.datenum = datenum;
	}

	public String getPlace_receipt() {
		return place_receipt;
	}

	public void setPlace_receipt(String place_receipt) {
		this.place_receipt = place_receipt;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String place_receipt;//交货/发货地
    private String companyname;//公司名字
    private String realname;//联系人
    private String phone;//联系电话

	// Constructors

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	/** default constructor */
	public VennerInfo() {
	}

	/** full constructor */
	public VennerInfo(Integer userid, String length, String width,
			String thicknessint, BigDecimal average_thickness,String level,
			String reference,String panel,String hole_panel,
			String moisture,String bark,String mildew,String lead_time,
			Integer number,BigDecimal price,String valid,String described,Integer type
			) {
		this.userid = userid;
		this.length=length;
		this.width=width;
		this.thicknessint=thicknessint;
		this.average_thickness=average_thickness;
		this.level=level;
		this.reference=reference;
		this.panel=panel;
		this.hole_panel=hole_panel;
		this.moisture=moisture;
		this.bark=bark;
		this.mildew=mildew;
		this.lead_time=lead_time;
		this.number=number;
		this.price=price;
		this.valid=valid;
		this.described=described;
		this.type=type;
		
		
	}


}