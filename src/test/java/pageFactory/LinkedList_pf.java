package pageFactory;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverFactory.DriverFactory_TestNG;

public class LinkedList_pf extends BasePage {

	public LinkedList_pf() throws IOException {
		super();

	}

	@FindBy(xpath = "//*[@href='introduction']")
	WebElement introPageLink;
	@FindBy(xpath = "//*[contains(text(),'Practice Questions')]")
	WebElement practicePageLink;
	@FindBy(xpath = "//*[@href='linked-list']")
	WebElement linkedListButton;
	@FindBy(xpath = "//*[@href='/tryEditor']")
	WebElement tryHereButton;
	@FindBy(xpath = "//*[@class='CodeMirror-scroll']")
	WebElement tryEditor;
	@FindBy(xpath = "//*[contains(text(),'Run')]")
	WebElement runButton;
	@FindBy(xpath = "//*[@id='output']")
	WebElement output;
	@FindBy(xpath = "//*[@href='creating-linked-list']")
	WebElement createLinkedListLink;
	@FindBy(xpath = "//*[@href='types-of-linked-list']")
	WebElement typesofLinkedListLink;
	@FindBy(xpath = "//*[@href='implement-linked-list-in-python']")
	WebElement implementLinkedListLink;
	@FindBy(xpath = "//*[@href='traversal']")
	WebElement traversalLink;
	@FindBy(xpath = "//*[@href='insertion-in-linked-list']")
	WebElement insertionLink;
	@FindBy(xpath = "//*[@href='deletion-in-linked-list']")
	WebElement deletionLink;

	public void getToLinkedList() {

		linkedListButton.click();
	}

	public void clickOnIntroLink() {
		introPageLink.click();
	}

	public void clickTryHere() {
		tryHereButton.click();
	}

	public void clickOnPracticeQuestion() {
		practicePageLink.click();
	}

	public void clickOncreateLinkedListLink() {
		createLinkedListLink.click();
	}

	public void clickOntypesofLinkedList() {
		typesofLinkedListLink.click();
	}

	public void clickOnimplementLinkedList() {
		implementLinkedListLink.click();
	}

	public void clickOntraversal() {
		traversalLink.click();
	}

	public void clickOninsertion() {
		insertionLink.click();
	}

	public void clickOndeletionLink() {
		deletionLink.click();
	}

	public void navigateToIntroTryEditor() {
		clickOnIntroLink();
		clickTryHere();
	}

	public void navigateToCreateLinkedListTryEditor() {
		clickOncreateLinkedListLink();
		clickTryHere();
	}

	public void navigateToTypesofLinkedListTryEditor() {
		clickOntypesofLinkedList();
		clickTryHere();
	}

	public void navigateToImplementLinkedListTryEditor() {
		clickOnimplementLinkedList();
		clickTryHere();
	}

	public void navigateTonavigateToTraversalTryEditor() {
		clickOntraversal();
		clickTryHere();
	}

	public void navigateTonavigateToInsertionTryEditor() {
		clickOninsertion();
		clickTryHere();
	}

	public void navigateTonavigateToDeletionTryEditor() {
		clickOndeletionLink();
		clickTryHere();
	}

}