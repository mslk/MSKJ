package com.meibaolian.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.meibaolian.service.useraid.IUserAidService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 用户拨打电话统计
 * @author Administrator
 *
 */
public class PhoneCallNumber extends BaseServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IUserAidService userAidService;
	
	public void setUserAidService(IUserAidService userAidService)
	{
		this.userAidService = userAidService;
	}
	
	Logger logger =Logger.getLogger(PhoneCallNumber.class);
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String userid=UtilHelp.strNotNull(request.getParameter("userid"));
		
		String phone=UtilHelp.strNotNull(request.getParameter("phone"));
		
		
		ResultType type=ResultType.SERVERFAIL;
		
		if(!"".equals(phone) &&  UtilHelp.isMobile(phone))
		{
			int result=userAidService.addCallPhoneLog(userid, phone, 1);
			if(result!=UtilHelp.ERRORCODE)
			{   
				type=ResultType.SUCCESS;
				logger.debug("记录拨打电话号码次数失败! " +userid +" : " +phone);
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
