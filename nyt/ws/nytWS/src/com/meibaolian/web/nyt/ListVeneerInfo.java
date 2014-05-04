package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.service.nyt.IVennerInfoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 桉木求购信息查询
 * @author llm
 *  
 */
public class ListVeneerInfo extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ListVeneerInfo.class);
	private IVennerInfoService vennerInfoService;
	

	public void setVennerInfoService(IVennerInfoService vennerInfoService) {
		this.vennerInfoService = vennerInfoService;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));//
		int page = UtilHelp.strToInt(req.getParameter("page"));
		int pageSize = UtilHelp.strToInt(req.getParameter("pageSize"));
		String length=UtilHelp.strNotNull(req.getParameter("length"));//长
		String width=UtilHelp.strNotNull(req.getParameter("width"));//宽
		String thicknessint=UtilHelp.strNotNull(req.getParameter("thicknessint"));//厚
		String pricesort=UtilHelp.strNotNull(req.getParameter("pricesort"));//价格排序
		String averagethicknesssort=UtilHelp.strNotNull(req.getParameter("averagethicknesssort"));//均厚排序
		String referencesort=UtilHelp.strNotNull(req.getParameter("reference"));//参考用途排序
		String levelsort=UtilHelp.strNotNull(req.getParameter("level"));//等级排序

		if(page==0)
		{
			page=1;
		}
		if(pageSize==0)
		{
			pageSize = 10;
		}
		
		//查询货讯信息
		QueryResult<VennerInfo> qr = null;
		try {
			qr = vennerInfoService.searchVennerInfo(userid,
					page, pageSize,length,width, thicknessint,pricesort, averagethicknesssort, referencesort, levelsort);
		} catch(NullPointerException e)
		{
			logger.error("查询桉木求购列表失败！",e);
		}catch (DataManagerException e) {
			logger.error("查询桉木求购列表失败！",e);
		}
		if(qr!=null){
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，查询桉木求购信息完成！");
		}else
		{
			Object obj = null;
			ResultType resultType=ResultType.NODATA;
			WebUtil.outputMsgObjJson(resp, resultType, obj);
		}
	}


	
	
}
