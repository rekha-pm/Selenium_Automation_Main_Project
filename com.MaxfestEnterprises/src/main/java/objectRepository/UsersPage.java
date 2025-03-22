package objectRepository;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UsersPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='users_table']/thead/tr/th")
	List<WebElement> columnHeadings;
	@FindBy(xpath = "//a[contains(@class,'btn-block')]")
	WebElement addButton;
	@FindBy(id = "first_name")
	WebElement firstNameTextBox;
	@FindBy(id = "email")
	WebElement emailTextBox;
	@FindBy(id = "role")
	WebElement roleDropDownBox;
	@FindBy(id = "password")
	WebElement passwordTextBox;
	@FindBy(id = "confirm_password")
	WebElement confirmPasswordTextBox;
	@FindBy(id = "submit_user_button")
	WebElement saveButton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchTextBox;
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[4]")
	WebElement email_SearchResult;
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[3]")
	WebElement role_SearchResult;
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[5]/a")
	WebElement editButton_SearchResult;
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[5]/button")
	WebElement deleteButton_SearchResult;
	@FindBy(id = "submit_user_button")
	WebElement updateButton;
		
	String xpathNoRecordFoundMessage = "//td[@class='dataTables_empty']";
	
	public List<String> getcolumnHeadings(){
		List<String> actualColumnHeadings = new ArrayList<String>();
		for (WebElement colHeading : columnHeadings) {
			actualColumnHeadings.add(colHeading.getText());
		}
		return actualColumnHeadings;
	}

	public String getSelectedValueOfRoleDropDown() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,addButton, Constants.explicitWait);
		addButton.click();
		return gu.getFirstSelectedDropDownOption_Utility(roleDropDownBox);
	}

	public void addUser(String fName, String emailID, String pW) {
		addButton.click();
		firstNameTextBox.sendKeys(fName);
		emailTextBox.sendKeys(emailID);
		gu.selectDropdownValueByIndex_Utility(roleDropDownBox, 2);
		passwordTextBox.sendKeys(pW);
		confirmPasswordTextBox.sendKeys(pW);
		saveButton.click();
	}

	public void editUser() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,editButton_SearchResult, Constants.explicitWait);
		editButton_SearchResult.click();
		gu.selectDropdownValueByIndex_Utility(roleDropDownBox, 0);
		updateButton.click();
	}

	public void deleteUser(){
		wu.waitForElementToBeVisibleByElement_Utility(driver,deleteButton_SearchResult, Constants.explicitWait);
		deleteButton_SearchResult.click();
		gu.keyDown_Utility(driver, Keys.ENTER);
		gu.keyUp_Utility(driver, Keys.ENTER);
	}

	public void searchUser(String email) {
		wu.waitForElementToBeVisibleByElement_Utility(driver,searchTextBox, Constants.explicitWait);
		searchTextBox.sendKeys(email);
	}

	public String getEmailFromUserSearchResult() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,email_SearchResult, Constants.explicitWait);
		return gu.getTextOfElement_Utility(email_SearchResult);
	}

	public String getRoleFromUserSearchResult() {
		wu.waitForElementToBeVisibleByElement_Utility(driver,role_SearchResult, Constants.explicitWait);
		return gu.getTextOfElement_Utility(role_SearchResult);
	}

	public String getMessageFromUserSearchResultAfetrDelete() {
		return wu.waitForPrecenceOfElementByXpathLocator_Utility(driver, xpathNoRecordFoundMessage, Constants.explicitWait).getText();
	}

}
