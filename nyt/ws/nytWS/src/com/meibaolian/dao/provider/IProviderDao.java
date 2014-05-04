package com.meibaolian.dao.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Provider;
import com.meibaolian.util.exception.DataManagerException;

public interface IProviderDao extends IBaseDao<Provider> {

	/**
	 * 发布出售单信息
	 * 
	 * @param provider
	 * @return
	 */
	public int addProvider(Provider provider);

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
	 * 更新煤质指标
	 * @param provider
	 * @return
	 */
	public int updateProvider(Provider provider);
}
