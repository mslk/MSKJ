package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.service.nyt.IPurchaseInfoService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class NytMyPurchase extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(NytMySupply.class);

	IPurchaseInfoService purchaseInfoService;




	public void setPurchaseInfoService(IPurchaseInfoService purchaseInfoService) {
		this.purchaseInfoService = purchaseInfoService;
	}






	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int page = UtilHelp.strToInt(request.getParameter("page"));

		int pageSize = UtilHelp.strToInt(request.getParameter("pageSize"));
		
		int type = UtilHelp.strToInt(request.getParameter("type"));

		int userid = UtilHelp.strToInt(request.getParameter("userid"));

		if(page<=0)page=ConfigUtil.PAGE;
		if(pageSize<=0)pageSize=ConfigUtil.PAGESIZE;
		
		QueryResult<PurchaseInfo> resultList = null;
		ResultType result=ResultType.SERVERFAIL;
		if (userid > 0 && type>=2 && type<=4 ) {
			try {
				resultList = purchaseInfoService.search(page, pageSize, userid,type);
				if( resultList!=null && resultList.getList()!=null && resultList.getList().size()>0)
				{
					WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, resultList.getPage()+"", resultList.getPageSize()+"", resultList.getCountNumber()+"", resultList.getList());
				}else if(resultList==null)
				{
					WebUtil.outputMsgJson(response, ResultType.NODATA);
				}
				return;
				
			} catch (DataManagerException e) {
				logger.error(e);
				
			}
		}
		
		
			WebUtil.outputMsgJson(response, result);
		

	}
}
