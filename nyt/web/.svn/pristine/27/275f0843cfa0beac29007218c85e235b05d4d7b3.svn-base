package com.meibaolian.dao.coalparticlesize.impl;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.coalparticlesize.ICoalParticleSizeDao;
import com.meibaolian.entity.CoalParticleSize;

public class CoalParticleSizeDao extends BaseDao<CoalParticleSize> implements
		ICoalParticleSizeDao {

	@Override
	public QueryResult<CoalParticleSize> searchByType(int page, int pageSize,
			int type) {

		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>();
		orders.put(" id ", " desc ");
		if (type != 0) {
			String sqlWhere = " and type=? ";
			return super.search(page, pageSize, sqlWhere,
					new Object[] { type }, orders);
		} else {
			return super.search(page, pageSize, orders);
		}

	}

	@Override
	public long searchByCoalParticleSizeName(int coalTypeId,String coalParticleSizeName) {
		
		String  hql=" select count(id) from CoalParticleSize where name=? and type=? ";
		return super.searchCountByhql(hql, new Object[]{coalParticleSizeName,coalTypeId});
	}

}
