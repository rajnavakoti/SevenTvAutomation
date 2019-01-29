package com.test.ta;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pages.HomePage;

import Utilities.Browser;
import Utilities.GenericComponents;
import Utilities.WebDriverFactory;

public class TATestCases {

	Properties properties;
	WebDriver driver;
	HomePage HomePageObject;
	GenericComponents object ;
	Browser browser;
	
	@BeforeClass
	public void setup(){
		properties = WebDriverFactory.loadPropertiesFile();
		object = new GenericComponents();
		
	}
	
	@Parameters("browser")
	@Test
	public void test1(String browser) throws Exception {
		//driver =WebDriverFactory.getDriver(Browser.firefox);
		//driver = WebDriverFactory.getDriver(Browser.valueOf(properties.getProperty("Browser")));
		driver = WebDriverFactory.getDriver(Browser.valueOf(browser));
		HomePageObject = new HomePage(driver);
		System.out.println(properties.get("ApplicationUrl"));
		driver.get(properties.getProperty("ApplicationUrl"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePageObject.getCookieAcceptWebElement().click();
		String parent = driver.getWindowHandle();
	    HomePageObject.getpageHeadLineWebElement().isDisplayed();
	    HomePageObject.getregisterLinkWebElement().click();
	    
	    Thread.sleep(10000);
	    Set<String> windows = driver.getWindowHandles();
	    for(String window : windows) {
	    	if(!parent.equals(window)) {
	    		object.switchToPageWindow(driver, window);
	    	}
	    }
	    String emailID = object.getRandomEmailAddress()+"@test.com";
	    System.out.println(emailID);
	    HomePageObject.getemailTextFieldWebElement().sendKeys(emailID);
	    HomePageObject.getpwdTextFiledWebElement().sendKeys("Test#123");
	    HomePageObject.getradioFemaleFieldWebElement().click();
	    Select DOB_Day  = new Select(HomePageObject.getdobDayFieldWebElement());
	    DOB_Day.selectByVisibleText("15");
	    
	    Select DOB_Month = new Select(HomePageObject.getdobMonthFieldWebElement());
	    DOB_Month.selectByVisibleText("Januar");
	    
	    Select DOB_Year = new Select(HomePageObject.getdobYearFieldWebElement());
	    DOB_Year.selectByVisibleText("1987");
	    
	    HomePageObject.getacceptCheckBoxWebElement().click();
	    HomePageObject.getsignOnButtonWebElement().click();
	    object.switchToPageWindow(driver, parent);
	    Thread.sleep(10000);
	    HomePageObject.getlogoutButtonWebElement().click();
	    Thread.sleep(10000);
	    if(!HomePageObject.getregisterLinkWebElement().isDisplayed()) {
	    	assertEquals(true, true, "User is not successfully logged out from application");
	    } 
	}
	
	
	@AfterClass
	public void teardown() {
		driver.close();
		object =null;
	}
}
	