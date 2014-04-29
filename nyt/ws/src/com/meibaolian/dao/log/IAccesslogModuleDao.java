package com.meibaolian.dao.log;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.AccesslogModule;

public interface IAccesslogModuleDao extends IBaseDao<AccesslogModule> {
	
	
	/**
	 * 添加模块操作日志
	 * @param accesslogmodule
	 * @return
	 */
	public int add(AccesslogModule accesslogmodule);

}
