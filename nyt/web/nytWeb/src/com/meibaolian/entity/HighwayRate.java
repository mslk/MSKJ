package com.meibaolian.entity;

/**
 * Highwayrate entity. @author MyEclipse Persistence Tools
 */

public class HighwayRate implements java.io.Serializable {

	// Fields

	private Integer id;
	private String startid;
	private String start;
	private Integer startcityid;
	private String startcityname;
	private Integer startprvid;
	private String startprvname;
	private Integer stopid;
	private String stop;
	private Integer stopcityid;
	private String stopcityname;
	private Integer stopprvid;
	private String stopprvname;
	private Double rate;
	private Double distance;

	// Constructors

	/** default constructor */
	public HighwayRate() {
	}

	/** full constructor */
	public HighwayRate(String startid, String start, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			Integer stopid, String stop, Integer stopcityid,
			String stopcityname, Integer stopprvid, String stopprvname,
			Double rate, Double distance) {
		this.startid = startid;
		this.start = start;
		this.startcityid = startcityid;
		this.startcityname = startcityname;
		this.startprvid = startprvid;
		this.startprvname = startprvname;
		this.stopid = stopid;
		this.stop = stop;
		this.stopcityid = stopcityid;
		this.stopcityname = stopcityname;
		this.stopprvid = stopprvid;
		this.stopprvname = stopprvname;
		this.rate = rate;
		this.distance = distance;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartid() {
		return this.startid;
	}

	public void setStartid(String startid) {
		this.startid = startid;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Integer getStartcityid() {
		return this.startcityid;
	}

	public void setStartcityid(Integer startcityid) {
		this.startcityid = startcityid;
	}

	public String getStartcityname() {
		return this.startcityname;
	}

	public void setStartcityname(String startcityname) {
		this.startcityname = startcityname;
	}

	public Integer getStartprvid() {
		return this.startprvid;
	}

	public void setStartprvid(Integer startprvid) {
		this.startprvid = startprvid;
	}

	public String getStartprvname() {
		return this.startprvname;
	}

	public void setStartprvname(String startprvname) {
		this.startprvname = startprvname;
	}

	public Integer getStopid() {
		return this.stopid;
	}

	public void setStopid(Integer stopid) {
		this.stopid = stopid;
	}

	public String getStop() {
		return this.stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public Integer getStopcityid() {
		return this.stopcityid;
	}

	public void setStopcityid(Integer stopcityid) {
		this.stopcityid = stopcityid;
	}

	public String getStopcityname() {
		return this.stopcityname;
	}

	public void setStopcityname(String stopcityname) {
		this.stopcityname = stopcityname;
	}

	public Integer getStopprvid() {
		return this.stopprvid;
	}

	public void setStopprvid(Integer stopprvid) {
		this.stopprvid = stopprvid;
	}

	public String getStopprvname() {
		return this.stopprvname;
	}

	public void setStopprvname(String stopprvname) {
		this.stopprvname = stopprvname;
	}

	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getDistance() {
		return this.distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}