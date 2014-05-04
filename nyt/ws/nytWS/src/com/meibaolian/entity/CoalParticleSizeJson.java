package com.meibaolian.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 公路站点分省列表
 * @author llm
 *
 */
public class CoalParticleSizeJson {
	
	private Integer parentid;
	private String  parentName;
	private List<CoalParticleSizeChildJson> list = new ArrayList<CoalParticleSizeChildJson>();
	
	public void addCoalParticleSizeChildJson(CoalParticleSizeChildJson entity)
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
	
	public List<CoalParticleSizeChildJson> getList() {
		return list;
	}

	public void setList(List<CoalParticleSizeChildJson> list) {
		this.list = list;
	}

	public CoalParticleSizeJson() {
		super();
	}

	public CoalParticleSizeJson(Integer parentid, String parentName) {
		super();
		this.parentid = parentid;
		this.parentName = parentName;
	}
	
	
	
	
}
