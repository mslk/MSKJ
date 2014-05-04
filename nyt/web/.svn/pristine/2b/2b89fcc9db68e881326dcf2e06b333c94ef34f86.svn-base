package com.meibaolian.service.user.imple;

import java.util.ArrayList;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
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


	@Override
	public List<Usermanager> searchAll() {
		QueryResult<Usermanager> qr = userMangerDao.search(0, 10000);
		return null != qr ? qr.getQueryList() : new ArrayList<Usermanager>();
	}

}
