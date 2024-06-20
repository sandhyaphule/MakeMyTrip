package util;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Reporter;

	public class Utility {

		
		public static String getProperty (String PropertyName) throws IOException
		{
			FileInputStream myfile = new FileInputStream("src\\test\\resources\\config.properties");
			Properties p = new Properties();
			p.load(myfile);
			String property = p.getProperty(PropertyName);
			return property;
		}
		
		public static String readExcelData (int row, int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream file = new FileInputStream("testdata\\mytest.xlsx");
			String data = WorkbookFactory.create(file).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
		
		public static void impliciteWait(WebDriver driver, int time)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}
		
		public static void expliciteWait(WebDriver driver, int time, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public static WebElement explicitwait(WebDriver driver, By xpath)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement newElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			return newElement;
		}
		
		public static void waitTime (int timeSec) throws InterruptedException
		{
			Thread.sleep(timeSec);
			Reporter.log("Waiting for "+timeSec+" milisec", true);
		}
		
		public static void ActionsClass(WebDriver driver) throws InterruptedException
		{
			Actions act = new Actions(driver);
			act.moveToLocation(0,500).click();
			Thread.sleep(1500);
			act.click();
		}
		
		
	}

