package com.meibaolian.action.purchase;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;

public class Update extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPurchaseService purchaseService;
	private Purchase purchase;
	
	public String updateSortnumber(){
		String msg = "修改排序值失败！";
		if(purchase != null && null != purchase.getPurid() && purchase.getPurid() > 0 && null != purchase.getSortnumber() && purchase.getSortnumber() > 0){
			purchaseService.updatePurchase(purchase.getPurid(), purchase.getSortnumber());
			msg = "修改排序值成功！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}
	
	
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}


	public Purchase getPurchase() {
		return purchase;
	}


	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	

}
