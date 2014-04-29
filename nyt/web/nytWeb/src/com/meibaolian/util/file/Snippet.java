package com.meibaolian.util.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Snippet {
	
	
	//存储运输起点 到终点的对应关系结构
	HashMap<String, List<DestinationEntity>> tran= new HashMap<String, List<DestinationEntity>>();
	
	
	public static void main(String[] args) throws InvalidFormatException, FileNotFoundException, IOException 
	{
		
		String fileName = "d:/1.xls";
		Workbook wb = WorkbookFactory.create(new FileInputStream(fileName));
		int sheetNum = wb.getNumberOfSheets();
	
		for (int i = 0; i < sheetNum; i++) {
			Sheet childSheet = wb.getSheetAt(i);
			int rowNum = childSheet.getLastRowNum();
	        
			DestinationEntity entity=null;
			
			for (int j = 0; j < rowNum; j++) {
				//有多少条记录
				Row row = childSheet.getRow(j);
				entity=new DestinationEntity();
				//有多少列
				int cellNum = row.getLastCellNum();
	
				for (int k = 0; k < cellNum; k++)
				{
					   	
					if(k==1 && row.getCell(k)!=null)
					{
					 entity.setTargetName(row.getCell(k).toString());
					 System.out.println(row.getCell(k).toString() + " - ");
					}else if(k==2 && row.getCell(k)!=null)
					{
//						entity.setFeight(Big)
					}
						
						
				}
				
				
			}
	
		}
	}
	
	
}

