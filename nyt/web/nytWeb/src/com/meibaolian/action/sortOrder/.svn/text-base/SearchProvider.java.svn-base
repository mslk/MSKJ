package com.meibaolian.action.sortOrder;

import java.util.LinkedHashMap;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;

public class SearchProvider extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProviderService providerService;
	
	private ProviderDto providerDto = new ProviderDto();
	
	public String search(){

		providerDto.setKeyword( providerDto.getKeyword() != null ? providerDto.getKeyword().trim() : null );
		
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>(1);
		orders.put("sortnumber", "desc");
		
		QueryResult<Provider> qr = providerService.searchList(providerDto, getPage(),PAGESIZE, orders);
		savePageView(new PageView<Provider>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("providerDto", providerDto);
		return SUCCESS;
	}

	public ProviderDto getProviderDto() {
		return providerDto;
	}

	public void setProviderDto(ProviderDto providerDto) {
		this.providerDto = providerDto;
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}
	
}
