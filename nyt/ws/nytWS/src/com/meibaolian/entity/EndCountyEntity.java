package com.meibaolian.entity;

/**
 * Highwayrate entity. @author MyEclipse Persistence Tools
 */

public class EndCountyEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String chileName;

	public String getChileName() {
		return chileName;
	}

	public void setChileName(String chileName) {
		this.chileName = chileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EndCountyEntity() {
		super();
	}

	public EndCountyEntity(Integer id, String chileName) {
		super();
		this.id = id;
		this.chileName = chileName;
	}

	

}