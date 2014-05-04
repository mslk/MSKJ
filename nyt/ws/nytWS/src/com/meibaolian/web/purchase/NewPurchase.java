package com.meibaolian.web.purchase;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Purchase;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 买方发布求购单
 * @author llm
 *  
 */
public class NewPurchase extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(NewPurchase.class);
	private IPurchaseService purchaseService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int coaltype = UtilHelp.strToInt(req.getParameter("coaltype"));
		String coalname = req.getParameter("coalname");
		int coalsize = UtilHelp.strToInt(req.getParameter("coalsize"));
		String coalsizename = req.getParameter("coalsizename");
//		String buyername = req.getParameter("buyername");
		//====基准值
		int heating = UtilHelp.strToInt(req.getParameter("heating"));
		BigDecimal sulphur = UtilHelp.strToBigDecimal(req.getParameter("sulphur"));
		BigDecimal ash = UtilHelp.strToBigDecimal(req.getParameter("ash"));
		BigDecimal moisture = UtilHelp.strToBigDecimal(req.getParameter("moisture"));
//		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
//		BigDecimal taxprice = UtilHelp.strToBigDecimal(req.getParameter("taxprice"));
//		BigDecimal price = UtilHelp.BIGDECIMAL_ZERO;
//		BigDecimal taxprice = UtilHelp.BIGDECIMAL_ZERO;
		//====偏移值
		int heatingoffset = UtilHelp.strToInt(req.getParameter("heatingoffset"));
//		int coalsizeoffset = UtilHelp.strToInt(req.getParameter("coalsizeoffset"));
		BigDecimal sulphuroffset = UtilHelp.strToBigDecimal(req.getParameter("sulphuroffset"));
		BigDecimal ashoffset = UtilHelp.strToBigDecimal(req.getParameter("ashoffset"));
		BigDecimal moistureoffset = UtilHelp.strToBigDecimal(req.getParameter("moistureoffset"));
//		BigDecimal priceoffset = UtilHelp.strToBigDecimal(req.getParameter("priceoffset"));
//		BigDecimal taxpriceoffset = UtilHelp.strToBigDecimal(req.getParameter("taxpriceoffset"));
		//====大小范围值
		int minheatingtype = 0;
		int maxheatingtype = 0;
		int mincoalsize = 0;
		int maxcoalsize = 0;
		BigDecimal minsulphur = UtilHelp.BIGDECIMAL_ZERO;
		BigDecimal maxsulphur = UtilHelp.BIGDECIMAL_ZERO;
		BigDecimal minash = UtilHelp.BIGDECIMAL_ZERO;
		BigDecimal maxash = UtilHelp.BIGDECIMAL_ZERO;
		BigDecimal minmoisture = UtilHelp.BIGDECIMAL_ZERO;
		BigDecimal maxmoisture = UtilHelp.BIGDECIMAL_ZERO;
