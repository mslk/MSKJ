package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.CoalMineJson;
import com.meibaolian.service.dictionary.ICoalMineService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 煤矿信息
 * @author llm
 *
 */
public class CoalMine  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(CoalMine.class);
	private ICoalMineService coalMineService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			List<CoalMineJson> list = coalMineService.getCoalMineJsonList();
			if(list == null){
				WebUtil.outputMsgJson(resp, ResultType.NODATA);
				logger.error("煤矿信息为空！");
			}else{
				WebUtil.outputSuccessJson(resp, list);
			}
		} catch (DataManagerException e) {
			logger.error("操作异常，查询煤矿信息失败！",e);
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void setCoalMineService(ICoalMineService coalMineService) {
		this.coalMineService = coalMineService;
	}

	
	
}
