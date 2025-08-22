package testCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory_TestNG;
import pageFactory.Array_pf;
import pageFactory.BasePage;
import utils.ExcelReader;

public class BaseTest {
	
	ExcelReader excelReader;
	HashMap<String, String> testDataValid; 
	HashMap<String, String> testDataInValid; 

	public BaseTest() throws IOException {
		this.excelReader = new ExcelReader();
	}

	

	@Parameters({"browser"})
	@BeforeMethod
	public void open_website(@Optional("chrome")String br) throws IOException, InterruptedException {
		DriverFactory_TestNG df = new DriverFactory_TestNG();
		df.init_browser(br);
		
	}


	@AfterMethod
	public void teardownDriver() {
		DriverFactory_TestNG.tear_driver();
	}

	public void failed_screenshot(String testMethodName) throws IOException {
		WebDriver driver = DriverFactory_TestNG.getDriver();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sFile = ts.getScreenshotAs(OutputType.FILE); //THIS METHOD WILL RETURN FILE TYPE OBJECT OR VARIABLE
		File dFile= new File("/Users/arpitgupta/eclipse-workspace/DISHA_TDD_218/screenshots/"
				+testMethodName+"_" + ".jpg");
		FileUtils.copyFile(sFile, dFile);

	}
	
	@DataProvider(name = "pythonCodeValidandInvalid")
	public Object[] pythonCodeTestData() throws IOException {
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
		
		Object[][] data = { { "ValidCode", testDataValid.get("PythonCode"), testDataValid.get("RunResult") },
				{ "InvalidCode", testDataInValid.get("PythonCode"), testDataInValid.get("RunResult") } };
		return data;
		
	}
	



}
