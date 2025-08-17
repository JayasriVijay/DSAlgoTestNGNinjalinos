package testMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverManager.DriverFactory;
import pageObjects.Array_pf;
import pageObjects.Base_pf;
import utils.ExcelReaderFile;

public class BaseTest {
	
	ExcelReaderFile excelReader;

	public BaseTest() throws IOException {
		this.excelReader = new ExcelReaderFile();
	}

	

	@Parameters({"browser"})
	@BeforeMethod
	public void testEnterWebsite(@Optional("firefox")String br) throws IOException, InterruptedException {
		DriverFactory df = new DriverFactory();
		df.initDriver(br);
		//Base_pf base_pf =new Base_pf();
		//base_pf.launch_webpage();

	}


	@AfterMethod
	public void closeBrowser() {
		DriverFactory.quitDriver();
	}

	public void takeScreenshot_failedTC(String testMethodName) throws IOException {
		WebDriver driver = DriverFactory.getDriver();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sFile = ts.getScreenshotAs(OutputType.FILE); //THIS METHOD WILL RETURN FILE TYPE OBJECT OR VARIABLE
		File dFile= new File("/Users/arpitgupta/eclipse-workspace/DISHA_TDD_218/screenshots/"
				+testMethodName+"_" + ".jpg");
		FileUtils.copyFile(sFile, dFile);

	}
	

	
//	@DataProvider(name = "InvalidDataForEditor")   //USING THIS
//	public String[] invalidDataTryEditor() throws IOException {
//		String[] data = new String[2];
//		data[0] = excelReader.inputTestData("Sheet1", "Try here Invalid code", "PythonCode");
//		data[1] = excelReader.inputTestData("Sheet1", "Invalid credential", "UserName");
//		return data;    	
//    }
	


}
