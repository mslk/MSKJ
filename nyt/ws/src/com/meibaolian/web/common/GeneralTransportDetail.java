package com.meibaolian.web.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.service.transportSupply.ITransportSupplyService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 用户查询推送消息详情( 车讯,货讯)
 * @author Administrator
 */
public class GeneralTransportDetail extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 车货
	 */
	ITransportSupplyService transportSupplyService;
	
	/**
	 * 货讯
	 */
	ITransportDemandService transportDemandService;
	

	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}

	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}

	Logger logger = Logger.getLogger(GeneralTransportDetail.class);
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1 为车讯信息 2 为货讯信息
		int type = UtilHelp.strToInt(request.getParameter("type"));

		int id = UtilHelp.strToInt(request.getParameter("id"));

		Object obj = null;

		ResultType resultType = ResultType.PARAMTER;

		if (id > 0) 
		{
			try {
				if(type==1)
				{
					obj=transportSupplyService.getById(id);
				}else if(type==2)
				{
					obj=transportDemandService.getById(id);
				}
			} catch (DataManagerException e) {
				logger.error("服务器错误:", e);
				resultType=ResultType.SERVERFAIL;
			}
		}
		
		if(obj==null)
		{
			resultType=ResultType.NODATA;
		}else{
			resultType=ResultType.SUCCESS;
		}
		WebUtil.outputMsgObjJson(response, resultType, obj);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
