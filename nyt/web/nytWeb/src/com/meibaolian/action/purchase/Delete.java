package com.meibaolian.action.purchase;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;

public class Delete extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//求购信息id
	private  int purId;
	
	public int getPurId() {
		return purId;
	}


	public void setPurId(int purId) {
		this.purId = purId;
	}


	IPurchaseService purchaseService;

	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}


	@Override
	public String execute() throws Exception 
	{
		String messageValue="删除求购信息失败！";
		String targetUrlValue="purchase/search.action";
		if(purId>0)
		{
			Purchase Purchase=purchaseService.getPurchase(purId);
			if(Purchase!=null)
			{
				purchaseService.deletePurchaseById(purId);
				messageValue="删除求购信息成功！";
			}else
			{
				messageValue="此求购信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	
	
	
	
	
	

}
