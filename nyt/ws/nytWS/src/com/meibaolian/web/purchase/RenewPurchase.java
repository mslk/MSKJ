package com.meibaolian.web.purchase;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Purchase;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 重新发布求购信息
 * @author llm
 *
 */
public class RenewPurchase  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(RenewPurchase.class);
	private IPurchaseService purchaseService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int purid = UtilHelp.strToInt(req.getParameter("purid"));
		int heating = UtilHelp.strToInt(req.getParameter("heating"));
		BigDecimal sulphur = UtilHelp.strToBigDecimal(req.getParameter("sulphur"));
		BigDecimal ash = UtilHelp.strToBigDecimal(req.getParameter("ash"));
		BigDecimal moisture = UtilHelp.strToBigDecimal(req.getParameter("moisture"));
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
		String validdate = req.getParameter("validdate");
		// 验证参数
		if (purid <= 0 || heating <= 0 || sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) < 0
				|| ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) < 0
				|| moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) < 0
				|| UtilHelp.isNullStr(validdate) || !UtilHelp.isDateValid(validdate.trim())
				|| quantity <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，重新发布求购信息失败！");
			return;
		}
		validdate = UtilHelp.setValiddateTime(validdate);
		// 封装
		Purchase purchase = new Purchase();
		purchase.setPurid(purid);
		purchase.setHeating(heating);
		purchase.setSulphur(sulphur);
		purchase.setAsh(ash);
		purchase.setMoisture(moisture);
		purchase.setQuantity(quantity);
		purchase.setValiddate(validdate);
		// 修改数据
		int count = 0;
//		count = purchaseService.updatePurchaseValiddate(purid, validdate);
		count = purchaseService.updatePurchase(purchase);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("purid:" + purid + "，数据库操作失败，重新发布求购信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("purid:" + purid + "，重新发布求购信息成功！");
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
