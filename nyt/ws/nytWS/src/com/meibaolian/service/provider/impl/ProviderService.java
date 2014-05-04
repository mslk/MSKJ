package com.meibaolian.service.provider.impl;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.provider.IProviderDao;
import com.meibaolian.dao.provider.IProviderJsonDao;
import com.meibaolian.dao.providerpush.IProviderpushDao;
import com.meibaolian.dao.user.IUserDao;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.exception.DataManagerException;

public class ProviderService  implements IProviderService{

	
	private IProviderJsonDao providerJsonDao;
	private IProviderDao providerDao;
	private IProviderpushDao providerpushDao;
	private IUserDao userDao;
	
	public void setProviderJsonDao(IProviderJsonDao providerJsonDao) {
		this.providerJsonDao = providerJsonDao;
	}

	public void setProviderDao(IProviderDao providerDao) {
		this.providerDao = providerDao;
	}

	public void setProviderpushDao(IProviderpushDao providerpushDao) {
		this.providerpushDao = providerpushDao;
	}

	@Override
	public ProviderJson getById(int id) throws DataManagerException {
		return providerJsonDao.getById(id);
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int addProviderAndPushTask(Provider provider, SearchlogCoal searchlog, int pushtype) throws DataManagerException {
		int id = 0;
//		UserInfo user = userDao.getById(provider.getUserid());
//		if(user != null){
//			provider.setBuyername(user.getCompnayname());
			id = providerDao.addProvider(provider);
			if(pushtype == 1){
				providerpushDao.updateProviderpush(provider.getUserid(), 0);
				providerpushDao.addProviderpush(searchlog, 1);
			}
//		}
		return id;
	}

	@Override
	public QueryResult<Provider> searchProviders(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		
		return providerDao.searchProviders(userid, page, pageSize, orders);
	}

	@Override
	public QueryResult<ProviderJson> searchProvidersWithRate(
			SearchlogCoal searchlog, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		return providerJsonDao.searchProvidersWithRate(searchlog, page, pageSize,
				orders);
	}

	@Override
	public QueryResult<ProviderJson> searchProviders(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		return providerJsonDao.searchProviders(searchlog, page, pageSize,
				orders);
	}

	@Override
	public int delProvider(int proid) {
		
		return providerDao.delProvider(proid);
	}

	@Override
	public int updateProviderValiddate(int proid, String validdate) {
		
		return providerDao.updateProviderValiddate(proid, validdate);
	}

	@Override
	public QueryResult<ProviderJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return providerJsonDao.searchByKey(keyword, page, pageSize, orders);
	}

	@Override
	public int updateProvider(Provider provider) {
		
		return providerDao.updateProvider(provider);
	}
	
}
