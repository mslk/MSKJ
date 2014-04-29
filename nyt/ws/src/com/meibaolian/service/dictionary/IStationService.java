package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.StationEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IStationService {
	
	/**
	 * 根据城市id 查询所有的公路,铁路地点
	 * @param city
	 * @return
	 * @throws DataManagerException 
	 */
	public List<StationEntity> searchByCity(int city) throws DataManagerException;

}
