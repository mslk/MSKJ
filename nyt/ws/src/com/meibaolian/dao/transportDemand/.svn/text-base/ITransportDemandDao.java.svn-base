package com.meibaolian.dao.transportDemand;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.util.exception.DataManagerException;

public interface ITransportDemandDao extends IBaseDao<TransportDemand> {

	public int addTransportDemand(TransportDemand transportDemand);
	/**
	 * 按条件查询
	 * @param exclusiveId
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<TransportDemand> searchTransportDemand(
			Integer exclusiveId, String keyword, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException;
	/**
	 * 获取用户已发布
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<TransportDemand> searchTransportDemand(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	/**
	 * 获取指定信息
	 * @param id
	 * @return
	 * @throws DataManagerException
	 */
	public TransportDemand getById(int id) throws DataManagerException;
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public int delTransportDemand(int id);
	
	/**
	 * 更新数据，重新发布
	 * @param transportDemand
	 * @return
	 */
	public int updateTransportDemand(TransportDemand transportDemand);
	/**
	 * 按起止地点查询
	 * @param startid
	 * @param start
	 * @param startcityid
	 * @param startcityname
	 * @param startprvid
	 * @param startprvname
	 * @param stopid
	 * @param stop
	 * @param stopcityid
	 * @param stopcityname
	 * @param stopprvid
	 * @param stopprvname
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<TransportDemand> searchTransportDemand(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException;
}
