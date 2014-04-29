package com.meibaolian.util.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

public class CompressFile
{

	
	/**
	 * 将文件压缩后 输出
	 * 
	 * @param file  需要压缩的文件
	 * @param path  压缩文件临时存放地
	 * @param response
	 * @throws Exception 
	 */
	public static void compressFile(File file,String path, HttpServletResponse response)
	{
			
		try
		{
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);

			String  compressName=file.getName().substring(0,file.getName().lastIndexOf("."))+".zip";
			
//			FileOutputStream fos = new FileOutputStream(compressName);
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			response.setContentType("application/x-gzip;charset=UTF-8");
		    response.setHeader("Content-disposition","attachment;filename="+compressName);
			ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());//
			ZipEntry ze = new ZipEntry(file.getName());//
			
			zos.putNextEntry(ze);//
			
			byte[] buf = new byte[1024];
			
			int len=-1;
			
			while ((len = bis.read(buf)) != -1)
			{
				zos.write(buf, 0, len);
				zos.flush();
			}
			bis.close();
			zos.close();
		//			OutputStream outp = response.getOutputStream();
//			InputStream input=new FileInputStream(new File(compressName));
//			len=-1;
//			while ((len = input.read(buf)) != -1)
//			{
//				outp.write(buf, 0, len);
//				outp.flush();
//			}
//			input.close();
//			outp.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

}
