package com.meibaolian.action.receiptplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.County;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;

public class AddDelivery extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IReceiptPlaceService receiptPlaceService;
	private IDeliveryPlaceService deliveryPlaceService;
	
	private Integer id;
	//
	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setReceiptPlaceService(IReceiptPlaceService receiptPlaceService) {
		this.receiptPlaceService = receiptPlaceService;
	}
	//

	public String add(){
		String msg = "获取地区信息失败！";
		if(id != null && id > 0){
			County county = receiptPlaceService.getReceiptPlace(id);
			if(county != null){
				DeliveryArea deliveryArea = new DeliveryArea(county.getId(),
						county.getName(), county.getShortname(), county
								.getCityid(), county.getCityname(), county
								.getProvinceid(), county.getProvincename());
				DeliveryArea dbDeliveryArea = deliveryPlaceService.getDeliveryArea(deliveryArea);
				if(null == dbDeliveryArea){
					deliveryPlaceService.addDeliveryArea(deliveryArea);
					msg = "成功加入到交货地！";
				}else{
					msg = "地区已在交货地中！";
				}
			}
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}

}
