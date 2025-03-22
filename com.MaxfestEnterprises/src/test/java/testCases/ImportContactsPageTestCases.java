package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import objectRepository.HomePage;
import objectRepository.ImportContactsPage;
import objectRepository.LogInPage;
import utilities.Constants;
import utilities.ExcelRead;

public class ImportContactsPageTestCases extends BaseClass{
  
	LogInPage lp;
	HomePage hp;
	ImportContactsPage icp;
	
	@Test
  public void VerifyTheFileImportFuncationslity() throws IOException {
		
		 lp = new LogInPage(driver);
		 hp = lp.logIn(Constants.userName,Constants.passWord);
		 hp.endTour();
		 icp = hp.navigateToImportContactsPage();
		 String filePath = System.getProperty("user.dir") + Constants.contactsFileToImportPath;
		 String actual_successMessage = icp.fileUpload(filePath);
		 System.out.println("Success Message After Import:" +actual_successMessage);
		 Assert.assertEquals(actual_successMessage, ExcelRead.getStringData(1, 0,Constants.sheetImportContactsPage));
  }
	
	
}
