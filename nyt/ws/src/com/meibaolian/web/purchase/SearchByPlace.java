package com.meibaolian.web.purchase;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.service.searchlog.ISearchlogService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 按起止地查询求购单
 * @author llm
 *
 */
public class SearchByPlace  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(SearchByPlace.class);
	private IPurchaseService purchaseService;
	private ISearchlogService searchlogService;
	//
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	public void setSearchlogService(ISearchlogService searchlogService) {
		this.searchlogService = searchlogService;
	}
	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		
		Integer startcountyid = UtilHelp.strToInt(req.getParameter("startcountyid"));
		String startcountyname = req.getParameter("startcountyname");
		Integer startcityid = UtilHelp.strToInt(req.getParameter("startcityid"));
		String startcityname = req.getParameter("startcityname");
		Integer startprvid = UtilHelp.strToInt(req.getParameter("startprvid"));
		String startprvname = req.getParameter("startprvname");
		
		Integer receiptplaceid = UtilHelp.strToInt(req.getParameter("receiptplaceid"));//收货
		String receiptplace = req.getParameter("receiptplace");//收货地点
		Integer stopcityid = UtilHelp.strToInt(req.getParameter("stopcityid"));
		String stopcityname = req.getParameter("stopcityname");
		Integer stopprvid = UtilHelp.strToInt(req.getParameter("stopprvid"));
		String stopprvname = req.getParameter("stopprvname");

		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));

		// 验证参数
		/*if (userid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，卖方查询求购单失败！");
			return;
		}*/
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		
		// 封装查询条件
		SearchlogCoal searchlog = new SearchlogCoal(userid, ConfigUtil.searchtype_Purchase, receiptplace,
				startcountyid, startcountyname, startcityid, startcityname,
				startprvid, startprvname, receiptplaceid, stopcityid,
				stopcityname, stopprvid, stopprvname);
		// 查询数据
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_PURCHASE);
		QueryResult<PurchaseJson> qr = null;
		try {
			qr = purchaseService.searchByPlace(searchlog, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.error("查询求购单数据失败！", e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询求购单完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询求购单完成！");
		}
		// 记录查询条件
		int count = searchlogService.addSearchLog(searchlog);// 查询条件为空不记录
		if(count > 0)
			logger.debug("记录卖方查询条件完成！");
		else
			logger.debug("卖方查询条件为空,不记录！");
	}
	
}
