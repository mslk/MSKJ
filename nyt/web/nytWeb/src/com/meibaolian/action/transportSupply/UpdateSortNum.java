package com.meibaolian.action.transportSupply;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;

public class UpdateSortNum extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ITransportSupplyService transportSupplyService;
	
	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
	private TransportSupply transportSupply;

	public TransportSupply getTransportSupply() {
		return transportSupply;
	}

	public void setTransportSupply(TransportSupply transportSupply) {
		this.transportSupply = transportSupply;
	}

	public String execute() throws Exception 
	{
		String msg = "修改排序值失败！";
		if(transportSupply != null && null != transportSupply.getId() && transportSupply.getId() > 0 && null != transportSupply.getSortnumber() && transportSupply.getSortnumber() > 0){
			transportSupplyService.updateSortNum(transportSupply.getId(), transportSupply.getSortnumber());
			msg = "修改排序值成功！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}

}
