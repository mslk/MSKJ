package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.HighwayrateEntity;
import com.meibaolian.entity.Railwayrate;
import com.meibaolian.service.dictionary.IHighwayrateService;
import com.meibaolian.service.dictionary.IRailwayrateService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 铁路、公路运价信息
 * @author llm
 *
 */
public class Rate  extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Rate.class);
	private IRailwayrateService railwayrateService;
	private IHighwayrateService highwayrateService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int city = UtilHelp.strToInt(req.getParameter("city"));
		String stop =req.getParameter("stop");
		int type = UtilHelp.isNullStr(req.getParameter("type")) ? -1 :  UtilHelp.strToInt(req.getParameter("type"));
		
		// 验证参数
		if(city <= 0 || UtilHelp.isNullStr(stop) || type < 0){
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，查询铁路信息失败！");
			return;
		}
		stop = UtilHelp.doubleDecode(stop);
		
		List<Object> list = new ArrayList<Object>();
		List<Railwayrate> rwlist = null;
		List<HighwayrateEntity> hwlist = null;
		try {
			rwlist = railwayrateService.getRailwayrateList(city, stop);
			hwlist = highwayrateService.getHighwayrateList(city, stop);
			if(type == -1){//查询公路、铁路运价
				list.addAll(rwlist);
				list.addAll(hwlist);
			}else if(type == 0){//只查询铁路运价
				list.addAll(rwlist);
			}else if(type == 1){//只查询公路运价
				list.addAll(hwlist);
			}
		} catch (DataManagerException e) {
			logger.error("操作异常，查询铁路信息失败！",e);
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
		}
		if(list.isEmpty()){
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.error("运价信息为空！");
		}else{
			WebUtil.outputSuccessJson(resp, list);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void setRailwayrateService(IRailwayrateService railwayrateService) {
		this.railwayrateService = railwayrateService;
	}

	public void setHighwayrateService(IHighwayrateService highwayrateService) {
		this.highwayrateService = highwayrateService;
	}

	

	

	
	
}
