package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.GenericComponents;

public class HomePage {
	
	private static String cookieAccept = "//a[@id='btn_cookie']";
	private static String pageHeadLine= "(.//h2[text()='Login oder kostenlos registrieren'])[2]";
	private static String registerLink = "(.//a[text()='Kostenlos registrieren'])[2]";
	private static String emailTextField = "//input[@id='email']";
	private static String pwdTextFiled = "//input[@id='pwd']";
	private static String radioFemaleField = "//label[@for='femaleRadio']";
	private static String dobDayField = "//select[@ng-model='birthdate.day']";
	private static String dobMonthField = "//select[@ng-model='birthdate.month']";
	private static String dobYearField = "//select[@ng-model='birthdate.year']";
	private static String signOnButton = "//button[text()='Kostenlos registrieren']";
	private static String acceptCheckBox = "//label[@for='accept']";
	private static String logoutButton = "//button[@class='button-logout']";
	
	GenericComponents object;
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		object = new GenericComponents();
		this.driver = driver;
	}
	public WebElement getCookieAcceptWebElement() {
		object.waitForObjectExists(driver, By.xpath(cookieAccept));
		return driver.findElement(By.xpath(cookieAccept));
	}
	
	public WebElement getpageHeadLineWebElement() {
		object.waitForObjectExists(driver, By.xpath(pageHeadLine));
		return driver.findElement(By.xpath(pageHeadLine));
	}
	
	public WebElement getregisterLinkWebElement() {
		object.waitForObjectExists(driver, By.xpath(registerLink));
		return driver.findElement(By.xpath(registerLink));
	}
	public WebElement getemailTextFieldWebElement() {
		object.waitForObjectExists(driver, By.xpath(emailTextField));
		return driver.findElement(By.xpath(emailTextField));
	}
	public WebElement getpwdTextFiledWebElement() {
		object.waitForObjectExists(driver, By.xpath(pwdTextFiled));
		return driver.findElement(By.xpath(pwdTextFiled));
	}
	public WebElement getradioFemaleFieldWebElement() {
		object.waitForObjectExists(driver, By.xpath(radioFemaleField));
		return driver.findElement(By.xpath(radioFemaleField));
	}
	public WebElement getdobDayFieldWebElement() {
		object.waitForObjectExists(driver, By.xpath(dobDayField));
		return driver.findElement(By.xpath(dobDayField));
	}
	public WebElement getdobMonthFieldWebElement() {
		object.waitForObjectExists(driver, By.xpath(dobMonthField));
		return driver.findElement(By.xpath(dobMonthField));
	}
	public WebElement getdobYearFieldWebElement() {
		object.waitForObjectExists(driver, By.xpath(dobYearField));
		return driver.findElement(By.xpath(dobYearField));
	}
	public WebElement getsignOnButtonWebElement() {
		object.waitForObjectExists(driver, By.xpath(signOnButton));
		return driver.findElement(By.xpath(signOnButton));
	}
	public WebElement getacceptCheckBoxWebElement() {
		object.waitForObjectExists(driver, By.xpath(acceptCheckBox));
		return driver.findElement(By.xpath(acceptCheckBox));
	}
	public WebElement getlogoutButtonWebElement() {
		object.waitForObjectExists(driver, By.xpath(logoutButton));
		return driver.findElement(By.xpath(logoutButton));
	}
}
