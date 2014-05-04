package com.meibaolian.web.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CustomerJson;
import com.meibaolian.service.customer.ICustomerService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/** 
 * 获取我的好友 
 * @author Kawin
 *
 */
public class GetCustomer  extends BaseServlet {
 
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(GetCustomer.class);
	private ICustomerService customerService;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		//int customertype = UtilHelp.strToInt(req.getParameter("customertype"));
		// 验证参数
//		if (userid <= 0 || customertype < 0) {
//			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
//			logger.debug("参数异常，查询我的客户信息失败！");
//			return;
//		}
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		
		//查询数据
		QueryResult<CustomerJson> qr = null;
		try {
			qr = customerService.getCustomerJson(userid, 0, page, pageSize);
		} catch (DataManagerException e) {
			logger.error("查询我的客户信息失败！", e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询我的客户信息完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询我的客户信息完成！");
		}
	}


	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	

}
