package com.meibaolian.entity;


public class DeliveryplaceChildEntity 
{
	
	private Integer stationid;
	private String name;
	private String shortname;
	private Integer countyid;
	private Integer type;
	private String heating;
	private String sulphur;
	private String ash;
	private String moisture;
	
	
	public Integer getStationid() {
		return stationid;
	}
	public void setStationid(Integer stationid) {
		this.stationid = stationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public Integer getCountyid() {
		return countyid;
	}
	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getSulphur() {
		return sulphur;
	}
	public void setSulphur(String sulphur) {
		this.sulphur = sulphur;
	}
	public String getAsh() {
		return ash;
	}
	public void setAsh(String ash) {
		this.ash = ash;
	}
	public String getMoisture() {
		return moisture;
	}
	public void setMoisture(String moisture) {
		this.moisture = moisture;
	}
	public DeliveryplaceChildEntity() {
		super();
	}
	public DeliveryplaceChildEntity(Integer stationid, String name,
			String shortname, Integer countyid, Integer type, String heating,
			String sulphur, String ash, String moisture) {
		super();
		this.stationid = stationid;
		this.name = name;
		this.shortname = shortname;
		this.countyid = countyid;
		this.type = type;
		this.heating = heating;
		this.sulphur = sulphur;
		this.ash = ash;
		this.moisture = moisture;
	}
	
	
	
	
	
	

}
