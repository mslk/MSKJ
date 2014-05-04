package com.meibaolian.web.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 发布出售单后展示出售单列表，发布的为第一条
 * 
 * @author llm
 * 
 */
public class ListProvider extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(ListProvider.class);

	private IProviderService providerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int proid = UtilHelp.strToInt(req.getParameter("proid"));
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		
//		// 验证参数
		if (proid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，获取出售单列表失败！");
			return;
		}
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		
		// 封装查询条件
//		Searchlog searchlog = new Searchlog(null, null, 0, null, null, 0, 0, 0,
//				0, UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
//				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
//				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
//				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
//				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO, null, null,
//				null, ConfigUtil.searchtype_Provider);
		SearchlogCoal searchlog = new SearchlogCoal(null, 0, null, 0, 0, 0, 0,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO, null, null,
				ConfigUtil.searchtype_Provider, null, 0, 0, null, 0, null, 0,
				null);
		//排除掉自己刚发布的
		searchlog.setId(proid);
		// 查询数据
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_PROVIDER);
		QueryResult<ProviderJson> qr = null;
		try {
			qr = providerService.searchProviders(searchlog, page, pageSize,
					orders);
		} catch (DataManagerException e) {
			logger.error("买方查询出售单数据失败！", e);
		}
		//获取自己刚发布的
		ProviderJson pj = null;
		if(page < 0 || pageSize < 0 || (page == 1 && pageSize > 0)){
			try {
				pj = providerService.getById(proid);
			} catch (DataManagerException e) {
				logger.error("买方查询出售单(id="+proid+")数据失败！", e);
			}
		}
		
		if(qr == null) {
			if(pj == null ){
				WebUtil.outputMsgJson(resp, ResultType.NODATA);
				logger.debug("无数据，买方查询出售单完成！");
				return;
			}
			qr = new QueryResult<ProviderJson>(new ArrayList<ProviderJson>(1),-1,-1,-1);
		} 
		if(pj != null){//将自己刚发布的设置在列表第一个
			pj.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), pj.getValiddate())));
			qr.getList().add(0, pj);
		}
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，买方查询出售单完成！");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}



}
