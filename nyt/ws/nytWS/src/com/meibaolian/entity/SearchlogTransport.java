package com.meibaolian.entity;

/**
 * SearchlogTransport entity. @author MyEclipse Persistence Tools
 */

public class SearchlogTransport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String addtime;
	private String keyword;
	private Integer searchtype;
	private String stopprvname;

	// Constructors

	/** default constructor */
	public SearchlogTransport() {
	}

	/** minimal constructor */
	public SearchlogTransport(Integer userid, String addtime, Integer searchtype) {
		this.userid = userid;
		this.addtime = addtime;
		this.searchtype = searchtype;
	}

	/** full constructor */
	public SearchlogTransport(Integer userid, String addtime, String keyword,
			Integer searchtype, String stopprvname) {
		this.userid = userid;
		this.addtime = addtime;
		this.keyword = keyword;
		this.searchtype = searchtype;
		this.stopprvname = stopprvname;
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

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getSearchtype() {
		return this.searchtype;
	}

	public void setSearchtype(Integer searchtype) {
		this.searchtype = searchtype;
	}

	public String getStopprvname() {
		return this.stopprvname;
	}

	public void setStopprvname(String stopprvname) {
		this.stopprvname = stopprvname;
	}

}