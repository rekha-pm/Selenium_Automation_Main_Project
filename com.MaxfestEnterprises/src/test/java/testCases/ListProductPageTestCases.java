package testCases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import objectRepository.HomePage;
import objectRepository.ListProductPage;
import objectRepository.LogInPage;
import utilities.Constants;
import utilities.ExcelRead;

public class ListProductPageTestCases extends BaseClass{
	
	LogInPage lp;
	HomePage hp;
	ListProductPage lpp;
	
	
  @Test
  public void verifyTheProductTypeDropDownBoxIsNotMultiple() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  lpp = hp.navigateToListProductsPage();
	  boolean actual_status = lpp.isProductTypeDropDownboxMultiple(); 
	  System.out.println( "IsMultiple Status of ProductTypeDropDownbox:" + actual_status);
	  Assert.assertFalse(actual_status);
	  
  }
  
  
  
  @Test
  public void verifyTheOptionsPresentInProductTypeDropDownBox() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  lpp = hp.navigateToListProductsPage(); 
	  List<String> expected_OptionsList = Arrays.asList(ExcelRead.getStringData(1, 0,Constants.sheetListProductPage),ExcelRead.getStringData(1, 1,Constants.sheetListProductPage),ExcelRead.getStringData(1, 2,Constants.sheetListProductPage));
	  List<String> actual_OptionsList = lpp.getAllOptionsFromProductTypeDropDownbox();
	  System.out.println(actual_OptionsList);
	  Assert.assertEquals(actual_OptionsList, expected_OptionsList);
	  	  
  }
  
  
}
