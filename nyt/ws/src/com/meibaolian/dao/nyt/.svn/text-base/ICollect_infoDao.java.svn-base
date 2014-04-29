package com.meibaolian.dao.nyt;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface ICollect_infoDao extends IBaseDao<Collect_infoEntity>{
	
	public int addCollect(Collect_infoEntity customer);
	
	public int delCollect(int id);
	/**
	 * 是否已存在此数据
	 * @param vo
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExistCollect(Collect_infoEntity vo) throws DataManagerException;
	
	public QueryResult<Collect_infoEntity> getCollect_infoBean(Collect_infoEntity vo, int page, int pageSize)throws DataManagerException;
}
