package com.meibaolian.action.otheraid;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CallPhoneLog;
import com.meibaolian.service.otheraid.ICallPhoneLogService;

public class PhoneStats extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String phone;
	
	private ICallPhoneLogService callPhoneLogService;
	
	public void setCallPhoneLogService(ICallPhoneLogService callPhoneLogService) {
		this.callPhoneLogService = callPhoneLogService;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String execute() throws Exception {
		QueryResult<CallPhoneLog> result=callPhoneLogService.searchByPhone(phone, getPage(), PAGESIZE);
		if(result!=null)
		{
		savePageView(new PageView<CallPhoneLog>(result, getPage(), PAGESIZE));
		}
		return "list";
	}

	
	
	
}
