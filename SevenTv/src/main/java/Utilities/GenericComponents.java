package Utilities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GenericComponents {
	
	private static final int MAX_TIMEOUT = 240;
	
	public boolean waitForObjectClickable(WebDriver driver,By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
	public boolean isObjectExists(WebDriver driver,By locator) {
		List<WebElement> elements = driver != null ? driver.findElements(locator) : null;
		return (elements != null && elements.size() > 0) ? true : false;
	}
	
	/**
	 * @return
	 * @param locator
	 */
	public boolean waitForObjectExists(WebDriver driver,By locator) {
		return waitForObjectExists(driver,locator, MAX_TIMEOUT);
	}
	
	/**
	 * @return
	 * @param pElement
	 * @param locator
	 */
	public boolean waitForObjectExists(WebElement pElement, By locator) {
		return waitForObjectExists(pElement, locator, MAX_TIMEOUT);
	}
	
	/**
	 * @return
	 * @param locator
	 */
	public boolean waitForObjectExists(WebDriver driver,By locator, int timeout) {
		ExecutorService executor = Executors.newCachedThreadPool();
		WaitForObjectExists task = new WaitForObjectExists(driver, null, locator);
		Future<Boolean> future = executor.submit(task);
		try {
			return future.get(timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
		} finally {
			executor.shutdownNow();
		}
		return false;
	}
	
	/**
	 * @return
	 * @param pElement
	 * @param locator
	 */
	public boolean waitForObjectExists(WebElement pElement, By locator, int timeout) {
		ExecutorService executor = Executors.newCachedThreadPool();
		WaitForObjectExists task = new WaitForObjectExists(null, pElement, locator);
		Future<Boolean> future = executor.submit(task);
		try {
			return future.get(timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
		} finally {
			executor.shutdownNow();
		}
		return false;
	}
	

class WaitForObjectExists implements Callable<Boolean> {
	WebDriver driver = null;
	WebElement pElement = null;
	By locator = null;
	
	WaitForObjectExists(WebDriver driver, WebElement pElement, By locator) {
		this.driver = driver;
		this.pElement = pElement;
		this.locator = locator;
	}
	
	public Boolean call() throws Exception {
		for (;;)  {
			try {
				Thread.sleep(500);
				if ((driver != null && driver.findElements(locator).size() != 0)
						|| (pElement != null && pElement.findElements(locator).size() != 0))
					return true;
			} catch (Exception e) { }
		}
	}
}
	public String getRandomEmailAddress() {
    String emailAddress = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder email = new StringBuilder();
    Random rnd = new Random();
    while (email.length() < 8) { // length of the random string.
        int index = (int) (rnd.nextFloat() * emailAddress.length());
        email.append(emailAddress.charAt(index));
    }
    return email.toString();
    }

	public void switchToPageWindow(WebDriver driver ,String windowTitle) throws Exception {
		driver.switchTo().window(windowTitle);
	}
	



}