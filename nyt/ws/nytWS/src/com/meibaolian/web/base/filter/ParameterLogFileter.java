package com.meibaolian.web.base.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/**
 * 设置编码格式
 * @author Administrator
 *
 */
public class ParameterLogFileter implements Filter {

	@Override
	public void destroy() {

	}

	Logger logger=Logger.getLogger(ParameterLogFileter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		
		try {
			Map<String, String[]> map=request.getParameterMap();
			
			logger.debug("requestUrl:" +httpRequest.getRequestURL());
			for(String key:map.keySet())
			{
				String [] values=map.get(key);
				if(values!=null)
				{
				for (int i = 0; i < values.length; i++) {
						logger.debug(key + "-" + i + " : " + values[i]);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(" 参数打印错误!" ,e);
		}
		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		 
	}

}
