package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class HomePage {
	
	WebDriver driver;
    GeneralUtilities gu = new GeneralUtilities();
    WaitUtilities wu = new WaitUtilities();
    
    
    public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement endTourButton;
    @FindBy(xpath = "//li[contains(@class,'user-menu')]/child::a/child::span")
	WebElement homePageLogInName;
    @FindBy(xpath = "//section[@class='content-header']")
    WebElement homePageHeader ;
     @FindBy(id = "view_todays_profit")
	WebElement viewTodaysProfitIcon;
    @FindBy(xpath = "//a[@id='tour_step5_menu']")
	WebElement productsLink;
	@FindBy(xpath = "//li[@id='tour_step5']/child::ul/child::li/child::a")
	WebElement listProductsLink;
	@FindBy(xpath = "//ul[contains(@class,'sidebar-menu')]/child::li[2]")
	WebElement userManagementLink;
	@FindBy(xpath = "//ul[contains(@class,'sidebar-menu')]/child::li[2]/child::ul/child::li")
	WebElement userstLink;
	@FindBy(xpath = "//ul[contains(@class,'sidebar-menu')]/child::li[3]")
	WebElement contactsLink;
	@FindBy(xpath = "//ul[contains(@class,'sidebar-menu')]/child::li[3]/child::ul/child::li[4]/child::a")
	WebElement importcontactsLink;
	@FindBy(xpath = "//div/child::strong")
	WebElement date_HomePage;
	@FindBy(xpath = "//li[@class='user-footer']//child::div[2]/child::a")
	WebElement signOutButton;
	
	
	String dateFormat = "dd-MM-yyyy" ;
	   
	
	
	public void endTour() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,endTourButton, Constants.explicitWait);
		endTourButton.click();
	}
    
    public String getTextOfHomePageLogInName() {
    	wu.waitForElementToBeVisibleByElement_Utility(driver,homePageLogInName, Constants.explicitWait);
    	return gu.getTextOfElement_Utility(homePageLogInName);
	}
    
    public String getTextOfHomePageHeader() {
    	wu.waitForElementToBeVisibleByElement_Utility(driver,homePageHeader, Constants.explicitWait);
    	return gu.getTextOfElement_Utility(homePageHeader);
	}
    
    public String getToolTipOfviewTodayProfitIcon() {
    	return gu.getTooltipOfElement_Utility(viewTodaysProfitIcon,"title");
	}
    
    public ListProductPage navigateToListProductsPage() {
    	productsLink.click();
    	listProductsLink.click();
		return new ListProductPage(driver);
    }
    
    public UsersPage navigateToUsersPage() {
    	userManagementLink.click();
    	userstLink.click();
		return new UsersPage(driver);
    }
    
    public ImportContactsPage navigateToImportContactsPage() {
    	contactsLink.click();
    	importcontactsLink.click();
		return new ImportContactsPage(driver);
    }
    
	public String getDateFromHomePage() {
		return date_HomePage.getText();
	}

	public String getCurrentDate() {
		return gu.getCurrentDate_Utility(dateFormat);
	}
	
	public LogInPage signOut() {
		homePageLogInName.click();
		signOutButton.click();
		return new LogInPage(driver);
	}

}

