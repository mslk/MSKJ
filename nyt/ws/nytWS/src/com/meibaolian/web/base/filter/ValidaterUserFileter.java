package com.meibaolian.web.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 验证用户权限 过滤器
 * @author Administrator
 *
 */
public class ValidaterUserFileter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		//用户id
		String userid=UtilHelp.strNotNull(request.getParameter("userid"));
		//用户令牌
		String token=UtilHelp.strNotNull(request.getParameter("token"));

		//参数异常
		if(UtilHelp.isNullStr(userid) || UtilHelp.isNullStr(token)){
			WebUtil.outputMsgJson(httpResponse, ResultType.FORBIDDEN);	
			return;
		}
		
		String cacheToken=WebUtil.getUserToken(userid);
		UserInfo userinfo = WebUtil.getUserEntity(userid);
		//会话过期
		if(!token.equals(cacheToken) || userinfo == null){
			
			WebUtil.outputMsgJson(httpResponse, ResultType.TIMEOUT);	
			return;
		}
		//账号被禁用
		if(userinfo.getStatus() == ConfigUtil.USERSTATUS_INVALID){
			WebUtil.outputMsgJson(httpResponse, ResultType.USEREDISABLED);	
			return;
		}
		String url = httpRequest.getRequestURI();
		//验证权限
	   if(!validateURL(url, userinfo.getType())){
			WebUtil.outputMsgJson(httpResponse, ResultType.FORBIDDEN);	
			return;
		}
		chain.doFilter(request, response);	
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		 
	}
	
	private static String[] notLoginUrl = new String[]{"/userPerfectInfo"};
	private static String[] loginUrl = new String[]{"/nyt/","/transportDemand/","/customer/"};
	
	/**
	 * 验证访问路径是否在用户的权限内
	 * 权限规则：
	 * @param url
	 * @param userType
	 * @return
	 */
	private boolean validateURL(String url, int userType){
		
		boolean flag = false;
		
		switch (userType) {
		case 1://会员
			flag =  validateURL(url, loginUrl);
			break;
		case 100:
			flag=  validateURL(url, notLoginUrl);
			break;
		default:
			break;
		}
		return flag;
	}
	
	/**
	 * 逐个遍历匹配
	 * @param validateURL
	 * @param userURLs
	 * @return
	 */
	private boolean validateURL(String validateURL, String [] userURLs){
		for(int i = 0; i < userURLs.length; i++){
			if(validateURL.indexOf(userURLs[i]) != -1){
				return true;
			}
		}
		return false;
	}
}
