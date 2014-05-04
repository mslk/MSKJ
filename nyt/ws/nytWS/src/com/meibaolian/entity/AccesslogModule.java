package com.meibaolian.entity;

import java.util.Date;

/**
 * AccesslogModule entity. @author MyEclipse Persistence Tools
 */

public class AccesslogModule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Integer userid;
	private Date addtime;
	private String module;
	private String funcation;
	private String content;
	

	// Constructors

	/** default constructor */
	public AccesslogModule() {
	}

	/** full constructor */
	public AccesslogModule(Integer id, String title, Integer userid,
			Date addtime, String module, String funcation, String content) {
		super();
		this.id = id;
		this.title = title;
		this.userid = userid;
		this.addtime = addtime;
		this.module = module;
		this.funcation = funcation;
		this.content = content;
	}
	// Property accessors
	
	

	public Integer getId() {
		return this.id;
	}

	


	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getFuncation() {
		return this.funcation;
	}

	public void setFuncation(String funcation) {
		this.funcation = funcation;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	


}