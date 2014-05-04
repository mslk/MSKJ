package com.meibaolian.entity;
/**
 * 煤矿
 * @author llm
 *
 */
public class MinCoalMine {
	
	private Integer id;
	private String name;
	private Integer heating;
	private String sulphur;
	private String ash;
	private String moisture;
	
	
	public MinCoalMine() {
		super();
	}
	public MinCoalMine(CoalMine coalMine) {
		super();
		this.id = coalMine.getId();
		this.name = coalMine.getName();
		this.heating = coalMine.getHeating();
		this.sulphur = coalMine.getSulphur();
		this.ash = coalMine.getAsh();
		this.moisture = coalMine.getMoisture();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeating() {
		return heating;
	}
	public void setHeating(Integer heating) {
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

}
