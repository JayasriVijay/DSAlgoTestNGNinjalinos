package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;
import utils.ConfigReader;
import utils.ExcelReader;

public class BasePage {

	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;
	ConfigReader config;
	Alert alert;
	JavascriptExecutor js;
	ExcelReader excelReader;
	HashMap<String, String> testData;

	public BasePage() throws IOException {

		this.config = new ConfigReader();
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));
		this.excelReader = new ExcelReader();
		this.js = (JavascriptExecutor) tldriver;
		this.testData = new HashMap<>();

	}

	@FindBy(xpath = "//div[2]/following::*/div[2]/a")
	WebElement tryHereQueue;
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

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runBtn;

	@FindBy(id = "output")
	WebElement outputTxt;

	public void launch_webpage() throws IOException {
		tldriver.get(config.get_prop_value("testurl"));
		launchBtn.click();
		signinBtn.click();
		testData = excelReader.readExcelRow("ValidCredential", "testdata");
		String username = testData.get("UserName");
		userName.sendKeys(username);
		String password = testData.get("Password");
		pwd.sendKeys(password);
		logInBtn.click();
	}

	public void clickRunBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(runBtn)).click();
	}
	
	

	public String alert_message() {
		alert = tldriver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}

	public void handle_alert() throws InterruptedException {
		Thread.sleep(2000);
		alert = tldriver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();

	}
	
	public boolean isAlertOpen() {
		try {
			tldriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void validAndInvalidCode(String code) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".CodeMirror")));
		js.executeScript(
				"let editor = document.querySelector('.CodeMirror').CodeMirror;" + "editor.setValue(arguments[0]);",
				code);
		wait.until(ExpectedConditions.elementToBeClickable(runBtn)).click();
	}

	public String output_text() {
		wait.until(ExpectedConditions.visibilityOf(outputTxt));
		String outputText = outputTxt.getText();
		return outputText;

	}

	
	

	public String get_current_url() {
		String current_url = tldriver.getCurrentUrl();
		return current_url;
	}

	public String getTitle() {
		String titleName = tldriver.getTitle();
		return titleName;

	}

}
