package com.meibaolian.action.log;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.AccessLogModuleDto;
import com.meibaolian.entity.AccessLogModule;
import com.meibaolian.service.log.IAccessLogModuleService;
import com.meibaolian.util.UtilHelp;

public class SearchModule extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IAccessLogModuleService accessLogModuleService;
	private AccessLogModuleDto accessLogModuleDto = new AccessLogModuleDto();
	
	
	public AccessLogModuleDto getAccessLogModuleDto() {
		return accessLogModuleDto;
	}
	public void setAccessLogModuleDto(AccessLogModuleDto accessLogModuleDto) {
		this.accessLogModuleDto = accessLogModuleDto;
	}

	public void setAccessLogModuleService(
			IAccessLogModuleService accessLogModuleService) {
		this.accessLogModuleService = accessLogModuleService;
	}
	public String search(){
		
		accessLogModuleDto.setKeyword( UtilHelp.trimStr(accessLogModuleDto.getKeyword()));
		
		QueryResult<AccessLogModule> qr = accessLogModuleService.searchList(accessLogModuleDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<AccessLogModule>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("accessLogModuleDto", accessLogModuleDto);
		return SUCCESS;
		
	}
	
}
