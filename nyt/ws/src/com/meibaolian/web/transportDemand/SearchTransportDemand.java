package com.meibaolian.web.transportDemand;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 查询货讯
 * @author llm
 *  
 */
public class SearchTransportDemand extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(SearchTransportDemand.class);
	private ITransportDemandService transportDemandService;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String keyword = req.getParameter("keyword");
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		String orderStr = req.getParameter("order");
		// 验证参数
		/*if (userid <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布货讯信息失败！");
			return;
		}*/
		keyword = UtilHelp.isNullStr(keyword) ? null : keyword.trim();
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String> ();
		if (UtilHelp.isNotNullStr(orderStr)) {
			//正数升序，负数降序
			int order = UtilHelp.strToInt(orderStr.trim());
			String column = ConfigUtil.getOrderColumn(Math.abs(order), ConfigUtil.ORDERTYPE_TRANSPORTDEMAND);
			if(UtilHelp.isNotNullStr(column)){
				orders.put(column, order>0?"asc":"desc");
			}
		}
		if(orders.isEmpty()){
			orders.put("sortnumber", "desc");
		}
		//查询货讯信息
		QueryResult<TransportDemand> qr = null;
		try {
			qr = transportDemandService.searchTransportDemand(null, keyword, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.debug("查询货讯信息失败！",e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询货讯信息完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询货讯信息完成！");
		}
	}


	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
}
