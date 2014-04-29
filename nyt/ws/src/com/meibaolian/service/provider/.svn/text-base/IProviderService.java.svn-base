package com.meibaolian.service.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.exception.DataManagerException;

public interface IProviderService {

	/**
	 * 根据id 查询供应信息详情
	 * 
	 * @param id
	 * @return
	 * @throws DataManagerException
	 */
	public ProviderJson getById(int id) throws DataManagerException;

	/**
	 * 发布出售单信息，添加到推送任务
	 * 
	 * @param provider
	 * @param pushtype
	 *            0 不推送,1 推送
	 * @return
	 */
	public int addProviderAndPushTask(Provider provider, SearchlogCoal searchlog,
			int pushtype) throws DataManagerException;

	/**
	 * 用户查询自己已发布出售单
	 * 
	 * @param userid
	 *            userid 用户id
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<Provider> searchProviders(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;

	/**
	 * 按条件查询出售单
	 * 
	 * @return
	 */
	public QueryResult<ProviderJson> searchProviders(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;

	/**
	 * 按条件查询出售单,带运价
	 * 
	 * @return
	 */
	public QueryResult<ProviderJson> searchProvidersWithRate(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	
	/**
	 * 直接删除数据
	 * 
	 * @param proid
	 * @return
	 */
	public int delProvider(int proid);

	/**
	 * 更新有效期
	 * 
	 * @param proid
	 * @param validdate
	 * @return
	 */
	public int updateProviderValiddate(int proid, String validdate);
	/**
	 * 关键字查询
	 * @param keyword 关键字
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<ProviderJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	/**
	 * 更新煤质指标
	 * @param provider
	 * @return
	 */
	public int updateProvider(Provider provider);
}
