package com.meibaolian.web.provider;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Provider;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 卖方发布出售单
 * @author llm
 * 
 */
public class NewProvider extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(NewProvider.class);
	private IProviderService providerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int coaltype = UtilHelp.strToInt(req.getParameter("coaltype"));
		String coalname = req.getParameter("coalname");
		int coalsize = UtilHelp.strToInt(req.getParameter("coalsize"));
		String coalsizename = req.getParameter("coalsizename");
		//====基准值 
		int heating = UtilHelp.strToInt(req.getParameter("heating"));
		BigDecimal sulphur = UtilHelp.strToBigDecimal(req.getParameter("sulphur"));
		BigDecimal ash = UtilHelp.strToBigDecimal(req.getParameter("ash"));
		BigDecimal moisture = UtilHelp.strToBigDecimal(req.getParameter("moisture"));
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		BigDecimal taxprice = UtilHelp.strToBigDecimal(req.getParameter("taxprice"));
		//====偏移值
//		int heatingoffset = UtilHelp.strToInt(req.getParameter("heatingoffset"));
////	int coalsizeoffset = UtilHelp.strToInt(req.getParameter("coalsizeoffset"));
//		BigDecimal sulphuroffset = UtilHelp.strToBigDecimal(req.getParameter("sulphuroffset"));
//		BigDecimal ashoffset = UtilHelp.strToBigDecimal(req.getParameter("ashoffset"));
//		BigDecimal moistureoffset = UtilHelp.strToBigDecimal(req.getParameter("moistureoffset"));
//		BigDecimal priceoffset = UtilHelp.strToBigDecimal(req.getParameter("priceoffset"));
//		BigDecimal taxpriceoffset = UtilHelp.strToBigDecimal(req.getParameter("taxpriceoffset"));
		//====大小范围值
		int minheatingtype = heating;
		int maxheatingtype = heating;
		int mincoalsize = coalsize;
		int maxcoalsize = coalsize;
		BigDecimal minsulphur = sulphur;
		BigDecimal maxsulphur = sulphur;
		BigDecimal minash = ash;
		BigDecimal maxash = ash;
		BigDecimal minmoisture = moisture;
		BigDecimal maxmoisture = moisture;
//		BigDecimal minprice = price;
//		BigDecimal maxprice = price;
//		BigDecimal mintaxprice = taxprice;
//		BigDecimal maxtaxprice = taxprice;
		
//		if(heating > 0){
//			minheatingtype = heating - heatingoffset;
//			maxheatingtype = heating + heatingoffset;
//		} 
//		if(coalsize > 0){
//			mincoalsize = coalsize;
//			maxcoalsize = coalsize;
//		}
//		if(sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			minsulphur = sulphur.subtract(sulphuroffset);
//			maxsulphur = sulphur.add(sulphuroffset) ;
//		}
//		if(ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			minash = ash.subtract(ashoffset);
//			maxash = ash.add(ashoffset);
//		}
//		if(moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			minmoisture = moisture.subtract( moistureoffset);
//			maxmoisture = moisture.add(moistureoffset);
//		}
//		if(price.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			minprice = price.subtract(priceoffset);
//			maxprice = price.add(priceoffset);
//		}
//		if(taxprice.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			mintaxprice = taxprice.subtract(taxpriceoffset);
//			maxtaxprice = taxprice.add(taxpriceoffset);
//		}
		//
		String validdate = req.getParameter("validdate");
		int quantity = UtilHelp.strToInt(req.getParameter("quantity"));
//		int transportype = UtilHelp.strToInt(req.getParameter("transportype"));
//		Integer transportype = null;
//		String sendoutplace = req.getParameter("sendoutplace");
//		String sendoutplace = null;
		Integer placeid = UtilHelp.strToInt(req.getParameter("placeid"));
		String place = req.getParameter("place");//交货地
		String startshortname = req.getParameter("startshortname");//交货地简称
		Integer startcountyid = UtilHelp.strToInt(req.getParameter("startcountyid"));
		String startcountyname = req.getParameter("startcountyname");
		Integer startcityid = UtilHelp.strToInt(req.getParameter("startcityid"));
		String startcityname = req.getParameter("startcityname");
		Integer startprvid = UtilHelp.strToInt(req.getParameter("startprvid"));
		String startprvname = req.getParameter("startprvname");
		
