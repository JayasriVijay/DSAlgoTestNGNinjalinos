package pageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;
import utils.ConfigReader;

public class Launch_pf {

	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;

	public Launch_pf() {
		this.tldriver = DriverFactory_TestNG.getDriver();
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

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