package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ListProductPage {
	
	WebDriver driver;
    GeneralUtilities gu = new GeneralUtilities();
    
    
    public ListProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    
    @FindBy(id = "product_list_filter_type")
	WebElement productTypeDropDownbox;
    
    
    
    public boolean isProductTypeDropDownboxMultiple() {    	
    	return gu.isMultipleDropdown_Utility(productTypeDropDownbox);    	
    }
    
    public List<String> getAllOptionsFromProductTypeDropDownbox() {
    	return gu.getAllDropDownOptions_Utility(productTypeDropDownbox);
    }

    
}
