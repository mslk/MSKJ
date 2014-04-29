package com.meibaolian.web.purchase;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 用户查询自己已发布的求购信息
 * @author llm
 *
 */
public class GetPurchase  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(GetPurchase.class);
	private IPurchaseService purchaseService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		// 验证参数
		if (userid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，查询已发布的求购信息失败！");
			return;
		}
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_PURCHASE);
		// 查询数据
		QueryResult<Purchase> qr = null;
		try {
			qr = purchaseService.searchPurchases(userid, page, pageSize, orders);
		} catch (DataManagerException e) {
			logger.error("查询已发布的求购信息失败！", e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询已发布的求购信息完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询已发布的求购信息完成！");
		}
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
