package com.meibaolian.web.other;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meibaolian.entity.UserProposal;
import com.meibaolian.service.other.IUserProposalService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 用户留言
 * @author Administrator
 *
 */
public class UserProposalServlet extends BaseServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserProposalService userProposalService;
	
	public void setUserProposalService(IUserProposalService userProposalService) {
		this.userProposalService = userProposalService;
	}






	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ResultType result=ResultType.SERVERFAIL;
		
		int userId=UtilHelp.strToInt(request.getParameter("userid"));
		
		String content=UtilHelp.strNotNull(request.getParameter("content"));
		
		
		if(userId>0 && content.length()>0 && content.length()<=200)
		{
			if(userProposalService.addProposal(new UserProposal(userId,content))>0)
			{
				result=ResultType.SUCCESS;
			}
		}else{
			result=ResultType.PARAMTER;
		}
		WebUtil.outputMsgJson(response, result);
	}

	
	
	
	
}
