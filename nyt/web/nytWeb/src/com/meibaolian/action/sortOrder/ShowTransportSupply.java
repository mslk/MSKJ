package com.meibaolian.action.sortOrder;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;

public class ShowTransportSupply extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransportSupplyService transportSupplyService;
	
	private Integer id;
	
	public String show(){
		if(id != null){
			TransportSupply transportSupply = transportSupplyService.getTransportSupply(id);
			if(transportSupply != null){
				WebUtil.setRequestValue("transportSupply",transportSupply);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
}
