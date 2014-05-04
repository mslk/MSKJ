package com.meibaolian.service.otheraid.imple;

import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.otheraid.IAdvertisingDao;
import com.meibaolian.entity.Advertising;
import com.meibaolian.service.otheraid.IAdvertisingService;

public class AdvertisingService implements IAdvertisingService {

	IAdvertisingDao advertisingDao;

	public void setAdvertisingDao(IAdvertisingDao advertisingDao) {
		this.advertisingDao = advertisingDao;
	}

	
	public void updateAdvertising(Advertising advertising)
	{
		advertisingDao.update(advertising);
	}
	
	@Override
	public List<Advertising> searchAll() {

		QueryResult<Advertising> result = advertisingDao.search(-1, -1);
		List<Advertising> list = null;
		if (result != null) {
			list = result.getQueryList();
			result = null;
		}
		return list;

	}

	@Override
	public Advertising getById(int id) {
		return advertisingDao.get(id);
	}

	

	@Override
	public void addDefaultAdvertising()
	{
		List<Advertising> list=searchAll();
		int iosCount=0;
		int androidCount=0;
		for(Advertising advertising:list)
		{
		     if(advertising.getType()==1)
		     {
		    	 iosCount++;
		     }
		     else if(advertising.getType()==2)
		     {
		    	 androidCount++;
		     }
		}

		Advertising advertising=null;
		if(iosCount==0)
		{  
			advertising=new Advertising("","http://www.ylctc.cn/");
			advertising.setAddtime(new Date());
			advertising.setType(1);
			advertisingDao.add(advertising);
		}
		
		if(androidCount==0)
		{
			advertising=new Advertising("","http://www.ylctc.cn/");
			advertising.setAddtime(new Date());
			advertising.setType(2);
			advertisingDao.add(advertising);
		}
		
		advertisingDao.deleteSurplusAdvertising();
		
	}

}
