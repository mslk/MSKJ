package com.meibaolian.service.coalparticlesize.impl;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.coalparticlesize.ICoalParticleSizeDao;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.service.coalparticlesize.ICoalParticleSizeService;

public class CoalParticleSizeService implements ICoalParticleSizeService {

	
	ICoalParticleSizeDao coalParticleSizeDao;
	
	public void setCoalParticleSizeDao(ICoalParticleSizeDao coalParticleSizeDao) {
		this.coalParticleSizeDao = coalParticleSizeDao;
	}


	@Override
	public void addCoalParticleSize(CoalParticleSize coalParticleSize) {
		coalParticleSizeDao.add(coalParticleSize);
	}


	@Override
	public QueryResult<CoalParticleSize> searchByType(int page, int pageSize,int type) {
		return coalParticleSizeDao.searchByType(page, pageSize, type);
	}


	@Override
	public void deleteCoalParticleSize(int particleSizeId) {
		coalParticleSizeDao.delete(particleSizeId);		
	}


	@Override
	public long searchByCoalParticleSizeName(int coalTypeId,String coalParticleSizeName) {
		return coalParticleSizeDao.searchByCoalParticleSizeName(coalTypeId,coalParticleSizeName);
	}



	
}
