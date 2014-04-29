package com.meibaolian.action.transportSupply;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;

public class UpdateStatus extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//车讯信息id
	private  int supplyId;
	
	public int getSupplyId() {
		return supplyId;
	}


	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}

	ITransportSupplyService transportSupplyService;
	
	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}


	
	public String invalid() throws Exception 
	{
		String messageValue="屏蔽车讯信息失败！";
		String targetUrlValue="transportSupply/search.action";
		if(supplyId>0)
		{
			TransportSupply transportSupply=transportSupplyService.getTransportSupply(supplyId);
			if(transportSupply!=null)
			{
				transportSupplyService.updateStatus(supplyId, 1);
				messageValue="屏蔽车讯信息成功！";
			}else
			{
				messageValue="此车讯信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	public String enable() throws Exception 
	{
		String messageValue="恢复车讯信息失败！";
		String targetUrlValue="transportSupply/search.action";
		if(supplyId>0)
		{
			TransportSupply transportSupply=transportSupplyService.getTransportSupply(supplyId);
			if(transportSupply!=null)
			{
				transportSupplyService.updateStatus(supplyId, 0);
				messageValue="恢复车讯信息成功！";
			}else
			{
				messageValue="此车讯信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	
	
	
	

}
