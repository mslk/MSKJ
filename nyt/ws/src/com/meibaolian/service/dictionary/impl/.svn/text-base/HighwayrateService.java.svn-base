package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IHighwayrateDao;
import com.meibaolian.entity.HighwayrateEntity;
import com.meibaolian.service.dictionary.IHighwayrateService;
import com.meibaolian.util.exception.DataManagerException;

public class HighwayrateService implements IHighwayrateService {
	
	private IHighwayrateDao highwayrateDao;
	
	@Override
	public List<HighwayrateEntity> getHighwayrateList(int city, String stop) throws DataManagerException{

		return highwayrateDao.getHighwayrateList(city, stop);
	}

	public void setHighwayrateDao(IHighwayrateDao highwayrateDao) {
		this.highwayrateDao = highwayrateDao;
	}
	
}
