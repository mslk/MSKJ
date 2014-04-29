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
public class VeneerInfoSerarch extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(VeneerInfoSerarch.class);
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
		String queryValue=UtilHelp.strNotNull(req.getParameter("queryValue"));//查询的值
		
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
					page, pageSize,queryValue);
		} catch(NullPointerException e)
		{
			logger.error("查询桉木供应列表失败！",e);
		}catch (DataManagerException e) {
			logger.error("查询桉木供应列表失败！",e);
		}
		if(qr!=null){
		WebUtil.outputSuccessJson(resp, qr.getList(), qr.getPage(), qr
				.getPageSize(), qr.getCountNumber());
		logger.debug("有数据(page:" + qr.getPage() + ",pagesize:"
				+ qr.getPageSize() + ",total:" + qr.getCountNumber()
				+ ")，查询桉木供应信息完成！");
		}else
		{
			Object obj = null;
			ResultType resultType=ResultType.NODATA;
			WebUtil.outputMsgObjJson(resp, resultType, obj);
		}
	}


	
	
}
