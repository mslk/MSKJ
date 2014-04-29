package com.meibaolian.service.dictionary.impl;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.dictionary.ICountyDao;
import com.meibaolian.entity.County;
import com.meibaolian.service.dictionary.ICountyService;
import com.meibaolian.util.exception.DataManagerException;

public class CountyService implements ICountyService {

	private ICountyDao countyDao;
	
	public void setCountyDao(ICountyDao countyDao) {
		this.countyDao = countyDao;
	}

	@Override
	public QueryResult<County> searchCounty(String keyword)
			throws DataManagerException {
		
		return countyDao.searchCounty(keyword);
	}

}
