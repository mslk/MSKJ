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
 * 发布车讯
 * @author llm
 *  
 */
public class NewTransportSupply extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(NewTransportSupply.class);
	private ITransportSupplyService transportSupplyService;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String username = req.getParameter("username");
		String phone = req.getParameter("phone");
		String carnumber = req.getParameter("carnumber");
		
		
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
		String validdate = req.getParameter("validdate");
		int pushtype = UtilHelp.strToInt(req.getParameter("pushtype"));//0 不推送,1 推送
		
		// 验证参数，|| UtilHelp.isNullStr(username) || UtilHelp.isNullStr(phone) || UtilHelp.isNullStr(carnumber) 
		//|| UtilHelp.isNullStr(start) || UtilHelp.isNullStr(stop) || price.equals(UtilHelp.BIGDECIMAL_ZERO)
		if (userid <= 0
				|| !isValidPlace(startid, start, startshortname, startcityid,
						startcityname, startprvid, startprvname, stopid, stop,
						stopshortname, stopcityid, stopcityname, stopprvid,
						stopprvname) 
				|| quantity <= 0 || UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim())) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布车讯信息失败！");
			return;
		}
		username = UtilHelp.trimStr(username);
		phone = UtilHelp.trimStr(phone);
		carnumber = UtilHelp.trimStr(carnumber);
		start = UtilHelp.trimStr(start);
		startshortname = UtilHelp.trimStr(startshortname);
		startcityname = UtilHelp.trimStr(startcityname);
		startprvname = UtilHelp.trimStr(startprvname);
		stop = UtilHelp.trimStr(stop);
		stopshortname = UtilHelp.trimStr(stopshortname);
		stopcityname = UtilHelp.trimStr(stopcityname);
		stopprvname = UtilHelp.trimStr(stopprvname);
		validdate = UtilHelp.setValiddateTime(validdate);
		
		// 封装车讯信息
//		TransportSupply transportSupply = new TransportSupply(userid, username, phone, carnumber, null, start.trim(), stop.trim(), price, quantity, validdate.trim(), 1, 0);
		int sortnumber = 1;
		int status = 0;
		TransportSupply transportSupply = new TransportSupply(userid, username,
				phone, carnumber, start, stop, price, quantity, validdate,
				sortnumber, status, startid, startcityid, startcityname,
				startprvid, startprvname, startshortname, stopid, stopcityid,
				stopcityname, stopprvid, stopprvname, stopshortname);
		//发布车讯信息，添加到推送任务
		int id = transportSupplyService.addTransportSupplyAndPushTask(transportSupply, pushtype);
		if(id > 0){
			WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, id+"", null);
			logger.debug("发布车讯信息成功，"+ (pushtype == 1?"需推送并添加到推送任务":"不需推送"));
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("发布车讯信息失败！");
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
		return
				UtilHelp.isNotNullStr(startprvname)
//				&& UtilHelp.isNotNullStr(startcityname)
				&& UtilHelp.isNotNullStr(stopprvname)
//				&& UtilHelp.isNotNullStr(stopcityname)
				;
	}

	public void setTransportSupplyService(
			ITransportSupplyService transportSupplyService) {
		this.transportSupplyService = transportSupplyService;
	}
	
}
