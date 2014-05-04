package com.meibaolian.dao.nyt;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.TypeListEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface ITypeListDao extends IBaseDao<TypeListEntity> {
	public List<TypeListEntity> searchAll() throws DataManagerException;
}
