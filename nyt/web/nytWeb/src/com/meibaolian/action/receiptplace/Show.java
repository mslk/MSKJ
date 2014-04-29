package com.meibaolian.action.receiptplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.County;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;

public class Show extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IReceiptPlaceService receiptPlaceService;
	
	private Integer id;
	
	public void setReceiptPlaceService(IReceiptPlaceService receiptPlaceService) {
		this.receiptPlaceService = receiptPlaceService;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//
	public String show(){
		if(id != null){
			County county = receiptPlaceService.getReceiptPlace(id);
			if(county != null){
				WebUtil.setRequestValue("receiptPlace", county);
				return SUCCESS;
			}
		}
		return INPUT;
	}

}
