package com.meibaolian.action.receiptplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.County;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;
import com.meibaolian.util.UtilHelp;

public class Add extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IReceiptPlaceService receiptPlaceService;
	private IDeliveryPlaceService deliveryPlaceService;
	
	private County county;
	private Integer isDelivery;
	//
	public County getCounty() {
		return county;
	}
	
	public void setCounty(County county) {
		this.county = county;
	}

	public Integer getIsDelivery() {
		return isDelivery;
	}

	public void setIsDelivery(Integer isDelivery) {
		this.isDelivery = isDelivery;
	}

	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}

	public void setReceiptPlaceService(IReceiptPlaceService receiptPlaceService) {
		this.receiptPlaceService = receiptPlaceService;
	}
	//

	public String add(){
		String msg = "参数异常！添加地区信息失败！";
		if(county != null && UtilHelp.isNotNullStr(county.getProvincename()) 
				&& UtilHelp.isNotNullStr(county.getCityname())
				&& UtilHelp.isNotNullStr(county.getName())){
			
			county.setProvincename(county.getProvincename().trim());
			county.setCityname(county.getCityname().trim());
			county.setName(county.getName().trim());
			
			if(UtilHelp.isNotNullStr(county.getShortname())){
				county.setShortname(county.getShortname().trim());
			}
			msg = "添加地区信息成功！";
			int count = receiptPlaceService.addReceiptPlace(county);
			if(count == 0){
				msg = "此地区信息已存在！";
			}else if(null != isDelivery && isDelivery == 1){
				DeliveryArea deliveryArea = new DeliveryArea(county.getId(),
						county.getName(), county.getShortname(), county
								.getCityid(), county.getCityname(), county
								.getProvinceid(), county.getProvincename());
				deliveryPlaceService.addDeliveryArea(deliveryArea);
				msg += "并加入到交货地地区。";
			}
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}



}
