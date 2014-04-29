package com.meibaolian.web.user;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.meibaolian.util.ConfigUtil;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class UploadFile extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(UploadFile.class);

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String upfile = null;
		ResultType result = ResultType.SERVERFAIL;

		try {

			File uploadFile = new File(ConfigUtil.uploadPath);
			if (!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			File tempPathFile = new File(ConfigUtil.tempPath);
			if (!tempPathFile.exists()) {
				tempPathFile.mkdirs();
			}
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			factory.setRepository(tempPathFile);// 设置缓冲区目录

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(4194304 / 2); // 设置最大文件尺寸，这里是2MB

			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			if (items != null) {
				Iterator<FileItem> i = items.iterator();
				String userId = null;
				String token = null;
				while (i.hasNext()) {
					FileItem item = (FileItem) i.next();
					if (item.isFormField()) {
						if ("userid".equals(item.getFieldName())) {
							userId = item.getString();
						}
						if ("token".equals(item.getFieldName())) {
							token = item.getString();
						}

					} else {

						if ( token != null
								&& userId != null) {
//
							String cacheToken = WebUtil.getUserToken(userId);
							if (token.equalsIgnoreCase(cacheToken))
							{
								String fileName = item.getName();
								int last = fileName.lastIndexOf(".");
								if (fileName != null && last != -1) {
									// File fullFile = new
									// File(fi.getName());
									// String filePrefix=
									File iconFile = new File(
											ConfigUtil.uploadPath + "/"
													+ userId);
									if (!iconFile.exists()) {
										iconFile.mkdirs();
									}
									Calendar calender=Calendar.getInstance();
									String newFileName =  "" + calender.get(Calendar.YEAR)+(calender.get(Calendar.MONTH)+1)+calender.get(Calendar.DATE) 
											+  new Random().nextInt(10)+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) 
											+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) +new Random().nextInt(10) 
											+  new Random().nextInt(10)+new Random().nextInt(10)+new Random().nextInt(10) +new Random().nextInt(10) 
											+fileName.substring(last);;
									File savedFile = new File(iconFile,
											newFileName);
									item.write(savedFile);
									upfile ="/icon/"+userId+"/"+newFileName;
									result=ResultType.SUCCESS;
								}

							}else 
							{
								result=ResultType.TIMEOUT;
							}

						}

					}
				}
			}

		} catch (Exception e) {
			// 可以跳转出错页面
			logger.error(e);
		} finally {
         
			if(result==ResultType.SUCCESS)
			{
				WebUtil.outputMsgObjJson(response, result, ConfigUtil.IMAGEPREFIX, upfile, null, null);
			}else
			{
				WebUtil.outputMsgJson(response, result);
			}
		}

	}

}
