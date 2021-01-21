package datadriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOption 
{
	public static void main(String[] args)
	{
		
		
		
		ChromeOptions option= new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriver driver =new ChromeDriver();
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath:"+projectPath);
		driver.get("https://seleniumhq.org/");
}
}
