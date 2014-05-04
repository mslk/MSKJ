package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.CoalMine;
import com.meibaolian.util.exception.DataManagerException;

public interface ICoalMineDao extends IBaseDao<CoalMine>{
	
	public List<CoalMine> getCoalMineList() throws DataManagerException;
}
