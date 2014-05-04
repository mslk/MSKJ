package com.meibaolian.entity;

/**
 * Highwayrate entity. @author MyEclipse Persistence Tools
 */

public class HighwayrateEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String start;
	private String stop;
	private Float rate;
	private Float distance;
	private Integer city;
	private Integer type;
	// Constructors

	/** default constructor */
	public HighwayrateEntity() {
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStop() {
		return this.stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getDistance() {
		return this.distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}


	public Integer getCity() {
		return city;
	}


	public void setCity(Integer city) {
		this.city = city;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}

}