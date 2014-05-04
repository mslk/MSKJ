package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.DeliveryplaceType;
import com.meibaolian.service.deliveryplace.IDeliveryplaceTypeService;
import com.meibaolian.util.UtilHelp;
/**
 * 添加交货地类型
 * @author llm
 *
 */
public class AddType extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryplaceTypeService deliveryplaceTypeService;
	
	private DeliveryplaceType deliveryplaceType;
	//
	public DeliveryplaceType getDeliveryplaceType() {
		return deliveryplaceType;
	}

	public void setDeliveryplaceType(DeliveryplaceType deliveryplaceType) {
		this.deliveryplaceType = deliveryplaceType;
	}

	public void setDeliveryplaceTypeService(
			IDeliveryplaceTypeService deliveryplaceTypeService) {
		this.deliveryplaceTypeService = deliveryplaceTypeService;
	}
	//
	public String add(){
		String msg = "添加交货地类型失败！";
		if(deliveryplaceType != null && UtilHelp.isNotNullStr(deliveryplaceType.getTypeName()) 
				&& deliveryplaceType.getType() > 0){

			deliveryplaceType.setTypeName(deliveryplaceType.getTypeName().trim());
			msg = "添加交货地类型成功！";
			int count = deliveryplaceTypeService.addDeliveryPlaceType(deliveryplaceType);
			if(count == 0){
				msg = "此交货地类型值或名称已存在！";
			}
		}else{
			msg = "参数异常！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}

}
