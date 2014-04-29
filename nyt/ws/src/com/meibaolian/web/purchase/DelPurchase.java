package com.meibaolian.web.purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 用户删除已发布的求购信息
 * @author llm
 *
 */
public class DelPurchase  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelPurchase.class);
	private IPurchaseService purchaseService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int purid = UtilHelp.strToInt(req.getParameter("purid"));
		
		// 验证参数
		if (purid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除求购信息失败！");
			return;
		}
		// 删除数据
		int count = 0;
		count = purchaseService.delPurchase(purid);
		
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, (count == UtilHelp.ERRORCODE) ? ResultType.SERVERFAIL : ResultType.NODATA);
			logger.debug("purid:" + purid + "，数据库操作失败，删除求购信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("purid:" + purid + "，删除求购信息成功！");
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
