package testCases;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import objectRepository.HomePage;
import objectRepository.LogInPage;
import objectRepository.UsersPage;
import utilities.Constants;
import utilities.ExcelRead;
import utilities.RandomDataUtility;

public class UsersPageTestCases extends BaseClass{
	
	LogInPage lp;
	HomePage hp;
	UsersPage up;
	
  @Test
  public void verifyTheColumnHeadingsOfAllUsersTable() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  up = hp.navigateToUsersPage();
	  List<String> expected_ColumnHeadings = List.of(ExcelRead.getStringData(1, 2,Constants.sheetUsersPage),ExcelRead.getStringData(1, 3,Constants.sheetUsersPage),ExcelRead.getStringData(1, 4,Constants.sheetUsersPage),ExcelRead.getStringData(1, 5,Constants.sheetUsersPage),ExcelRead.getStringData(1, 6,Constants.sheetUsersPage));
	  List<String> actual_ColumnHeadings = up.getcolumnHeadings();
	  Assert.assertEquals(actual_ColumnHeadings, expected_ColumnHeadings);
  }
	
	
  @Test
  public void verifyTheRoleSelectedByDefaultIsAdminWhileAddingAUser() throws IOException {
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  up = hp.navigateToUsersPage();
	  String actual_DefaultRole = up.getSelectedValueOfRoleDropDown();
	  System.out.println("String Default Selected Role:" + actual_DefaultRole);
	  Assert.assertEquals(actual_DefaultRole,ExcelRead.getStringData(1, 0,Constants.sheetUsersPage));
  }
  
  
  
	
  @Test
  public void verifyAddUsersFunctionality() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  up = hp.navigateToUsersPage();
	  String expected_EmailID = RandomDataUtility.getEmail_Utility();
	  up.addUser(RandomDataUtility.getFirstName_Utility(), expected_EmailID, RandomDataUtility.getPassword_Utility());
	  up.searchUser(expected_EmailID);
	  String actual_EmailID = up.getEmailFromUserSearchResult();
	  System.out.println("Expected EmailID:" + expected_EmailID + "  ActualEmail:"+ actual_EmailID);
	  Assert.assertEquals(actual_EmailID, expected_EmailID);
  }
  
  
  
  
  @Test
  public void verifyEditUsersFunctionality() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  up = hp.navigateToUsersPage();
	  String expected_EmailID = RandomDataUtility.getEmail_Utility();
	  up.addUser(RandomDataUtility.getFirstName_Utility(), expected_EmailID, RandomDataUtility.getPassword_Utility());
	  up.searchUser(expected_EmailID);
	  up.editUser();
	  up.searchUser(expected_EmailID);
	  String actual_Role = up.getRoleFromUserSearchResult();
	  System.out.println("Role From Search Result:" + actual_Role);
	  Assert.assertEquals(actual_Role, ExcelRead.getStringData(1, 0,Constants.sheetUsersPage));
  }
  
  
  
  @Test
  public void verifyDeleteUsersFunctionality() throws IOException {
	  
	  lp = new LogInPage(driver);
	  hp = lp.logIn(Constants.userName,Constants.passWord);
	  hp.endTour();
	  up = hp.navigateToUsersPage();
	  String expected_EmailID = RandomDataUtility.getEmail_Utility();
	  up.addUser(RandomDataUtility.getFirstName_Utility(), expected_EmailID, RandomDataUtility.getPassword_Utility());
	  up.searchUser(expected_EmailID);
	  up.deleteUser();
	  up.searchUser(expected_EmailID);
	  String actual_Message = up.getMessageFromUserSearchResultAfetrDelete();
	  System.out.println("Message From Search Result:" + actual_Message);
	  Assert.assertEquals(actual_Message, ExcelRead.getStringData(1, 1,Constants.sheetUsersPage));
  }
  
  
  
}
