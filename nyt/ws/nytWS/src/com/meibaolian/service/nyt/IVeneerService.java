package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.VennerSupplyInfo;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.nyt.dto.VeneerDTo;

public interface IVeneerService 
{
 
	public int add(VennerSupplyInfo vo) throws NoParameterException;
	
	public int delete(Integer userid,Integer supplyId);
	 
	public QueryResult<VennerSupplyInfo> search(int page,int pageSize,VeneerDTo vo) throws DataManagerException;
	
	public QueryResult<VennerSupplyInfo> searchBase(int page,int pageSize,VeneerDTo vo) throws DataManagerException;
}
