package com.meibaolian.service.searchlog.imlp;

import com.meibaolian.dao.searchlog.ISearchlogDao;
import com.meibaolian.dao.searchlog.ISearchlogTransportDao;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.entity.SearchlogTransport;
import com.meibaolian.service.searchlog.ISearchlogService;


public class SearchlogService implements ISearchlogService{
	
	private ISearchlogDao searchlogDao;
	private ISearchlogTransportDao searchlogTransportDao;
	
	public void setSearchlogDao(ISearchlogDao searchlogDao) {
		this.searchlogDao = searchlogDao;
	}

	public void setSearchlogTransportDao(
			ISearchlogTransportDao searchlogTransportDao) {
		this.searchlogTransportDao = searchlogTransportDao;
	}

	@Override
	public int addSearchLog(SearchlogCoal searchlog) {
		return searchlogDao.addSearchLog(searchlog);
	}
	
	@Override
	public int addSearchLog(SearchlogTransport searchlog) {
		
		return searchlogTransportDao.addSearchLog(searchlog);
	}
}
