package com.meibaolian.action.provider;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;

public class UpdateStatus extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//供应信息id
	private  int proId;
	
	IProviderService providerService;

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	
	public String invalid() throws Exception 
	{
		String messageValue="屏蔽供应信息失败！";
		String targetUrlValue="provider/search.action";
		if(proId>0)
		{
			Provider provider=providerService.getProvider(proId);
			if(provider!=null)
			{
				providerService.updateStatus(proId, 1);
				messageValue="屏蔽供应信息成功！";
			}else
			{
				messageValue="此供应信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	public String enable() throws Exception 
	{
		String messageValue="恢复供应信息失败！";
		String targetUrlValue="provider/search.action";
		if(proId>0)
		{
			Provider provider=providerService.getProvider(proId);
			if(provider!=null)
			{
				providerService.updateStatus(proId, 0);
				messageValue="恢复供应信息成功！";
			}else
			{
				messageValue="此供应信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}
	
	
	
	
	

}
