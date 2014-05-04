package com.meibaolian.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meibaolian.service.user.IUserService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;

public class UserDelete extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}




	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String phone =UtilHelp.strNotNull(request.getParameter("phone"));
		
		int result=0;
		if(!"".equals(phone) && phone.length()==11 && UtilHelp.isMobile(phone))
		{
			result=userService.deleteUserByPhone(phone);
		}
		
		
		String msg="删除用户:"+phone +" 失败!";
		if(result==1)
		{
			msg="删除用户:"+phone +" 成功!";
		}
		
		PrintWriter  print=response.getWriter();
		print.write(msg);
		print.close();
		
	  	
	}
	
	
	
	
	
	

}
