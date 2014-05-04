package com.meibaolian.service.log.imple;

import java.util.Date;

import com.meibaolian.dao.log.IAccesslogLoginDao;
import com.meibaolian.dao.log.IAccesslogModuleDao;
import com.meibaolian.entity.AccesslogLogin;
import com.meibaolian.entity.AccesslogModule;
import com.meibaolian.entity.log.LogModule;
import com.meibaolian.service.log.ILogService;

public class LogService implements ILogService {

	IAccesslogLoginDao accesslogLoginDao;
	
	IAccesslogModuleDao accesslogModuleDao;
	
	public void setAccesslogLoginDao(IAccesslogLoginDao accesslogLoginDao) {
		this.accesslogLoginDao = accesslogLoginDao;
	}

	public void setAccesslogModuleDao(IAccesslogModuleDao accesslogModuleDao) {
		this.accesslogModuleDao = accesslogModuleDao;
	}

	@Override
	public int addLoginLog(Integer userid, String phone,int type,int result)
	{
		AccesslogLogin login=new AccesslogLogin();
		if(userid==null)
		{
			userid=0;
		}
		login.setUserid(userid);
		login.setPhone(phone);
		login.setType(type);
		login.setResult(result);
		login.setAddtime(new Date());
		return accesslogLoginDao.add(login);
	}

	@Override
	public int addModuleLog(Integer userid,String content, LogModule logModule) 
	{
		AccesslogModule module=new AccesslogModule();
		if(userid==null)
		{
			userid=0;
		}
		module.setUserid(userid);
		module.setTitle(logModule.getTitle());
		module.setModule(logModule.getModule());
		module.setFuncation(logModule.getFuncation());
		module.setContent(content);
		module.setAddtime(new Date());
		return accesslogModuleDao.add(module);
	}
	
	

}
