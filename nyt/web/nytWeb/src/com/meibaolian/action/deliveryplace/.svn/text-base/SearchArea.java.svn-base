package com.meibaolian.action.deliveryplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
/**
 * 条件查询交货地地区
 * @author llm
 *
 */
public class SearchArea extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDeliveryPlaceService deliveryPlaceService;
	
	private DeliveryPlaceDto deliveryPlaceDto = new DeliveryPlaceDto();//条件封装
	
	public String search(){

		deliveryPlaceDto.setKeyword( deliveryPlaceDto.getKeyword() != null ? deliveryPlaceDto.getKeyword().trim() : null );
		QueryResult<DeliveryArea> qr = deliveryPlaceService.searchAreaList(deliveryPlaceDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<DeliveryArea>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("deliveryPlaceDto", deliveryPlaceDto);
		return SUCCESS;
	}

	public DeliveryPlaceDto getDeliveryPlaceDto() {
		return deliveryPlaceDto;
	}

	public void setDeliveryPlaceDto(DeliveryPlaceDto deliveryPlaceDto) {
		this.deliveryPlaceDto = deliveryPlaceDto;
	}

	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}

	
}
