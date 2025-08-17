package pageFactory;

import java.time.Duration;

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
	String browser;
	WebDriverWait wait;
	
	public Queue_pf() {
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

	}


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

	
	public void queue_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(QueueBtn)).click();
	}

	public void implementation_queue_python_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(implementationQueuePythonBtn)).click();
	}

	public void implementation_collection_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(implementationUseCollectionBtn)).click();

	}

	public void implementation_array_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(implementationUseArrayBtn)).click();

	}

	public void queue_operations_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(queueOperationsBtn)).click();

	}

	public void practice_queue() {
		wait.until(ExpectedConditions.elementToBeClickable(queuePracticeQ)).click();

	}

	public void tryhere_queue() {

		wait.until(ExpectedConditions.elementToBeClickable(tryHereQueue)).click();
	}

	
}
