package com.meibaolian.web.transportDemand;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.TransportDemand;
import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 重新发布货讯
 * @author llm
 *  
 */
public class RenewTransportDemand extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(RenewTransportDemand.class);
	private ITransportDemandService transportDemandService;

	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
		String sendoutdate = req.getParameter("sendoutdate");
		String validdate = req.getParameter("validdate");
		
		// 验证参数，
		if (id <= 0 
				|| price.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| quantity <= 0 
				|| UtilHelp.isNullStr(sendoutdate)
				|| !UtilHelp.isDateValid(sendoutdate.trim())
				|| UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim())) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，重新发布货讯信息失败！");
			return;
		}
		validdate = UtilHelp.setValiddateTime(validdate);
		TransportDemand transportDemand = new TransportDemand();
		transportDemand.setId(id);
		transportDemand.setPrice(price);
		transportDemand.setQuantity(quantity);
		transportDemand.setSendoutdate(sendoutdate);
		transportDemand.setValiddate(validdate);
		//更新数据
		int count = transportDemandService.updateTransportDemand(transportDemand);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("id:" + id + "，数据库操作失败，重新发布货讯信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，重新发布货讯信息成功！");
		}
	}
	
}
