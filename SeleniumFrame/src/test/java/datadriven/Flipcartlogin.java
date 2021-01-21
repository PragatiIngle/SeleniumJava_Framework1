package datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Flipcartlogin
{

	
		
		@Test(dataProvider="FlipKart")
		public void logintoflipkart(String mailid, String password) throws InterruptedException
		
		{
			String projectPath = System.getProperty("user.dir");
			System.out.println("projectPath:"+projectPath);
			
			System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/samsung-galaxy-s21-ultra-phantom-black-512-gb/p/itm74793d2bde182?pid=MOBFZ3TMCEHYWGNG&otracker=hp_bannerads_4_2.bannerAdCard.BANNERADS_Samsung_ITUZH32HARXC");
		   
			//locators for the emailId
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("mailid");
			
			//locators for the password
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("password");
			
			//locators for the login
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span")).click();
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			System.out.println("data successfully run");
			driver.quit();
			
			}
		@DataProvider(name="Flipkart")
		 public Object[][] passdata()
		 {
			 Object[][] data =new Object[3][2];

			data [0][0]="pragatiqer@gmail.com";
			data [0][1]="admin12";
			
			data [1][0]="pragatideshmukh7487@gmail.com";
			data [1][1]="Admin@123";
			
			data [2][0]="pragatiqhjer@gmail.com";
			data [1][1]="Admin@456";
			
			return data;
			
			 
		 }
		
		
		
		
		
		
	

	
	
}
