package com.meibaolian.service.transportSupply;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.util.exception.DataManagerException;

public interface ITransportSupplyService {
	/**
	 * 
	 * @param transportSupply
	 * @param pushtype
	 * @return
	 */
	public int addTransportSupplyAndPushTask(TransportSupply transportSupply,
			int pushtype);
	/**
	 * 按条件查询
	 * @param exclusiveId 结果不包含此id指定数据
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<TransportSupply> searchTransportSupply(
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
	public QueryResult<TransportSupply> searchTransportSupply(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	/**
	 * 获取指定信息
	 * @param id
	 * @return
	 * @throws DataManagerException
	 */
	public TransportSupply getById(int id) throws DataManagerException;
	/**
	 * 删除数据
	 */
	public int delTransportSupply(int id);
	/**
	 * 更新数据，重新发布
	 * @param id
	 * @param validdate
	 * @return
	 */
	public int updateTransportSupply(TransportSupply transportSupply);
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
	public QueryResult<TransportSupply> searchTransportSupply(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException;
}
