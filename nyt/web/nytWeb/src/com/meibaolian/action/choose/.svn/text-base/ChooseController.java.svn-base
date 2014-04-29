package com.meibaolian.action.choose;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.entity.CoalType;
import com.meibaolian.entity.DeliveryplaceType;
import com.meibaolian.service.coalparticlesize.ICoalParticleSizeService;
import com.meibaolian.service.coaltype.ICoalTypeService;
import com.meibaolian.service.deliveryplace.IDeliveryplaceTypeService;

public class ChooseController extends BaseAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int coalTypeId;
	
	private int type=1;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getCoalTypeId() {
		return coalTypeId;
	}
	public void setCoalTypeId(int coalTypeId) {
		this.coalTypeId = coalTypeId;
	}

	
	ICoalTypeService coalTypeService;
	
	ICoalParticleSizeService coalParticleSizeService;
	
	IDeliveryplaceTypeService deliveryplaceTypeService;
	
	public void setDeliveryplaceTypeService(
			IDeliveryplaceTypeService deliveryplaceTypeService) {
		this.deliveryplaceTypeService = deliveryplaceTypeService;
	}

	public void setCoalTypeService(ICoalTypeService coalTypeService) {
		this.coalTypeService = coalTypeService;
	}

	public void setCoalParticleSizeService(
			ICoalParticleSizeService coalParticleSizeService) {
		this.coalParticleSizeService = coalParticleSizeService;
	}

	/**
	 *  type   1  为煤种 选择
	 *         2 为煤种粒度选择
	 *         3 为交货地站台类型选择
	 */
	@Override
	public String execute() throws Exception
	{
		
		//跳转的地址 默认为煤种的选择页面
		String targetUrl="coaltype";
		
		PageView<?> result=null;
		
		//默认为煤种的 选择
		if(type==1)
		{
			result=new PageView<CoalType>(coalTypeService.search(getPage(), PAGESIZE), getPage(), PAGESIZE);
		}else if(type==2 && coalTypeId>0)
		{
			targetUrl="coalParticleSize";
			result=new PageView<CoalParticleSize>(coalParticleSizeService.searchByType(getPage(), PAGESIZE, coalTypeId),getPage(), PAGESIZE);
		}else if(type==3)
		{
			targetUrl="deliveryplacetype";
			result=new PageView<DeliveryplaceType>(deliveryplaceTypeService.search(getPage(), PAGESIZE), getPage(), PAGESIZE);
		}
		savePageView(result);
		
		return targetUrl;
	}
	
	
	
	
}
