package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
/**
 * 删除交货地地区
 * @author llm
 *
 */
public class DelArea extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryPlaceService deliveryPlaceService;
	
	private Integer id;//交货地地区id
	//
	
	public Integer getId() {
		return id;
	}

	

	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	//
	
	public String execute(){
		if(id != null){
			deliveryPlaceService.delDeliveryArea(id);
			super.saveMessage("删除交货地地区成功！", null);
			return MESSAGE;
		}
		return INPUT;
	}

}
