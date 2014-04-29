package com.meibaolian.action.otheraid;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.QualityControlDto;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.service.otheraid.IQualityControlService;
import com.meibaolian.util.UtilHelp;

public class SearchQualityControl extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQualityControlService qualityControlService;
	private QualityControlDto qualityControlDto = new QualityControlDto();

	public QualityControlDto getQualityControlDto() {
		return qualityControlDto;
	}

	public void setQualityControlDto(QualityControlDto qualityControlDto) {
		this.qualityControlDto = qualityControlDto;
	}

	public void setQualityControlService(
			IQualityControlService qualityControlService) {
		this.qualityControlService = qualityControlService;
	}



	public String search(){
		
		qualityControlDto.setKeyword( UtilHelp.trimStr(qualityControlDto.getKeyword()));
		
		QueryResult<QualityControl> qr = qualityControlService.searchList(qualityControlDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<QualityControl>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("qualityControlDto", qualityControlDto);
		return SUCCESS;
		
	}
	
}
