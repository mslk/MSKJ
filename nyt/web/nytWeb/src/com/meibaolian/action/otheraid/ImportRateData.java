package com.meibaolian.action.otheraid;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.service.otheraid.IImportDateService;
import com.meibaolian.util.file.ExcelUtil;
/**
 * 导入运价数据
 * @author llm
 *
 */
public class ImportRateData extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;
	private String fileFileName;
	private String fileContentType;
	private int type;
	private IImportDateService importDateService;
	private Logger logger = Logger.getLogger(ImportRateData.class);

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public File getFile() {
		return file;
	}
	
	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public int getType() {
		return type;
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
//			logger.error("");
			super.saveMessage("未上传文件，请重新上传", null);
			return MESSAGE;
		}
		List<String[]> dataList = null;
		try {
			dataList = ExcelUtil.getDataListFromFile(file);
		} catch (Exception e) {
			logger.error("文件格式错误！");
			super.saveMessage("文件格式错误，必须是.xls/.xlsx文件！", null);
			return MESSAGE;
		}
		List<Integer> errDataList = importDateService.importRateData(dataList, type);
		if(!errDataList.isEmpty()){
			StringBuilder msg = new StringBuilder("数据导入完成，有错误。错误总数:");
			msg.append(errDataList.size()).append("条，数据行号:[");
			for(int i=0;i<errDataList.size();i++){
				msg.append(errDataList.get(i));
				if(i+1 == errDataList.size()){
					msg.append("]。");
				}else{
					msg.append(",");
				}
			}
			msg.append("错误数据请修正后再导入。");
			super.saveMessage(msg.toString(), null);
			logger.info(msg.toString());
			return MESSAGE;
		}
//		logger.info("");
		super.saveMessage("数据导入全部成功！", null);
		return MESSAGE;
	}

	public String skipToPage(){
		return SUCCESS;
	}
	
	
}
