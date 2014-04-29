package com.meibaolian.action.receiptplace;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ReceiptPlaceDto;
import com.meibaolian.entity.County;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IReceiptPlaceService receiptPlaceService;
	
	private ReceiptPlaceDto receiptPlaceDto = new ReceiptPlaceDto();
	
	public ReceiptPlaceDto getReceiptPlaceDto() {
		return receiptPlaceDto;
	}

	public void setReceiptPlaceDto(ReceiptPlaceDto receiptPlaceDto) {
		this.receiptPlaceDto = receiptPlaceDto;
	}

	public void setReceiptPlaceService(IReceiptPlaceService receiptPlaceService) {
		this.receiptPlaceService = receiptPlaceService;
	}
	//
	public String search(){

		receiptPlaceDto.setKeyword( receiptPlaceDto.getKeyword() != null ? receiptPlaceDto.getKeyword().trim() : null );
		QueryResult<County> qr = receiptPlaceService.searchList(receiptPlaceDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<County>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("receiptPlaceDto", receiptPlaceDto);
		return SUCCESS;
	}


}
