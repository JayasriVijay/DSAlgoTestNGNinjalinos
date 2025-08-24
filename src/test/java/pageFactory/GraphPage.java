package pageFactory;

import java.io.IOException;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GraphPage extends BasePage {

	// constructor
	public GraphPage() throws IOException {
		super();
	}

	@FindBy(xpath = "//a[text()='Get Started' and @href='graph']")
	WebElement graphGetStarted;
	@FindBy(xpath = "//a[@href='graph' and text()='Graph']")
	WebElement graph;
	@FindBy(xpath = "//a[contains(text(),'Graph Representations')]")
	WebElement graphRepr;
	@FindBy(tagName = "a")
	List<WebElement> graphLinks;
	@FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
	WebElement tryHereButton;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runButton;
	@FindBy(xpath = "//div[@class='CodeMirror-measure']//span")
	WebElement textEditor;
	@FindBy(id = "output")
	WebElement outputTxt;
	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement practQuestGraph;
	// background
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
	@FindBy(id = "content")
	WebElement practicePage;

	// Login to Graph
	public void getTograph() throws InterruptedException, IOException {
		((JavascriptExecutor) tldriver).executeScript("arguments[0].scrollIntoView(true);", graphGetStarted);
		wait.until(ExpectedConditions.elementToBeClickable(graphGetStarted)).click();
	}

	public void click_Graph_link() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(graph)).click();
	}

	public void click_GraphRepre() {
		wait.until(ExpectedConditions.elementToBeClickable(graphRepr)).click();
	}

	public void click_practQuest() {
		wait.until(ExpectedConditions.elementToBeClickable(practQuestGraph)).click();
	}

	public String checkNavigation() {
		@Nullable
		String title = tldriver.getTitle();
		return title;
	}

	public void clickTryHere() {
		wait.until(ExpectedConditions.elementToBeClickable(tryHereButton)).click();
	}

}