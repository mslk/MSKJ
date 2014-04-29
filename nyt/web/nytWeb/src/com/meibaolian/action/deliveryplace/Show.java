package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.DeliveryPlace;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
/**
 * 交货地详情展示
 * @author llm
 *
 */
public class Show extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryPlaceService deliveryPlaceService;
	
	private Integer id;//交货地id
	
	public String show(){
		if(id != null){
			DeliveryPlace deliveryPlace = deliveryPlaceService.getDeliveryPlace(id);
			if(deliveryPlace != null){
				WebUtil.setRequestValue("deliveryPlace", deliveryPlace);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	



	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
