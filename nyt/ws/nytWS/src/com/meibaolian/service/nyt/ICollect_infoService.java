package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface ICollect_infoService {
	/**
	 * 添加 
	 * @param customer
	 * @return
	 */
	public int add(Collect_infoEntity vo);

	/**
	 * 获取自己的收藏 根据用户id,类型(1供应,2求购) 信息类型(1桉木, 2胶合板,3原木,4淀粉)
	 * @param userid
	 * @param customertype
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<Collect_infoEntity> getCollect_infoBean(Collect_infoEntity vo, int page, int pageSize)
			throws DataManagerException;
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */ 
	public int del(int id);
	
	/**
	 * 是否已存在此数据
	 * @param Collect_infoEntity
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExist(Collect_infoEntity vo) throws DataManagerException;
}
