package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.DeliveryPlace;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
/**
 * 修改交货地
 * @author llm
 *
 */
public class Update extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryPlaceService deliveryPlaceService;
	private Integer id;//交货地id
	private DeliveryPlace deliveryPlace;
	
	public String initUpdate(){
		String msg = "获取交货地信息失败！";
		if(id != null && id > 0){
			deliveryPlace = deliveryPlaceService.getDeliveryPlace(id);
			if(deliveryPlace != null){
				WebUtil.setRequestValue("deliveryPlace", deliveryPlace);
				return SUCCESS;
			}
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}
	
	public String update(){
		String msg = "修改交货地信息失败！";
		if(deliveryPlace != null && null != deliveryPlace.getId() && deliveryPlace.getId() > 0){
			deliveryPlaceService.updateDeliveryPlace(deliveryPlace);
			msg = "修改交货地信息成功！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DeliveryPlace getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(DeliveryPlace deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}

}
