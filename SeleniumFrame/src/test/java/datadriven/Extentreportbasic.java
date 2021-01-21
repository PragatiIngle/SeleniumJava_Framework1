package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreportbasic
{
	 private static WebDriver driver=null;
	public static void main(String[] args) 
	{
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		 
		 // create ExtentReports and attach reporter(s)
		 ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	     // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test1 = extent.createTest("GoogleSearch", "Sample description");
	        
	        String projectPath = System.getProperty("user.dir");
	    	System.out.println("projectPath:"+projectPath);
	    	System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
	    	 
	    	driver = new FirefoxDriver();
	        test1.log(Status.INFO, "starting test case");
	    	 
	    	 driver.get("https://google.com");
	    	 test1.pass("Navigate to google.com");
	    	 
	    	 driver.findElement(By.name("q")).sendKeys("Automation step by step");
	    	 test1.pass("Entered text in searchBox");
	    	 
	    		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[2]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.RETURN);
	    		test1.pass("Pressed Keyboard enter key");
	    		
	    		test1.info("Test Completed");
	    		
	    		// calling flush writes everything to the log file
	            extent.flush();
	    		
	    		
	}
	
	
	

}
