package com.meibaolian.action.userProposal;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.service.userProposal.IUserProposalService;

public class UpdateStatus extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id
	private  int id;
	private IUserProposalService userProposalService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserProposalService(IUserProposalService userProposalService) {
		this.userProposalService = userProposalService;
	}

	public String process() throws Exception 
	{
		String messageValue="留言信息标记为已处理失败！";
		String targetUrlValue="userProposal/search.action";
		if(id>0)
		{
			UserProposal userProposal = userProposalService.getUserProposal(id);
			if(userProposal!=null)
			{
				userProposalService.updateStatus(id, 1);
				messageValue="留言信息标记为已处理成功！";
			}else
			{
				messageValue="此留言信息不存在！";
			}
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	}

}
