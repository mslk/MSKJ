package com.meibaolian.service.userProposal.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.userProposal.IUserProposalDao;
import com.meibaolian.dto.UserProposalDto;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.service.userProposal.IUserProposalService;

public class UserProposalService implements IUserProposalService {
	
	private IUserProposalDao userProposalDao;
	
	public void setUserProposalDao(IUserProposalDao userProposalDao) {
		this.userProposalDao = userProposalDao;
	}

	@Override
	public QueryResult<UserProposal> searchList(
			UserProposalDto userProposalDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return userProposalDao.searchList(userProposalDto, page, pageSize, orders);
	}

	@Override
	public int updateStatus(int id, int status) {
		int count = -1;
		UserProposal userProposal = userProposalDao.get(id);
		if(null != userProposal){
			userProposal.setStatus(status);
			count = 1;
		}
		return count;
	}

	@Override
	public UserProposal getUserProposal(int id) {
		
		return userProposalDao.get(id);
	}

}
