package com.meibaolian.dao.coalparticlesize;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CoalParticleSize;

public interface ICoalParticleSizeDao extends IBaseDao<CoalParticleSize> {

	/**
	 * 根据type 查询相关的粒度信息
	 * @param page
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public QueryResult<CoalParticleSize> searchByType(int page,int pageSize, int type);
	
	
	/**
	 * 根据名称查询 煤种粒度是否已经存在
	 * @param coalParticleSizeName
	 * @return
	 */
	public long searchByCoalParticleSizeName(int coalTypeId,String coalParticleSizeName);
	
}
