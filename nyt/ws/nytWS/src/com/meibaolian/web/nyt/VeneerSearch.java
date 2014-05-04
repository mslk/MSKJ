package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.VennerSupplyInfo;
import com.meibaolian.service.nyt.IVeneerService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
import com.meibaolian.web.nyt.dto.VeneerDTo;

/** 
 * 单板供应查询  
 * @author Kawin
 * @version 1.0[2014.05.04 11:45]
 *
 */
public class VeneerSearch extends BaseServlet {
 
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListVeneerInfo.class);
	
	private IVeneerService veneerService;

	public void setVeneerService(IVeneerService veneerService) {
		this.veneerService = veneerService;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = UtilHelp.strToInt(request.getParameter("userid"));
		int page = UtilHelp.strToInt(request.getParameter("page"));
		int pageSize = UtilHelp.strToInt(request.getParameter("pageSize"));

		if (page <= 0)
			page = ConfigUtil.PAGE;
		if (pageSize <= 0)
			pageSize = ConfigUtil.PAGESIZE;
		
		//类型 1 供应 2 求购
		int type = UtilHelp.strToInt(request.getParameter("type"));
		//关键字
		String key = UtilHelp.strNotNull(request.getParameter("key"));
		//长
		String length = UtilHelp.strNotNull(request.getParameter("length"));
		//宽
		String width = UtilHelp.strNotNull(request.getParameter("width"));
		//厚
		String thicknessint = UtilHelp.strNotNull(request.getParameter("thicknessint"));
		//价格排序
		int priceOrder = UtilHelp.strToInt(request.getParameter("priceOrder"));
		//均厚排序
		int averagethicknesssort = UtilHelp.strToInt(request.getParameter("averagethicknessOrder"));
		//大于等于平均厚度
		String averagethickness = UtilHelp.strNotNull(request.getParameter("averagethickness"));
		//参考用途
		String reference = UtilHelp.strNotNull(request.getParameter("reference")); 
		//等级
		String level = UtilHelp.strNotNull(request.getParameter("level"));
		//拼板
		String panel = UtilHelp.strNotNull(request.getParameter("panel"));
		//交货地址
		String place_receipt = UtilHelp.strNotNull(request.getParameter("place_receipt"));

		VeneerDTo dto = new VeneerDTo();
		dto.setUserid(userid);
		dto.setType(type);
		dto.setKey(key);
		dto.setLength(length);
		dto.setWidth(width);
		dto.setThicknessint(thicknessint);
		dto.setPricesort(priceOrder);
		dto.setAveragethicknesssort(averagethicknesssort);
		dto.setAveragethickness(averagethickness);
		dto.setReference(reference);
		dto.setLevel(level);
		dto.setPanel(panel);
		dto.setPlace_receipt(place_receipt);

		ResultType result = ResultType.SERVERFAIL;

		if(userid == 0){//未登陆
			QueryResult<VennerSupplyInfo> list = null;
			try {
				list = veneerService.searchBase(page, pageSize, dto);
				if (list == null || list.getList() == null
						|| list.getList().size() == 0) {
					result = ResultType.NODATA;
				} else {
					WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
							+ "", pageSize + "", list.getCountNumber() + "",  list.getList());
					return;
				}
			} catch (DataManagerException e) {
				logger.error(e);
			}
			 
		}else{
			//登陆
			QueryResult<VennerSupplyInfo> list = null;
			try {
				list = veneerService.search(page, pageSize, dto);
				if (list == null || list.getList() == null
						|| list.getList().size() == 0) {
					result = ResultType.NODATA;
				} else {
					WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
							+ "", pageSize + "", list.getCountNumber() + "", list);
					return;
				}
			} catch (DataManagerException e) {
				logger.error(e);
			}
		}
		WebUtil.outputMsgJson(response, result);
	}
 
}
