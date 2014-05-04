package com.meibaolian.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 省
 * @author Administrator
 *
 */
public class DeliveryareaProvinceEntity {
	
	
	
	private String provinceid;
	
	private String provincename;
	
	private List<DeliveryareaCityEntity> list=new ArrayList<DeliveryareaCityEntity>();
	
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public List<DeliveryareaCityEntity> getList() {
		return list;
	}
	public void setList(List<DeliveryareaCityEntity> list) {
		this.list = list;
	}
	


}
