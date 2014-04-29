package com.meibaolian.action.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meibaolian.entity.Usermanager;
import com.meibaolian.util.UtilHelp;

/**
 * 验证请求权限
 * 是否已经是登录用户
 * @author Administrator
 *
 */
public class FilterPermision implements Filter {
	
	private String passUrl = "user/system_login.action";
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {

		
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
//		Usermanager admin= (Usermanager)httpRequest.getSession().getAttribute("admin ");
		Usermanager admin = WebUtil.getAdmin(httpRequest);
		String uri = httpRequest.getRequestURI();
	   if(admin!=null || -1 != uri.indexOf(passUrl)){
		   filter.doFilter(request, response);
	   }else {
		   httpResponse.sendRedirect(httpRequest.getContextPath()+"/index.jsp");
//		   httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);
	   }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String value = arg0.getInitParameter("passUrl");
		if(UtilHelp.isNotNullStr(value)){
			passUrl = value.trim();
		}
	}

}
