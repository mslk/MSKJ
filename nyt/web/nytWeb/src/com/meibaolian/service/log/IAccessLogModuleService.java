package com.meibaolian.service.log;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.AccessLogModuleDto;
import com.meibaolian.entity.AccessLogModule;

public interface IAccessLogModuleService {
	
	public QueryResult<AccessLogModule> searchList(AccessLogModuleDto accessLogModuleDto, int page,
			int pageSize, LinkedHashMap<String, String> orders);
}
