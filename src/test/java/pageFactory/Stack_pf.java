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

public class Stack_pf {
	private WebDriver tldriver;
	private Actions action;
	String browser;
	WebDriverWait wait;

	@FindBy(xpath = "//h5[text()='Stack']/../../..//a[text()='Get Started']")
	WebElement stackBtn;

	@FindBy(xpath = "//a[text()='Operations in Stack']")
	WebElement operationsStackBtn;

	@FindBy(xpath = "//a[text()='Implementation']")
	WebElement implementationStackBtn;

	@FindBy(xpath = "//a[text()='Applications']")
	WebElement applicationStackBtn;

	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement stackPracticeQ;

	@FindBy(xpath = "//div[2]/following::*/div[2]/a")
	WebElement tryHereStack;

	public Stack_pf() {
		this.tldriver = DriverFactory_TestNG.getDriver();
		this.action = new Actions(tldriver);
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

	}

	public void stack_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(stackBtn)).click();

	}

	public void opreations_stack_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(operationsStackBtn)).click();

	}

	public void implementation_stack_btn() {

	}

	public void application_stack_btn() {

	}

	public void practice_stack() {

		action.scrollToElement(stackPracticeQ).perform();
		action.click(stackPracticeQ).perform();
	}

	public void tryhere_stack() {

		wait.until(ExpectedConditions.elementToBeClickable(tryHereStack)).click();
	}

	public String get_current_url() {
		String current_url = tldriver.getCurrentUrl();
		return current_url;
	}

}
