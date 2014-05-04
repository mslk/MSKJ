package com.meibaolian.service.useraid.impl;

import com.meibaolian.dao.useraid.IUserAidDao;
import com.meibaolian.service.useraid.IUserAidService;

public class UserAidService  implements IUserAidService {

	
	IUserAidDao userAidDao;
	
	
	public void setUserAidDao(IUserAidDao userAidDao) {
		this.userAidDao = userAidDao;
	}


	@Override
	public int addCallPhoneLog(String uuid, String phone, int num) {
		return userAidDao.addCallPhoneLog(uuid, phone, num);
	}

	
}
