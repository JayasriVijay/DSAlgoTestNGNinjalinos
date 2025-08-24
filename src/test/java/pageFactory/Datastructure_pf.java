package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Datastructure_pf extends BasePage {

	public Datastructure_pf() throws IOException {
		super();

	}

	@FindBy(xpath = "//*[text()='Data Structures-Introduction']//../a")
	WebElement getstartedButton_dataStructures;

	@FindBy(xpath = "//*[text()='Time Complexity']")
	WebElement timecomplexityLink;

	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement practiceQuestionsLink;

	@FindBy(xpath = "//*[text()='Try here>>>']")
	WebElement tryhereLink;

	@FindBy(xpath = "//div[@class='CodeMirror-lines']")
	WebElement tryEditorbox;

	@FindBy(xpath = "//*[text()='Run']")
	WebElement runButton;

	@FindBy(xpath = "//h4[text()='Data Structures-Introduction']")
	WebElement datastructuresPagetitle;

	@FindBy(xpath = "//p[text()='Time Complexity']")
	WebElement timecomplexitytitle;

	@FindBy(xpath = "//div[@align='left'] ")
	WebElement consoleoutpt;

	public String datastructurespagetitle() {
		String text = datastructuresPagetitle.getText();
		return text;
	}

	public String timecomplexitytitle() {
		String text = timecomplexitytitle.getText();
		return text;
	}

	public void clickgetstartedDatastructures() {
		getstartedButton_dataStructures.click();
	}

	public void clickTimecomplexityLink() {
		if (timecomplexityLink.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(timecomplexityLink)).click();
		}

	}

	public String alert_message() {
		alert = tldriver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println(alertMsg);
		return alertMsg;
	}

	public void clickPracticeQuestionsLink() {
		practiceQuestionsLink.click();
	}

	public void clickTryhereLink() {

		if (tryhereLink.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(tryhereLink)).click();
		}

	}

	public String editortxt() {
		String txt = tryEditorbox.getText();
		return txt;
	}

	public String tryeditorurl() {
		String tryeditorurl1 = tldriver.getCurrentUrl();
		return tryeditorurl1;
	}

	public String practiceQueURl() {
		String tryeditorurl = tldriver.getCurrentUrl();
		return tryeditorurl;
	}

	public void closealert() {
		tldriver.switchTo().alert().accept();
	}

	public void clickRunButton() {
		runButton.click();
	}

	public String alertconfim() {
		String msg = "NameError: name 'DsAlgoNew' is not defined on line 1";
		return msg;
	}

	public String consoletxt() {
		String msg = consoleoutpt.getText();
		return msg;
	}

}