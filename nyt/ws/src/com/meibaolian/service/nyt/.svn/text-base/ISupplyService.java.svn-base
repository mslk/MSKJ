package com.meibaolian.service.nyt;

import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.entity.SupplyInfoExpand;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.nyt.dto.SupplyDTo;

public interface ISupplyService 
{


	
	public int add(SupplyInfo supplyInfo) throws NoParameterException;
	
	public int delete(Integer userid,Integer supplyId);
	
	public int update(SupplyInfo supplyInfo);
	
	
	public QueryResult<SupplyInfoExpand> search(int page,int pageSize,SupplyDTo dto) throws DataManagerException;
	
	public QueryResult<SupplyInfo> search(int page,int pageSize,int userid,int type) throws DataManagerException;
	
//	/**
//	 * 根据id查询
//	 * @param id
//	 * @return
//	 * @throws DataManagerException
//	 */
//	public SupplyInfo getById(int id) throws DataManagerException;
	/**
	 * 根据记录id查询
	 * @param ids 集合数组
	 * @return
	 * @throws DataManagerException
	 */
	public List<SupplyInfo> searchByIds(int[] ids) throws DataManagerException;

}
