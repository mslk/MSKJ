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
 * 发布货讯
 * @author llm
 *  
 */
public class NewTransportDemand extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(NewTransportDemand.class);
	private ITransportDemandService transportDemandService;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String username = req.getParameter("username");
		String phone = req.getParameter("phone");
		
		Integer startid = UtilHelp.strToInt(req.getParameter("startid"));
		String start = req.getParameter("start");
		String startshortname = req.getParameter("startshortname");//交货地简称
		Integer startcityid = UtilHelp.strToInt(req.getParameter("startcityid"));
		String startcityname = req.getParameter("startcityname");
		Integer startprvid = UtilHelp.strToInt(req.getParameter("startprvid"));
		String startprvname = req.getParameter("startprvname");
		//
		Integer stopid = UtilHelp.strToInt(req.getParameter("stopid"));//收货
		String stop = req.getParameter("stop");
		String stopshortname = req.getParameter("stopshortname");//收货地简称
		Integer stopcityid = UtilHelp.strToInt(req.getParameter("stopcityid"));
		String stopcityname = req.getParameter("stopcityname");
		Integer stopprvid = UtilHelp.strToInt(req.getParameter("stopprvid"));
		String stopprvname = req.getParameter("stopprvname");
		
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
		String sendoutdate = req.getParameter("sendoutdate");
		String validdate = req.getParameter("validdate");
		int pushtype = UtilHelp.strToInt(req.getParameter("pushtype"));//0 不推送,1 推送
		
		// 验证参数，|| UtilHelp.isNullStr(username)|| UtilHelp.isNullStr(phone) 
		if (userid <= 0
				|| !isValidPlace(startid, start, startshortname, startcityid,
						startcityname, startprvid, startprvname, stopid, stop,
						stopshortname, stopcityid, stopcityname, stopprvid,
						stopprvname) 
				|| price.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| quantity <= 0 || UtilHelp.isNullStr(sendoutdate)
				|| !UtilHelp.isDateValid(sendoutdate.trim())
				|| UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim())) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布货讯信息失败！");
			return;
		} 
		username = UtilHelp.trimStr(username);
		phone = UtilHelp.trimStr(phone);
		start = UtilHelp.trimStr(start);
		startshortname = UtilHelp.trimStr(startshortname);
		startcityname = UtilHelp.trimStr(startcityname);
		startprvname = UtilHelp.trimStr(startprvname);
		stop = UtilHelp.trimStr(stop);
		stopshortname = UtilHelp.trimStr(stopshortname);
		stopcityname = UtilHelp.trimStr(stopcityname);
		stopprvname = UtilHelp.trimStr(stopprvname);
		validdate = UtilHelp.setValiddateTime(validdate);
		
		// 封装货讯信息
//		TransportDemand transportDemand = new TransportDemand(userid, username, phone, null, start.trim(), stop.trim(), price, quantity, sendoutdate.trim(), validdate.trim(), 1, 0);
		int sortnumber = 1;
		int status = 0;
		TransportDemand transportDemand = new TransportDemand(userid, username,
				phone, start, stop, price, quantity, sendoutdate, validdate,
				sortnumber, status, startid, startcityid, startcityname,
				startprvid, startprvname, startshortname, stopid, stopcityid,
				stopcityname, stopprvid, stopprvname, stopshortname);
		//发布货讯信息，添加到推送任务
		int id = transportDemandService.addTransportDemandAndPushTask(transportDemand, pushtype);
		if(id > 0){
			WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, id+"", null);
			logger.debug("发布货讯信息成功，"+ (pushtype == 1?"需推送并添加到推送任务":"不需推送"));
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("发布货讯信息失败！");
		}
	}
	/**
	 * 起止地验证
	 * @param startid
	 * @param start
	 * @param startshortname
	 * @param startcityid
	 * @param startcityname
	 * @param startprvid
	 * @param startprvname
	 * @param stopid
	 * @param stop
	 * @param stopshortname
	 * @param stopcityid
	 * @param stopcityname
	 * @param stopprvid
	 * @param stopprvname
	 * @return
	 */
	private boolean isValidPlace(Integer startid, String start,
			String startshortname, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, String stopshortname, Integer stopcityid,
			String stopcityname, Integer stopprvid, String stopprvname) {
		return UtilHelp.isNotNullStr(startprvname)
				//&& UtilHelp.isNotNullStr(startcityname)
				//&& UtilHelp.isNotNullStr(start)
				&& UtilHelp.isNotNullStr(stopprvname)
				//&& UtilHelp.isNotNullStr(stopcityname)
				//&& UtilHelp.isNotNullStr(stop)
				;
	}
	
	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
}
