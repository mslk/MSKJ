package com.meibaolian.service.transportSupply.impl;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.transportSupply.ITransportSupplyDao;
import com.meibaolian.dao.transportSupplyPush.ITransportSupplyPushDao;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.exception.DataManagerException;

public class TransportSupplyService implements ITransportSupplyService{
	
	private ITransportSupplyDao transportSupplyDao;
	private ITransportSupplyPushDao transportSupplyPushDao;
	
	public void setTransportSupplyDao(ITransportSupplyDao transportSupplyDao) {
		this.transportSupplyDao = transportSupplyDao;
	}

	public void setTransportSupplyPushDao(
			ITransportSupplyPushDao transportSupplyPushDao) {
		this.transportSupplyPushDao = transportSupplyPushDao;
	}
	
	
	
	
	@Override
	public int addTransportSupplyAndPushTask(TransportSupply transportSupply,
			int pushtype) {
		int id = transportSupplyDao.addTransportSupply(transportSupply);
		if(pushtype == 1){
			transportSupplyPushDao.updateTransportSupplyPush(transportSupply.getUserid(), 0);
			transportSupplyPushDao.addTransportSupplyPush(transportSupply, 1);
		}
		return id;
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(Integer exclusiveId, String keyword,
			int page, int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		
		return transportSupplyDao.searchTransportSupply(exclusiveId, keyword, page, pageSize, orders);
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return transportSupplyDao.searchTransportSupply(userid, page, pageSize, orders);
	}

	@Override
	public TransportSupply getById(int id) throws DataManagerException {
		
		return transportSupplyDao.getById(id);
	}

	@Override
	public int delTransportSupply(int id) {
		
		return transportSupplyDao.delTransportSupply(id);
	}

	@Override
	public int updateTransportSupply(TransportSupply transportSupply) {
		
		return transportSupplyDao.updateTransportSupply(transportSupply);
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		
		return transportSupplyDao.searchTransportSupply(startid, start,
				startcityid, startcityname, startprvid, startprvname, stopid,
				stop, stopcityid, stopcityname, stopprvid, stopprvname, page,
				pageSize, orders);
	}

}
