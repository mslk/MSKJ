package com.meibaolian.action.purchase;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.UtilHelp;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPurchaseService purchaseService;
	
	private PurchaseDto purchaseDto = new PurchaseDto();
	
	public String search(){
		
		if(null != purchaseDto.getMinheating() && null != purchaseDto.getMaxheating() && purchaseDto.getMinheating() > purchaseDto.getMaxheating() ){
			super.saveMessage("参数异常！", null);
			return MESSAGE;
		}
		purchaseDto.setCoalname(UtilHelp.trimStr(purchaseDto.getCoalname()));
		purchaseDto.setCoalsizename(UtilHelp.trimStr(purchaseDto.getCoalsizename()));
		purchaseDto.setKeyword( UtilHelp.trimStr(purchaseDto.getKeyword()));
		
		QueryResult<Purchase> qr = purchaseService.searchList(purchaseDto, getPage(),PAGESIZE, null);
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
