package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.ICoalTypeDao;
import com.meibaolian.entity.CoalTypeEntity;
import com.meibaolian.service.dictionary.ICoalTypeService;
import com.meibaolian.util.exception.DataManagerException;

public class CoalTypeService implements ICoalTypeService {

	ICoalTypeDao coalTypeDao;
	
	public void setCoalTypeDao(ICoalTypeDao coalTypeDao) {
		this.coalTypeDao = coalTypeDao;
	}



	@Override
	public List<CoalTypeEntity> searchAll() throws DataManagerException {
		return coalTypeDao.searchAll();
	}

}
