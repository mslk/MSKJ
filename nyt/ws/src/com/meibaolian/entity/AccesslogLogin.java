package com.meibaolian.entity;

import java.util.Date;

/**
 * AccesslogLogin entity. @author MyEclipse Persistence Tools
 */

public class AccesslogLogin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7862913464012726334L;

	private Integer id;
	
	private Integer userid;
	private String phone;
	private Integer type;
	private Integer result;
	private Date addtime;

	// Constructors

	/** default constructor */
	public AccesslogLogin() {
	}


	/** full constructor */
	public AccesslogLogin(Integer id, Integer userid, String phone,
			Integer type, Integer result, Date addtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.phone = phone;
		this.type = type;
		this.result = result;
		this.addtime = addtime;
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





	public Date getAddtime() {
		return addtime;
	}


	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getResult() {
		return this.result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}