package testCases;

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
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driverFactory.DriverFactory_TestNG;
import io.qameta.allure.Allure;
import pageFactory.BasePage;
import utils.ExcelReader;

public class BaseTest {

	ExcelReader excelReader;

	public BaseTest() throws IOException {
		this.excelReader = new ExcelReader();
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void open_website(String br) throws IOException {
		DriverFactory_TestNG df = new DriverFactory_TestNG();
		df.init_browser(br);
		BasePage base;
		base = new BasePage();
		base.launch_webpage();

	}

	@AfterMethod
	public void teardownDriver() {
		DriverFactory_TestNG.tear_driver();

	}

	public void failed_screenshot(String testMethodName) throws IOException {

		File screenshot = ((TakesScreenshot) DriverFactory_TestNG.getDriver()).getScreenshotAs(OutputType.FILE);
		File savedScreenshot = new File("target/screenshots/" + "screenshot_" + testMethodName + ".jpg");
		FileUtils.copyFile(screenshot, savedScreenshot);
		try (InputStream is = new FileInputStream(savedScreenshot)) {
			Allure.addAttachment("Screenshot", "image/jpg", is, "jpg");
		}
		ChainTestListener.embed(savedScreenshot, "image/jpg");

	}

	@DataProvider(name = "pythonCodeValidandInvalid")
	public Object[] pythonCode() throws IOException {
		Object data[] = excelReader.getCode("testdata");
		return data;
	}
}
