package dataProvider;

import utilities.ExcelRead;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	

	@DataProvider(name = "unSuccessfulLogIn")
	public Object[][] dp1() throws IOException {
		return new Object[][] { 
			new Object[] { ExcelRead.getStringData(1, 1,"LogInPage"), ExcelRead.getIntegerData(1, 2,"LogInPage") }, 
			new Object[] { ExcelRead.getStringData(2, 1,"LogInPage"), ExcelRead.getIntegerData(2, 2,"LogInPage") },
			new Object[] { ExcelRead.getStringData(3, 1,"LogInPage"), ExcelRead.getIntegerData(3, 2,"LogInPage") } };
	}

}
