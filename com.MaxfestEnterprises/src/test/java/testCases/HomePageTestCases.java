package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import objectRepository.HomePage;
import objectRepository.LogInPage;
import utilities.Constants;
import utilities.ExcelRead;

public class HomePageTestCases extends BaseClass{
 

	LogInPage lp;
	HomePage hp;
	
	
  @Test
  public void verifyTheToolTipOnViewTodaysProfitIcon() throws IOException {
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  String actual_ToolTip = hp.getToolTipOfviewTodayProfitIcon();
	  System.out.println("Actual ToolTip:" + actual_ToolTip);
	  Assert.assertTrue(actual_ToolTip.contains(ExcelRead.getStringData(1, 0,Constants.sheetHomePage)));
  }
  
  
  
  @Test
  public void verifyTheCurrentDateDisplayedOnHomePage() throws IOException {
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  String actual_date = hp.getDateFromHomePage();
	  String expected_date = hp.getCurrentDate();
	  System.out.println("Date from HomePage:" +actual_date + "   Today'sDate:" + expected_date );
	  Assert.assertEquals(actual_date, expected_date);
  }
  
  
  
  @Test (enabled = true,groups = "Group1")
  public void verifySignOut() throws IOException {
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  hp.signOut();
	  String actual_Heading = lp.getTextOfDemoPOSHeading();
	  System.out.println("Actual heading in LogIn page: " + actual_Heading);
	  Assert.assertEquals(actual_Heading, ExcelRead.getStringData(1, 0,Constants.sheetLogInPage));
  }
	
	
}
