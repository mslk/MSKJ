package com.meibaolian.service.other.imple;

import com.meibaolian.dao.other.IUserProposalDao;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.service.other.IUserProposalService;

public class UserProposalService implements IUserProposalService {

	
	IUserProposalDao userProposalDao;
	
	public void setUserProposalDao(IUserProposalDao userProposalDao) {
		this.userProposalDao = userProposalDao;
	}

	@Override
	public int addProposal(UserProposal proposal) 
	{
		return userProposalDao.addProposal(proposal);
	}

}
