package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.BeginStationEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IBeginStationService {

	/**
	 * 查询所有的发货地点
	 * @return
	 * @throws DataManagerException 
	 */
	public List<BeginStationEntity> searchAll() throws DataManagerException;
}
