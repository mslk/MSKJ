package com.meibaolian.service.user.imple;

import com.meibaolian.dao.user.IUserManagerDao;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.service.user.IUserManagerService;

public class UserManagerService implements IUserManagerService {

	
	IUserManagerDao userMangerDao;
	

	public void setUserMangerDao(IUserManagerDao userMangerDao) {
		this.userMangerDao = userMangerDao;
	}


	@Override
	public Usermanager searchByNameAndPwd(String name, String pwd) {
		return userMangerDao.searchByNameAndPwd(name, pwd);
	}

	@Override
	public void updatePwd(Usermanager usermanager) {
		userMangerDao.updatePwd(usermanager);
	}

}
