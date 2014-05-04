package com.meibaolian.action.transportDemand;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class UpdateSortNum extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ITransportDemandService transportDemandService;
	
	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}

	private TransportDemand transportDemand;

	public TransportDemand getTransportDemand() {
		return transportDemand;
	}

	public void setTransportDemand(TransportDemand transportDemand) {
		this.transportDemand = transportDemand;
	}

	public String execute() throws Exception 
	{
		String msg = "修改排序值失败！";
		if(transportDemand != null && null != transportDemand.getId() && transportDemand.getId() > 0 && null != transportDemand.getSortnumber() && transportDemand.getSortnumber() > 0){
			transportDemandService.updateSortNum(transportDemand.getId(), transportDemand.getSortnumber());
			msg = "修改排序值成功！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}
}
