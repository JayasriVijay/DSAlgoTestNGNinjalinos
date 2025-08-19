package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;

public class Home_pf {

	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;

	public Home_pf() {
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(30));
	}
	// Locators

	@FindBy(xpath = "//*[text()='Data Structures-Introduction']//../a")
	WebElement getstartedButton_dataStructures;

	@FindBy(xpath = "//*[text()='Array']//../a")
	WebElement getstartedButton_Array;

	@FindBy(xpath = "//*[text()='Get Started']")
	WebElement btn_getstarted;

	@FindBy(xpath = "//h5[text()='Linked List']//../a")
	WebElement getstartedButton_LinkedList;

	@FindBy(xpath = "//h5[text()='Stack']//../a")
	WebElement getstartedButton_Stack;

	@FindBy(xpath = "//h5[text()='Queue']//../a")
	WebElement getstartedButton_Queue;

	@FindBy(xpath = "//h5[text()='Tree']//../a")
	WebElement getstartedButton_Tree;

	@FindBy(xpath = "//h5[text()='Graph']//../a")
	WebElement getstartedButton_Graph;

	@FindBy(xpath = "//*[@data-toggle='dropdown']")
	WebElement dropdownbox;

	@FindBy(xpath = "//a[text()='Data Structures-Introduction']")
	WebElement dropdownDataStructuresIntroduction;

	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement dropdownboxArrays;

	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement dropdownboxLinkedList;

	@FindBy(xpath = "//a[text()='Stack']")
	WebElement dropdownboxStack;

	@FindBy(xpath = "//a[text()='Queue']")
	WebElement dropdownboxQueue;

	@FindBy(xpath = "//a[text()='Graph']")
	WebElement dropdownboxGraph;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement dropdownboxTree;

	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement register;

	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement homepage;

	@FindBy(xpath = "//*[@class='alert alert-primary']")
	WebElement notloggedinmesg;

	public void clickgetstartedDatastructures() {
		getstartedButton_dataStructures.click();
	}

	public void clickgetstartedArray() {
		getstartedButton_Array.click();

	}

	public void clickgetstartedLinkedList() {
		getstartedButton_LinkedList.click();
	}

	public void clickgetstartedStack() {
		if (getstartedButton_Stack.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(getstartedButton_Stack)).click();
		}

	}

	public void clickgetstartedQueue() {
		if (getstartedButton_Queue.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(getstartedButton_Queue)).click();
		}

	}

	public void clickgetstartedTree() {
		if (getstartedButton_Tree.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(getstartedButton_Tree)).click();
		}

	}

	public void clickgetstartedGraph() {
		if (getstartedButton_Graph.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(getstartedButton_Graph)).click();
		}

	}

	public void clickDropdownbox() {
		dropdownbox.click();
	}

	public void clickDropdownArrays() {
		dropdownboxArrays.click();
	}

	public void clickDropdownLinkedList() {
		dropdownboxLinkedList.click();
	}

	public void clickDropdownStack() {
		dropdownboxStack.click();
	}

	public void clickDropdownQueue() {

		dropdownboxQueue.click();
	}

	public void clickDropdownTree() {
		dropdownboxTree.click();
	}

	public void clickDropdownGraph() {
		dropdownboxGraph.click();
	}

	public void clickRegister() {
		register.click();
	}

	public String homepagetext() {
		String text = homepage.getText();
		return text;
	}

	public String notloggedinmesg() {

		String text1 = notloggedinmesg.getText();
		return text1;
	}
}