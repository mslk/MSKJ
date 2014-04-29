package com.meibaolian.service.user.impl;

import com.meibaolian.dao.user.IUserDao;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;

public class UserService implements IUserService {

	IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public long searchPhone(String phone) throws DataManagerException {
		return userDao.searchPhone(phone);
	}

	@Override
	public int addUserInfo(String phone) throws NoParameterException,
			DataManagerException {
		long have = 0;// userDao.searchName(userInfo.getLoginname());
		
		int result = 0;
		
		have = userDao.searchPhone(phone);
		if (have >= 1) {
			result = 3;
		} else {
			UserInfo userInfo = new UserInfo();
//			userInfo.setLoginname("");
//			userInfo.setPassword("");
			userInfo.setPhone(phone);
//			userInfo.setRealname("");
//			userInfo.setCompnayname("");
//			userInfo.setType(100);
//			userInfo.setAddress("");
			result = userDao.addUserInfo(userInfo);
		}

		return result;
	}

	@Override
	public UserInfo searchUser(String phone, String pwd)
			throws DataManagerException {
		return userDao.searchUser(phone, pwd);
	}
	
	@Override
	public UserInfo searchUser(String phone) throws DataManagerException {
		return userDao.searchUser(phone);
	}
	

	@Override
	public int editContacts(UserInfo userInfo){
		return userDao.editContacts(userInfo);
	}

	@Override
	public int updatePushStatus(int uuid, int status) {
		return userDao.updatePushStatus(uuid, status);
	}

	@Override
	public int updateUserPwd( String phone, String oldPwd,
			String newPwd) {
		return userDao.updateUserPwd(phone, oldPwd, newPwd);
	}

	@Override
	public int updateUserContacts(UserInfo userInfo,int updateType) {
		return userDao.updateUserContacts(userInfo,updateType);
	}

	@Override
	public UserInfo getById(int id) throws DataManagerException {
		return userDao.getById(id);
	}

	@Override
	public int updateUserPwd(String phone, String newPwd) {
		return userDao.updateUserPwd(phone, newPwd);
	}

	@Override
	public int deleteUserByPhone(String phone) {
		return userDao.deleteUserByPhone(phone);
	}


}
