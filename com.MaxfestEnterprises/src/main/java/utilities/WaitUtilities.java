package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	WebDriverWait wait;
	
	

	//**************************Explicit Wait***************************************************//
	public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	public void waitForElementToBeClickableByIdLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}
	
	
	public void waitForElementToBeVisibleByElement_Utility(WebDriver driver,WebElement element,int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementToBeVisibleByXpathLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement we =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		return we;
	}
	
	public WebElement waitForElementToBeVisibleByIdLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		return we;
	}
	
	public WebElement waitForPrecenceOfElementByXpathLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
		return we;
	}
	
	public WebElement waitForPrecenceOfElementByIdLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
		return we;
	}
	
	public void waitForAlert_Utility(WebDriver driver,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	//**************************Fluent Wait***************************************************//
	
	public void fluentWaitForElementtoBeClickableByXpathLocator_Utility(WebDriver driver,String locatorValue,int totalTimeOut,int pollingTimeOut ) {
		
		FluentWait<WebDriver> wait = new FluentWait<> (driver)
				.withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	public void fluentWaitForElementtoBeClickableByIdLocator_Utility(WebDriver driver,String locatorValue,int totalTimeOut,int pollingTimeOut ) {
		
		FluentWait<WebDriver> wait = new FluentWait<> (driver)
				.withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}



}
