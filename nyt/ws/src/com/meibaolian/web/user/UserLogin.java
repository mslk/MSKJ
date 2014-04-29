package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.log.ILogService;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.util.redis.DataToRedis;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 用户登录
 * 
 * @author Administrator
 * 
 */
public class UserLogin extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService userService;
	
	ILogService logService;

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	Logger logger = Logger.getLogger(UserLogin.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ResultType resultType = ResultType.SERVERFAIL;
		UserInfo userinfo = null;
		String token = "";

		String phone = UtilHelp.strNotNull(request.getParameter("phone"));

		String code = UtilHelp.strNotNull(request.getParameter("code"));

		String pwd = UtilHelp.strNotNull(request.getParameter("pwd")).toLowerCase();
		//在验证码与密码都填写的情况下,只验证码验证
		int parameter = 0;
			if (!"".equals(phone) && phone.length() == 11
					&& UtilHelp.isMobile(phone)) {

				try {
					int result = userService.addUserInfo(phone);
					UserInfo user =null;
					
					if (result != 0) {
						
						user = userService.searchUser(phone);
						if(!"".equals(code)){
							parameter = 1;
						}
						//如果此用户设置过密码,则不能通过动态验证码登录
						if(user!=null && null!=user.getPassword() && !"".equals(user.getPassword()) && parameter==1)
						{
							resultType=ResultType.USEREHAVEPWD;
						}else{
							
							
							
							  //用户以验证码登录包含注册功能
							if (parameter==1
									&& code.length() == 4) {
								String redisCode = DataToRedis.getPhoneCheck(phone,1);
								logger.debug("phone :" + phone + "code:" + code
										+ " redisCode:" + redisCode);

								if (redisCode.equals(code)) {
									userinfo=user;
								} else {
									resultType = ResultType.CODEERROR;
								}
							 
							//用户以密码登录
							}else if (parameter == 0 && !"".equals(pwd) && pwd.length() >= 4 && pwd.length() <= 16) {
								//状态:0 正常    2 禁用 
								if ( user!= null && pwd.equalsIgnoreCase(user.getPassword())) {
									userinfo = user;
								} else {
									resultType = ResultType.USERERROR;
								}
							} 
							else {
								resultType = ResultType.PARAMTER;
							}
							
							
						}
					}

				} catch (NoParameterException e) {
				   logger.error(e);
				} catch (DataManagerException e) {
				   logger.error(e);
				}
				
				
				
				

			} else {
				resultType = ResultType.PARAMTER;
			}
		
		if(userinfo!=null)
		{
			userinfo.setPassword("");
			resultType = ResultType.SUCCESS;
			token = UtilHelp.createValidateCode();
			DataToRedis.saveUserToken(userinfo.getId()+"", token);
			DataToRedis.saveUserInfo(userinfo.getId()+"", userinfo);
			logService.addLoginLog(userinfo.getId(),phone,parameter,0); 
		}else
		{
			logService.addLoginLog(0,phone,parameter,1); 
		}

		WebUtil.outputMsgObjJson(response, resultType, token, userinfo);
	}

}
