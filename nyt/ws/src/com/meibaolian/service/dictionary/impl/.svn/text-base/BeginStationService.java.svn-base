package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IBeginStationDao;
import com.meibaolian.entity.BeginStationEntity;
import com.meibaolian.service.dictionary.IBeginStationService;
import com.meibaolian.util.exception.DataManagerException;

public class BeginStationService implements IBeginStationService {

	
	IBeginStationDao beginStationDao;
	
	public void setBeginStationDao(IBeginStationDao beginStationDao) {
		this.beginStationDao = beginStationDao;
	}



	@Override
	public List<BeginStationEntity> searchAll() throws DataManagerException {
		return beginStationDao.searchAll();
	}

}
