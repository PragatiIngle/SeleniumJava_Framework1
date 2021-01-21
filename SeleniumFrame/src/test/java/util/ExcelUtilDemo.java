package util;

public class ExcelUtilDemo
{
	public static void main(String[] args)
	{
	    String	projectPath = System.getProperty("user.dir");
	    
		Excelutil excel = new Excelutil(projectPath+"/excel/Data.xlsx"," Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0,0);
		excel.getCellDataNum(1, 1);
	}
}
