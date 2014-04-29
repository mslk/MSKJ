package com.meibaolian.dao.coaltype.imple;

import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.coaltype.ICoalTypeDao;
import com.meibaolian.entity.CoalType;

public class CoalTypeDao extends BaseDao<CoalType> implements ICoalTypeDao {

	@Override
	public long searchByCoalType(String coalTypeName) 
	{
		String hql=" select count(id) from CoalType where coalName=? ";
		return super.searchCountByhql(hql, new Object[]{coalTypeName});
	}

	

}
