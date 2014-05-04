package com.meibaolian.service.nyt.impl;

import java.util.List;

import com.meibaolian.dao.nyt.ITypeListDao;
import com.meibaolian.entity.TypeListEntity;
import com.meibaolian.service.nyt.ITypeListService;
import com.meibaolian.util.exception.DataManagerException;

public class TypeListService implements ITypeListService {
	ITypeListDao typeListDao;

	public void setTypeListDao(ITypeListDao typeListDao) {
		this.typeListDao = typeListDao;
	}
	
	@Override
	public List<TypeListEntity> searchAll() throws DataManagerException {
		return typeListDao.searchAll();
	}
}
