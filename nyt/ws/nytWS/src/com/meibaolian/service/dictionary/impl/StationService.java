package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IStationDao;
import com.meibaolian.entity.StationEntity;
import com.meibaolian.service.dictionary.IStationService;
import com.meibaolian.util.exception.DataManagerException;

public class StationService implements IStationService {

	
	IStationDao stationDao;
	
	public void setStationDao(IStationDao stationDao) {
		this.stationDao = stationDao;
	}



	@Override
	public List<StationEntity> searchByCity(int city)
			throws DataManagerException {
		return stationDao.searchByCity(city);
	}

}
