package com.meibaolian.dao.coaltype;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.CoalType;

public interface ICoalTypeDao  extends IBaseDao<CoalType>
{

	
	public long searchByCoalType(String coalTypeName);
}
