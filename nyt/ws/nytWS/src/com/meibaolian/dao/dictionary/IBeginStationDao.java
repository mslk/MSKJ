package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.BeginStationEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IBeginStationDao extends IBaseDao<BeginStationEntity>
{
	/**
	 * 查询所有的发货地点
	 * @return
	 * @throws DataManagerException 
	 */
	public List<BeginStationEntity> searchAll() throws DataManagerException;

}
