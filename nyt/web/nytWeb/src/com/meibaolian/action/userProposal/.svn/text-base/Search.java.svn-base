package com.meibaolian.action.userProposal;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.UserProposalDto;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.service.userProposal.IUserProposalService;
import com.meibaolian.util.UtilHelp;

public class Search extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserProposalService userProposalService;
	private UserProposalDto userProposalDto = new UserProposalDto();
	
	public UserProposalDto getUserProposalDto() {
		return userProposalDto;
	}

	public void setUserProposalDto(UserProposalDto userProposalDto) {
		this.userProposalDto = userProposalDto;
	}

	public void setUserProposalService(IUserProposalService userProposalService) {
		this.userProposalService = userProposalService;
	}


	public String search(){
		
		userProposalDto.setKeyword( UtilHelp.trimStr(userProposalDto.getKeyword()));
		
		QueryResult<UserProposal> qr = userProposalService.searchList(userProposalDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<UserProposal>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("userProposalDto", userProposalDto);
		return SUCCESS;
		
	}
	
}
