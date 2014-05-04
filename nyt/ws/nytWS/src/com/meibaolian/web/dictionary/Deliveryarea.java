package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.DeliveryareaCityEntity;
import com.meibaolian.entity.DeliveryareaCountyEntity;
import com.meibaolian.entity.DeliveryareaEntity;
import com.meibaolian.entity.DeliveryareaProvinceEntity;
import com.meibaolian.service.dictionary.IDeliveryareaService;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class Deliveryarea  extends BaseServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IDeliveryareaService deliveryareaService;
	


	public void setDeliveryareaService(IDeliveryareaService deliveryareaService) {
		this.deliveryareaService = deliveryareaService;
	}


	Logger logger=Logger.getLogger(Deliveryarea.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<DeliveryareaProvinceEntity> list=null;
		
		ResultType result=ResultType.SERVERFAIL;
		try {
			List<DeliveryareaEntity>  searchList=deliveryareaService.searchAll();
			
			if(searchList!=null && searchList.size()>0)
			{
				list=new ArrayList<DeliveryareaProvinceEntity>();
				
				for(DeliveryareaEntity entity:searchList)
				{
                    DeliveryareaProvinceEntity provinceEntity=null;
                    
                    //查找省
					for(DeliveryareaProvinceEntity province: list)
					{
					    if(entity.getProvinceid().equals(province.getProvinceid())
					    		&& entity.getProvincename().equals(province.getProvincename()))
					    {
					    	provinceEntity=province;
					    	break;
					    }	
						
					}
					//省没有找到
					if(provinceEntity==null)
					{
						provinceEntity=new DeliveryareaProvinceEntity();
						provinceEntity.setProvinceid(entity.getProvinceid());
						provinceEntity.setProvincename(entity.getProvincename());
						list.add(provinceEntity);
					}
					
					//查找市
					DeliveryareaCityEntity cityEntity=null;
					
					for(DeliveryareaCityEntity city:provinceEntity.getList())
					{
						if(entity.getCityid().equals(city.getCityid())&&
								entity.getCityname().equals(city.getCityname()))
						{
							cityEntity=city;
							break;
						}
					}
					
					//市没有找到
					if(cityEntity==null)
					{
						cityEntity=new DeliveryareaCityEntity();
						cityEntity.setCityid(entity.getCityid());
						cityEntity.setCityname(entity.getCityname());
						provinceEntity.getList().add(cityEntity);
					}
					
					//查找县
					DeliveryareaCountyEntity countyEntity=null;
					for(DeliveryareaCountyEntity county:cityEntity.getList())
					{
						if(entity.getCountyid().equals(county.getCountyid())&&
								entity.getCountyname().equals(county.getCountyname()))
						{
							countyEntity=county;
							break;
						}
							
					}
					
					//县没有找到
					if(countyEntity==null)
					{
						countyEntity=new DeliveryareaCountyEntity();
						countyEntity.setCountyid(entity.getCountyid());
						countyEntity.setCountyname(entity.getCountyname());
						countyEntity.setShortcountyname(entity.getShortcountyname());
						cityEntity.getList().add(countyEntity);
					}
					
					
				}
				
			}

			
			
			if(list!=null && list.size()>0)
			{
			 result=ResultType.SUCCESS;
			}
			else
			{
			 result=ResultType.NODATA;
			}
			
		} catch (DataManagerException e) {
			logger.error(e);
		}
		WebUtil.outputMsgObjJson(response, result, list);
	}

	
	
	
	
	
}
