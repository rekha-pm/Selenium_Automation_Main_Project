package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import dataProvider.DataProviderClass;
import objectRepository.HomePage;
import objectRepository.LogInPage;
import utilities.Constants;
import utilities.ExcelRead;

public class LogInPageTestCases extends BaseClass {
 
	LogInPage lp;
	HomePage hp;
	
	
  @Test(priority = 1,groups = "Group1")
  public void verifyTheExactPageIsOpenedWhileHittingTheURL() throws IOException {
		
	  lp = new LogInPage(driver);
	  String actual_Heading = lp.getTextOfDemoPOSHeading();
	  System.out.println("Actual heading: " + actual_Heading);
	  Assert.assertEquals(actual_Heading, ExcelRead.getStringData(1, 0,Constants.sheetLogInPage));
	  
  }
  
  
  @Test(priority = 2,groups = "Group1")
  public void verifySuccessfulLogIn() throws IOException {
	  
		lp = new LogInPage(driver);
		hp = lp.logIn(Constants.userName, Constants.passWord);
		hp.endTour();
		String actual_HomePageLogInName = hp.getTextOfHomePageLogInName();
		System.out.println("Actual_HomePage LogIn Name:" + actual_HomePageLogInName);
		Assert.assertEquals(actual_HomePageLogInName, Constants.userName);
		 		
		/*
		 * String actual_HomePageHeader = hp.getTextOfHomePageHeader(); String
		 * expected_HomePageHeader = ExcelRead.getStringData(1, 1,
		 * Constants.sheetHomePage) + " " + Constants.userName;
		 * System.out.println("Actual HomePage Header: " + actual_HomePageHeader);
		 * System.out.println("Expected HomePage Header: " + expected_HomePageHeader);
		 * Assert.assertTrue(actual_HomePageHeader.contains(expected_HomePageHeader));
		 */
		 
  }
	
  
  
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "unSuccessfulLogIn",priority = 3)
  public void verifyUnSuccessfulLogIn(String uName,String pName) throws IOException {
	  lp = new LogInPage(driver);
	  lp.logIn(uName, pName);
	  String actual_InvalidLogInErrorMsg = lp.unSuccessfulErrorMessage();
	  System.out.println("Actual Invalid LogIn ErrorMessage: " + actual_InvalidLogInErrorMsg);
	  Assert.assertTrue(actual_InvalidLogInErrorMsg.contains(ExcelRead.getStringData(1, 3,Constants.sheetLogInPage)));
	 }
	
  
  
  @Test(priority = 4)
  public void verifyRememberMeCheckBoxIsNotCheckedByDefault() {
	  lp = new LogInPage(driver);
	  boolean actual_status = lp.isRememeberMeCheckBoxChecked();
	  System.out.println("RememberMeCheckBox Status:" +actual_status);
	  Assert.assertFalse(actual_status);
	  
  }
	
}
