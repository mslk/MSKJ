package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class UserPerfectInfo extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ResultType resultType = ResultType.SERVERFAIL;

		int userid = UtilHelp.strToInt(UtilHelp.strNotNull(request
				.getParameter("userid")));

		// 用户类型 100 游客 , 1 完善信息的会员
		int type = 1;// UtilHelp.strToIntNoZero(UtilHelp.strNotNull(request.getParameter("type")));

		String realName = UtilHelp.strNotNull(request.getParameter("realname"));

		String pwd1 = UtilHelp.strNotNull(request.getParameter("pwd1"))
				.toLowerCase();

		String pwd2 = UtilHelp.strNotNull(request.getParameter("pwd2"))
				.toLowerCase();

		String company = UtilHelp.strNotNull(request.getParameter("company"));
		String address = UtilHelp.strNotNull(request.getParameter("address"));

		// String
		// place_receipt=UtilHelp.strNotNull(request.getParameter("place_receipt"));
		String telephone = UtilHelp.strNotNull(request
				.getParameter("telephone"));
		String province = UtilHelp.strNotNull(request.getParameter("province"));
		String city = UtilHelp.strNotNull(request.getParameter("city"));
		String county = UtilHelp.strNotNull(request.getParameter("county"));

		// 可以为空
		String park = UtilHelp.strNotNull(request.getParameter("park"));
		String fax = UtilHelp.strNotNull(request.getParameter("fax"));
		String qq = UtilHelp.strNotNull(request.getParameter("qq"));
		String logo = UtilHelp.strNotNull(request.getParameter("logo"));

		if (userid > 0 && !"".equals(realName) && realName.length() <= 50
				&& !"".equals(pwd1) && pwd1.length() >= 4
				&& pwd1.length() <= 16 && !"".equals(pwd2)
				&& pwd2.length() >= 4 && pwd2.length() <= 16
				&& pwd1.equals(pwd2) && !"".equals(company)
				&& company.length() <= 100 && !"".equals(address)
				&& address.length() <= 100 && !"".equals(telephone)
				&& telephone.length() <= 20 && !"".equals(province)
				&& province.length() <= 20 && !"".equals(city)
				&& city.length() <= 20 && !"".equals(county)
				&& county.length() <= 20) {

			UserInfo userInfo = new UserInfo();
			userInfo.setId(userid);
			userInfo.setPassword(pwd1);
			userInfo.setRealname(realName);
			userInfo.setType(type);
			userInfo.setCompanyname(company);
			userInfo.setAddress(address);
			userInfo.setPlace_receipt(province + city + county);
			userInfo.setTelephone(telephone);
			userInfo.setProvince(province);
			userInfo.setCity(city);
			userInfo.setCounty(county);

			if (!"".equals(park) && park.length() <= 20) {
				userInfo.setPark(park);
			}

			if (!"".equals(fax) && fax.length() <= 20) {
				userInfo.setFax(fax);
			}

			if (!"".equals(qq) && qq.length() <= 20) {
				userInfo.setQq(qq);
			}

			if (!"".equals(logo)) {
				userInfo.setLogo(logo);
			}

			int result = userService.updateUserContacts(userInfo,1);

			if (result == 1) {
				resultType = ResultType.SUCCESS;
				WebUtil.saveUserEntity(userid + "", userInfo);
			}

		} else {
			resultType = ResultType.PARAMTER;
		}
		WebUtil.outputMsgObjJson(response, resultType, null);
	}

}
