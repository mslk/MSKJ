package com.meibaolian.web.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Customer;
import com.meibaolian.service.customer.ICustomerService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 添加我的好友 
 * @author Kawin
 *
 */
public class AddCustomer extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(AddCustomer.class);
	private ICustomerService customerService;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int customerid = UtilHelp.strToInt(req.getParameter("customerid"));
	//	int customertype = UtilHelp.strToInt(req.getParameter("customertype"));
	//	String phone = UtilHelp.strNotNull(req.getParameter("phone"));
		// 验证参数, || UtilHelp.isNullStr(phone)
//		if(customerid <= 0 || customertype < 0 ){
//			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
//			logger.debug("参数异常，添加客户失败！");
//			return;
//		}
		// 封装客户数据
		Customer customer = new Customer(userid, customerid, null, null, null);
		//验证是否已存在
		int count = 0;
		try {
			boolean flag = customerService.isExistCustomer(customer);
			if(!flag){
				//添加到数据库
				count = customerService.addCustomer(customer);
			}else{
				WebUtil.outputMsgJson(resp, ResultType.DATAEXIST);
				logger.debug("客户信息已存在！操作丢弃");
			}
		} catch (DataManagerException e) {
			logger.error("添加客户失败！",e);
		}
		if(count > 0){
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("添加客户成功");
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("添加客户失败！");
		}
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
