package com.meibaolian.web.nyt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.TypeListEntity;
import com.meibaolian.service.nyt.ITypeListService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
import com.meibaolian.web.dictionary.CoalType;

public class TypeList extends BaseServlet{
	private static final long serialVersionUID = 1L;

	Logger logger =Logger.getLogger(CoalType.class);
	
	ITypeListService typeListService;

	public void setTypeListService(ITypeListService typeListService) {
		this.typeListService = typeListService;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ResultType result=ResultType.SERVERFAIL;
		
		List<TypeListEntity> list=null;
		
		try {
			list=typeListService.searchAll();
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
