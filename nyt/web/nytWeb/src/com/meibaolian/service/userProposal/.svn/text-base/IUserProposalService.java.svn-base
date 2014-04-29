package com.meibaolian.service.userProposal;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.UserProposalDto;
import com.meibaolian.entity.UserProposal;

public interface IUserProposalService {

	public QueryResult<UserProposal> searchList(UserProposalDto userProposalDto, int page,
			int pageSize, LinkedHashMap<String, String> orders);
	
	/**
	 * 
	 * @param id
	 * @param status 处理状态 0 未处理 1 已处理
	 */
	public int updateStatus(int id, int status);
	
	public UserProposal getUserProposal(int id);
}
