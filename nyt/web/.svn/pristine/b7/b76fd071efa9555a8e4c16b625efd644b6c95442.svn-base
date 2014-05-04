package com.meibaolian.service.provider.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.provider.IProviderDao;
import com.meibaolian.dao.provider.IProviderInfoDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.provider.IProviderService;

public class ProviderService implements IProviderService {
	
	private IProviderInfoDao providerInfoDao;
	private IProviderDao providerDao;
	private IUserInfoDao userInfoDao;
	
	
	@Override
	public QueryResult<Provider> searchList(ProviderDto providerDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		
//		return providerInfoDao.searchList(providerDto, page, pageSize, orders);
		return providerDao.searchList(providerDto, page, pageSize, orders);
	}

	@Override
	public Provider getProvider(Integer id) {
		
		Provider provider = null;
		UserInfo userInfo = null;
//		ProviderInfo providerInfo = null;
		
		provider = providerDao.get(id);
		if(null != provider){
			userInfo = userInfoDao.get(provider.getUserid());
			if(null != userInfo){
//				providerInfo = new ProviderInfo(provider, userInfo);
				provider.setBuyername(userInfo.getRealname());
				provider.setCompany(userInfo.getCompanyname());
				provider.setPhone(userInfo.getPhone());
			}else{
				provider = null;
			}
		}
//		return providerInfo;
		return provider;
	}

	@Override
	public int updateProvider(Integer id, Integer sortnumber) {
		int count = -1;
		Provider provider = providerDao.get(id);
		if(null != provider){
			provider.setSortnumber(sortnumber);
			count=1;
		}
		return count;
	}

	@Override
	public int updateStatus(int id, int status) {
		int count = -1;
		Provider provider = providerDao.get(id);
		if(null != provider){
			provider.setValidstatus(status);//屏蔽状态（0 正常，1 屏蔽）
			count=1;
		}
		return count;
	}

	public void setProviderInfoDao(IProviderInfoDao providerInfoDao) {
		this.providerInfoDao = providerInfoDao;
	}

	public void setProviderDao(IProviderDao providerDao) {
		this.providerDao = providerDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void deleteProviderById(int id) {
		 providerDao.delete(id);
	}


	

}
