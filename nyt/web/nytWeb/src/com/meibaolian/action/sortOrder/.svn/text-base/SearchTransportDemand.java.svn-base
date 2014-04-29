package com.meibaolian.action.sortOrder;

import java.util.LinkedHashMap;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class SearchTransportDemand extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransportDemandService transportDemandService;
	
	private TransportDemandDto transportDemandDto = new TransportDemandDto();
	
	public String search(){
		
		transportDemandDto.setKeyword( transportDemandDto.getKeyword() != null ? transportDemandDto.getKeyword().trim() : null );

		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>(1);
		orders.put("sortnumber", "desc");
		
		QueryResult<TransportDemand> qr = transportDemandService.searchList(transportDemandDto, getPage(),PAGESIZE, orders);
		savePageView(new PageView<TransportDemand>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("transportDemandDto", transportDemandDto);
		return SUCCESS;
	}

	public TransportDemandDto getTransportDemandDto() {
		return transportDemandDto;
	}

	public void setTransportDemandDto(TransportDemandDto transportDemandDto) {
		this.transportDemandDto = transportDemandDto;
	}

	public void setTransportDemandService(ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
}
