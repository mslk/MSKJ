package com.meibaolian.web.transportSupply;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 发布车讯后展示车讯列表，发布的为第一条
 * @author llm
 *  
 */
public class ListTransportSupply extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListTransportSupply.class);
	private ITransportSupplyService transportSupplyService;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		// 验证参数
		if (id <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布车讯信息失败！");
			return;
		}
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_TRANSPORTSUPPLY);
		//查询车讯信息
		QueryResult<TransportSupply> qr = null;
		try {
			qr = transportSupplyService.searchTransportSupply(id, null, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.error("查询车讯信息失败！",e);
		}
		//获取自己刚发布的
		TransportSupply ts = null;
		if(page < 0 || pageSize < 0 || (page == 1 && pageSize > 0)){
			try {
				ts = transportSupplyService.getById(id);
			} catch (DataManagerException e) {
				logger.error("查询车讯信息(id="+id+")失败！",e);
			}
		}
		if (qr == null) {
			if(ts == null){
				WebUtil.outputMsgJson(resp, ResultType.NODATA);
				logger.debug("无数据，查询车讯信息完成！");
				return;
			}
			qr = new QueryResult<TransportSupply>(new ArrayList<TransportSupply>(), -1, -1, -1);
		} 
		if(ts != null){//将自己刚发布的设置在列表第一个
			ts.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), ts.getValiddate())));
			qr.getList().add(0, ts);
		}
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，查询车讯信息完成！");
		
	}


	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
}
