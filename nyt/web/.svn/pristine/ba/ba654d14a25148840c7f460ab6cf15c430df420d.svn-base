package com.meibaolian.action.sortOrder;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;

public class ShowProvider extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProviderService providerService;
	
	private Integer id;
	
	public String show(){
		if(id != null){
			Provider provider = providerService.getProvider(id);
			if(provider != null){
				WebUtil.setRequestValue("provider", provider);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	


	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
