package com.meibaolian.action.coalparticlesize;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.service.coalparticlesize.ICoalParticleSizeService;

public class CoalParticleSizeSearch extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	ICoalParticleSizeService coalParticleSizeService;
	
	private int coalTypeId;
	
	private String coalTypeName;
	
	public int getCoalTypeId() {
		return coalTypeId;
	}

	public void setCoalTypeId(int coalTypeId) {
		this.coalTypeId = coalTypeId;
	}

	public String getCoalTypeName() {
		return coalTypeName;
	}
	public void setCoalTypeName(String coalTypeName) {
		this.coalTypeName = coalTypeName;
	}
	

	public void setCoalParticleSizeService(
			ICoalParticleSizeService coalParticleSizeService) {
		this.coalParticleSizeService = coalParticleSizeService;
	}

	
	
	
	@Override
	public String execute() throws Exception {
		QueryResult<CoalParticleSize> queryResult=coalParticleSizeService.searchByType(getPage(), PAGESIZE, coalTypeId);
		savePageView(new PageView<CoalParticleSize>(queryResult, getPage(), PAGESIZE));
		return SUCCESS;
	}
	
	
	
	

}
