package com.meibaolian.action.receiptplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.County;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;
import com.meibaolian.util.UtilHelp;

/**
 * 
 * @author zhaojian
 * @version 1.1[2014.05.05 11:59]
 *
 */
public class Update extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IReceiptPlaceService receiptPlaceService;
	private IDeliveryPlaceService deliveryPlaceService;
	
	private Integer id;
	private County county;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public void setReceiptPlaceService(IReceiptPlaceService receiptPlaceService) {
		this.receiptPlaceService = receiptPlaceService;
	}
	
	public void setDeliveryPlaceService(IDeliveryPlaceService deliveryPlaceService) {
		this.deliveryPlaceService = deliveryPlaceService;
	}

	//
	public String initUpdate(){
		String msg = "获取地区信息失败！";
		if(id != null && id > 0){
			county = receiptPlaceService.getReceiptPlace(id);
			if(county != null){
				WebUtil.setRequestValue("county", county);
				return SUCCESS;
			}
		}
		super.saveMessage(msg, "receiptplace/search.action");
		return MESSAGE;
	}
	
	public String update(){
		String msg = "参数异常！修改地区信息失败！";
		if (county != null && null != county.getId() && county.getId() > 0
				&& null != county.getCityid() && county.getCityid() > 0
				&& null != county.getProvinceid() && county.getProvinceid() > 0
				&& UtilHelp.isNotNullStr(county.getProvincename())
				&& UtilHelp.isNotNullStr(county.getCityname())
				&& UtilHelp.isNotNullStr(county.getName())) {
			
			county.setProvincename(county.getProvincename().trim());
			county.setCityname(county.getCityname().trim());
			county.setName(county.getName().trim());
			
			if(UtilHelp.isNotNullStr(county.getShortname())){
				county.setShortname(county.getShortname().trim());
			}
			msg = "修改地区信息成功！";
			int count = updateDelivery(county);//同步修改交货地
			count = receiptPlaceService.updateReceiptPlace(county);
			if(count == 0){
				msg = "此地区信息已不存在！";
			}
		}
		super.saveMessage(msg, "receiptplace/search.action");
		return MESSAGE;
	}
	/**
	 * 同步修改交货地
	 * @param county
	 * @return
	 */
	private int updateDelivery(County county){
		int count = 0;
		County dbCounty = receiptPlaceService.getReceiptPlace(county.getId());
		if(null != dbCounty){
			
			DeliveryArea dbDeliveryArea = new DeliveryArea(dbCounty.getId(),
					dbCounty.getName(), dbCounty.getShortname(), dbCounty
							.getCityid(), dbCounty.getCityname(), dbCounty
							.getProvinceid(), dbCounty.getProvincename());
			
			DeliveryArea newDeliveryArea = new DeliveryArea(county.getId(),
					county.getName(), county.getShortname(), county
							.getCityid(), county.getCityname(), county
							.getProvinceid(), county.getProvincename());
			
			count = deliveryPlaceService.updateDeliveryArea(dbDeliveryArea, newDeliveryArea);
		}
		return count;
	}
}
