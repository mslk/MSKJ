package com.meibaolian.action.otheraid;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.HelpCenter;
import com.meibaolian.service.otheraid.IHelpCenterService;

public class HelpCenterShow extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IHelpCenterService helpCenterService;
	
	public void setHelpCenterService(IHelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	private int type=-1;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String execute() throws Exception 
	{
		QueryResult<HelpCenter> result=helpCenterService.searchByType(getPage(), PAGESIZE, type);
		savePageView(new PageView<HelpCenter>(result, getPage(), PAGESIZE));
		return "list";
	}
	
	
	

}
