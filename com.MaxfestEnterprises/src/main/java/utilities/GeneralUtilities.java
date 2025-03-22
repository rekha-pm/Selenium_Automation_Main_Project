package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	// *******************************WebElementCommands***********************************//
	public String getTextOfElement_Utility(WebElement element) {
		return element.getText();
	}
	
	public String getTooltipOfElement_Utility(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}

	public boolean IsDisplayedElement_Utility(WebElement element) {
		return element.isDisplayed();
	}

	public boolean IsSelectedElement_Utility(WebElement element) {
		return element.isSelected();
	}

	public String getAttributeOfElement_Utility(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getCssvalueOfElement_Utility(WebElement element, String cssPropertyName) {
		return element.getCssValue(cssPropertyName);
	}

	// ***********************************JavaScript*******************************************//
	public void clickUsingJavaScriptExecutor_Utility(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollUsingJavaScriptExecutor_Utility(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// ****************************** Mouse&Keyboard Actions***************************************//

	public void keyDown_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	public void keyUp_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}

	public void mouseHoverElement_Utility(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleclick_Utility(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void leftclick_Utility(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void clickAndHold_Utility(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	public void dragAndDrop_Utility(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).perform();
	}

	// ************************************FileUpload******************************************//

	public void fileUpload_Utility(WebElement element, String filePath) {
		element.sendKeys(filePath);
	}

	// *************************************DropDown***************************************//
	public boolean isMultipleDropdown_Utility(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void selectDropdownValueByIndex_Utility(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void deSelectDropdownValueByIndex_Utility(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void selectDropdownValueByValue_Utility(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void deSelectDropdownValueByValue_Utility(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void selectDropdownValueByVisibleText_Utility(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void deSelectDropdownValueByVisibleText_Utility(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	public void deSelectAllDropdownValues_Utility(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
		;
	}

	public String getFirstSelectedDropDownOption_Utility(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public List<String> getAllDropDownOptions_Utility(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getAllSelectedDropDownOptions_Utility(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// *************************************Alert***************************************//
	public void switchToAlertAccept_Utility(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertDismiss_Utility(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String switchToAlertGetText_Utility(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void switchToAlertInputText_Utility(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// *************************************Frames***************************************//
	public void switchToFrameByIndex_Utility(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByNameOrID_Utility(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	public void switchToFrameByElement_Utility(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackToMainPage_Utility(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchBackToParentFrame_Utility(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// *************************************WindowHandle**************************************//
	public String getParenetWindowhandle_Utility(WebDriver driver) {
		return driver.getWindowHandle();

	}

	public Set<String> getAllWindowhandles_Utility(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void switchToWindowhandle_Utility(WebDriver driver, String windowhandle) {
		driver.switchTo().window(windowhandle);
	}

	// *****************************************Sleep***************************************//
	public void addSleep_Utility(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}

	public String getCurrentDate_Utility(String format) {
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(currentDate);
	}

}
