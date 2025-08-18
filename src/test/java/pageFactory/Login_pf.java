package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import driverFactory.DriverFactory_TestNG;
import utils.ExcelReader;
import utils.LoggerLoad;



public class Login_pf {

	private WebDriver tldriver;
	String browser;
	LoggerLoad log;
	WebDriverWait wait;
	ExcelReader excelReader;
	JavascriptExecutor js;

			public Login_pf( ) throws IOException
			{
				this.tldriver = DriverFactory_TestNG.getDriver();
				PageFactory.initElements(tldriver, this);
				this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));
				js = (JavascriptExecutor) tldriver;
				this.excelReader = new ExcelReader();

			}

	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signinLink;

	@FindBy(xpath = "//*[@name='username']")
	WebElement username_textbox;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password_textbox;

	@FindBy(xpath = "//*[@value=\"Login\"]")
	WebElement login_button;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement loginsuccesfullmessage;

	@FindBy(xpath = "//div[@role='alert'] ")
	WebElement invaliddatamsg;
	


	public void clickSigninLink() {
		signinLink.click();
	}

	public void clickLoginbutton() {
		login_button.click();
	}

	public String loginsuccesfullmessage() {
		String msg = loginsuccesfullmessage.getText();
		return msg;
	}

	public String invaliddatamessage() {
		String msg = invaliddatamsg.getText();
		return msg;
	}
	public void setdata(String username,String password) {
		username_textbox.sendKeys(username);
		password_textbox.sendKeys(password);
		
		
	}



	public String invalidAssertionusernamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", username_textbox);
		return validationMsg;
	}

	public String invalidAssertiopasswordbox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", password_textbox);
		return validationMsg;
	}

}