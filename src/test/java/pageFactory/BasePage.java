package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import driverFactory.DriverFactory_TestNG;
import utils.ConfigReader;
import utils.ExcelReader;

public class BasePage {

	private WebDriver tldriver;
	private Actions action;
	String browser;
	Alert alert;
	//JavascriptExecutor js;
	WebDriverWait wait;
	ConfigReader config;
	ExcelReader excelReader;
	HashMap<String, String> testData;
	


	public BasePage() throws IOException {
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(15));

		this.action = new Actions(tldriver);
		this.config = new ConfigReader();
		this.excelReader = new ExcelReader();
		this.testData = new HashMap<>();
		
	}

	// =========== LOGIN ELEMENTS ============

	@FindBy(className = "btn")
	WebElement launchBtn;

	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signinBtn;

	@FindBy(id = "id_username")
	WebElement userName;

	@FindBy(id = "id_password")
	WebElement pwd;

	@FindBy(xpath = "//input[4]")
	WebElement logInBtn;

	@FindBy(xpath = "//*[text()='Sign out']")
	WebElement signOut;

	//Common elements

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]/div")
	WebElement textEditor;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runBtn;
	@FindBy(id = "output")
	WebElement outputTxt;

	
	public void launch_webpage() throws IOException {
		tldriver.get(config.get_prop_value("testurl"));
		launchBtn.click();
		signinBtn.click();
		testData = excelReader.readExcelRow("ValidCredential", "testdata");
		String data1 = testData.get("UserName");
		String data2 = testData.get("Password");

		userName.sendKeys(data1);
		pwd.sendKeys(data2);
		logInBtn.click();

	}


	public void clickRun() {
		runBtn.click();
	}


	public String output_text() {
		wait.until(ExpectedConditions.visibilityOf(outputTxt));
		action.scrollToElement(outputTxt).perform();
		String outputText = outputTxt.getText();
		return outputText;

	}

	public String alert_message() {
		alert = tldriver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}

	public void handle_alert() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert = tldriver.switchTo().alert();
		alert.accept();

	}

	public String get_current_url() {
		String current_url = tldriver.getCurrentUrl();
		return current_url;
	}


	public String getTitle() {
		return tldriver.getTitle();
	}

	
}
