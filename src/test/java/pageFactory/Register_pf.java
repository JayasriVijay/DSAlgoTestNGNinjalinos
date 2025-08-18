package pageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;
import utils.ExcelReader;



public class Register_pf {

	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;
	ExcelReader excelReader;
	JavascriptExecutor js;

		public Register_pf() throws IOException
		{
			this.tldriver = DriverFactory_TestNG.getDriver();
			PageFactory.initElements(tldriver, this);
			this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));
			js = (JavascriptExecutor) tldriver;
			this.excelReader = new ExcelReader();

		}
	// Locators

	@FindBy(xpath = "//*[@name='username']")
	WebElement usernameTextbox;

	@FindBy(xpath = "//*[@name='password1']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//*[@name='password2']")
	WebElement confirmpasswordTextbox;

	@FindBy(xpath = "//*[@value='Register']")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class=\"alert alert-primary\"]")
	WebElement missmatchPasswordMessage;
	

	public void setinvalidusername(String username) {
		usernameTextbox.sendKeys(username);
	}
	public void setdatas(String username,String password,String confirmpassword) {
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		confirmpasswordTextbox.sendKeys(confirmpassword);
	}
		
	public void setinvalidpassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void setinvalidconfirmpassword(String confirmpassword) {
		confirmpasswordTextbox.sendKeys(confirmpassword);
	}



	public void clickRegisterbutton() {
		registerButton.click();
	}

	public String missmatchPasswordMessage() {
		String msg = missmatchPasswordMessage.getText();
		return msg;
	}
	
	public String successfulMessage() {
		String msg = missmatchPasswordMessage.getText();
		return msg;
	}

	public String invalidAssertionUsernamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", usernameTextbox);
		return validationMsg;
	}

	public String invalidAssertionconfirmpswdbox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;",
				confirmpasswordTextbox);
		return validationMsg;
	}

	public String invalidAssertionPasswdnamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", passwordTextbox);
		return validationMsg;
	}
	
}