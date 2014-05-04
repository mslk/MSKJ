package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.StationEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IStationDao extends IBaseDao<StationEntity> {

	
	/**
	 * 根据城市id 查询所有的公路,铁路地点
	 * @param city
	 * @return
	 * @throws DataManagerException 
	 */
	public List<StationEntity> searchByCity(int city) throws DataManagerException;
}
