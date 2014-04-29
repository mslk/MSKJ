package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Railwayrate;
import com.meibaolian.util.exception.DataManagerException;

public interface IRailwayrateDao extends IBaseDao<Railwayrate>{
	public List<Railwayrate> getRailwayrateList(int city, String stop) throws DataManagerException;
}
