package com.meibaolian.dao.searchlog;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.SearchlogTransport;

public interface ISearchlogTransportDao extends IBaseDao<SearchlogTransport> {
	
	/**
	 * 记录物流查询条件
	 * 
	 * @param searchlog
	 * @return
	 */
	public int addSearchLog(SearchlogTransport searchlog);
}
