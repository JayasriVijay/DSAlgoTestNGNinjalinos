package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.jspecify.annotations.Nullable;
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
		this.action = new Actions(tldriver);
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));	
	}
	
	private WebDriver tldriver;
	private Actions action;
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
		
		((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", treegetStartedButton);
		wait.until(ExpectedConditions.elementToBeClickable(treegetStartedButton));
		action.moveToElement(treegetStartedButton).click().perform();
	
	}
	
	
	//action methods
	public void practice_Tree() {
		((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", practQuestTree);
		action.scrollToElement(practQuestTree).perform();
		action.click(practQuestTree).perform();
	}
	
	public void scrollDownTree() throws InterruptedException {
		((JavascriptExecutor) tldriver).executeScript("window.scrollTo(0, 600);");
		Thread.sleep(3000);
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
		action.scrollToElement(overviewOfTree).perform();
		wait.until(ExpectedConditions.elementToBeClickable(overviewOfTree));
		action.click(overviewOfTree).perform();
	}
	
	public String outputText() {
		String OuputResult = outputTxt.getText();
		System.out.println(OuputResult);
		return OuputResult;
	}
	
	public void click_Terminilogy() {
		action.scrollToElement(terminologies).perform();
		wait.until(ExpectedConditions.elementToBeClickable(terminologies));
		action.click(terminologies).perform();
		wait.until(ExpectedConditions.urlContains("/tree/terminologies/"));
	}
	public void typesOfTrees() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(typeofTrees));
		action.scrollToElement(typeofTrees).perform();
		wait.until(ExpectedConditions.elementToBeClickable(typeofTrees));
		action.click(typeofTrees).perform();
		wait.until(ExpectedConditions.urlContains("/tree/types-of-trees/"));
	}
	
	public void tree_Trav() {
		wait.until(ExpectedConditions.visibilityOf(traversals));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", traversals);
		action.scrollToElement(traversals).perform();
		wait.until(ExpectedConditions.elementToBeClickable(traversals));
		action.click(traversals).perform();
		wait.until(ExpectedConditions.urlContains("/tree/tree-traversals/"));

	}
	public String navigation_treeTrav() {
		String afterNavigation = tldriver.getCurrentUrl();
		System.out.println("check after click" + afterNavigation);
		return afterNavigation;
	}

	public void Traversal_Illustra() {
		wait.until(ExpectedConditions.visibilityOf(traIllustration));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", traIllustration);
		action.scrollToElement(traIllustration).perform();
		wait.until(ExpectedConditions.elementToBeClickable(traIllustration));
		action.click(traIllustration).perform();
		// wait.until(ExpectedConditions.urlContains("/tree/traversals-illustration/"));

	}

	
	public void binary_Tree() {
		wait.until(ExpectedConditions.visibilityOf(binaryTrees));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", binaryTrees);
		action.scrollToElement(binaryTrees).perform();
		wait.until(ExpectedConditions.elementToBeClickable(binaryTrees));
		action.click(binaryTrees).perform();
		wait.until(ExpectedConditions.urlContains("/tree/binary-trees/"));
	}

	public String navigate_binaryTree() {
		String afterNavigation = tldriver.getCurrentUrl();
		System.out.println("check after click" + afterNavigation);
		return afterNavigation;
	}

	public void types_ofBinary() {
		wait.until(ExpectedConditions.visibilityOf(typofBinary));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typofBinary);
		action.scrollToElement(typofBinary).perform();
		wait.until(ExpectedConditions.elementToBeClickable(typofBinary));
		action.click(typofBinary).perform();
		wait.until(ExpectedConditions.urlContains("tree/types-of-binary-trees/"));
	}

	public String navigate_typesOfBinary() {
		String afterNavigation = tldriver.getCurrentUrl();
		System.out.println("check after click" + afterNavigation);
		return afterNavigation;
	}

	public void Impl_in_Python() {
		wait.until(ExpectedConditions.visibilityOf(impPython));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", impPython);
		action.scrollToElement(impPython).perform();
		wait.until(ExpectedConditions.elementToBeClickable(impPython));
		action.click(impPython).perform();
		wait.until(ExpectedConditions.urlContains("/tree/implementation-in-python/"));
	}

	public void navigat_Imp_in_Python() {
		String afterNavigation = tldriver.getCurrentUrl();
		System.out.println("check after click" + afterNavigation);
	}

	public void binary_Tree_Travers() {
		wait.until(ExpectedConditions.visibilityOf(binaryTraversal));
		action.scrollToElement(binaryTraversal).perform();
		wait.until(ExpectedConditions.elementToBeClickable(binaryTraversal));
		action.click(binaryTraversal).perform();
		wait.until(ExpectedConditions.urlContains("/tree/binary-tree-traversals/"));
	}
	public void app_of_binaryTrees() {
		wait.until(ExpectedConditions.visibilityOf(appofBinary));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", appofBinary);
		action.scrollToElement(appofBinary).perform();
		wait.until(ExpectedConditions.elementToBeClickable(appofBinary));
		action.click(appofBinary).perform();

	}

	public void imp_of_binaryTrees() {
		wait.until(ExpectedConditions.visibilityOf(impOfBinary));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", impOfBinary);
		action.scrollToElement(impOfBinary).perform();
		wait.until(ExpectedConditions.elementToBeClickable(impOfBinary));
		action.click(impOfBinary).perform();

	}

	public void binary_Search() {
		wait.until(ExpectedConditions.visibilityOf(binarySearch));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", binarySearch);
		action.scrollToElement(binarySearch).perform();
		wait.until(ExpectedConditions.elementToBeClickable(binarySearch));
		action.click(binarySearch).perform();

	}

	public void Implement_OfBst() {
		wait.until(ExpectedConditions.visibilityOf(impOfBST));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", impOfBST);
		action.scrollToElement(impOfBST).perform();
		wait.until(ExpectedConditions.elementToBeClickable(impOfBST));
		action.click(impOfBST).perform();

	}
	

public void click_TryHere() {
	wait.until(ExpectedConditions.elementToBeClickable(tryHereButton));
	if(tryHereButton.isDisplayed() && tryHereButton.isEnabled()) {
		@Nullable
		String currentTitle = tldriver.getTitle();
	System.out.println("The Try Here Button is enabled and displayed on " + currentTitle +" Tree Page");
	action.scrollToElement(tryHereButton).perform();
	action.click(tryHereButton).perform();
	wait.until(ExpectedConditions.urlContains("https://dsportalapp.herokuapp.com/tryEditor"));
	String currentUrl = tldriver.getCurrentUrl();
	if(currentUrl.contains("https://dsportalapp.herokuapp.com/tryEditor")) {
		System.out.println("Sucessfully navigated to Try here page");
	}else System.out.println("Naviagtion failed to Try Here Page");
  }else System.out.println("Try Here button not enabled");
	
}


}
