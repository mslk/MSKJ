package com.meibaolian.dao.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.ProviderInfo;

public interface IProviderInfoDao extends IBaseDao<ProviderInfo>{
	
	public QueryResult<ProviderInfo> searchList(ProviderDto providerDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	
}
