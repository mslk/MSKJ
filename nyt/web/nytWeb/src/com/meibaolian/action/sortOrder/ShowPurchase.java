package com.meibaolian.action.sortOrder;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;

public class ShowPurchase extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPurchaseService purchaseService;
	
	private Integer id;
	
	public String show(){
		if(id != null){
			Purchase purchase = purchaseService.getPurchase(id);
			if(purchase != null){
				WebUtil.setRequestValue("purchase", purchase);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	


	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
