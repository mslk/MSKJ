package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.web.base.BaseServlet;
/**
 * 用户注册
 * 
 * @author Administrator
 * 
 */
public class UserRegister extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(UserRegister.class);

	IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		ResultType resultType = ResultType.SERVERFAIL;

//		String code = UtilHelp.strNotNull(request.getParameter("code"));
		
//		String phone = UtilHelp.strNotNull(request.getParameter("phone"));
		
		// 用户类型(0-供应商，1-采购商，2-中间商，3-物流)
//		int type = UtilHelp.strToInt(request.getParameter("type"));
		
//		String loginName = UtilHelp.strNotNull(request.getParameter("loginname"));
//		String pwd = UtilHelp.strNotNull(request.getParameter("pwd"));
//		String realName = UtilHelp.strNotNull(request.getParameter("realname"));
//		String companyName = UtilHelp.strNotNull(request
//				.getParameter("companyname"));
//		String address = UtilHelp.strNotNull(request.getParameter("address"));
//		UserInfo userinfo=null;
//		String token="";
//		if (
//				!"".equals(loginName)
//				&& loginName.length() >= 6
//				&& loginName.length() <= 15
//				&& UtilHelp.validateNumAndChart(loginName)
//				&& !"".equals(realName)
//				&& realName.length() <= 50
//				&& ("".equals(address) || address.length() <= 100)
//				&& ("".equals(companyName) ||  companyName.length() <= 100)
//				!"".equals(phone)
//				&& phone.length() == 11
//				&& UtilHelp.isMobile(phone)
//				&& !"".equals(pwd)
//				&& pwd.length() == 6
//				&& UtilHelp.validateNumAndChart(pwd)
//				&& type >= 0
//				&& type <= 3
//				&& code.length() == 4
//				) {

//			String redisCode = DataToRedis.getPhoneCheck(phone);
//			logger.debug("phone :" + phone + "code:" + code + " redisCode:"
//					+ redisCode);
//
//			if (redisCode.equals(code)) {
//
//				UserInfo userInfo = new UserInfo();
//				userInfo.setLoginname("");
//				userInfo.setPassword(code);
//				userInfo.setPhone(phone);
//				userInfo.setRealname("");
//				userInfo.setCompanyname("");
//				userInfo.setType(type);
//				userInfo.setAddress("");
//				try {
//					int result = userService.addUserInfo(userInfo);
					
//					if (result == 1) {
//						userinfo = userService.searchUser(phone, code);
//						token=UtilHelp.createValidateCode();
//						resultType = ResultType.SUCCESS;
//					} else if (result == 2) {
//						resultType = ResultType.USERHAVE;
//					} else if (result == 3) {
//						resultType = ResultType.PHONEHAVE;
//					}

//				} catch (NoParameterException e) {
//					logger.error(e);
//				} catch (DataManagerException e) {
//					logger.error(e);
//				}
//			} else {

//				resultType = ResultType.CODEERROR;
//			}

//		} else {
//			resultType = ResultType.PARAMTER;
//		}
//		logger.debug("loginname:" +loginName +" phone:"+ phone+" 结果:" +resultType.toString());
//		WebUtil.outputMsgObjJson(response, resultType, token,userinfo);
//		WebUtil.outputMsgJson(response, resultType);

	}

}
