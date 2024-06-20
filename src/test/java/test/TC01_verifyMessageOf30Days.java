package test;


	import java.io.IOException;
	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import base.Base;
	import pom.HomePage;
	import util.Utility;

	public class TC01_verifyMessageOf30Days extends Base
	{
		HomePage hp ;
	  
	@BeforeClass
	public void OpenBrowser() throws IOException
	{
		lauchBrowser();
		hp = new HomePage(driver);
		
	}

	@BeforeMethod
	public void journeyInfo() throws InterruptedException, EncryptedDocumentException, IOException
	{
		hp.closePopupWindow();
		hp.clickOnroundTrip();
		hp.clickOnfromcity();
		Utility.waitTime(2000);
		hp.enterFromcityname();
		hp.clickOntocity();
		hp.enterTocityName();
		hp.enterTocityName1();
		hp.enterDepDate();
		hp.enterReturnDate();
		
	}

	@Test
	  public void VerifyMessageOF30Days () throws InterruptedException 
	 {
		hp.Validate30DaysMsg();
		hp.clickOnTravellers();

		hp.SelectTravellersandClassforadults();
		hp.SelectTravellersandClsssforchild();
		hp.ValidateMsgForMoreThan9Travellers();
		
		hp.selectAdultSeats();
		hp.selectChildrenSeats();
		hp.clickOnapplyButton();
		hp.clickOnSearchButton();
		
		hp.closePopup3Window();
		hp.SelectDepFlight1();
		hp.SelectReturnFilght1();
		hp.ClickOnBookNowButton();
		
		hp.getDateDisplayOnReviewPage();
		
		Utility.waitTime(4000);
		closeBrowser();
		Utility.waitTime(5000);
	}


	}

//testng
	//beforeclass   lunch brow
	//bmethod//method call
	//test//tc write
	//aftermethod  logout method call
	
	//afterclass close brower
	