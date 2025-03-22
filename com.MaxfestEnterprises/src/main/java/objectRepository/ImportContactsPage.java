package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ImportContactsPage {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	
	
	public ImportContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='contacts_csv']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[contains(@class,'btn-primary')]")
	WebElement submitButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement successMessageAfterImport;
	
	
	
	public String fileUpload(String filepath) {
		chooseFileButton.sendKeys(filepath);
		submitButton.click();
		return successMessageAfterImport.getText();
	}
	

}
