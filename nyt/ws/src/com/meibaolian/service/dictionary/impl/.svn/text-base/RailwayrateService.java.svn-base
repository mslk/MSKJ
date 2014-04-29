package com.meibaolian.service.dictionary.impl;

import java.util.List;
import com.meibaolian.dao.dictionary.IRailwayrateDao;
import com.meibaolian.entity.Railwayrate;
import com.meibaolian.service.dictionary.IRailwayrateService;
import com.meibaolian.util.exception.DataManagerException;

public class RailwayrateService implements IRailwayrateService {
	
	private IRailwayrateDao railwayrateDao;
	
	@Override
	public List<Railwayrate> getRailwayrateList(int city, String stop) throws DataManagerException{

		return railwayrateDao.getRailwayrateList(city, stop);
	}

	public void setRailwayrateDao(IRailwayrateDao railwayrateDao) {
		this.railwayrateDao = railwayrateDao;
	}

	
}
