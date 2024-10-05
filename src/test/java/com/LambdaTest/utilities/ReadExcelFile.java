package com.LambdaTest.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
	FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	String formData;
	XSSFSheet sheet;
	Row row;
	
	DataFormatter formatter;
	
	public ReadExcelFile()
	{
		try 
		{
			 inputStream = new FileInputStream("C:\\Users\\HP\\deepak_workspace\\LearnPOM\\src\\test\\resources\\TestData\\FormData.xlsx");
			 workbook = new XSSFWorkbook(inputStream);
			 formatter = new DataFormatter();
		}
		catch (IOException e) {
            e.printStackTrace();
		}
	
	}
	
	 public void setSheetByName(String sheetName) {
	        sheet = workbook.getSheet(sheetName);
	    }
	 
	 
	 public int getRowCount() {
	        return sheet.getPhysicalNumberOfRows();
	    }

	    public int getColumnCount(int row) {
	        return sheet.getRow(row).getLastCellNum();
	    }
	    
	    
	    public String getCellData(int row, int col) {
	        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
	    }
	    
	    public void closeWorkbook() {
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
			

}
