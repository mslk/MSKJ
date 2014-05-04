package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.entity.CoalParticleSizeChildJson;
import com.meibaolian.entity.CoalParticleSizeJson;
import com.meibaolian.service.dictionary.ICoalParticleSizeService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class CoalParticleSizeType extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ICoalParticleSizeService coalParticleSizeService;

	public void setCoalParticleSizeService(
			ICoalParticleSizeService coalParticleSizeService) {
		this.coalParticleSizeService = coalParticleSizeService;
	}

	Logger logger = Logger.getLogger(CoalParticleSizeType.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<CoalParticleSizeJson> resultList = new ArrayList<CoalParticleSizeJson>();
	// coalTypeNameMap.put(0, "不限");
	// coalTypeNameMap.put(1, "动力煤");
	// coalTypeNameMap.put(2, "炼焦煤");
	// coalTypeNameMap.put(3, "无烟煤");
	// coalTypeNameMap.put(4, "喷吹煤");
	//resultList.add(new CoalParticleSizeJson(0, "不限"));
//		resultList.add(new CoalParticleSizeJson(1, "动力煤"));
//		resultList.add(new CoalParticleSizeJson(2, "炼焦煤"));
//		resultList.add(new CoalParticleSizeJson(3, "无烟煤"));
//		resultList.add(new CoalParticleSizeJson(4, "喷吹煤"));

		ResultType resultType = ResultType.SERVERFAIL;

		try {
			List<CoalParticleSize> countyList = coalParticleSizeService
					.searchAll();

			if (countyList != null && countyList.size() > 0) {
				for (CoalParticleSize entity : countyList) {
					CoalParticleSizeJson coalParticleSizeJson = findParentId(
							resultList, entity.getType());
					
					if (coalParticleSizeJson == null) {
						coalParticleSizeJson=new CoalParticleSizeJson();
						coalParticleSizeJson.setParentid(entity.getType());
						coalParticleSizeJson.setParentName(entity.getTypeName());
						resultList.add(coalParticleSizeJson);
					}
					coalParticleSizeJson.addCoalParticleSizeChildJson(new CoalParticleSizeChildJson(entity.getId(),entity.getName(),entity.getType()));
				}
				resultType = ResultType.SUCCESS;
			}
		} catch (DataManagerException e) {
			logger.debug(e);
		}

		WebUtil.outputMsgObjJson(response, resultType, resultList);
	}

	public CoalParticleSizeJson findParentId(
			List<CoalParticleSizeJson> resultList, int type) {
		CoalParticleSizeJson coalParticleSizeJson = null;
		
		for (CoalParticleSizeJson entity : resultList) {
			
			if (entity.getParentid() == type) {
				coalParticleSizeJson = entity;
				break;
			}
		}
		return coalParticleSizeJson;
	}

}
