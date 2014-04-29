package com.meibaolian.service.log.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.log.IAccessLogModuleDao;
import com.meibaolian.dto.AccessLogModuleDto;
import com.meibaolian.entity.AccessLogModule;
import com.meibaolian.service.log.IAccessLogModuleService;

public class AccessLogModuleService implements IAccessLogModuleService {

	private IAccessLogModuleDao accessLogModuleDao;
	
	public void setAccessLogModuleDao(IAccessLogModuleDao accessLogModuleDao) {
		this.accessLogModuleDao = accessLogModuleDao;
	}

	@Override
	public QueryResult<AccessLogModule> searchList(
			AccessLogModuleDto accessLogModuleDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return accessLogModuleDao.searchList(accessLogModuleDto, page, pageSize, orders);
	}

}
