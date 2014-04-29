package com.meibaolian.entity;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer provinceid;
	private String provincename;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(String name, Integer provinceid, String provincename) {
		this.name = name;
		this.provinceid = provinceid;
		this.provincename = provincename;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProvinceid() {
		return this.provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

}