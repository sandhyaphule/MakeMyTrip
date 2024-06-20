package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import util.Utility;

public class Base {

    public WebDriver driver;
	
	public void lauchBrowser () throws IOException
	{
//		 ChromeOptions opt = new ChromeOptions();
//		 opt.addArguments("incongnito");
//		 opt.addArguments("started maximized");
		 Reporter.log("lauching chromeBrowser", true);
		 driver = new ChromeDriver();
		 Reporter.log("Lauching website", true);
		 driver.get(Utility.getProperty("url"));
		 driver.manage().window().maximize();
    }
	
	public void closeBrowser()  
	{
		Reporter.log("Closing Browser", true);
		driver.quit();
		
	}
	
}