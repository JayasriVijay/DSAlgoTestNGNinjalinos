package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stack_pf extends BasePage {

	public Stack_pf() throws IOException {

		super();
	}

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

	public void stack_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(stackBtn)).click();

	}

	public void opreations_stack_btn() {

		wait.until(ExpectedConditions.elementToBeClickable(operationsStackBtn)).click();

	}

	public void implementation_stack_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(implementationStackBtn)).click();

	}

	public void application_stack_btn() {
		wait.until(ExpectedConditions.elementToBeClickable(applicationStackBtn)).click();

	}

	public void practice_stack() {

		wait.until(ExpectedConditions.elementToBeClickable(stackPracticeQ)).click();
	}

	public void tryhere_stack() {

		wait.until(ExpectedConditions.elementToBeClickable(tryHereStack)).click();
	}

}
