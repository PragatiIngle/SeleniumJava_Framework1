import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	public static void main(String[] args)
	{
		
		
		
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath:"+projectPath);
		
		//System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
	//
	//driver.get("http://google.com");
		//driver.findElement(By.name("q")).sendKeys("Automation step by step");
		//driver.findElement(By.className("Google Search")).click();
		//driver.findElement(By.class("btnk")).sendKeys(Keys.RETURN);
		//System.out.println("ended successfully");
		
		
		System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\chromedrivr\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://seleniumhq.org/");
		
		System.out.println("ended successfully");
		

	}

}
