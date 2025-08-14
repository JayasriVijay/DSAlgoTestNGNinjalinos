package pageFactory;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public BasePage() throws IOException {

		this.config = new ConfigReader();
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));
		this.excelReader = new ExcelReader();
		js = (JavascriptExecutor) tldriver;

	}

	public void launch_webpage() throws IOException {
		tldriver.get(config.get_prop_value("testurl"));
		launchBtn.click();
		signinBtn.click();
		String username = excelReader.inputTestData("ValidCredential", "testdata", "UserName");
		userName.sendKeys(username);
		String password = excelReader.inputTestData("ValidCredential", "testdata", "Password");
		pwd.sendKeys(password);
		logInBtn.click();
	}

	public void clickRunBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(runBtn)).click();
	}

	public String alert_message() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert = tldriver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}

	public void handle_alert() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert = tldriver.switchTo().alert();
		alert.accept();

	}

	public void validAndInvalidCode(String code) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".CodeMirror")));
		js.executeScript(
				"let editor = document.querySelector('.CodeMirror').CodeMirror;" + "editor.setValue(arguments[0]);",
				code);
		wait.until(ExpectedConditions.elementToBeClickable(runBtn)).click();
	}

	public String validCode() throws IOException {
		String validCodeData = excelReader.inputTestData("ValidCode", "testdata", "PythonCode");

		return validCodeData;
	}

	public String inValidCode() throws IOException {
		String inValidCodeData = excelReader.inputTestData("InvalidCode", "testdata", "PythonCode");
		return inValidCodeData;
	}

	public String validOutput() throws IOException {
		String validOutputData = excelReader.inputTestData("ValidCode", "testdata", "RunResult");
		return validOutputData;
	}

	public String expectedAlert() throws IOException {
		String alert = excelReader.inputTestData("InvalidCode", "testdata", "RunResult");
		return alert;
	}

	public String output_text() {
		wait.until(ExpectedConditions.visibilityOf(outputTxt));
		String outputText = outputTxt.getText();
		return outputText;

	}

}
