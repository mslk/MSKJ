package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.entity.DeliveryPlace;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
import com.meibaolian.util.UtilHelp;
/**
 * 跳转到添加页面，添加交货地（煤矿、煤场等）
 * @author llm
 *
 */
public class Add extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryPlaceService deliveryPlaceService;
	
	private DeliveryPlace deliveryPlace;
	/**
	 * 交货地地区(省市县)信息id
	 */
	private Integer id;
	//
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
	
	
	//
	/**
	 * 跳转到添加页面，获取选择挂载的地区信息
	 */
	public String initAdd(){
		String msg = "获取交货地地区信息失败！";
		if(id != null && id > 0){
			DeliveryArea deliveryArea = deliveryPlaceService.getDeliveryArea(id);
			if(deliveryArea != null){
				WebUtil.setRequestValue("deliveryArea", deliveryArea);
				return SUCCESS;
			}
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}
	
	/**
	 * 添加交货地信息
	 * @return
	 */
	public String add(){
		String msg = "添加交货地信息失败！";

		if(deliveryPlace != null 
				&& UtilHelp.isNotNullStr(deliveryPlace.getProvincename()) 
				&& UtilHelp.isNotNullStr(deliveryPlace.getCityname())
				&& UtilHelp.isNotNullStr(deliveryPlace.getCountyname())
				&& deliveryPlace.getType() != null
//			    && UtilHelp.isNotNullStr(deliveryPlaceInfo.getTypename())
				&& UtilHelp.isNotNullStr(deliveryPlace.getName())){
			
			deliveryPlace.setProvincename(deliveryPlace.getProvincename().trim());
			deliveryPlace.setCityname(deliveryPlace.getCityname().trim());
			deliveryPlace.setCountyname(deliveryPlace.getCountyname().trim());
//			deliveryPlaceInfo.setTypename(deliveryPlaceInfo.getTypename().trim());
			
			deliveryPlace.setName(deliveryPlace.getName().trim());
			
			if(UtilHelp.isNotNullStr(deliveryPlace.getShortname())){
				deliveryPlace.setShortname(deliveryPlace.getShortname().trim());
			}
			if(UtilHelp.isNotNullStr(deliveryPlace.getAddress())){
				deliveryPlace.setAddress(deliveryPlace.getAddress().trim());
			}
			msg = "添加交货地信息成功！";
			int count = deliveryPlaceService.addDeliveryPlace(deliveryPlace);
			if(count == 0){
				msg = "此交货地信息已存在！";
			}
		}else{
			msg = "参数异常！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}


	
}
