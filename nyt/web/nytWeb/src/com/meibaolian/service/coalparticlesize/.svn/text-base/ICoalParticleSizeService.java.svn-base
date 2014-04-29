package com.meibaolian.service.coalparticlesize;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CoalParticleSize;

public interface ICoalParticleSizeService {

    /**
     * 添加煤种粒度 	
     * @param coalParticleSize
     */
	public void addCoalParticleSize(CoalParticleSize coalParticleSize);
	/**
	 * 删除煤种粒度 	
	 * @param coalParticleSize
	 */
	public void deleteCoalParticleSize(int particleSizeId);
	
	
	/**
	 * 根据type 查询相关的粒度信息
	 * @param page
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public QueryResult<CoalParticleSize> searchByType(int page,int pageSize, int type);
	
	/**
	 * 根据粒度名称查询是否已经存在
	 * @param coalParticleSizeName
	 * @return
	 */
	public long searchByCoalParticleSizeName(int coalTypeId,String coalParticleSizeName);
	
}
