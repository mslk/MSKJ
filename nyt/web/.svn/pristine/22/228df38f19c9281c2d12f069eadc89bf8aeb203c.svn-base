package com.meibaolian.action.sortOrder;

import java.util.LinkedHashMap;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;

public class SearchPurchase extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPurchaseService purchaseService;
	
	private PurchaseDto purchaseDto = new PurchaseDto();
	
	public String search(){
		
		purchaseDto.setKeyword( purchaseDto.getKeyword() != null ? purchaseDto.getKeyword().trim() : null );
		
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>(1);
		orders.put("sortnumber", "desc");
		
		QueryResult<Purchase> qr = purchaseService.searchList(purchaseDto, getPage(), PAGESIZE, orders);
		savePageView(new PageView<Purchase>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("purchaseDto", purchaseDto);
		return SUCCESS;
		
	}

	public PurchaseDto getPurchaseDto() {
		return purchaseDto;
	}

	public void setPurchaseDto(PurchaseDto purchaseDto) {
		this.purchaseDto = purchaseDto;
	}

	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
}
