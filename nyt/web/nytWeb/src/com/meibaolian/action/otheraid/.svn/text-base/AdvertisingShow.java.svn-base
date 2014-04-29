package com.meibaolian.action.otheraid;

import java.util.List;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Advertising;
import com.meibaolian.service.otheraid.IAdvertisingService;

public class AdvertisingShow extends BaseAction 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IAdvertisingService advertisingService;
	
	public void setAdvertisingService(IAdvertisingService advertisingService) {
		this.advertisingService = advertisingService;
	}



	@Override
	public String execute() throws Exception {
		List<Advertising> list=advertisingService.searchAll();
		saveList(list);
		return "list";
	}
	
	
	

}
