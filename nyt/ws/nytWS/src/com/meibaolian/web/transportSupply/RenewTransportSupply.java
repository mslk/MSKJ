package com.meibaolian.web.transportSupply;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.TransportSupply;
import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 重新发布车讯
 * @author llm
 *  
 */
public class RenewTransportSupply extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(RenewTransportSupply.class);
	private ITransportSupplyService transportSupplyService;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
		String validdate = req.getParameter("validdate");
		
		// 验证参数，
		if (id <= 0 || price.compareTo(UtilHelp.BIGDECIMAL_ZERO) < 0
				|| quantity <= 0 
				|| UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim())) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，重新发布车讯信息失败！");
			return;
		}
		validdate = UtilHelp.setValiddateTime(validdate);
		TransportSupply transportSupply = new TransportSupply();
		transportSupply.setId(id);
		transportSupply.setPrice(price);
		transportSupply.setQuantity(quantity);
		transportSupply.setValiddate(validdate);
		// 更新数据,重新发布车讯
		int count = transportSupplyService.updateTransportSupply(transportSupply);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("id:" + id + "，数据库操作失败，重新发布车讯信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，重新发布车讯信息成功！");
		}
	}


	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
}
