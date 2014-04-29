package com.meibaolian.dao.userInfo;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;

public interface IUserInfoDao extends IBaseDao<UserInfo>{
	
	public QueryResult<UserInfo> searchList(UserInfoDto userInfoDto, int page, int pageSize);
}
