package com.meibaolian.action.userInfo;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.userInfo.IUserInfoService;

public class Show extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserInfoService userInfoService;
	
	private Integer id;
	
	public String show(){
		if(id != null){
			UserInfo userInfo = userInfoService.getUserInfo(id);
			if(userInfo != null){
				WebUtil.setRequestValue("userInfo", userInfo);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
