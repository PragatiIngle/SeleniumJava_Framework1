package util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExcelDataProvider
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver=null;

	@BeforeSuite
	public void steup()
	{
		htmlReporter = new ExtentHtmlReporter("extent1.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUPTest()
	{
         String projectPath = System.getProperty("user.dir");
		//System.out.println("projectPath:"+projectPath);

		System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}


	@Test(dataProvider="test1data")
	
	public void test1(String username,String password) throws InterruptedException, IOException
	{
		//System.out.println(username+" |"+password);
		ExtentTest test = extent.createTest("Data driven test", "by using testng");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		test.pass("Navigate to OrangehrmLive");
		test.log(Status.INFO, "check with the username and password");

		// info(details)
		test.info("This step shows usage of info");

		// log with snapshot
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		//driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).sendKeys(Keys.RETURN);

		Thread.sleep(2000);	

	}

	@DataProvider(name="test1data")
	public  Object[][] getData()
	{
		String excelPath="C:/Users/Udeep/eclipse-workspace/sel/SeleniumFrame/excel/Data.xlsx";

		Object data[][] = testData (excelPath,"Sheet1");
		return data;

	}
	
	
	
	@AfterTest
	public void teardownTest()
	{
		
		//driver.close();
		//driver.quit();
		System.out.println("test completed successfully");

	}

	@AfterSuite
	public void tearDown()
	{
		// calling flush writes everything to the log file
		extent.flush();
	}
	
	
	public  Object[][] testData(String excelPath, String SheetName)
	{
		Excelutil excel =new Excelutil(excelPath,SheetName);
		int rowCount = excel.getRowCount();
		int colCount=	excel.getColumnCount();

		Object data[][]=new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData= excel.getCellDataString(i,j);
				//System.out.print(cellData+" ");
				data[i-1][j]=cellData;
			}


			System.out.println();

		}
		return data;
		

	}

}
