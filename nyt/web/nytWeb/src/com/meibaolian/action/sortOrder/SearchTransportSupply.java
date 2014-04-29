package com.meibaolian.action.sortOrder;

import java.util.LinkedHashMap;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.TransportSupplyDto;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;

public class SearchTransportSupply extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransportSupplyService transportSupplyService;
	
	private TransportSupplyDto transportSupplyDto = new TransportSupplyDto();
	
	
	public TransportSupplyDto getTransportSupplyDto() {
		return transportSupplyDto;
	}

	public void setTransportSupplyDto(TransportSupplyDto transportSupplyDto) {
		this.transportSupplyDto = transportSupplyDto;
	}


	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}


	public String search()
	{
		transportSupplyDto.setKeyword( transportSupplyDto.getKeyword() != null ? transportSupplyDto.getKeyword().trim() : null );

		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>(1);
		orders.put("sortnumber", "desc");
		
		QueryResult<TransportSupply> qr = transportSupplyService.searchList(transportSupplyDto, getPage(),PAGESIZE, orders);
		savePageView(new PageView<TransportSupply>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("transportDemandDto", transportSupplyDto);
		return SUCCESS;
	}


	
}
