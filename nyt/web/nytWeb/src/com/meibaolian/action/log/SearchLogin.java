package com.meibaolian.action.log;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.AccessLogLoginDto;
import com.meibaolian.entity.AccessLogLogin;
import com.meibaolian.service.log.IAccessLogLoginService;
import com.meibaolian.util.UtilHelp;

public class SearchLogin extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IAccessLogLoginService accessLogLoginService;
	private AccessLogLoginDto accessLogLoginDto = new AccessLogLoginDto();
	
	
	public AccessLogLoginDto getAccessLogLoginDto() {
		return accessLogLoginDto;
	}
	public void setAccessLogLoginDto(AccessLogLoginDto accessLogLoginDto) {
		this.accessLogLoginDto = accessLogLoginDto;
	}

	public void setAccessLogLoginService(
			IAccessLogLoginService accessLogLoginService) {
		this.accessLogLoginService = accessLogLoginService;
	}
	public String search(){
		
		accessLogLoginDto.setKeyword( UtilHelp.trimStr(accessLogLoginDto.getKeyword()));
		
		QueryResult<AccessLogLogin> qr = accessLogLoginService.searchList(accessLogLoginDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<AccessLogLogin>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("accessLogLoginDto", accessLogLoginDto);
		return SUCCESS;
		
	}
	
}
