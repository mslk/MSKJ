package com.meibaolian.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static List<String[]> getDataListFromFile(File file) throws InvalidFormatException, FileNotFoundException, IOException{
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		int sheetNum = wb.getNumberOfSheets();
		
		List<String[]> dataList = new ArrayList<String[]>();
		
		for (int i = 0; i < sheetNum; i++) {
			Sheet childSheet = wb.getSheetAt(i);
			int rowNum = childSheet.getLastRowNum();
			if(rowNum == 0){
				continue;
			}
			int cellNum = 0;
			for (int j = 0; j <= rowNum; j++) {
				//有多少条记录
				Row row = childSheet.getRow(j);
				if(j==0){
					//有多少列
					cellNum = row.getLastCellNum();
					continue;
				}
				String[] dataRow = new String[cellNum];
				
				for (int k = 0; k < cellNum; k++)
				{  	
					Cell cell = row.getCell(k);
					String tmp = cell == null ? null :cell.toString();
					//为避免字段类型冲突，取为空值
					dataRow[k] = (tmp == null||"".equals(tmp.trim()) ? null : tmp.trim());
				}
				dataList.add(dataRow);
			}
		}
		return dataList;
	}
	
	
	public static void main(String[] args) {
		try {
			List<String[]> dataList = getDataListFromFile(new File("C:\\Documents and Settings\\Administrator\\桌面\\123.xls"));
			for(int i=0; i<dataList.size();i++){
				String[] row = dataList.get(i);
				for(int j=0;j<row.length;j++){
					System.out.print(row[j]+"\t");
				}
				System.out.println();
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

