package com.QA.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	

	private static String TEST_DATA_SHEET = ".\\src\\test\\resources\\TestData\\AutomationData.xlsx";
	private static Workbook wb;
	private static Sheet sh;
	private static Row row;
	
	public static Object[][] getTestData(String sheetName) {
		System.out.println(sheetName);
		
		Object[][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET);			
			wb = WorkbookFactory.create(fis);		
			sh = wb.getSheet(sheetName);
			
			data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sh.getLastRowNum();i++) {
				for(int j=0; j<sh.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sh.getRow(i+1).getCell(j).toString();
					
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	

	
}
