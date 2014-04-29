package com.meibaolian.entity;

import java.sql.Timestamp;
/**
 * PushTask entity. @author MyEclipse Persistence Tools
 */

public class PushTask implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Integer clickcount;
	private Integer pushnumber;
	private Integer notsendnumber;
	private Integer sendNumberr;
	private Integer successNumber;
	private Integer edition;
	private Timestamp begintime;
	private Timestamp endtime;
	private String sysdescription;
	private String url;
	private Timestamp addtime;
	private String sendUrl;
	private String superaddition;
	private Integer status;
	private Integer sendtype;
	private Integer relativeId;
	private Integer statuspertain;

	// Constructors

	/** default constructor */
	public PushTask() {
	}

	public PushTask(Integer id, String title, Integer clickcount,
			Integer pushnumber, Integer notsendnumber, Integer sendNumberr,
			Integer successNumber, Integer edition, Timestamp begintime,
			Timestamp endtime, String sysdescription, String url,
			Timestamp addtime, String sendUrl, String superaddition,
			Integer status, Integer sendtype, Integer relativeId,
			Integer statuspertain) {
		super();
		this.id = id;
		this.title = title;
		this.clickcount = clickcount;
		this.pushnumber = pushnumber;
		this.notsendnumber = notsendnumber;
		this.sendNumberr = sendNumberr;
		this.successNumber = successNumber;
		this.edition = edition;
		this.begintime = begintime;
		this.endtime = endtime;
		this.sysdescription = sysdescription;
		this.url = url;
		this.addtime = addtime;
		this.sendUrl = sendUrl;
		this.superaddition = superaddition;
		this.status = status;
		this.sendtype = sendtype;
		this.relativeId = relativeId;
		this.statuspertain = statuspertain;
	}






	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getClickcount() {
		return this.clickcount;
	}

	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}

	public Integer getPushnumber() {
		return this.pushnumber;
	}

	public void setPushnumber(Integer pushnumber) {
		this.pushnumber = pushnumber;
	}

	public Integer getNotsendnumber() {
		return this.notsendnumber;
	}

	public void setNotsendnumber(Integer notsendnumber) {
		this.notsendnumber = notsendnumber;
	}

	public Integer getSendNumberr() {
		return this.sendNumberr;
	}

	public void setSendNumberr(Integer sendNumberr) {
		this.sendNumberr = sendNumberr;
	}

	public Integer getSuccessNumber() {
		return this.successNumber;
	}

	public void setSuccessNumber(Integer successNumber) {
		this.successNumber = successNumber;
	}

	public Integer getEdition() {
		return this.edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}


	public Timestamp getBegintime() {
		return begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getSysdescription() {
		return this.sysdescription;
	}

	public void setSysdescription(String sysdescription) {
		this.sysdescription = sysdescription;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getSendUrl() {
		return this.sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getSuperaddition() {
		return this.superaddition;
	}

	public void setSuperaddition(String superaddition) {
		this.superaddition = superaddition;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSendtype() {
		return this.sendtype;
	}

	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}

	public Integer getRelativeId() {
		return this.relativeId;
	}

	public void setRelativeId(Integer relativeId) {
		this.relativeId = relativeId;
	}

	public Integer getStatuspertain() {
		return this.statuspertain;
	}

	public void setStatuspertain(Integer statuspertain) {
		this.statuspertain = statuspertain;
	}

	
	
	
}