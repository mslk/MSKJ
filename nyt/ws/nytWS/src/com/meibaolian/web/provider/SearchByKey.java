package com.meibaolian.web.provider;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.service.searchlog.ISearchlogService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 关键字查询出售单
 * 
 * @author llm
 * 
 */
public class SearchByKey extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(SearchByKey.class);
	private IProviderService providerService;
	private ISearchlogService searchlogService;
	
	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}
	public void setSearchlogService(ISearchlogService searchlogService) {
		this.searchlogService = searchlogService;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String keyword = req.getParameter("keyword");//
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		String orderStr = req.getParameter("order");
		
		// 验证参数
		/*if (userid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，买方查询出售单失败！");
			return;
		}*/
		keyword = UtilHelp.isNullStr(keyword) ? null : keyword.trim();
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		// 封装查询条件
		
		// 查询数据
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String> ();
		if (UtilHelp.isNotNullStr(orderStr)) {
			//正数升序，负数降序
			int order = UtilHelp.strToInt(orderStr.trim());
			String column = ConfigUtil.getOrderColumn(Math.abs(order), ConfigUtil.ORDERTYPE_PROVIDER);
			if(UtilHelp.isNotNullStr(column)){
				orders.put(column, order>0?"asc":"desc");
			}
		}
		if(orders.isEmpty()){
			orders.put("sortnumber", "desc");
		}
		QueryResult<ProviderJson> qr = null;
		try {
			qr = providerService.searchByKey(keyword, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.error("查询出售单数据失败！", e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，买方查询出售单完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，买方查询出售单完成！");
		}
		// 封装查询条件
		SearchlogCoal searchlog = new SearchlogCoal(userid, ConfigUtil.searchtype_Provider, keyword);
		// 记录查询条件
		int count = searchlogService.addSearchLog(searchlog);// 查询条件为空不记录
		if(count > 0)
			logger.debug("记录买方查询条件完成！");
		else
			logger.debug("买方查询条件为空,不记录！");
	}

}
