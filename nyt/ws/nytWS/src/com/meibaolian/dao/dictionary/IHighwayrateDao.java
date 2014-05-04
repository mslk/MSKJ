package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.HighwayrateEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IHighwayrateDao extends IBaseDao<HighwayrateEntity>{
	public List<HighwayrateEntity> getHighwayrateList(int city, String stop) throws DataManagerException;
}
