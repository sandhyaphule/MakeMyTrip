package pom;

	import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import util.Utility;

	public class HomePage  {
		
		WebDriver driver;
		
		@FindBy(xpath="//iframe[@title='notification-frame-173061064']")private WebElement iframe1;
		@FindBy(xpath="//a[@id='webklipper-publisher-widget-container-notification-close-div']")private WebElement closePopup1;
		@FindBy(xpath="//span[@class='commonModal__close']")private WebElement closePopup2;
		@FindBy(xpath="//li[@data-cy='roundTrip']")private WebElement roundTrip;
		@FindBy(xpath="//label[@for='fromCity']")private WebElement Fromcity;
		@FindBy(xpath="(//input[@type='text'])[2]")private WebElement fromcitynameenter;
		@FindBy(xpath="//label[@for='toCity']")private WebElement tocity;
		@FindBy(xpath="//input[@id='toCity']")private WebElement tocityName;
		@FindBy(xpath="//*[text()='Mumbai, India']")private WebElement tocityName1;
		@FindBy(xpath="//div[@aria-label='Wed Oct 25 2023']")private WebElement depDate;
		@FindBy(xpath="//*[@aria-label='Tue Nov 28 2023']")private WebElement returnDate;
		@FindBy(id="range_error")private WebElement validateMsg;
		@FindBy(xpath="//label[@for='travellers']")private WebElement travellers;
		@FindBy(xpath="(//ul[@class='guestCounter font12 darkText gbCounter'])[1]/li")private List<WebElement> adultsList;
		@FindBy(xpath="(//ul[@class='guestCounter font12 darkText gbCounter'])[2]/li")private List<WebElement> childrenList;
		@FindBy(xpath="((//ul[@class='guestCounter font12 darkText gbCounter'])[1]/li)[10]")private WebElement moveOn9plusSeat;
		@FindBy(xpath="//div[@class='gbTravelTooltip']")private WebElement validate9TravellerMsg;
		@FindBy(xpath="//li[@data-cy='adults-2']")private WebElement selectAdult;
		@FindBy(xpath="//li[@data-cy='children-2']")private WebElement selectChildren;
		@FindBy(xpath="(//button[@type='button'])[1]")private WebElement applyButton;
		@FindBy(xpath="//a[text()='Search']")private WebElement searchButton;
		@FindBy(xpath="//span[@class='bgProperties icon20 overlayCrossIcon']")private WebElement closePopup3;
		@FindBy(xpath="(//span[@class='customRadioBtn sizeSm primaryRadiobox '])[1]")private WebElement selectDepflight;
		@FindBy(xpath="(((//div[@class='listingCardWrap'])[2])//span[@class='customRadioBtn sizeSm primaryRadiobox '])[1]")private WebElement selectReturnFlight;
		@FindBy(xpath="//button[text()='Book Now']")private WebElement BookNowButton;
		@FindBy(xpath="(//p[@class='appendBottom5 departureList-text'])[1]")private WebElement DateDisply;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		public void closePopupWindow() throws InterruptedException
		{
			Utility.waitTime(3000);
			//driver.switchTo().frame(iframe1);
//			driver.switchTo().frame(3);
//			closePopup1.click();
//			Utility.waitTime(1000);
//			driver.switchTo().parentFrame();
			closePopup2.click();
			
//			Actions act = new Actions(driver);
//			act.click();
//			Utility.waitTime(1000);
//			act.click();
		}
		public void clickOnroundTrip() throws InterruptedException
		{
			
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", roundTrip);
//			js.executeScript("arguments[0].click();", roundTrip);

			Utility.waitTime(2000);
			Reporter.log("Clicking on roundTrip", true);
			roundTrip.click();
		}
		 
		public void clickOnfromcity()
		{
			Fromcity.click();
		}
		
		public void enterFromcityname() throws EncryptedDocumentException, IOException, InterruptedException
		{
			Utility.waitTime(1000);
			Reporter.log("Entering from city name", true);
			fromcitynameenter.sendKeys(Utility.readExcelData(4, 0));
			Utility.waitTime(500);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN.ENTER).click().build().perform();
		}
		
		public void clickOntocity() throws InterruptedException
		{
			Utility.waitTime(500);
			tocity.click();
		}
		public void enterTocityName() throws EncryptedDocumentException, IOException, InterruptedException
		{
			Utility.waitTime(1000);
			Reporter.log("Entering toCityname", true);
			tocityName.sendKeys(Utility.readExcelData(4, 1));
//			Utility.waitTime(1500);
//			Actions act = new Actions(driver);
//			act.sendKeys(Keys.ARROW_DOWN.ENTER).click().build().perform();
		}
		public void enterTocityName1() throws InterruptedException
		{
			Utility.waitTime(1000);
			tocityName1.click();
		}
		
		public void enterDepDate()
		{
			Reporter.log("Entering Dep date", true);
			depDate.click();
		}
		public void enterReturnDate() throws InterruptedException
		{
			Utility.waitTime(500);
			Reporter.log("Entering return Date", true);
			returnDate.click();
		}
		
		public void Validate30DaysMsg() throws InterruptedException
		{
			
			String ActualMessage = validateMsg.getText();
			Reporter.log("Getting Actual Message like "+ActualMessage, true);
			String ExpectedMessage = "You are booking for more than 30 days";
			Utility.waitTime(500);
			
			Assert.assertEquals(ActualMessage,ExpectedMessage, "Actual and Expected are not matching");
		}
		
		public void clickOnTravellers()
		{
			travellers.click();
		}
		

		public void SelectTravellersandClassforadults() throws InterruptedException
		{
			Utility.waitTime(800);
			for(WebElement AList:adultsList)
			{
				String exAdultResult = "9";
				String actualAdultResult = AList.getText();
				
				if (exAdultResult.equalsIgnoreCase(actualAdultResult))
				{
					AList.click();
				}
			}
			
		}
		
		public void SelectTravellersandClsssforchild() throws InterruptedException
		{
			Utility.waitTime(1000);
			for(WebElement childList:childrenList)
			{
				String exChildResult ="3";
				String actualResult = childList.getText();
				
				if(exChildResult.equalsIgnoreCase(actualResult))
				{
					childList.click();
				}
			}
		}
		
		public void ValidateMsgForMoreThan9Travellers() throws InterruptedException
		{

			Utility.waitTime(500);
			Actions act = new Actions(driver);
			act.moveToElement(moveOn9plusSeat).perform();
			
			
			Utility.waitTime(500);
			String actualMsg = validate9TravellerMsg.getText();
			Reporter.log(""+actualMsg, true);
			Utility.waitTime(800);
			String expectedMsg = "Save on bookings with more than 9 travellers";
			Assert.assertEquals(actualMsg,expectedMsg, "Actual and Expected are not matching");
			
		}
		public void selectAdultSeats() throws InterruptedException
		{
			Utility.waitTime(1000);
			selectAdult.click();
		}
		public void selectChildrenSeats() throws InterruptedException
		{
			Utility.waitTime(500);
			selectChildren.click();
		}
		
		
		public void clickOnapplyButton() throws InterruptedException
		{
			Utility.waitTime(500);
			applyButton.click();
		}
		
		public void clickOnSearchButton() throws InterruptedException
		{
			Utility.waitTime(500);
			searchButton.click();
		}
		
		public void closePopup3Window()
		{
			Utility.expliciteWait(driver, 30, closePopup3);
			closePopup3.click();
		}
		public void SelectDepFlight1() throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,100)");
			Utility.waitTime(2000);
			selectDepflight.click();
		}
		public void SelectReturnFilght1() throws InterruptedException
		{
			Utility.waitTime(2000);
			//Utility.expliciteWait(driver, 1000, selectReturnFlight);
			selectReturnFlight.click();
		}
		public void ClickOnBookNowButton() throws InterruptedException
		{
			Utility.waitTime(1500);
			BookNowButton.click();
		}
		public void getDateDisplayOnReviewPage() throws InterruptedException
		{
			Utility.waitTime(1000);
			String DateOnLastPage = DateDisply.getText();
			Reporter.log("The date Display on Review page is "+DateOnLastPage, true);
		}
	}

