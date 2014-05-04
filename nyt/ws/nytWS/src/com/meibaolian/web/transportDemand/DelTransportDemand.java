package com.meibaolian.web.transportDemand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 删除已发布货讯
 * @author llm
 *  
 */
public class DelTransportDemand extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelTransportDemand.class);
	private ITransportDemandService transportDemandService;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		// 验证参数
		if (id <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除货讯信息失败！");
			return;
		}
		//删除货讯信息
		int count = transportDemandService.delTransportDemand(id);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, (count == UtilHelp.ERRORCODE) ? ResultType.SERVERFAIL : ResultType.NODATA);
			logger.debug("id:" + id + "，数据库操作失败，删除货讯信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，删除货讯信息成功！");
		}
	}


	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
}
