package com.meibaolian.web.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 用户查询推送消息详情( 供应商,求购商详情列表)
 * 
 * @author Administrator
 * 
 */
public class GeneralDetail extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 供应
	 */
	IProviderService providerService;

	/**
	 * 求购
	 */
	IPurchaseService purchaseService;

	Logger logger = Logger.getLogger(GeneralDetail.class);

	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}



	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1 为求购信息 2 为供应信息
		int type = UtilHelp.strToInt(request.getParameter("type"));

		int id = UtilHelp.strToInt(request.getParameter("id"));

		Object obj = null;

		ResultType resultType = ResultType.PARAMTER;

		if (id > 0) {
			try {
				if (type == 1) {
                   obj=purchaseService.getById(id);
				} else if (type == 2) {
					obj= providerService.getById(id);
					
				}
			} catch (DataManagerException e) {
				logger.error("服务器错误:", e);
				resultType=ResultType.SERVERFAIL;
			}
		}
		
		if(obj==null)
		{
			resultType=ResultType.NODATA;
		}else
		{
			resultType=ResultType.SUCCESS;
		}
		WebUtil.outputMsgObjJson(response, resultType, obj);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
