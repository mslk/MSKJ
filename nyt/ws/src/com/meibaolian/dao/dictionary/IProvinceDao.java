package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.ProvinceEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IProvinceDao  extends IBaseDao<ProvinceEntity>{
	
	/**
	 * 查询所有的省市列表
	 * @return
	 * @throws DataManagerException 
	 */
	public List<ProvinceEntity> searchAllProvinceAndCity() throws DataManagerException;

}
