package com.meibaolian.dao.log;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.AccesslogLogin;

public interface IAccesslogLoginDao extends IBaseDao<AccesslogLogin>{
	
	
	/**
	 * 添加用户登陆日志
	 * @param accessloglogin
	 * @return
	 */
	public int  add(AccesslogLogin accessloglogin);

}