//		String phone = req.getParameter("phone");
		int pushtype = UtilHelp.strToInt(req.getParameter("pushtype"));//0 不推送,1 推送
		
		// 验证参数，
		boolean isCoal = checkCoal(coaltype, coalname, maxcoalsize,
				coalsizename, maxheatingtype, maxsulphur, maxash, maxmoisture);
		
		boolean isPlace = checkPlace(placeid, place, startshortname,
				startcountyid, startcountyname, startcityid, startcityname,
				startprvid, startprvname);

		if (!isCoal || !isPlace
				|| (price.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0 
						&& taxprice.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0)
				|| UtilHelp.isNullStr(validdate)
				|| !UtilHelp.isDateValid(validdate.trim()) || quantity < 40) {//
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布出售单信息失败！");
			return;
		}
		//解码中文字段并去掉两端空格
//		validdate = UtilHelp.isNullStr(validdate) ? null : validdate;
//		String coalname = ConfigUtil.coalTypeNameMap.get(coaltype);
//		sendoutplace = UtilHelp.doubleDecode(sendoutplace);
		validdate = UtilHelp.setValiddateTime(validdate);
		coalname = UtilHelp.doubleDecode(coalname);
		coalsizename = UtilHelp.doubleDecode(coalsizename);
		place = UtilHelp.doubleDecode(place);
		startshortname = UtilHelp.doubleDecode(startshortname);
		startcountyname = UtilHelp.doubleDecode(startcountyname);
		startcityname = UtilHelp.doubleDecode(startcityname);
		startprvname = UtilHelp.doubleDecode(startprvname);
		
		// 封装查询条件
		SearchlogCoal searchlog = new SearchlogCoal(userid, coaltype, coalname,
				minheatingtype, maxheatingtype, mincoalsize, maxcoalsize,
				minsulphur, maxsulphur, minash, maxash, minmoisture,
				maxmoisture, null, null, null, null, place, null,
				ConfigUtil.searchtype_Purchase, coalsizename, placeid,
				startcountyid, startcountyname, startcityid, startcityname,
				startprvid, startprvname);
		// 封装求购信息
		int sortnumber = 1;
		int status = 0;
		Provider provider = new Provider(userid, coaltype, coalname, heating,
				coalsize, coalsizename, sulphur, ash, moisture,
				price, taxprice, null, place, validdate,
				quantity, sortnumber, status, placeid, startcountyid,
				startcountyname, startcityid, startcityname, startprvid,
				startprvname, startshortname);
		//发布求购信息，添加到推送任务
		int id = 0;
		try {
			id = providerService.addProviderAndPushTask(provider, searchlog, pushtype);
		} catch (DataManagerException e) {
			logger.error("发布出售单信息失败！",e);
		}
		if(id > 0){
			WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, id+"", null);
			logger.debug("发布出售单信息成功，"+ (pushtype == 1?"需推送并添加到推送任务":"不需推送"));
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("发布出售单信息失败！");
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
				|| heating <= 0
				|| sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0);*/
		return !(  UtilHelp.isNullStr(coalname)
				|| UtilHelp.isNullStr(coalsizename)
				|| heating <= 0
				|| sulphur.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| ash.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0
				|| moisture.compareTo(UtilHelp.BIGDECIMAL_ZERO) <= 0);
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
		/*return !((startcountyid <= 0 && UtilHelp.isNullStr(startcountyname))
				|| (startcityid <= 0 && UtilHelp.isNullStr(startcityname)) 
				|| (startprvid <= 0 && UtilHelp.isNullStr(startprvname)));*/
		return !(UtilHelp.isNullStr(startcountyname)
				|| UtilHelp.isNullStr(startcityname) 
				|| UtilHelp.isNullStr(startprvname));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}
	
	


}
