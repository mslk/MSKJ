package com.meibaolian.entity;

import java.sql.Timestamp;

/**
 * AccesslogLogin entity. @author MyEclipse Persistence Tools
 */

public class AccessLogLogin implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Timestamp addtime;
	private String phone;
	private Integer type;
	private Integer result;
	// view Fields
	private Integer usertype;
	private String username;
	// Constructors

	/** default constructor */
	public AccessLogLogin() {
	}

	/** minimal constructor */
	public AccessLogLogin(Integer userid, Timestamp addtime) {
		this.userid = userid;
		this.addtime = addtime;
	}

	/** full constructor */
	public AccessLogLogin(Integer userid, Timestamp addtime, String phone,
			Integer type, Integer result) {
		this.userid = userid;
		this.addtime = addtime;
		this.phone = phone;
		this.type = type;
		this.result = result;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
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

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}