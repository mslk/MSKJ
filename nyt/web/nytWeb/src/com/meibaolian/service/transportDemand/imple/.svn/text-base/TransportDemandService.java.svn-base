package com.meibaolian.service.transportDemand.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.transportDemand.ITransportDemandDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.transportDemand.ITransportDemandService;

public class TransportDemandService implements ITransportDemandService{

	private ITransportDemandDao transportDemandDao;
	private IUserInfoDao userInfoDao;
	
	public void setTransportDemandDao(ITransportDemandDao transportDemandDao) {
		this.transportDemandDao = transportDemandDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public TransportDemand getTransportDemand(int id) {
		TransportDemand transportDemand = null;
		UserInfo userInfo = null;
		transportDemand = transportDemandDao.get(id);
		if(null != transportDemand){
			userInfo = userInfoDao.get(transportDemand.getUserid());
			if(null != userInfo){
				transportDemand.setUsername(userInfo.getRealname());
				transportDemand.setPhone(userInfo.getPhone());
			}
		}
		return transportDemand;
	}

	@Override
	public QueryResult<TransportDemand> searchList(
			TransportDemandDto transportDemandDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return transportDemandDao.searchList(transportDemandDto, page, pageSize, orders);
	}

	@Override
	public void deleteById(int id) {
		transportDemandDao.delete(id);
	}

	@Override
	public int updateStatus(int id, int status) {
		int count = -1;
		TransportDemand transportDemand = transportDemandDao.get(id);
		if(null != transportDemand){
			transportDemand.setValidstatus(status);//屏蔽状态（0 正常，1 屏蔽）
			count=1;
		}
		return count;
	}

	@Override
	public int updateSortNum(Integer id, Integer sortnumber) {
		int count = -1;
		TransportDemand transportDemand = transportDemandDao.get(id);
		if(null != transportDemand){
			transportDemand.setSortnumber(sortnumber);
			count=1;
		}
		return count;
	}

}
