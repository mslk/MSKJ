package com.meibaolian.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 修改用户信息
 * @author Administrator
 *
 */
public class UserUpdateContects extends BaseServlet 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	Logger logger=Logger.getLogger(UserUpdateContects.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ResultType resultType = ResultType.SERVERFAIL;

		int userid = UtilHelp.strToInt(UtilHelp.strNotNull(request
				.getParameter("userid")));

		// 用户类型 100 游客 , 1 完善信息的会员
		int type = 1;// UtilHelp.strToIntNoZero(UtilHelp.strNotNull(request.getParameter("type")));

		String realName = UtilHelp.strNotNull(request.getParameter("realname"));

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
				 && !"".equals(company)&& company.length() <= 100
				 && !"".equals(address)
				&& address.length() <= 100 && !"".equals(telephone)
				&& telephone.length() <= 20 && !"".equals(province)
				&& province.length() <= 20 && !"".equals(city)
				&& city.length() <= 20 && !"".equals(county)
				&& county.length() <= 20) {

			UserInfo userInfo = new UserInfo();
			userInfo.setId(userid);
			userInfo.setRealname(realName);
			userInfo.setType(type);
			userInfo.setCompanyname(company);
			userInfo.setAddress(address);
			userInfo.setPlace_receipt(province + city + county);
			userInfo.setTelephone(telephone);
			userInfo.setProvince(province);
			userInfo.setCity(city);
			userInfo.setCounty(county);

			if ("".equals(park) || park.length() <= 20) {
				userInfo.setPark(park);
			}

			if (!"".equals(fax) || fax.length() <= 20) {
				userInfo.setFax(fax);
			}

			if ("".equals(qq) || qq.length() <= 20) {
				userInfo.setQq(qq);
			}

			if (!"".equals(logo)) {
				userInfo.setLogo(logo);
			}

			int result = userService.updateUserContacts(userInfo,2);

			if (result == 1) {
				resultType = ResultType.SUCCESS;
				UserInfo userInfo2=WebUtil.getUserEntity(""+userid);
				userInfo2.setId(userid);
				userInfo2.setRealname(realName);
				userInfo2.setType(type);
				userInfo2.setCompanyname(company);
				userInfo2.setAddress(address);
				userInfo2.setPlace_receipt(province + city + county);
				userInfo2.setTelephone(telephone);
				userInfo2.setProvince(province);
				userInfo2.setCity(city);
				userInfo2.setCounty(county);
				if ("".equals(park) || park.length() <= 20) {
					userInfo2.setPark(park);
				}
				if ("".equals(fax) || fax.length() <= 20) {
					userInfo2.setFax(fax);
				}
				if ("".equals(qq) || qq.length() <= 20) {
					userInfo2.setQq(qq);
				}
				if (!"".equals(logo)) {
					userInfo2.setLogo(logo);
				}
				
				WebUtil.saveUserEntity(userid + "", userInfo2);
			}

		} else {
			resultType = ResultType.PARAMTER;
		}
		WebUtil.outputMsgObjJson(response, resultType, null);
		
	}
	
	

}
