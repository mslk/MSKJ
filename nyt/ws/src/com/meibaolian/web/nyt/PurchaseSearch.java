package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseInfoExpand;
import com.meibaolian.service.nyt.IPurchaseInfoService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
import com.meibaolian.web.nyt.dto.PurchaseDTo;

public class PurchaseSearch extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IPurchaseInfoService purchaseInfoService;


	public void setPurchaseInfoService(IPurchaseInfoService purchaseInfoService) {
		this.purchaseInfoService = purchaseInfoService;
	}

	Logger logger = Logger.getLogger(PurchaseSearch.class);

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int page = UtilHelp.strToInt(request.getParameter("page"));
		int pageSize = UtilHelp.strToInt(request.getParameter("pageSize"));

		if (page <= 0)
			page = ConfigUtil.PAGE;
		if (pageSize <= 0)
			pageSize = ConfigUtil.PAGESIZE;

		// 2 胶合板 3 原木 4 淀粉
		int type = UtilHelp.strToInt(request.getParameter("type"));

		String key = UtilHelp.strNotNull(request.getParameter("key"));

		// 排序
		// 价格 0 全部 1 升序 2降序
		int priceOrder = UtilHelp.strToInt(request.getParameter("priceOrder"));
		// 数量 0 全部 1 升序 2降序
		int numOrder = UtilHelp.strToInt(request.getParameter("numOrder"));

		PurchaseDTo dto = new PurchaseDTo();
		dto.setKey(key);
		dto.setType(type);
		dto.setPriceOrder(priceOrder);
		dto.setNumOrder(numOrder);

		if ("".equals(key)) {
			if (type == 2) {
				// 胶合板
				String length = UtilHelp.strNotNull(request
						.getParameter("length"));
				String width = UtilHelp.strNotNull(request
						.getParameter("width"));
				String thickness = UtilHelp.strNotNull(request
						.getParameter("thickness"));
				dto.setLength(length);
				dto.setWidth(width);
				dto.setThickness(thickness);

			} else if (type == 3) {
				// 原木
				String length = UtilHelp.strNotNull(request
						.getParameter("length"));
				String cultivated = UtilHelp.strNotNull(request
						.getParameter("cultivated"));
				String tail_directly = UtilHelp.strNotNull(request
						.getParameter("tail_directly"));
				dto.setLength(length);
				dto.setCultivated(cultivated);
				dto.setTail_directly(tail_directly);

			} else if (type == 4) {

				// 淀粉
				String brand = UtilHelp.strNotNull(request
						.getParameter("brand"));
				Integer level = UtilHelp
						.strToInt(request.getParameter("level"));

				dto.setBrand(brand);
				dto.setLevel(level);
			}
		}

		ResultType result = ResultType.SERVERFAIL;

		QueryResult<PurchaseInfoExpand> list = null;
		try {
			list = purchaseInfoService.search(page, pageSize, dto);
			if (list == null || list.getList() == null
					|| list.getList().size() == 0) {
				result = ResultType.NODATA;
			} else {
				WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
						+ "", pageSize + "", list.getCountNumber() + "", list.getList());
				return;
			}
		} catch (DataManagerException e) {
			logger.error(e);
		}

		WebUtil.outputMsgJson(response, result);

	}

}
