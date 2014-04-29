package com.meibaolian.service.searchlog;

import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.entity.SearchlogTransport;

public interface ISearchlogService {
	
	/**
	 * 记录煤炭查询条件
	 * 
	 * @param searchlog
	 * @return
	 */
	public int addSearchLog(SearchlogCoal searchlog);
	
	/**
	 * 记录物流查询条件
	 * 
	 * @param searchlog
	 * @return
	 */
	public int addSearchLog(SearchlogTransport searchlog);
}
