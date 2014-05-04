package com.meibaolian.action.user;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.service.user.IUserManagerService;
import com.meibaolian.util.UtilHelp;

/**
 * 用户登录管理
 * 
 * @author Administrator
 * 
 */
public class UserManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserManagerService userManagerService;

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	// 用户名
	private String username;

	// 密码
	private String password;

	private String pwd1;

	private String pwd2;

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	// 验证码
	private String checkNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * 系统管理员登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() {
		String code = UtilHelp.notNullStr(WebUtil.checkCode());
		String result = "login";
		if (code.equals(checkNumber)) {
			System.out.println("userManagerService:" + userManagerService);
			Usermanager userinfo = userManagerService.searchByNameAndPwd(
					username, password);
			if (userinfo != null) {
				WebUtil.saveAdmin(userinfo);
				result = "main";
			} else {
				WebUtil.setRequestValue(MESSAGE, "用户名或密码错误!");
			}
		} else {
			WebUtil.setRequestValue(MESSAGE, "验证码错误!");
		}

		return result;
	}

	/**
	 * 系统管理员登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String outLogin() {
		// 移除登录信息
		WebUtil.removeAdmin();
		
		return "login_redirect";
	}

	/**
	 * 修改管理员密码
	 * 
	 * @return
	 */
	public String updatePwd() {
		String message = "修改密码失败！";
		String targetUrl = "controller/userManager/update.jsp";

		if (!"".equals(UtilHelp.notNullStr(password))
				&& !"".equals(UtilHelp.notNullStr(pwd1))
				&& !"".equals(UtilHelp.notNullStr(pwd2)) && pwd1.equals(pwd2)) {
			Usermanager usermanager = WebUtil.getAdmin(null);
			if (usermanager != null) {
				Usermanager usermanager1 = userManagerService
						.searchByNameAndPwd(usermanager.getLoginname(),
								password);
				if (usermanager1 != null) {
					usermanager1.setPassword(pwd1);
					userManagerService.updatePwd(usermanager1);
					WebUtil.saveAdmin(usermanager1);
					message = "修改密码成功！";
				}

			}

		} else if (!pwd1.equals(pwd2)) {
			message = "修改密码失败，新密码与确定密码不一致！";
		}

		saveMessage(message, targetUrl);
		return MESSAGE;
	}

}
