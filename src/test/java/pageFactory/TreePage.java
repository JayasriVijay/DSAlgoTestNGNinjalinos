package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;


public class TreePage extends BasePage{
	
	public TreePage() throws IOException {
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));	
	}
	
	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;
	
	@FindBy(xpath = "//h5[text()='Tree']/../../..//a[contains(text(),'Get Started' )]")
	WebElement treegetStartedButton;
	@FindBy(xpath = "//a[@class='list-group-item' and text()='Overview of Trees']")
	WebElement overviewOfTree;
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signin;
	@FindBy(id = "id_username")
	private WebElement usernameField;
	@FindBy(id = "id_password")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement loginGetStarted;
	@FindBy(xpath = "//a[contains(text(),'Terminologies')]")
	WebElement terminologies;
	@FindBy(xpath = "//h4[text()='Tree']/../../../..//div[2]//a[text()='Types of Trees']")
	WebElement typeofTrees;
	@FindBy(xpath = "//a[contains(text(),'Tree Traversals')]")
	WebElement traversals;
	@FindBy(xpath = "//a[contains(text(),'Traversals-Illustration')]")
	WebElement traIllustration;
	@FindBy(xpath = "//a[contains(text(),'Binary Trees')]")
	WebElement binaryTrees;
	@FindBy(xpath = "//a[contains(text(),'Types of Binary Trees')]")
	WebElement typofBinary;
	@FindBy(xpath = "//a[text()='Implementation in Python']")
	WebElement impPython;
	@FindBy(xpath = "//a[text()='Binary Tree Traversals']")
	WebElement binaryTraversal;
	@FindBy(xpath = "//a[text()='Applications of Binary trees']")
	WebElement appofBinary;
	@FindBy(xpath = "//a[text()='Implementation of Binary Trees']")
	WebElement impOfBinary;
	@FindBy(xpath = "//a[contains(text(),'Binary Search Trees')]")
	WebElement binarySearch;
	@FindBy(xpath = "//a[contains(text(),'Implementation Of BST')]")
	WebElement impOfBST;
	@FindBy(xpath ="//a[@class='list-group-item']")
	List<WebElement> treeLinks;
	@FindBy(xpath = "//a[contains(text(),'Try here')]")
	WebElement tryHereButton;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runButton;
	@FindBy(xpath = "//div[@class='CodeMirror-measure']//span")
	WebElement textEditor;
	@FindBy(id = "output")
	WebElement outputTxt;
	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement practQuestTree;

		
	public void getToTree() throws InterruptedException, IOException {
			wait.until(ExpectedConditions.elementToBeClickable(treegetStartedButton)).click();
		
	
	}
	
	
	
	public void practice_Tree() {
		wait.until(ExpectedConditions.elementToBeClickable(practQuestTree)).click();
		
	}
	
	
	public void verifyLinks() {
		List<String> expectedLinks = Arrays.asList(
			"Overview of trees", "Terminologies", "Types of Tree", "Tree Traversals",
			"Traversals-Illustration", "Binary Trees", "Types of Binary", "Implementation in Python",
			"Binary Tree Traversals", "Applications of Binary trees", "Implementation of Binary Trees",
			"Binary Search", "Implementation of BST"
		);
		System.out.println("Total matching links " + treeLinks.size());
		((JavascriptExecutor) tldriver).executeScript("window.scrollTo(0, 300);");
		for (WebElement treeLink : treeLinks) {
			String linkText = treeLink.getText().trim();
			if (expectedLinks.contains(linkText)) {
				System.out.println("Link found- " + linkText);
				System.out.println(" url of the links  " + treeLink.getAttribute("href"));
			} 
		}
	}
	

	public void click_Overview() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(overviewOfTree)).click();
	}
	
	public String outputText() {
		String OuputResult = outputTxt.getText();
		System.out.println(OuputResult);
		return OuputResult;
	}
	
	public void click_Terminilogy() {
		wait.until(ExpectedConditions.elementToBeClickable(terminologies)).click();
		
	}
	public void typesOfTrees() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(typeofTrees)).click();
		
	}
	
	public void tree_Trav() {

		wait.until(ExpectedConditions.elementToBeClickable(traversals)).click();
		

	}

	public void Traversal_Illustra() {
		wait.until(ExpectedConditions.elementToBeClickable(traIllustration)).click();
		

	}

	
	public void binary_Tree() {
		wait.until(ExpectedConditions.elementToBeClickable(binaryTrees)).click();
		
	}

	public String navigate_binaryTree() {
		String afterNavigation = tldriver.getCurrentUrl();
		System.out.println("check after click" + afterNavigation);
		return afterNavigation;
	}

	public void types_ofBinary() {
		wait.until(ExpectedConditions.elementToBeClickable(typofBinary)).click();
		
	}



	public void Impl_in_Python() {
		wait.until(ExpectedConditions.elementToBeClickable(impPython)).click();
		
	}


	public void binary_Tree_Travers() {
		wait.until(ExpectedConditions.elementToBeClickable(binaryTraversal)).click();
		
	}
	public void app_of_binaryTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(appofBinary)).click();

	}

	public void imp_of_binaryTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(impOfBinary)).click();

	}

	public void binary_Search() {
		wait.until(ExpectedConditions.elementToBeClickable(binarySearch)).click();

	}

	public void Implement_OfBst() {
		wait.until(ExpectedConditions.elementToBeClickable(impOfBST)).click();

	}
	

public void click_TryHere() {
	wait.until(ExpectedConditions.elementToBeClickable(tryHereButton)).click();
}
}