package pageObjects;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverFactory.DriverFactory;


public class RegisterPage extends BasePage {
	
	public RegisterPage() {
	    super();
		
    }
	@FindBy(id="id_username")
	WebElement usernameInput;
	@FindBy(id="id_password1")
	WebElement passwordInput;
	@FindBy(id="id_password2")
	WebElement confirmPasswordInput;
	@FindBy(xpath="//*[@value='Register']")
	WebElement registerButton;
	@FindBy(xpath ="//*[contains(@class,'alert')]")
	WebElement errorText;
	private String actualResult;
 
    
    private static final Map<String, String> fieldIdMap = new HashMap<>();
    static {
        fieldIdMap.put("username", "id_username");
        fieldIdMap.put("password", "id_password1");
        fieldIdMap.put("confirmPassword", "id_password2");
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username == null ? "" : username);
    }

    public void enterPassword(String password) {
    
        passwordInput.sendKeys(password == null ? "" : password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        
        confirmPasswordInput.sendKeys(confirmPassword == null ? "" : confirmPassword);
    }

    public void clickRegister() {
        registerButton.click();
    }

   public String actualError(String fieldname) {
	   String fieldId=fieldIdMap.get(fieldname);
	    JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getdriver();
	    actualResult = (String) js.executeScript(
	        "return document.getElementById(arguments[0]).validationMessage;",fieldId
	    );
	return actualResult;
	   
   }
   
   public String errorText() {
	    return errorText.getText();
	}
	


}
