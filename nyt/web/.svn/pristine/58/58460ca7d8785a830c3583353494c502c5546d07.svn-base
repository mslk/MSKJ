package com.meibaolian.service.log.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.log.ISearchLogTransportDao;
import com.meibaolian.dto.SearchLogTransportDto;
import com.meibaolian.entity.SearchLogTransport;
import com.meibaolian.service.log.ISearchLogTransportService;

public class SearchLogTransportService implements ISearchLogTransportService {

	private ISearchLogTransportDao searchLogTransportDao;
	
	public void setSearchLogTransportDao(
			ISearchLogTransportDao searchLogTransportDao) {
		this.searchLogTransportDao = searchLogTransportDao;
	}

	@Override
	public QueryResult<SearchLogTransport> searchList(
			SearchLogTransportDto searchLogTransportDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		
		return searchLogTransportDao.searchList(searchLogTransportDto, page, pageSize, orders);
	}

}
