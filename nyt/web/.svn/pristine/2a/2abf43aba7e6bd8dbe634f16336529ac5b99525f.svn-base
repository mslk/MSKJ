package com.meibaolian.service.userInfo;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;

public interface IUserInfoService {
	
	public QueryResult<UserInfo> searchList(UserInfoDto userInfoDto, int page, int pageSize);
	
	public UserInfo getUserInfo(Integer id);
	
	public int updateUserInfoStatus(Integer id, Integer status);
	
	public void updateUser(UserInfo userInfo);
}
