package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.EndCountyEntity;
import com.meibaolian.entity.EndStationJson;
import com.meibaolian.entity.ProvinceEntity;
import com.meibaolian.service.dictionary.IProvinceService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 省市接口
 * @author Administrator
 *
 */
public class Provinces extends BaseServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IProvinceService provinceService;
	
	public void setProvinceService(IProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	Logger logger =Logger.getLogger(Provinces.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<EndStationJson> resultList=null;
		ResultType resultType=ResultType.SERVERFAIL;
		 
		try {
			List<ProvinceEntity> countyList = provinceService.searchAllProvinceAndCity();
			
			if(countyList!=null && countyList.size()>0)
			{
				resultList=new ArrayList<EndStationJson>();
				resultType=ResultType.SUCCESS;
				for(ProvinceEntity entity:countyList)
				{
					EndStationJson endStationJson=findParentId(resultList,entity.getProvinceId());
						
					if(endStationJson==null)
					{
						endStationJson=new EndStationJson(entity.getProvinceId(),entity.getProvinceName());
						resultList.add(endStationJson);
					}
					endStationJson.addEndCountyEntity(
							new EndCountyEntity(entity.getCityId(), entity.getCityName()));
				    	
				}
				
			}
			
			
		} catch (DataManagerException e) {
			logger.debug(e);
		}
		
		 WebUtil.outputMsgObjJson(response, resultType, resultList);

		
		
	}
	
	public EndStationJson findParentId(List<EndStationJson> resultList, int type) {
		EndStationJson endStationJson = null;
		
		for (EndStationJson entity : resultList) 
		{
			if (entity.getParentid() == type) {
				endStationJson = entity;
				break;
			}
		}
		return endStationJson;
	}

	

}
