package com.meibaolian.web.provider;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.service.provider.IProviderService;
import com.meibaolian.service.searchlog.ISearchlogService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 查询出售单
 * 
 * @author llm
 * 
 */
public class SearchProvider extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(SearchProvider.class);

	private ISearchlogService searchlogService;
	private IProviderService providerService;
	
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
//		if(price.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			minprice = price.subtract(priceoffset);
//			maxprice = price.add(priceoffset);
//		}
//		if(taxprice.compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
//			mintaxprice = taxprice.subtract(taxpriceoffset);
//			maxtaxprice = taxprice.add(taxpriceoffset);
//		}
		//
//		String transportypeStr = req.getParameter("transportype");
//		String transportypeStr = null;
		String place = req.getParameter("place");
		Integer placeid = UtilHelp.strToInt(req.getParameter("placeid"));
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
		
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		
		// 验证参数
		/*if (userid <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，买方查询出售单失败！");
			return;
		}*/
		
//		Integer transportype = UtilHelp.isNullStr(transportypeStr) ? null : UtilHelp.strToInt(transportypeStr);
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
//		String coalname = ConfigUtil.coalTypeNameMap.get(coaltype);
		//解码中文字段并去掉两端空格
		coalname = UtilHelp.doubleDecode(coalname);
		coalsizename = UtilHelp.doubleDecode(coalsizename);
		place = UtilHelp.doubleDecode(place);
		startcountyname = UtilHelp.doubleDecode(startcountyname);
		startcityname = UtilHelp.doubleDecode(startcityname);
		startprvname = UtilHelp.doubleDecode(startprvname);
		receiptplace = UtilHelp.doubleDecode(receiptplace);
		stopcityname = UtilHelp.doubleDecode(stopcityname); 
		stopprvname = UtilHelp.doubleDecode(stopprvname); 
//		buyername = UtilHelp.doubleDecode(buyername);
		// 封装查询条件
		SearchlogCoal searchlog = new SearchlogCoal(userid, coaltype, coalname,
				minheatingtype, maxheatingtype, mincoalsize, maxcoalsize,
				minsulphur, maxsulphur, minash, maxash, minmoisture,
				maxmoisture, null, null, null, null,
				place, receiptplace, ConfigUtil.searchtype_Provider,
				coalsizename, placeid, startcountyid, startcountyname,
				startcityid, startcityname, startprvid, startprvname,
				receiptplaceid, stopcityid, stopcityname, stopprvid,
				stopprvname, stopshortname);
		// 查询数据
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_PROVIDER_RATE);
		QueryResult<ProviderJson> qr = null;
		try {
			qr = providerService.searchProvidersWithRate(searchlog, page, pageSize,
					orders);
		} catch (DataManagerException e) {
			logger.error("买方查询出售单数据失败！", e);
		}
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，买方查询出售单完成！");
		} else {
			WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
					.getPageSize(), qr.getCountNumber());
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，买方查询出售单完成！");
		}
		
		// 记录查询条件
		int count = searchlogService.addSearchLog(searchlog);// 查询条件为空不记录
		if(count > 0)
			logger.debug("记录买方查询条件完成！");
		else
			logger.debug("买方查询条件为空,不记录！");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	public void setSearchlogService(ISearchlogService searchlogService) {
		this.searchlogService = searchlogService;
	}

	public void setProviderService(IProviderService providerService) {
		this.providerService = providerService;
	}



}
