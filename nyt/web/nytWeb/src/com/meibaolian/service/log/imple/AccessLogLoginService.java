package com.meibaolian.service.log.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.log.IAccessLogLoginDao;
import com.meibaolian.dto.AccessLogLoginDto;
import com.meibaolian.entity.AccessLogLogin;
import com.meibaolian.service.log.IAccessLogLoginService;

public class AccessLogLoginService implements IAccessLogLoginService {

	private IAccessLogLoginDao accessLogLoginDao;
	
	public void setAccessLogLoginDao(IAccessLogLoginDao accessLogLoginDao) {
		this.accessLogLoginDao = accessLogLoginDao;
	}

	@Override
	public QueryResult<AccessLogLogin> searchList(
			AccessLogLoginDto accessLogLoginDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return accessLogLoginDao.searchList(accessLogLoginDto, page, pageSize, orders);
	}

}
