package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.service.deliveryplace.IDeliveryplaceTypeService;
/**
 * 删除交货地类型
 * @author llm
 *
 */
public class DelType extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryplaceTypeService deliveryplaceTypeService;
	
	private Integer id;//交货地类型id
	//
	
	public Integer getId() {
		return id;
	}

	public void setDeliveryplaceTypeService(
			IDeliveryplaceTypeService deliveryplaceTypeService) {
		this.deliveryplaceTypeService = deliveryplaceTypeService;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//
	
	public String execute(){
		if(id != null){
			deliveryplaceTypeService.delDeliveryPlaceType(id);
			super.saveMessage("删除交货地类型成功！", null);
			return MESSAGE;
		}
		return INPUT;
	}

}
