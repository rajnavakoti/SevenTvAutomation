package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverFactory {
	
	private static Properties properties;
	private static FileInputStream input = null;
	public static Properties loadPropertiesFile(){
		 properties = new Properties();
		 
		
			 try {
				input = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				properties.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return properties;
	}

	public static RemoteWebDriver getDriver(Browser browser) {
		WebDriver driver = null;

		switch (browser) {
		case chrome:
			properties = loadPropertiesFile();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		return (RemoteWebDriver)driver;
	}
	
	}

