package com.meibaolian.action.otheraid;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.service.otheraid.IImportDateService;
import com.meibaolian.util.file.ExcelUtil;
/**
 * 导入站台数据
 * @author llm
 *
 */
public class ImportStationData extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;
	private String fileName;
	private IImportDateService importDateService;
	private Logger logger = Logger.getLogger(ImportStationData.class);

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		importDateService.importStationData(dataList);
		logger.info("");
		return SUCCESS;
	}

	
	
	
}
