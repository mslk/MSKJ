package com.meibaolian.dao.searchlog;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.SearchlogCoal;

public interface ISearchlogDao extends IBaseDao<SearchlogCoal>{
	/**
	 * 添加查询条件记录
	 * @param searchlog
	 * @return
	 */
	public int addSearchLog(SearchlogCoal searchlog) ;
}
