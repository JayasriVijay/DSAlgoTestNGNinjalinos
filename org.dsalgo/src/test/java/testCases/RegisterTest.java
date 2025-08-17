package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LinkedList_pf;
import pageFactory.RegisterPage;
import utils.ExcelReaderTestNg;
import utils.LoggerLoad;

public class RegisterTest {
	
	 RegisterPage registerPg ;
	 LoggerLoad log;
	 private Map<String, String> testData;
	   
	
	@BeforeMethod
    public void initPageObjects() {
        registerPg = new RegisterPage();
        registerPg.clickRegister();
        log = new LoggerLoad();
        
    }


	@DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][] {
            { ExcelReaderTestNg.readExcelRow("TC_01-For invalid username", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_02-For invalid username", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_03-For invalid username", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_04-For invalid username", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_05-For invalid password", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_06-For invalid password", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_07-For invalid password", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_08-For password and confirm password mismatch", "Sheet2") },
            { ExcelReaderTestNg.readExcelRow("TC_09-For already existing credentials", "Sheet2") }
  
        };
	}
        
        @Test(dataProvider = "registrationData")
        public void testRegistration(Map<String, String> testData) {
            System.out.println("Running test for scenario: " + testData.get("scenario"));
            System.out.println("Username: " + testData.get("username"));
            System.out.println("Password: " + testData.get("password"));
            System.out.println("Confirm Password: " + testData.get("confirmPassword"));
            System.out.println("Expected Result: " + testData.get("expectedResult"));

}
	}
