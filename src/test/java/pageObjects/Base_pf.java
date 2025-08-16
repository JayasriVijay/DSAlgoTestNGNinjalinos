package pageObjects;

import java.io.IOException;
import java.time.Duration;

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

import driverManager.DriverFactory;
import utils.ConfigReader;
import utils.ExcelReaderFile;

public class Base_pf {
	
	private WebDriver driver;
	private Actions action;
	String browser;
	Alert alert;
	//JavascriptExecutor js;
	WebDriverWait wait;
	ConfigReader config;
	ExcelReaderFile excelReader;
//	String path;
	
	
	public Base_pf() throws IOException {
		this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		this.action = new Actions(driver);
		this.config = new ConfigReader();
		this.excelReader = new ExcelReaderFile();
		
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
	
	// Helper methods

	

	private void safeType(WebElement element, String code) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    action.moveToElement(element)
	    .click()
	    .sendKeys(code).perform();
	}
	
	private void safeClick(WebElement element) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	// Actions
	
	public void launch_webpage() throws IOException {
		driver.get(config.get_prop_value("testurl"));
		launchBtn.click();
		signinBtn.click();
		//String data1 = excelReader.getData("Credentials", 1, 0);
	   // String data2 = excelReader.getData("Credentials", 1, 1);
		//String data1 = "ninjalinos@work.com";
		//String data2 = "sdet218920@";
		//FOR NEW EXCEL SHEET
		String data1 = excelReader.inputTestData("Sheet1", "Valid credential", "UserName");
		String data2 = excelReader.inputTestData("Sheet1", "Valid credential", "Password");
		
		userName.sendKeys(data1);
		pwd.sendKeys(data2);
		logInBtn.click();


	}

//	public void get_testUrl() {
//		driver.get(config.get_prop_value("testurl"));
//	}
	
	public void tryEditor_validCode() throws IOException {
		String data = excelReader.inputTestData("Sheet1", "Try Here Valid Code", "PythonCode");
		//String data = "print(\"Hello World\")";
		safeType(textEditor, data);
	}

	public void tryEditor_invalidCode() throws IOException {
		String data = excelReader.inputTestData("Sheet1", "Try here Invalid code", "PythonCode");
		//String data = "ABC";
		safeType(textEditor, data);
	}

	public void clickRun() {
		safeClick(runBtn);
	}

	public void getErrMsg_NoCode() {
		System.out.println("No Error Alert Found, report bug");
	}


	public String output_text() {
		wait.until(ExpectedConditions.visibilityOf(outputTxt));
		action.scrollToElement(outputTxt).perform();
		String outputText = outputTxt.getText();
		return outputText;

	}

	public String alert_message() {
		alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}

	public void handle_alert() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();

	}

	public String currentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	

//	// This method is to read the expected output from the excel reader
//	public String getExcelExpOutput(String sheetName, String scenarioName ,String key ) throws IOException {
//		//String sheet = sheetName;
//		//String scenario = scenarioName;
//		//String cell = key;
//		String data = excelReader.inputTestData(sheetName, scenarioName, key);
//		return data;
//
//	}


}
