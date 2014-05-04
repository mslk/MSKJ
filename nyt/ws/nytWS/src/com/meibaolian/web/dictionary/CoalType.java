package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.CoalTypeEntity;
import com.meibaolian.service.dictionary.ICoalTypeService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class CoalType extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger logger =Logger.getLogger(CoalType.class);
	
	ICoalTypeService coalTypeService;
	
	public void setCoalTypeService(ICoalTypeService coalTypeService) {
		this.coalTypeService = coalTypeService;
	}



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ResultType result=ResultType.SERVERFAIL;
		
		List<CoalTypeEntity> list=null;
		
		try {
			list=coalTypeService.searchAll();
			if(list!=null && list.size()>0){
			  result=ResultType.SUCCESS;
			}else
			{
				result=ResultType.NODATA;	
			}
		} catch (DataManagerException e) {
			logger.error(e);
		}
		
		WebUtil.outputMsgObjJson(response, result, list);
		
		
		
	}
	
	
	

}
