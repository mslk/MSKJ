package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.DeliveryplaceType;
import com.meibaolian.service.deliveryplace.IDeliveryplaceTypeService;
/**
 * 交货地类型列表
 * @author llm
 *
 */
public class SearchType extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryplaceTypeService deliveryplaceTypeService;
	
	
	public void setDeliveryplaceTypeService(
			IDeliveryplaceTypeService deliveryplaceTypeService) {
		this.deliveryplaceTypeService = deliveryplaceTypeService;
	}


	public String search(){
		QueryResult<DeliveryplaceType> qr = deliveryplaceTypeService.search(getPage(),PAGESIZE);
		savePageView(new PageView<DeliveryplaceType>(qr, getPage(), PAGESIZE));
		return SUCCESS;
	}

	
}
