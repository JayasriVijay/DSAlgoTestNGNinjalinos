package testCases;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driverFactory.DriverFactory_TestNG;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageFactory.BasePage;
import utils.ExcelReader;

public class BaseTest {

	ExcelReader excelReader;

	public BaseTest() throws IOException {
		this.excelReader = new ExcelReader();
	}

	@Parameters({ "browser" })
	@BeforeMethod
		public void setup(@Optional("firefox") String br) throws IOException, InterruptedException {
		DriverFactory_TestNG df = new DriverFactory_TestNG();
		df.init_browser(br);
		BasePage base;
		base = new BasePage();
		

	}

	@AfterMethod
	public void teardownDriver() {
		DriverFactory_TestNG.tear_driver();

	}
    
	
	public void failed_screenshot(String testMethodName) throws IOException {

		File screenshot = ((TakesScreenshot) DriverFactory_TestNG.getDriver()).getScreenshotAs(OutputType.FILE);
		File savedScreenshot = new File("target/screenshots/" + "screenshot_" + testMethodName + ".jpg");
		FileUtils.copyFile(screenshot, savedScreenshot);
		ChainTestListener.embed(savedScreenshot, "image/jpg");
		
	}
	
	public void allureScreenshot() {
	try {
		byte[] screenshotBytes = ((TakesScreenshot) DriverFactory_TestNG.getDriver())
				.getScreenshotAs(OutputType.BYTES);

		
		Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshotBytes), "png");

	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	@DataProvider(name = "pythonCodeValidandInvalid")
	public Object[] pythonCode() throws IOException {
		Object data[] = excelReader.getCode("testdata");
		return data;
	}
}

