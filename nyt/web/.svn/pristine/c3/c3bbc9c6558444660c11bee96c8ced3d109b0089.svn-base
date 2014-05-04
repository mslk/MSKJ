package com.meibaolian.action.provider;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;

public class Update extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProviderService providerService;
	private Provider provider;
	
	public String updateSortnumber(){
		String msg = "修改排序值失败！";
		if(provider != null && null != provider.getProid() && provider.getProid() > 0 && null != provider.getSortnumber() && provider.getSortnumber() > 0){
			providerService.updateProvider(provider.getProid(), provider.getSortnumber());
			msg = "修改排序值成功！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}
	
	

	
	

}
