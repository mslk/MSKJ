package com.meibaolian.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 煤矿输出列表json
 * @author llm
 *
 */
public class CoalMineJson {
	
	private Integer countyid;
	private String county;
	private Integer type;
	private List<MinCoalMine> list = new ArrayList<MinCoalMine>();
	
	
	public Integer getCountyid() {
		return countyid;
	}
	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<MinCoalMine> getList() {
		return list;
	}
	public void setList(List<MinCoalMine> list) {
		this.list = list;
	}
	
	

}
