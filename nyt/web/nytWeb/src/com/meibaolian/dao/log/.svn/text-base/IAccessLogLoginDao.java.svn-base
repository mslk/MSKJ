package com.meibaolian.dao.log;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.AccessLogLoginDto;
import com.meibaolian.entity.AccessLogLogin;

public interface IAccessLogLoginDao extends IBaseDao<AccessLogLogin> {
	
	public QueryResult<AccessLogLogin> searchList(AccessLogLoginDto accessLogLoginDto, int page,
			int pageSize, LinkedHashMap<String, String> orders);
}
