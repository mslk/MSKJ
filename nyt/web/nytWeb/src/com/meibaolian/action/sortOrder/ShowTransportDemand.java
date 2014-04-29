package com.meibaolian.action.sortOrder;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class ShowTransportDemand extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransportDemandService transportDemandService;
	
	private Integer id;
	
	public String show(){
		if(id != null){
			TransportDemand transportDemand = transportDemandService.getTransportDemand(id);
			if(transportDemand != null){
				WebUtil.setRequestValue("transportDemand", transportDemand);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	


	public void setTransportDemandService(ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
