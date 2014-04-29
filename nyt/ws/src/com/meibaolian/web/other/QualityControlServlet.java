package com.meibaolian.web.other;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.QualityControlEntityJson;
import com.meibaolian.service.other.IQualityControlService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class QualityControlServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IQualityControlService qualityControlService;

	public void setQualityControlService(
			IQualityControlService qualityControlService) {
		this.qualityControlService = qualityControlService;
	}

    Logger logger=Logger.getLogger(QualityControlServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String number=UtilHelp.strNotNull(request.getParameter("number"));
		
		ResultType result=ResultType.SERVERFAIL;
		
		List<QualityControlEntityJson> list=null;
		
		if(!"".equals(number))
		{
			try {
				list=qualityControlService.searchByNum(number);
				if(list!=null)
				{
				  result=ResultType.SUCCESS;
				}else
				{
					result=ResultType.NODATA;	
				}
			} catch (DataManagerException e){
				logger.error(e);
			}
		}else{
			result=ResultType.PARAMTER;
		}
		WebUtil.outputMsgObjJson(response, result, list);
		
		
	}
	
	
	

}
