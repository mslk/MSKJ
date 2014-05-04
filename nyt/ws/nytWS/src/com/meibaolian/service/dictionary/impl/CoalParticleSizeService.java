package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.ICoalParticleSizeDao;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.service.dictionary.ICoalParticleSizeService;
import com.meibaolian.util.exception.DataManagerException;

public class CoalParticleSizeService implements ICoalParticleSizeService {

	
	ICoalParticleSizeDao coalParticleSizeDao;
	
	public void setCoalParticleSizeDao(ICoalParticleSizeDao coalParticleSizeDao) {
		this.coalParticleSizeDao = coalParticleSizeDao;
	}



	@Override
	public List<CoalParticleSize> searchAll() throws DataManagerException {
		return coalParticleSizeDao.searchAll();
	}

}
