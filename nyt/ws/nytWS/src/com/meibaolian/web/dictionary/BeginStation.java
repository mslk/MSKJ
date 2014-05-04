package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.BeginStationEntity;
import com.meibaolian.service.dictionary.IBeginStationService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class BeginStation extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IBeginStationService beginStationService;

	public void setBeginStationService(IBeginStationService beginStationService) {
		this.beginStationService = beginStationService;
	}

	Logger logger = Logger.getLogger(BeginStation.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultType type = ResultType.SERVERFAIL;
		List<BeginStationEntity> list=null;
		try {
			list = beginStationService.searchAll();
			if(list!=null){
			type=ResultType.SUCCESS;
			}else{
				type=ResultType.NODATA;
			}
			
		} catch (DataManagerException e) {
			logger.error("", e);
		}
		WebUtil.outputMsgObjJson(response, type, list);

	}

}
