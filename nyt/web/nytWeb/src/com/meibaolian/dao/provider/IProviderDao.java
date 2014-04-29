package com.meibaolian.dao.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;

public interface IProviderDao extends IBaseDao<Provider>{
	public QueryResult<Provider> searchList(ProviderDto providerDto, int page, int pageSize, LinkedHashMap<String, String> orders);
}
