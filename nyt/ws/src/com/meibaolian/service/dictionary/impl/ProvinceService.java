package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IProvinceDao;
import com.meibaolian.entity.ProvinceEntity;
import com.meibaolian.service.dictionary.IProvinceService;
import com.meibaolian.util.exception.DataManagerException;

public class ProvinceService implements IProvinceService {

	
	IProvinceDao provinceDao;
	
	
	public void setProvinceDao(IProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}



	@Override
	public List<ProvinceEntity> searchAllProvinceAndCity()
			throws DataManagerException {
		return provinceDao.searchAllProvinceAndCity();
	}

	

}
