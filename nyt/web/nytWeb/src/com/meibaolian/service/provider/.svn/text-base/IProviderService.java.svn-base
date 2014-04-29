package com.meibaolian.service.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;

public interface IProviderService {
	
	public QueryResult<Provider> searchList(ProviderDto userInfoDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	
	public Provider getProvider(Integer id);
	 
	public int updateProvider(Integer id, Integer sortnumber);
	
	public void deleteProviderById(int id);
	/**
	 * 屏蔽、恢复信息
	 * @param id
	 * @param status 屏蔽状态（0 正常，1 屏蔽）
	 */
	public int updateStatus(int id, int status);
}
