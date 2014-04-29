package com.meibaolian.service.coaltype.imple;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.coaltype.ICoalTypeDao;
import com.meibaolian.entity.CoalType;
import com.meibaolian.service.coaltype.ICoalTypeService;

public class CoalTypeService implements ICoalTypeService {

	
	ICoalTypeDao coalTypeDao;
	
	public void setCoalTypeDao(ICoalTypeDao coalTypeDao) {
		this.coalTypeDao = coalTypeDao;
	}

	@Override
	public void add(CoalType coalType) {
		coalTypeDao.add(coalType);
		
	}

	@Override
	public void delete(int coalTypeId) {
		coalTypeDao.delete(coalTypeId);	
	}


	@Override
	public QueryResult<CoalType> search(int page, int pageSize) {
		return coalTypeDao.search(page, pageSize);
	}


	@Override
	public long searchByCoalType(String coalTypeName) {
		return coalTypeDao.searchByCoalType(coalTypeName);
	}
	
	
	


}
