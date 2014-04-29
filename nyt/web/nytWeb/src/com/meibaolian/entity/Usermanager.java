package com.meibaolian.entity;

import java.sql.Timestamp;

/**
 * Usermanager entity. @author MyEclipse Persistence Tools
 */

public class Usermanager implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;
	private String loginname;
	private String password;
	private Timestamp registertime;
	private Integer status;

	// Constructors

	/** default constructor */
	public Usermanager() {
	}

	/** full constructor */
	public Usermanager(Integer type, String loginname, String password,
			Timestamp registertime, Integer status) {
		this.type = type;
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Timestamp registertime) {
		this.registertime = registertime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}