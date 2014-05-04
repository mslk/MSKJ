package com.meibaolian.service.dictionary;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.County;
import com.meibaolian.util.exception.DataManagerException;

public interface ICountyService {

	public QueryResult<County> searchCounty(String keyword) throws DataManagerException;
}
