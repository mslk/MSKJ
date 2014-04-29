package com.meibaolian.service.transportDemand.impl;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.transportDemand.ITransportDemandDao;
import com.meibaolian.dao.transportDemandPush.ITransportDemandPushDao;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.util.exception.DataManagerException;

public class TransportDemandService implements ITransportDemandService{
	
	private ITransportDemandDao transportDemandDao;
	private ITransportDemandPushDao transportDemandPushDao;
	
	public void setTransportDemandDao(ITransportDemandDao transportDemandDao) {
		this.transportDemandDao = transportDemandDao;
	}

	public void setTransportDemandPushDao(
			ITransportDemandPushDao transportDemandPushDao) {
		this.transportDemandPushDao = transportDemandPushDao;
	}
	

	@Override
	public int addTransportDemandAndPushTask(TransportDemand transportDemand,
			int pushtype) {
		int id = transportDemandDao.addTransportDemand(transportDemand);
		if(pushtype == 1){
			transportDemandPushDao.updateTransportDemandPush(transportDemand.getUserid(), 0);
			transportDemandPushDao.addTransportDemandPush(transportDemand, 1);
		}
		return id;
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(Integer exclusiveId, String keyword,
			int page, int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		
		return transportDemandDao.searchTransportDemand(exclusiveId, keyword, page, pageSize, orders);
	}
	
	@Override
	public TransportDemand getById(int id) throws DataManagerException {
		
		return transportDemandDao.getById(id);
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return transportDemandDao.searchTransportDemand(userid, page, pageSize, orders);
	}

	@Override
	public int delTransportDemand(int id) {
		
		return transportDemandDao.delTransportDemand(id);
	}

	@Override
	public int updateTransportDemand(TransportDemand transportDemand) {
		
		return transportDemandDao.updateTransportDemand(transportDemand);
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		
		return transportDemandDao.searchTransportDemand(startid, start, startcityid, startcityname, startprvid, startprvname, stopid, stop, stopcityid, stopcityname, stopprvid, stopprvname, page, pageSize, orders);
	}
	
}
