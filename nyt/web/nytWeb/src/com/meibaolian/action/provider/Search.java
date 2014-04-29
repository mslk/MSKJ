package com.meibaolian.action.provider;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.UtilHelp;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProviderService providerService;
	
	private ProviderDto providerDto = new ProviderDto();
	
	public String search(){
		if(null != providerDto.getMinheating() && null != providerDto.getMaxheating() && providerDto.getMinheating() > providerDto.getMaxheating() ){
			super.saveMessage("参数异常！", null);
			return MESSAGE;
		}
		providerDto.setCoalname(UtilHelp.trimStr(providerDto.getCoalname()));
		providerDto.setCoalsizename(UtilHelp.trimStr(providerDto.getCoalsizename()));
		providerDto.setKeyword( UtilHelp.trimStr(providerDto.getKeyword()));
		
		QueryResult<Provider> qr = providerService.searchList(providerDto, getPage(),PAGESIZE, null);
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
