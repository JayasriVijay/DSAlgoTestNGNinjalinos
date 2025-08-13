package pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;

public class Queue_pf {

	private WebDriver tldriver;
	private Actions action;
	String browser;
	WebDriverWait wait;
	
	
	@FindBy(xpath = "//h5[text()='Queue']/../../..//a[text()='Get Started']")
	WebElement QueueBtn;

	@FindBy(xpath = "//a[text()='Implementation of Queue in Python']")
	WebElement implementationQueuePythonBtn;

	@FindBy(xpath = "//a[text()='Implementation using collections.deque']")
	WebElement implementationUseCollectionBtn;

	@FindBy(xpath = "//a[text()='Implementation using array']")
	WebElement implementationUseArrayBtn;

	@FindBy(xpath = "//a[text()='Queue Operations']")
	WebElement queueOperationsBtn;

	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement queuePracticeQ;
	
	@FindBy(xpath = "//div[2]/following::*/div[2]/a")
	WebElement tryHereQueue;



	public Queue_pf() {
		this.tldriver = DriverFactory_TestNG.getDriver();
		
		//this.tldriver = driver;
		this.action = new Actions(tldriver);
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

	}



	public void waitUntilPageLoads(String partialUrl) {
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public void queue_btn() {
		//((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", QueueBtn);

		//action.scrollToElement(QueueBtn).perform();
		//action.click(QueueBtn).perform();
		wait.until(ExpectedConditions.elementToBeClickable(QueueBtn)).click();
	}

	public void implementation_queue_python_btn() {
		//((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", implementationQueuePythonBtn);

		//action.scrollToElement(implementationQueuePythonBtn).perform();
		//action.click(implementationQueuePythonBtn).perform();
		wait.until(ExpectedConditions.elementToBeClickable(implementationQueuePythonBtn)).click();
	}

	public void implementation_collection_btn() {
		((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);",
				implementationUseCollectionBtn);
		//action.scrollToElement(implementationUseCollectionBtn).perform();
		action.click(implementationUseCollectionBtn).perform();
	}

	public void implementation_array_btn() {

		//((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", implementationUseArrayBtn);
		//action.scrollToElement(implementationUseArrayBtn).perform();
		//action.click(implementationUseArrayBtn).perform();
	}

	public void queue_operations_btn() {

		//((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", queueOperationsBtn);
		//action.scrollToElement(queueOperationsBtn).perform();
		//action.click(queueOperationsBtn).perform();
	}

	public void practice_queue() {

		((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", queuePracticeQ);
		//action.scrollToElement(queuePracticeQ).perform();
		action.click(queuePracticeQ).perform();
	}

	public void tryhere_queue() {

		//((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", tryHereQueue);
		//action.scrollToElement(tryHereQueue).perform();
		//action.click(tryHereQueue).perform();
		wait.until(ExpectedConditions.elementToBeClickable(tryHereQueue)).click();
	}

	public String get_current_url() {
		String current_url = tldriver.getCurrentUrl();
		return current_url;
	}


}
