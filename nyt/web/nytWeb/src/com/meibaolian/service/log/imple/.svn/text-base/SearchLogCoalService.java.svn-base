package com.meibaolian.service.log.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.log.ISearchLogCoalDao;
import com.meibaolian.dto.SearchLogCoalDto;
import com.meibaolian.entity.SearchLogCoal;
import com.meibaolian.service.log.ISearchLogCoalService;

public class SearchLogCoalService implements ISearchLogCoalService {

	private ISearchLogCoalDao searchLogCoalDao;
	
	public void setSearchLogCoalDao(ISearchLogCoalDao searchLogCoalDao) {
		this.searchLogCoalDao = searchLogCoalDao;
	}

	@Override
	public QueryResult<SearchLogCoal> searchList(
			SearchLogCoalDto searchLogCoalDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return searchLogCoalDao.searchList(searchLogCoalDto, page, pageSize, orders);
	}

}
