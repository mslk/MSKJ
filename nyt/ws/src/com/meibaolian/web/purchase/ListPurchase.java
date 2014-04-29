package com.meibaolian.web.purchase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 发布求购单后展示求购单列表，发布的为第一条
 * @author llm
 *
 */
public class ListPurchase  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListPurchase.class);
	private IPurchaseService purchaseService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int purid = UtilHelp.strToInt(req.getParameter("purid"));
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));

		// 验证参数
		if (purid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，获取求购单列表失败！");
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
//				null, ConfigUtil.searchtype_Purchase);
		SearchlogCoal searchlog = new SearchlogCoal(null, 0, null, 0, 0, 0, 0,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO,
				UtilHelp.BIGDECIMAL_ZERO, UtilHelp.BIGDECIMAL_ZERO, null, null,
				ConfigUtil.searchtype_Purchase, null, 0, 0, null, 0, null, 0,
				null);
		//排除掉自己刚发布的
		searchlog.setId(purid);
		
		// 查询数据
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_PURCHASE);
		QueryResult<PurchaseJson> qr = null;
		try {
			qr = purchaseService.searchPurchases(searchlog, page, pageSize,
					orders);
		} catch (DataManagerException e) {
			logger.error("卖方查询求购单数据失败！", e);
		}
		//获取自己刚发布的
		PurchaseJson pj = null;
		if(page < 0 || pageSize < 0 || (page == 1 && pageSize > 0)){
			try {
				pj = purchaseService.getById(purid);
			} catch (DataManagerException e) {
				logger.error("买方查询求购单(id="+purid+")数据失败！", e);
			}
		}
		if (qr == null) {
			if(pj == null ){
				WebUtil.outputMsgJson(resp, ResultType.NODATA);
				logger.debug("无数据，卖方查询求购单完成！");
				return;
			}
			qr = new QueryResult<PurchaseJson>(new ArrayList<PurchaseJson>(0),-1,-1,-1);
		} 
		if(pj != null){//将自己刚发布的设置在列表第一个
			pj.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), pj.getValiddate())));
			qr.getList().add(0, pj);
		}
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，卖方查询求购单完成！");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

}
