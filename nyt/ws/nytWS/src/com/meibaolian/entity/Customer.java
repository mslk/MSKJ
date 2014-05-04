package com.meibaolian.entity;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private Integer customerid;
	private Integer customertype;
	private String addtime;
	private String phone;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(Integer userid, Integer customerid, Integer customertype,
			String addtime, String phone) {
		this.userid = userid;
		this.customerid = customerid;
		this.customertype = customertype;
		this.addtime = addtime;
		this.phone = phone;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
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

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getCustomertype() {
		return this.customertype;
	}

	public void setCustomertype(Integer customertype) {
		this.customertype = customertype;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}