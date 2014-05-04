package com.meibaolian.web.transportSupply;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.SearchlogTransport;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.searchlog.ISearchlogService;
import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 按条件查询车讯
 * @author llm
 *  
 */
public class SearchByPlace extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(SearchByPlace.class);
	private ITransportSupplyService transportSupplyService;
	private ISearchlogService searchlogService;
	
	public void setSearchlogService(ISearchlogService searchlogService) {
		this.searchlogService = searchlogService;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		
		Integer startid = UtilHelp.strToInt(req.getParameter("startid"));
		String start = req.getParameter("start");//交货地
		Integer startcityid = UtilHelp.strToInt(req.getParameter("startcityid"));
		String startcityname = req.getParameter("startcityname");
		Integer startprvid = UtilHelp.strToInt(req.getParameter("startprvid"));
		String startprvname = req.getParameter("startprvname");
		//
		Integer stopid = UtilHelp.strToInt(req.getParameter("stopid"));//收货
		String stop = req.getParameter("stop");
		Integer stopcityid = UtilHelp.strToInt(req.getParameter("stopcityid"));
		String stopcityname = req.getParameter("stopcityname");
		Integer stopprvid = UtilHelp.strToInt(req.getParameter("stopprvid"));
		String stopprvname = req.getParameter("stopprvname");
		
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		// 验证参数
		/*if (userid <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布车讯信息失败！");
			return;
		}*/
		start = UtilHelp.trimStr(start);
		startcityname = UtilHelp.trimStr(startcityname);
		startprvname = UtilHelp.trimStr(startprvname);
		stop = UtilHelp.trimStr(stop);
		stopcityname = UtilHelp.trimStr(stopcityname);
		stopprvname = UtilHelp.trimStr(stopprvname);
		
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_TRANSPORTSUPPLY);
		//查询车讯信息
		QueryResult<TransportSupply> qr = null;
		try {
			qr = transportSupplyService.searchTransportSupply(startid, start,
					startcityid, startcityname, startprvid, startprvname,
					stopid, stop, stopcityid, stopcityname, stopprvid,
					stopprvname, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.debug("查询车讯信息失败！",e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询车讯信息完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询车讯信息完成！");
		}
		//记录查询条件
		SearchlogTransport st = new SearchlogTransport(userid, null, null, ConfigUtil.searchtype_supply, stopprvname);
		int count = searchlogService.addSearchLog(st);
		if(count > 0){
			logger.debug("查询条件记录成功！");
		}else{
			logger.debug("查询条件记录失败！");
		}
	}


	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
}
