package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.HttpSendMsg;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.redis.DataToRedis;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 手机登陆,发送验证码，保存手机号与验证码到redis
 * 
 * @author liaolm
 * 
 */
public class PhoneCheckCode extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(PhoneCheckCode.class);

	IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("phone");

		logger.debug("手机客户端登陆(" + phone + ") 发送验证码....");

		ResultType resultType = ResultType.SERVERFAIL;

		String result = "发送验证码失败!";

		// 验证码使用 1 用户注册登录 2 用户修改密码使用
		int codeType = UtilHelp.strToInt(request.getParameter("codetype"));

		if (codeType == 0) {
			codeType = 1;
		}

		String checkCode = "";

		if (!UtilHelp.isNotNullStr(phone) || !UtilHelp.isMobile(phone)) {
			resultType = ResultType.PARAMTER;

		} else {
			// if (ConfigUtil.SERVICEMODE == 1) {// 测试环境
			// checkCode = "8888";
			// request.get
			// DataToRedis.savePhoneCheck(phone, checkCode);
			// resultType = ResultType.SUCCESS;
			// } else {// 正式环境

			checkCode = UtilHelp.createCheckCode();
			String title = "本次登录煤宝联的验证码为";

			if (codeType == 2) {
				title = "本次煤宝联修改密码的验证码为";
			}
			if (codeType == 1 || codeType == 2) {

				boolean isF = false;
				
				try {
					UserInfo userinfo = userService.searchUser(phone);
					if (codeType == 1) {
						if (userinfo == null
								|| "".equals(UtilHelp.strNotNull(userinfo
										.getPassword()))) {
							isF = true;
						} else {
							resultType = ResultType.USEREHAVEPWD;
						}

					} else if (codeType == 2)
					{
						if(userinfo!=null)
						{
						isF = true;
						}else
						{
							resultType = ResultType.NODATA;
						}
					}

				} catch (DataManagerException e) {
					logger.error("获取验证码!" + e);
				}

				if (isF && HttpSendMsg.sendMSMcode(phone, title + checkCode)) {
					result = "验证码发送成功! ";
					logger.debug(" phone: " + phone + " code:" + checkCode);
					DataToRedis.savePhoneCheck(phone, checkCode, codeType);
					resultType = ResultType.SUCCESS;
				}

			} else {
				resultType = ResultType.PARAMTER;
			}
			// }
		}
		logger.debug("phone:" + phone + " chekcode:" + checkCode + "  result:"
				+ result);
		WebUtil.outputMsgJson(response, resultType);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
