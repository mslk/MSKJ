package com.meibaolian.service.userInfo.imple;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.userInfo.IUserInfoService;

public class UserInfoService implements IUserInfoService {
	
	private IUserInfoDao userInfoDao;
	
	@Override
	public QueryResult<UserInfo> searchList(UserInfoDto userInfoDto, int page,
			int pageSize) {
		
		return userInfoDao.searchList(userInfoDto, page, pageSize);
	}

	@Override
	public UserInfo getUserInfo(Integer id) {
		return userInfoDao.get(id);
	}

	@Override
	public int updateUserInfoStatus(Integer id, Integer status) {
		
		UserInfo userInfo = userInfoDao.get(id);
		int result = 0;
		if(userInfo != null){
			userInfo.setStatus(status);
			userInfoDao.update(userInfo);
			result = 1;
		}
		return result;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void updateUser(UserInfo userInfo) {
          userInfoDao.update(userInfo);		
	}

}
