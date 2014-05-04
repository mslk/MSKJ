package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.cache.Freight_ratesCache;
import com.meibaolian.entity.Freight_ratesEntity;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/** 
 * 运价查询  
 * @author Kawin
 *
 */
public class Freight_ratesSearch extends BaseServlet {
 
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListVeneerInfo.class);
	
	private Freight_ratesCache fr;
 
	public void setFr(Freight_ratesCache fr) {
		this.fr = fr;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//买方地址 省市区
		String buyerPlaceReceipt = UtilHelp.strNotNull(request.getParameter("start")); 
		//卖方地址 省市区
		String sellPlaceReceipt = UtilHelp.strNotNull(request.getParameter("to"));

		ResultType result = ResultType.SERVERFAIL;
		try {
			Freight_ratesEntity bean = fr.getFreight_ratesByBuyerAddressAndSellAddress(buyerPlaceReceipt, sellPlaceReceipt);
			if (null == bean) {
				result = ResultType.NODATA;
			} else {
				WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, bean);
				return;
			}
		} catch (DataManagerException e) {
			logger.error(e);
		}

		WebUtil.outputMsgJson(response, result);
	}
 
}
