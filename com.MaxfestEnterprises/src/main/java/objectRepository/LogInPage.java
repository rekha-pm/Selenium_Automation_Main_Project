package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class LogInPage {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h1[contains(text(),'Demo')]") 
	WebElement headingDemoPOS;
	@FindBy(name = "username") 
	WebElement userNameTextBox;
	@FindBy(name = "password") 
	WebElement passWordTextBoxTextBox;
	@FindBy(xpath="//span[@class='help-block']/child::strong")
	WebElement invalidLogIn;
	@FindBy(xpath = "//button[@type='submit']") 
	WebElement loginButton;
	@FindBy(name = "remember") 
	WebElement rememberMeCheckBox;
	
	
	public String getTextOfDemoPOSHeading() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,headingDemoPOS, Constants.explicitWait);
		return gu.getTextOfElement_Utility(headingDemoPOS);
	}
	
	public HomePage logIn(String uName,String pW) {
		userNameTextBox.sendKeys(uName);
		passWordTextBoxTextBox.sendKeys(pW);
		loginButton.click();
		return new HomePage(driver);
	}

	public String unSuccessfulErrorMessage() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,invalidLogIn, Constants.explicitWait);
		return gu.getTextOfElement_Utility(invalidLogIn);
	}
	
	public boolean isRememeberMeCheckBoxChecked() {
		return gu.IsSelectedElement_Utility(rememberMeCheckBox);
	}
	
    

}
