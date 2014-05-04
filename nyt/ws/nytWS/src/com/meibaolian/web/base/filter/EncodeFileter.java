package com.meibaolian.web.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 设置编码格式
 * @author Administrator
 *
 */
public class EncodeFileter implements Filter {

	@Override
	public void destroy() {

	}
	private String encode="UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
    
		String value=config.getInitParameter("encode");
		if(value!=null && !"".equals(value)){
			encode=value;
		}
		 
	}

}
