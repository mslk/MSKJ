package com.meibaolian.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 公路站点分省列表
 * @author llm
 *
 */
public class EndStationJson {
	
	private Integer parentid;
	private String  parentName;
	
	private List<EndCountyEntity> list = new ArrayList<EndCountyEntity>();
	
	public void addEndCountyEntity(EndCountyEntity entity)
	{
		list.add(entity);
	}
	
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<EndCountyEntity> getList() {
		return list;
	}

	public void setList(List<EndCountyEntity> list) {
		this.list = list;
	}

	public EndStationJson() {
		super();
	}

	public EndStationJson(Integer parentid, String parentName) {
		super();
		this.parentid = parentid;
		this.parentName = parentName;
	}
	
	
	
	
}
