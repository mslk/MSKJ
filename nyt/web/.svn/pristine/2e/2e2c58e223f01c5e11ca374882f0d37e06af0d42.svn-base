package com.meibaolian.action.otheraid;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.service.otheraid.IImportDateService;
import com.meibaolian.util.file.ExcelUtil;
/**
 * 导入交货地数据
 * @author llm
 *
 */
public class ImportPlaceData extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;
	private String fileName;
	private int type;
	private IImportDateService importDateService;
	private Logger logger = Logger.getLogger(ImportPlaceData.class);

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setImportDateService(IImportDateService importDateService) {
		this.importDateService = importDateService;
	}

	@Override
	public String execute() throws Exception {
		if(file == null || !file.exists()){
			logger.error("");
			return INPUT;
		}
		List<String[]> dataList = ExcelUtil.getDataListFromFile(file);
		importDateService.importPlaceData(dataList, type);
		logger.info("");
		return SUCCESS;
	}

	
	
	
}
