package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.util.exception.DataManagerException;

public interface ICoalParticleSizeService {

	/**
	 * 查询所有的煤 对应的粒度类型
	 * @return
	 * @throws DataManagerException 
	 */
	public List<CoalParticleSize> searchAll() throws DataManagerException;
	
}
