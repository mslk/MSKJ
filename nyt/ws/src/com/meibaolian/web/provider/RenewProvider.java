package com.meibaolian.web.provider;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Provider;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 重新发布出售单信息
 * @author llm
 *
 */
public class RenewProvider  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(RenewProvider.class);
	private IProviderService providerService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int proid = UtilHelp.strToInt(req.getParameter("proid"));
		int heating = UtilHelp.strToInt(req.getParameter("heating"));
		BigDecimal sulphur = UtilHelp.strToBigDecimal(req.getParameter("sulphur"));
		BigDecimal ash = UtilHelp.strToBigDecimal(req.getParameter("ash"));
		BigDecimal moisture = UtilHelp.strToBigDecimal(req.getParameter("moisture"));
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		BigDecimal taxprice = UtilHelp.strToBigDecimal(req.getParameter("taxprice"));
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
		String validdate = req.getParameter("validdate");
		// 验证参数
		if (proid <= 0 || heating <= 0
				|| sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| (price.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0 
						&& taxprice.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0)
				|| UtilHelp.isNullStr(validdate) || !UtilHelp.isDateValid(validdate.trim())
				|| quantity < 40) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，重新发布出售单信息失败！");
			return;
		}
		validdate = UtilHelp.setValiddateTime(validdate);
		// 封装求购信息
		Provider provider = new Provider();
		provider.setProid(proid);
		provider.setHeating(heating);
		provider.setAsh(ash);
		provider.setSulphur(sulphur);
		provider.setMoisture(moisture);
		provider.setPrice(price);
		provider.setTaxprice(taxprice);
		provider.setQuantity(quantity);
		provider.setValiddate(validdate);
				
		// 更新
		int count = 0;
//		count = providerService.updateProviderValiddate(proid, validdate);
		count = providerService.updateProvider(provider);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("proid:" + proid + "，数据库操作失败，重新发布出售单信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("proid:" + proid + "，重新发布出售单信息成功！");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}

	
	
}
