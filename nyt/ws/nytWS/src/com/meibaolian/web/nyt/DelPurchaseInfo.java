package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.nyt.IVennerInfoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 删除桉木信息
 * @author llm
 *  
 */
public class DelPurchaseInfo extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelPurchaseInfo.class);
	private IVennerInfoService vennerInfoService;
	

	public void setVennerInfoService(IVennerInfoService vennerInfoService) {
		this.vennerInfoService = vennerInfoService;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));//用户id
		int id = UtilHelp.strToInt(req.getParameter("id"));//主键id
		if(userid<=0||id<=0)
		{
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除失败！");
			return;
		}
		int count=0;
		try{
			count = vennerInfoService.delPurchaseInfo(userid,id);
			if(count > 0){
				WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
				logger.debug("删除按木供应信息成功");
			}else{
				WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
				logger.debug("删除按木供应信息失败！");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}


	
	
}
