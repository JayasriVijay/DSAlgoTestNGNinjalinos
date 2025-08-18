package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import driverFactory.DriverFactory_TestNG;
import utils.ExcelReader;

public class Array_pf {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	ExcelReader excelReader;
	private BasePage base_pf;
	HashMap<String, String> PQtestData;
	HashMap<String, String> testData2;
	HashMap<String, String> testData3;


	public Array_pf() throws IOException {
		this.driver = DriverFactory_TestNG.getDriver();

		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.action = new Actions(driver);
		this.base_pf = new BasePage();

		this.excelReader = new ExcelReader();
		this.PQtestData = new HashMap<>();
		this.testData2 = new HashMap<>();
		this.testData3 = new HashMap<>();
		PQtestData = excelReader.readExcelRow("Code", "practiceQ");
	}


	// ========== Elements ==========

	@FindBy(xpath = "//h5[text()='Array']/../../..//a[text()='Get Started']")
	WebElement arrayGetStarted;

	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement arraysInPythonLink;

	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement arraysUsingListLink;

	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOperationsLink;

	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement applicationsOfArrayLink;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuestionsLink;

	@FindBy(xpath = "//a[contains(text(), 'Try here')]")
	WebElement tryHereLink;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]/div")
	WebElement textEditor;

	// Practice Questions Page
	@FindBy(xpath = "//a[text()='Search the array']")
	WebElement searchTheArrayLink;

	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement maxConsecutiveOnesLink;

	@FindBy(xpath = "//a[text()='Find Numbers with Even Number of Digits']")
	WebElement evenNumberDigitsLink;

	@FindBy(xpath = "//a[contains(text(),'Squares')]")
	WebElement squaresOfSortedArrayLink;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]")
	WebElement practiceQuestionEditor;

	@FindBy(css = "input[value='Submit']")
	WebElement submitBtn;

	// ========== Helper ==========


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


	// ============ BACKGROUND ===============

	public void background_array() throws IOException {
		base_pf.launch_webpage();
	
	}

	public void clickArrayGetStarted() {
		//driver = new ChromeDriver();

		safeClick(arrayGetStarted);
	}

	public void clickArraysInPython() {
		safeClick(arraysInPythonLink);
	}

	public void clickArraysUsingList() {
		safeClick(arraysUsingListLink);
	}

	public void clickBasicOperations() {
		safeClick(basicOperationsLink);
	}

	public void clickApplicationsOfArray() {
		safeClick(applicationsOfArrayLink);
	}

	public void clickPracticeQuestionsLink() {
		safeClick(practiceQuestionsLink);
	}

	public void clickTryHere() {
		safeClick(tryHereLink);
	}

	public void clickSearchTheArray() {
		safeClick(searchTheArrayLink);
	}

	public void clickMaxConsecutiveOnes() {
		safeClick(maxConsecutiveOnesLink);
	}

	public void clickEvenNumberDigits() {
		safeClick(evenNumberDigitsLink);
	}

	public void clickSquaresOfSortedArray() {
		safeClick(squaresOfSortedArrayLink);
	}

	public void tryEditor_validCode() throws IOException {
		testData2 = excelReader.readExcelRow("ValidCode", "testdata");
		String data = testData2.get("PythonCode");
		safeType(textEditor, data);
	}

	public void tryEditor_invalidCode() throws IOException {
		testData3 = excelReader.readExcelRow("InvalidCode", "testdata");
		String data = testData3.get("PythonCode");
		
		safeType(textEditor, data);
	}
	
	
	
	public void enterValidCodeInPracticeEditor(String code) {
	    safeClick(practiceQuestionEditor);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	   
	    js.executeScript(
	        "var editor = arguments[0].CodeMirror || arguments[0].closest('.CodeMirror').CodeMirror;" +
	        "editor.setValue(arguments[1]);",
	        practiceQuestionEditor, code);    // arguments[0] = practiceQuestionEditor (the div inside CodeMirror).
	                                        // .closest('.CodeMirror').CodeMirror ensures we fetch the real CodeMirror editor instance.
	}                                    //.setValue(code) puts the code into the editor.

	

	public void tryEditor_validCode_practiceQ1() throws IOException, InterruptedException {
		String validCode1 = PQtestData.get("PracticeQ1validcode");
		//String validCode1 = excelReader.readExcelRow("Sheet1", "Practice Q1 valid code", "PythonCode");

		enterValidCodeInPracticeEditor(validCode1);
		Thread.sleep(300);
	}

	public void tryEditor_validCode_practiceQ2() throws IOException {
		String validCode2 = PQtestData.get("PracticeQ2validcode");
		enterValidCodeInPracticeEditor(validCode2);
	}

	public void tryEditor_validCode_practiceQ3() throws IOException {
		String validCode3 = PQtestData.get("PracticeQ3validcode");
		enterValidCodeInPracticeEditor(validCode3);
	}

	public void tryEditor_validCode_practiceQ4() throws IOException {
		String validCode4 = PQtestData.get("PracticeQ4validcode");
		enterValidCodeInPracticeEditor(validCode4);
	}

	public void tryEditor_invalidCode_practiceQ() throws IOException {
		String data = PQtestData.get("InvalidCode");
		safeClick(practiceQuestionEditor);
		Actions actions = new Actions(driver);
		actions.moveToElement(practiceQuestionEditor).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
		.sendKeys(Keys.DELETE).sendKeys(data).perform();
		//practiceQuestionEditor.sendKeys(data);
	}

	public void clickSubmit() {
		safeClick(submitBtn);
	}

	public void waitForUrlToContain(String partialUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public void getErrMsg_NoCode() {
		System.out.println("No Error Alert Found, report bug");
	}

	
}
