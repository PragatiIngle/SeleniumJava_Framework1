package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo
{
WebDriver driver= null;
@BeforeTest
public void setUPTest()
{
	String projectPath = System.getProperty("user.dir");
	System.out.println("projectPath:"+projectPath);
	
	System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
	 driver = new FirefoxDriver();
}
@Test
public void googleSearch()
{
	//driver.get("https://www.flipkart.com/samsung-galaxy-s21-ultra-phantom-black-512-gb/p/itm74793d2bde182?pid=MOBFZ3TMCEHYWGNG&otracker=hp_bannerads_4_2.bannerAdCard.BANNERADS_Samsung_ITUZH32HARXC");
	driver.get("https://google.com");
	
	driver.findElement(By.name("q")).sendKeys("Automation step by step");
	//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[2]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.RETURN);
	
	
}
@AfterTest
public void teardownTest()
{
	//driver.close();
	//driver.quit();
	System.out.println("test completed successfully");
	
	
}

}