//		BigDecimal minprice = UtilHelp.BIGDECIMAL_ZERO;
//		BigDecimal maxprice = UtilHelp.BIGDECIMAL_ZERO;
//		BigDecimal mintaxprice = UtilHelp.BIGDECIMAL_ZERO;
//		BigDecimal maxtaxprice = UtilHelp.BIGDECIMAL_ZERO;
		
		if(heating > 0){
			minheatingtype = heating - heatingoffset;
			maxheatingtype = heating + heatingoffset;
		} 
		if(coalsize > 0){
			mincoalsize = coalsize;
			maxcoalsize = coalsize;
		}
		if(sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			minsulphur = sulphur.subtract(sulphuroffset);
			maxsulphur = sulphur.add(sulphuroffset) ;
		}
		if(ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			minash = ash.subtract(ashoffset);
			maxash = ash.add(ashoffset);
		}
		if(moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			minmoisture = moisture.subtract( moistureoffset);
			maxmoisture = moisture.add(moistureoffset);
		}
		/*if(price.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			minprice = price.subtract(priceoffset);
			maxprice = price.add(priceoffset);
		}
		if(taxprice.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			mintaxprice = taxprice.subtract(taxpriceoffset);
			maxtaxprice = taxprice.add(taxpriceoffset);
		}*/
		//
		String validdate = req.getParameter("validdate");
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
//		String transportypeStr = req.getParameter("transportype");
		
		Integer placeid = UtilHelp.strToInt(req.getParameter("placeid"));
		String place = req.getParameter("place");//交货地
		String startshortname = req.getParameter("startshortname");//交货地简称
		Integer startcountyid = UtilHelp.strToInt(req.getParameter("startcountyid"));
		String startcountyname = req.getParameter("startcountyname");
		Integer startcityid = UtilHelp.strToInt(req.getParameter("startcityid"));
		String startcityname = req.getParameter("startcityname");
		Integer startprvid = UtilHelp.strToInt(req.getParameter("startprvid"));
		String startprvname = req.getParameter("startprvname");
		//
		Integer receiptplaceid = UtilHelp.strToInt(req.getParameter("receiptplaceid"));//收货
		String receiptplace = req.getParameter("receiptplace");//收货地点
		String stopshortname = req.getParameter("stopshortname");//收货地简称
		Integer stopcityid = UtilHelp.strToInt(req.getParameter("stopcityid"));
		String stopcityname = req.getParameter("stopcityname");
		Integer stopprvid = UtilHelp.strToInt(req.getParameter("stopprvid"));
		String stopprvname = req.getParameter("stopprvname");
		
//		String phone = req.getParameter("phone");
		int pushtype = UtilHelp.strToInt(req.getParameter("pushtype"));//0 不推送,1 推送
		// 验证参数，
		boolean isCoal = checkCoal(coaltype, coalname, maxcoalsize,
				coalsizename, maxheatingtype, maxsulphur, maxash, maxmoisture);
		
		boolean isPlace = checkPlace(placeid, place, startshortname,
				startcountyid, startcountyname, startcityid, startcityname,
				startprvid, startprvname);
		
		boolean isReceiptPlace = checkReceiptPlace(receiptplaceid,
				receiptplace, stopshortname, stopcityid, stopcityname,
				stopprvid, stopprvname);
		
		if (!isCoal || !isPlace || !isReceiptPlace
				|| UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim()) || quantity <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布求购单信息失败！");
			return;
		}
//		validdate = UtilHelp.isNullStr(validdate) ? null : validdate;
//		Integer transportype = UtilHelp.isNullStr(transportypeStr) ? null : UtilHelp.strToInt(transportypeStr);
//		String coalname = ConfigUtil.coalTypeNameMap.get(coaltype);
		validdate = UtilHelp.setValiddateTime(validdate);
		//解码中文字段并去掉两端空格
		coalname = UtilHelp.doubleDecode(coalname);
		coalsizename = UtilHelp.doubleDecode(coalsizename);
		place = UtilHelp.doubleDecode(place);
		startshortname = UtilHelp.doubleDecode(startshortname);
		startcountyname = UtilHelp.doubleDecode(startcountyname);
		startcityname = UtilHelp.doubleDecode(startcityname);
		startprvname = UtilHelp.doubleDecode(startprvname);
		receiptplace = UtilHelp.doubleDecode(receiptplace);
		stopshortname = UtilHelp.doubleDecode(stopshortname);
		stopcityname = UtilHelp.doubleDecode(stopcityname);
		stopprvname = UtilHelp.doubleDecode(stopprvname);
