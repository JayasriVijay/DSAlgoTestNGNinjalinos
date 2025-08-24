package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ConfigReader;

public class Launch_pf extends BasePage {

	public Launch_pf() throws IOException {
		super();

	}

	@FindBy(xpath = "//*[text()='You are at the right place']")
	WebElement message;

	@FindBy(xpath = "//*[text()='Get Started']")

	WebElement btn_getstarted;

	@FindBy(xpath = "//*[text()='NumpyNinja']")
	WebElement numpyNinja;
	private ConfigReader config;

	public void clickgetstarted() {
		btn_getstarted.click();
	}

	public void numpyNinja() {
		numpyNinja.isDisplayed();

	}

	public void get_testUrl() throws IOException {
		config = new ConfigReader();
		tldriver.get(config.get_prop_value("testurl"));
	}

	public String gettextmsg() {
		String text = message.getText();
		return text;
	}

	public String gettitle() {
		String title = tldriver.getTitle();
		return title;
	}

	public void quitdriver() {
		tldriver.quit();
	}
}