package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.StationEntity;
import com.meibaolian.service.dictionary.IStationService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class Station extends BaseServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IStationService stationService;
	
	public void setStationService(IStationService stationService) {
		this.stationService = stationService;
	}

	Logger logger =Logger.getLogger(Station.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cityId=UtilHelp.strToInt(request.getParameter("cityid"));
		
		List<StationEntity> list=null;
		ResultType resultType=ResultType.SERVERFAIL;
		
		try {
			list=stationService.searchByCity(cityId);
			resultType=ResultType.SUCCESS;
		} catch (DataManagerException e) {
			logger.error(e);
		}
		WebUtil.outputMsgObjJson(response, resultType, list);
		
	}
	
	
	

}
