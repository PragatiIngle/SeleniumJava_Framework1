package util;

//import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Excelutil 
{
	static String projectPath;
	static  XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	
	public Excelutil(String excelPath,String sheetName)
	{
		try
	{
			
	
		//projectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	}
	public static void main(String args[])
	{
		getRowCount();
		getCellDataString(0,0);
		getCellDataNum(1,1);
		
	}
	
	public static int getRowCount()
	{
		int rowCount=0;

		try { 
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			 rowCount= sheet.getPhysicalNumberOfRows();
			System.out.println("no.of rowsCount:" +rowCount);
			} 

		catch (Exception exp1) 
		{
			System.out.println(exp1.getMessage()); 
			System.out.println(exp1.getCause());
			exp1.printStackTrace();
		}
		return rowCount;

	}
	
	public static int getColumnCount()
	{
       int colCount=0;
		try { 
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			
			colCount= sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("no.of colCount:" +colCount);
			} 

		catch (Exception exp1) 
		{
			System.out.println(exp1.getMessage()); 
			System.out.println(exp1.getCause());
			exp1.printStackTrace();
		}
		return colCount;

	}


	public static String getCellDataString(int rowNum, int colNum)
	{
         String cellData=null;
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		}
		catch (Exception exp)
		{
			System.out.println(exp.getMessage()); 
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;

	}
	
	public static void getCellDataNum(int rowNum,int colNum)
	{

		try {
			
		
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			double celldata=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);
		
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage()); 
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
	}
}
