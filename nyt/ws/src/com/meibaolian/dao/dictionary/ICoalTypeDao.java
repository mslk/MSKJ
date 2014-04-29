package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.CoalTypeEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface ICoalTypeDao extends IBaseDao<CoalTypeEntity>{

	public List<CoalTypeEntity> searchAll() throws DataManagerException;
	
	
}
