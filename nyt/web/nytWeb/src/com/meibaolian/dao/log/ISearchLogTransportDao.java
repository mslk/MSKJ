package com.meibaolian.dao.log;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.SearchLogTransportDto;
import com.meibaolian.entity.SearchLogTransport;

public interface ISearchLogTransportDao extends IBaseDao<SearchLogTransport> {

	public QueryResult<SearchLogTransport> searchList(SearchLogTransportDto searchLogTransportDto, int page,
			int pageSize, LinkedHashMap<String, String> orders);
}
