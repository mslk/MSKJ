package com.meibaolian.action.coaltype;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CoalType;
import com.meibaolian.service.coaltype.ICoalTypeService;

public class CoalSeach  extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	ICoalTypeService coalTypeService ;
	
	public void setCoalTypeService(ICoalTypeService coalTypeService) {
		this.coalTypeService = coalTypeService;
	}
  
	


	@Override
	public String execute() throws Exception {
		
		
		QueryResult<CoalType> result=coalTypeService.search(getPage(),PAGESIZE);

		savePageView(new PageView<CoalType>(result, getPage(), PAGESIZE));
		
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	
}
