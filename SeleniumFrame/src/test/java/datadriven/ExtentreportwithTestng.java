package datadriven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentreportwithTestng 
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver;
	@BeforeSuite
	public void steup()
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}


	@BeforeTest
	public void setUPTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath:"+projectPath);

		System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void test1() throws IOException
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		///log(Status, details)

		driver.get("https://google.com");
		test.pass("Navigate to google.com");
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
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


}
