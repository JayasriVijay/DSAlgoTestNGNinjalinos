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
		this.action = new Actions(tldriver);
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

	}

	public void queue_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(QueueBtn)).click();
	}

	public void implementation_queue_python_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(implementationQueuePythonBtn)).click();
	}

	public void implementation_collection_btn() {

	}

	public void implementation_array_btn() {

	}

	public void queue_operations_btn() {

	}

	public void practice_queue() {

	}

	public void tryhere_queue() {

		wait.until(ExpectedConditions.elementToBeClickable(tryHereQueue)).click();
	}

	public String get_current_url() {
		String current_url = tldriver.getCurrentUrl();
		return current_url;
	}

}
