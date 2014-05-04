package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.util.exception.DataManagerException;

public interface ICoalParticleSizeDao extends IBaseDao<CoalParticleSize> {

	/**
	 * 查询所有的煤 对应的粒度类型
	 * @return
	 * @throws DataManagerException 
	 */
	public List<CoalParticleSize> searchAll() throws DataManagerException;
	
}
