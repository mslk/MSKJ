package com.meibaolian.web.transportDemand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
 * 发布货讯后展示货讯列表，发布的为第一条
 * @author llm
 *  
 */
public class ListTransportDemand extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListTransportDemand.class);
	private ITransportDemandService transportDemandService;
	

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
			logger.debug("参数异常，获取货讯列表失败！");
			return;
		}
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_TRANSPORTDEMAND);
		//查询货讯信息
		QueryResult<TransportDemand> qr = null;
		try {
			qr = transportDemandService.searchTransportDemand(id, null, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.error("查询货讯信息失败！",e);
		}
		//获取自己刚发布的
		TransportDemand td = null;
		if(page < 0 || pageSize < 0 || (page == 1 && pageSize > 0)){
			try {
				td = transportDemandService.getById(id);
			} catch (DataManagerException e) {
				logger.error("查询货讯信息(id="+id+")失败！",e);
			}
		}
		if (qr == null) {
			if(td == null){
				WebUtil.outputMsgJson(resp, ResultType.NODATA);
				logger.debug("无数据，查询货讯信息完成！");
				return;
			}
			qr = new QueryResult<TransportDemand>(new ArrayList<TransportDemand>(), -1, -1, -1);
		} 
		if(td != null){//将自己刚发布的设置在列表第一个
			td.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), td.getValiddate())));
			qr.getList().add(0, td);
		}
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，查询货讯信息完成！");
		
	}


	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
}
