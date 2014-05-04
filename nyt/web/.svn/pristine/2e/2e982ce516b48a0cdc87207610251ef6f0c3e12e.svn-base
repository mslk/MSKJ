package com.meibaolian.action.coaltype;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.CoalType;
import com.meibaolian.service.coaltype.ICoalTypeService;

public class CoaltypeManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ICoalTypeService coalTypeService;
	
	public void setCoalTypeService(ICoalTypeService coalTypeService) {
		this.coalTypeService = coalTypeService;
	}


	private String coalName;
	
	private int coalTypeId;

	public int getCoalTypeId() {
		return coalTypeId;
	}

	public void setCoalTypeId(int coalTypeId) {
		this.coalTypeId = coalTypeId;
	}

	public String getCoalName() {
		return coalName;
	}

	public void setCoalName(String coalName) {
		this.coalName = coalName;
	}





	/**
	 * 增加煤种
	 * @return
	 */
	public String add(){
		
		String messageValue;
		String targetUrlValue;
		
		if(coalName!=null && coalName.length()>0 && coalName.length()<=20)
		{
			targetUrlValue="coal/coaltypeSearch.action";
			if(coalTypeService.searchByCoalType(coalName)>0)
			{
				messageValue="煤种已存在，添加失败！";
			}else{
				coalTypeService.add(new CoalType(coalName));
				messageValue="添加成功！";
			}
		}else
		{
		    messageValue="添加失败，参数错误！";
			targetUrlValue="controller/coaltype/add.jsp";
		}
		
		saveMessage(messageValue, targetUrlValue);
		
		return MESSAGE;
	} 
	
	/**
	 * 删除煤种
	 * @return
	 */
	public String delete(){
		String messageValue;
		String 	targetUrlValue="coal/coaltypeSearch.action";
		if(coalTypeId>0)
		{
			coalTypeService.delete(coalTypeId);
			messageValue="煤种删除成功！";
		}else
		{
		    messageValue="煤种删除失败，参数错误！";
		}
		saveMessage(messageValue, targetUrlValue);
		return MESSAGE;
	} 
	
	

}
