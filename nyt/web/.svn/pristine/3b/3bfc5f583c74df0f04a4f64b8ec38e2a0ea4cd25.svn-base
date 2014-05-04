package com.meibaolian.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.WebUtil;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;

public class FileUpHelp {
	
	
	/**
	 * 上传文件
	 * @param request
	 * @param
	 * @param fileName
	 * @param file
	 * @return
	 */
	private static final int BUFFER_SIZE = 16 * 1024;
	
	 static Logger logger =Logger.getLogger(FileUpHelp.class);
	
	/**
	 * @param type  
	 *              1 为帮助中心 信息--》服务
	 *              2 为帮助中心 物流--》 新闻
	 *              3 为帮助中心 融资
	 *              4 为广告
	 *              5 帮助中心图片上传地址
	 *              6 android apk 上传目录
	 *          
	 * @return
	 */
	public static String upFile(File file,String fileName,int type)
	{
		return upFile(WebUtil.getRequest(),getLocalPath(type),fileName,file,"");
	}
	
	public static String upFile(File file,String fileName,String fileSuffix,int type)
	{
		return upFile(WebUtil.getRequest(),getLocalPath(type),fileName,file,fileSuffix);
	}
	public static String upFile(HttpServletRequest request,String path,String fileName,File file,String fileSuffix){
		
		
//		if(!FileTypeConfig.validateImageFormat(fileName))
//			return null;
		
		if(request==null  || "".equals(UtilHelp.notNullStr(fileName)) || "".equals(UtilHelp.notNullStr(fileName))  || file==null) return null;
		
//		String result=request.getSession().getServletContext().getRealPath(path);
		
		String rootPath = ConfigUtil.FILEROOTPATH;
		File  fileP= null;
		if (rootPath==null || "".equals(rootPath)) {
			rootPath = request.getSession().getServletContext().getRealPath(path);
			fileP = new File(rootPath);
		}else {			
			fileP = new File(rootPath+path);
		}
		
		if(!fileP.exists()) fileP.mkdirs();
		
		Calendar calender=Calendar.getInstance();
		
		fileName= "" + calender.get(Calendar.YEAR)+(calender.get(Calendar.MONTH)+1)+calender.get(Calendar.DATE) 
		+  new Random().nextInt(10)+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) 
		+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) +new Random().nextInt(10) 
		+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) +new Random().nextInt(10) 
		+ ("".equals(fileSuffix)?"":"-"+fileSuffix)+ fileName.substring(fileName.lastIndexOf("."));
//		fileName=  new Random(10)+ "" + + fileName.substring(fileName.lastIndexOf("."));
		File newFile=new File(fileP,fileName);
		InputStream  input=null;
		OutputStream out=null;
		try {
			
			  input=new BufferedInputStream(new FileInputStream(file),BUFFER_SIZE);
			  out=new BufferedOutputStream(new FileOutputStream(newFile),BUFFER_SIZE);
			int len=-1;
			byte [] b=new byte[1024];
			
			while((len=input.read(b))!=-1){
				out.write(b, 0, len);
			}
			return UtilHelp.replace("\\\\", "/", path+File.separator+fileName) ;
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		finally{
			
			try {
				if(out!=null)
				out.close();
			} catch (IOException e) {
				logger.error(e);
			}finally{
				try {
					if(input!=null)
						input.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return null; 
	}
	
	/**
	 * 封装上传地址
	 * @param type  
	 *              1 为帮助中心 信息
	 *              2 为帮助中心 物流
	 *              3 为帮助中心 融资
	 *              4 为广告
	 *              5 帮助中心图片上传地址
	 *              6 android apk 上传目录
	 * @return
	 */
	public static String getLocalPath(int type){
		StringBuffer stringBuffer = new StringBuffer().append(File.separator);
		switch (type) {
		case 1:
			stringBuffer.append("message").append(File.separator);
			break;
		case 2:
			stringBuffer.append("logistic").append(File.separator);
			break;
		case 3:
			stringBuffer.append("finance").append(File.separator);
			break;
		case 4:
			stringBuffer.append("adv").append(File.separator);
			break;
		case 5:
			stringBuffer.append("helpcenter").append(File.separator);
			break;
		case 6:
			stringBuffer.append("android").append(File.separator);
			break;
		default:
			break;
		}
		stringBuffer.append(Calendar.getInstance().get(Calendar.YEAR)).append(File.separator);
		stringBuffer.append((Calendar.getInstance().get(Calendar.MONTH)+1)).append(File.separator);
		stringBuffer.append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).append(File.separator);
		return stringBuffer.toString();
	}
	
	public static String getSendUrlPath(){
		StringBuffer stringBuffer = new StringBuffer("file").append(File.separator);
		stringBuffer.append("sendToCustList");
		return stringBuffer.toString();
	}
	
	/**
	  * 判断文件是否存在
	  * 
	  * @return
	  */
	 public static boolean isFileExists(String filePath) {
//		 filepath.replaceAll("/", File.separator);
//		 filepath.replaceAll("\\", File.separator);
//		 String filePath = filepath;
		 filePath = filePath.replace("/", File.separator);
		 filePath = filePath.replace("\\", File.separator);
	
	  File f = new File(filePath);
	  if (f.exists()) {// 检查File.txt是否存在
	   return true;
	  } else {
	   return false;
	  }

	 }
}
