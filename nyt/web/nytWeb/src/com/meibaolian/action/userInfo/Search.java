package com.meibaolian.action.userInfo;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.service.userInfo.IUserInfoService;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserInfoService userInfoService;
	
	private UserInfoDto userInfoDto = new UserInfoDto();
	
	public String search(){
		
		userInfoDto.setKeyword( userInfoDto.getKeyword() != null ? userInfoDto.getKeyword().trim() : null );	
		Usermanager usermanager = WebUtil.getAdmin(null);
		if(null != usermanager)
			userInfoDto.setUsermanager(usermanager);
		QueryResult<UserInfo> qr = userInfoService.searchList(userInfoDto, getPage(),PAGESIZE);
		savePageView(new PageView<UserInfo>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("userInfoDto", userInfoDto);
		return SUCCESS;
	}

	public UserInfoDto getUserInfoDto() {
		return userInfoDto;
	}

	public void setUserInfoDto(UserInfoDto userInfoDto) {
		this.userInfoDto = userInfoDto;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
}
