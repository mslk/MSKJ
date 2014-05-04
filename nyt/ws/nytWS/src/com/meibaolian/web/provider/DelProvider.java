package com.meibaolian.web.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 用户删除已发布的出售单信息
 * @author llm
 *
 */
public class DelProvider  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelProvider.class);
	private IProviderService providerService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int proid = UtilHelp.strToInt(req.getParameter("proid"));
		
		// 验证参数
		if (proid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除出售单信息失败！");
			return;
		}
		
		// 删除数据
		int count = 0;
		count = providerService.delProvider(proid);
		
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, (count == UtilHelp.ERRORCODE) ? ResultType.SERVERFAIL : ResultType.NODATA);
			logger.debug("proid:" + proid + "，数据库操作失败，删除出售单信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("proid:" + proid + "，删除出售单信息成功！");
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
