package com.meibaolian.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.redis.DataToRedis;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class UserUpdatePwd extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	Logger logger = Logger.getLogger(UserUpdatePwd.class);
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		int userid = UtilHelp.strToInt(UtilHelp.strNotNull(request
//				.getParameter("userid")));

		// 1 通过原始密码修改 2 通过动态验证码 设置密码
		int type = UtilHelp.strToInt(UtilHelp.strNotNull(request
				.getParameter("type")));

		String phone = UtilHelp.strNotNull(request.getParameter("phone"));

		String pwd1 = UtilHelp.strNotNull(request.getParameter("pwd1")).toLowerCase();

		String pwd2 = UtilHelp.strNotNull(request.getParameter("pwd2")).toLowerCase();

		ResultType resultType = ResultType.SERVERFAIL;

		if (!"".equals(phone) && phone.length() == 11
				&& UtilHelp.isMobile(phone) && !"".equals(pwd1)
				&& pwd1.length() >= 4 && pwd1.length() <= 16
				&& !"".equals(pwd2) && pwd2.length() >= 4
				&& pwd2.length() <= 16 && pwd1.equalsIgnoreCase(pwd2)) {
			try {
				if (type == 1) {

					String oldPwd = UtilHelp.strNotNull(request
							.getParameter("oldpwd")).toLowerCase();
					UserInfo userinfo = userService.searchUser(phone, oldPwd);
					// 如果密码相同,则修改
					if (userinfo != null) {

						int result = userService.updateUserPwd(phone, oldPwd, pwd1);
						
						if (result == 1) {
							resultType = ResultType.SUCCESS;
						}
						logger.debug("phone:" + phone+"修改密码:"+result);

					} else {
						resultType = ResultType.USERERROR;
					}
				} else if (type == 2) 
				{
					String code = UtilHelp.strNotNull(request.getParameter("code"));
					
					String redisCode = DataToRedis.getPhoneCheck(phone,2);
					
					logger.debug("phone :" + phone + "code:" + code
							+ " redisCode:" + redisCode);
					
					if (!"".equals(code)&& code.length() == 4 && redisCode.equals(code)) 
					{
						int result=userService.updateUserPwd(phone, pwd1);
						if(result==1){
							resultType=ResultType.SUCCESS;
						}
						
						logger.debug("phone:" + phone+"修改密码:"+result);
					}else
					{
						resultType=ResultType.CODEERROR;
					}

					

				} else {
					resultType = ResultType.PARAMTER;
				}

			} catch (DataManagerException e) {
				logger.error(e);
			}

		} else {
			resultType = ResultType.PARAMTER;
		}
		WebUtil.outputMsgJson(response, resultType);
	}

}
