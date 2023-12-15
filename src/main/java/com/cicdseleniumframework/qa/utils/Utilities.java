package com.cicdseleniumframework.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;

	
	public static Object [][] getTestDataFromExcel(String sheetName) 
	{
		File file = new File(System.getProperty("user.dir")+"\\resources\\testdata.xlsx");
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fis = new FileInputStream(file);
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rowCount][columnCount];
		for (int i =0; i< rowCount;i++)
		{
			XSSFRow rowNum= sheet.getRow(i+1);
			for (int j =0; j< columnCount;j++)
			{
				XSSFCell cell= rowNum.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType)
				{
				case STRING:
				data[i][j] =cell.getStringCellValue();
				break;
				case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
					
			}
		}
		return data;
				}
	
	
	public static String captureScreenshot (WebDriver driver,String  testName)
	{
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\cicdseleniumframework\\Screenshots\\"+testName+".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}
	
}
