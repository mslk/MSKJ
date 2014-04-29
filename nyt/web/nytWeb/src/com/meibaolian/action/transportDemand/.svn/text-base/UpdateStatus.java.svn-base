package com.meibaolian.action.transportDemand;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class UpdateStatus extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 货讯id
	private  int demandId;
	
	public int getDemandId() {
		return demandId;
	}

	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}


	ITransportDemandService transportDemandService;
	
	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}





	
	public String invalid() throws Exception 
	{
		String messageValue="屏蔽货讯信息失败！";
		String targetUrlValue="transportDemand/search.action";
		if(demandId>0)
		{
			TransportDemand transportDemand=transportDemandService.getTransportDemand(demandId);
			if(transportDemand!=null)
			{
				transportDemandService.updateStatus(demandId, 1);
				messageValue="屏蔽货讯信息成功！";
			}else
			{
				messageValue="此货讯信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	public String enable() throws Exception 
	{
		String messageValue="恢复货讯信息失败！";
		String targetUrlValue="transportDemand/search.action";
		if(demandId>0)
		{
			TransportDemand transportDemand=transportDemandService.getTransportDemand(demandId);
			if(transportDemand!=null)
			{
				transportDemandService.updateStatus(demandId, 0);
				messageValue="恢复货讯信息成功！";
			}else
			{
				messageValue="此货讯信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	
	
	
	
	

}
