package com.meibaolian.web.transportSupply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 删除已发布车讯
 * @author llm
 *  
 */
public class DelTransportSupply extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelTransportSupply.class);
	private ITransportSupplyService transportSupplyService;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		// 验证参数
		if (id <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布车讯信息失败！");
			return;
		}
		//删除车讯信息
		
		int count = transportSupplyService.delTransportSupply(id);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, (count == UtilHelp.ERRORCODE) ? ResultType.SERVERFAIL : ResultType.NODATA);
			logger.debug("id:" + id + "，数据库操作失败，删除车讯信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，删除车讯信息成功！");
		}
	}


	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
}
