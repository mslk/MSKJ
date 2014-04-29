package com.meibaolian.web.transportDemand;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.County;
import com.meibaolian.entity.SearchlogTransport;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.entity.TransportDemandJson;
import com.meibaolian.service.dictionary.ICountyService;
import com.meibaolian.service.searchlog.ISearchlogService;
import com.meibaolian.service.transportDemand.ITransportDemandService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 查询货讯
 * @author llm
 *  
 */
public class SearchByKey extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(SearchByKey.class);
	private ITransportDemandService transportDemandService;
	private ICountyService countyService;
	private ISearchlogService searchlogService;
	//
	public void setCountyService(ICountyService countyService) {
		this.countyService = countyService;
	}


	public void setTransportDemandService(
			ITransportDemandService transportDemandService) {
		this.transportDemandService = transportDemandService;
	}
	
	public void setSearchlogService(ISearchlogService searchlogService) {
		this.searchlogService = searchlogService;
	}


	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String keyword = req.getParameter("keyword");
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		int order = UtilHelp.strToInt(req.getParameter("order"));
		// 验证参数
		/*if (userid <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布货讯信息失败！");
			return;
		}*/
		keyword = UtilHelp.trimStr(keyword);
		page = (page <= 0 ? -1 : page);
		pageSize = (pageSize <= 0 ? -1 : pageSize);
		LinkedHashMap<String, String> orders = ConfigUtil.getOrderMap(order, ConfigUtil.ORDERTYPE_TRANSPORTDEMAND);
		 
		TransportDemandJson result = null;
		QueryResult<County> cqr = null;
		QueryResult<TransportDemand> qr = null;
		County county = null;
		
		if(UtilHelp.isNullStr(keyword)){
			//查询全部货讯信息
			try {
				qr = transportDemandService.searchTransportDemand(null, null, page, pageSize, orders);
			} catch (DataManagerException e) {
				logger.debug("查询全部货讯信息失败！",e);
			}
		}else{
			//查询关键字匹配的收货地
			try {
				cqr = countyService.searchCounty(keyword);
			} catch (DataManagerException e) {
				logger.debug("关键字查询收货地失败！",e);
			}
			if(cqr == null || cqr.getList().isEmpty()){
				//无匹配的收货地，关键字查询货讯信息
				try {
					qr = transportDemandService.searchTransportDemand(null, keyword, page, pageSize, orders);
				} catch (DataManagerException e) {
					logger.debug("查询货讯信息失败！",e);
				}
			}else if(cqr != null && cqr.getList().size() > 1){//多个匹配的收货地，返回收货地
				result = new TransportDemandJson(cqr.getList(), null);
				WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, "", result);
				logger.debug("关键字匹配的收货地有多个,num="+cqr.getList().size());
//				return;
			}else if(cqr != null && cqr.getList().size() == 1){//1个匹配的收货地，返回货讯信息
				county = cqr.getList().get(0);
				//查询货讯信息
				try {
					qr = transportDemandService.searchTransportDemand(null, null, null,
							null, null, null, null, null, null, null, county.getProvinceid(), 
							county.getProvincename(), page, pageSize, orders);
				} catch (DataManagerException e) {
					logger.debug("查询货讯信息失败！",e);
				}
			}
		}
		//成功响应
		if (qr == null) {
			WebUtil.outputMsgJson(resp, ResultType.NODATA);
			logger.debug("无数据，查询货讯信息完成！");
		} else {
			result = new TransportDemandJson(null, qr.getList());
			WebUtil.outputMsgObjJson(resp, ResultType.SUCCESS, qr.getPage()+"", 
					qr.getPageSize()+"", qr.getCountNumber()+"", result);
			logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
					+ qr.getPageSize() + ",total:" + qr.getCountNumber()
					+ ")，查询货讯信息完成！");
		}
		//记录查询条件
		SearchlogTransport st = new SearchlogTransport(userid, null, keyword, ConfigUtil.searchtype_demand, county == null?null:county.getProvincename());
		int count = searchlogService.addSearchLog(st);
		if(count > 0){
			logger.debug("查询条件记录成功！");
		}else{
			logger.debug("查询条件记录失败！");
		}
	}

}