//		buyername = UtilHelp.doubleDecode(buyername);
		// 封装查询条件
		SearchlogCoal searchlog = new SearchlogCoal(userid, coaltype, coalname,
				minheatingtype, maxheatingtype, mincoalsize, maxcoalsize,
				minsulphur, maxsulphur, minash, maxash, minmoisture,
				maxmoisture, null, null, null, null,
				place, null, ConfigUtil.searchtype_Provider,
				coalsizename, placeid, startcountyid, startcountyname,
				startcityid, startcityname, startprvid, startprvname);
		
		// 封装求购信息
		int sortnumber = 1;
		int status = 0;
		Purchase purchase = new Purchase(userid, coaltype, coalname, heating,
				coalsize, coalsizename, sulphur, ash, moisture,
				null, null, place, receiptplace, validdate,
				quantity, sortnumber, status, placeid, startcountyid,
				startcountyname, startcityid, startcityname, startprvid,
				startprvname, startshortname, receiptplaceid, stopcityid, stopcityname,
				stopprvid, stopprvname, stopshortname);
		//发布求购信息，添加到推送任务
		int id = 0;
		try {
			id = purchaseService.addPurchaseAndPushTask(purchase, searchlog, pushtype);
		} catch (DataManagerException e) {
			logger.error("发布求购信息失败！",e);
		}
		if(id > 0){
			WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, id+"", null);
			logger.debug("发布求购信息成功，"+ (pushtype == 1?"需推送并添加到推送任务":"不需推送"));
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("发布求购信息失败！");
		}
	}

	/**
	 * 验证煤质指标，true通过
	 * @param coaltype
	 * @param coalname
	 * @param coalsize
	 * @param coalsizename
	 * @param heating
	 * @param sulphur
	 * @param ash
	 * @param moisture
	 * @return
	 */
	private boolean checkCoal(int coaltype, String coalname, int coalsize,
			String coalsizename, int heating, BigDecimal sulphur,
			BigDecimal ash, BigDecimal moisture) {
		/*return !((coaltype <= 0 && UtilHelp.isNullStr(coalname))
				|| (coalsize <= 0 && UtilHelp.isNullStr(coalsizename))
				|| heating <= 0);*/
		return !( UtilHelp.isNullStr(coalname)
				|| UtilHelp.isNullStr(coalsizename)
				|| heating <= 0);
	}
	/**
	 * 验证交货地，true通过
	 * @param placeid
	 * @param place
	 * @param startshortname
	 * @param startcountyid
	 * @param startcountyname
	 * @param startcityid
	 * @param startcityname
	 * @param startprvid
	 * @param startprvname
	 * @return
	 */
	private boolean checkPlace(Integer placeid, String place,
			String startshortname, Integer startcountyid,
			String startcountyname, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname) {
		/*return ((placeid >0 || UtilHelp.isNotNullStr(place) 
				|| startcountyid > 0 || UtilHelp.isNotNullStr(startcountyname)
				|| startcityid > 0 || UtilHelp.isNotNullStr(startcityname)
				|| startprvid > 0 || UtilHelp.isNotNullStr(startprvname))
			&& 
			((startcountyid <= 0 && UtilHelp.isNullStr(startcountyname) )
				|| (startcityid <= 0 && UtilHelp.isNullStr(startcityname)) 
				|| (startprvid <= 0 && UtilHelp.isNullStr(startprvname))));*/
		return !((UtilHelp.isNotNullStr(place) 
				|| UtilHelp.isNotNullStr(startcountyname)
				|| UtilHelp.isNotNullStr(startcityname)
				|| UtilHelp.isNotNullStr(startprvname))
			&& 
			(UtilHelp.isNullStr(startcountyname)
				|| UtilHelp.isNullStr(startcityname)
				|| UtilHelp.isNullStr(startprvname)));
	}
	/**
	 * 验证收货地，true通过
	 * @param receiptplaceid
	 * @param receiptplace
	 * @param stopshortname
	 * @param stopcityid
	 * @param stopcityname
	 * @param stopprvid
	 * @param stopprvname
	 * @return
	 */
	private boolean checkReceiptPlace(Integer receiptplaceid, String receiptplace, String stopshortname, Integer stopcityid, String stopcityname, Integer stopprvid, String stopprvname){
		/*return (receiptplaceid <= 0 && UtilHelp.isNullStr(receiptplace))
		|| (stopcityid <= 0 && UtilHelp.isNullStr(stopcityname))
		|| (stopprvid <= 0 && UtilHelp.isNullStr(stopprvname));*/
		return !(UtilHelp.isNullStr(receiptplace)
		|| UtilHelp.isNullStr(stopcityname)
		|| UtilHelp.isNullStr(stopprvname));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

}
