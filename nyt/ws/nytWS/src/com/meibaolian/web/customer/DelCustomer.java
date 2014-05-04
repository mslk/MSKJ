package com.meibaolian.web.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.customer.ICustomerService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 删除我的用户
 * @author llm
 *
 */
public class DelCustomer  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelCustomer.class);
	private ICustomerService customerService;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		// 验证参数
		if (id <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除我的客户信息失败！");
			return;
		}
		// 删除数据
		int count = 0;
		count = customerService.delCustomer(id);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("id:" + id + "，数据库操作失败，删除我的客户信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，删除我的客户信息成功！");
		}
	}


	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	

}
