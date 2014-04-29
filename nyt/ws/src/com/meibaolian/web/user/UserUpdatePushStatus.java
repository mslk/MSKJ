package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 用户修改推送状态
 * @author Administrator
 *
 */
public class UserUpdatePushStatus extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int userid=UtilHelp.strToInt(request.getParameter("userid"));
		
		int status=UtilHelp.strToInt(request.getParameter("status"));
		
		ResultType type=ResultType.SERVERFAIL;
		
		if(userid>0 && (status==1 || status==2) )
		{
	   		int result=userService.updatePushStatus(userid, status-1);
	   		if(result==1)
	   		{
	   			type=ResultType.SUCCESS;
	   		}
		}else
		{
     		 type=ResultType.PARAMTER;	
		}
		
		
		WebUtil.outputMsgJson(response, type);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	
	

	
	
}
