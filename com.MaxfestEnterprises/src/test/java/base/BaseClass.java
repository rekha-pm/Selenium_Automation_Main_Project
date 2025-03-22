package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import extentReport.ExtentManager;
import utilities.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public static WebDriver driver;
	public static Properties property;
    
    	
	public static void readProperty() throws IOException {

		property = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\configuration\\config.properties");
		property.load(f);
	}

	@BeforeSuite
	public void createReport() {
		ExtentManager.createInstance();
	}
	
	@BeforeMethod(groups = {"Launch"})
	@Parameters("browser")
	public void beforeMethod(String browserName) throws IOException {
		
		readProperty();
		  if(browserName.equalsIgnoreCase("Chrome")) {
			  System.out.println("Execution through Chrome Browser.");
			  driver = new ChromeDriver();
		  }
		  else if(browserName.equalsIgnoreCase("Firefox")) {
			  System.out.println("Execution through Firefox Browser.");
			  driver = new FirefoxDriver();
		  }
		  else {
			  throw new IllegalArgumentException("Browser Not Supported." + browserName);
		  }
		  
		driver.get(property.getProperty("base_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWait));
	}

	
	
	@AfterMethod(groups = {"End"})
	public void afterMethod() {

		driver.quit();
	}

}
