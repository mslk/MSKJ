package com.meibaolian.action.transportDemand;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransportDemandService transportDemandService;
	
	private TransportDemandDto transportDemandDto = new TransportDemandDto();
	
	public String search(){
		
		transportDemandDto.setKeyword( transportDemandDto.getKeyword() != null ? transportDemandDto.getKeyword().trim() : null );
		QueryResult<TransportDemand> qr = transportDemandService.searchList(transportDemandDto, getPage(),PAGESIZE, null);
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
