package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;

import pageFactory.Stack_pf;
import utils.LoggerLoad;

@Listeners(CustomListener.class)
public class Stack extends BaseTest {

	Stack_pf stack;
	BasePage base;
	LoggerLoad log;

	@BeforeMethod
	public void stack_page() throws IOException {
		this.base = new BasePage();
		this.stack = new Stack_pf();
		this.log = new LoggerLoad();

	}

	@Test(priority = 1)
	public void open_stac_page() {
		//base.waitUntilPageLoads("/home");
		stack.stack_btn();
	}

	@Test(priority = 2)
	public void stackOperations() {
		//base.waitUntilPageLoads("/home");
		stack.stack_btn();

		//base.waitUntilPageLoads("/stack/");
		stack.opreations_stack_btn();
		//base.waitUntilPageLoads("/operations-in-stack/");
		String currentUrl = stack.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/stack/operations-in-stack/", currentUrl,
				"not in operations in stack page");
	}

	@Test(priority = 3)
	public void StackoperationsCodeEditor() {
		//base.waitUntilPageLoads("/home");
		stack.stack_btn();
		//base.waitUntilPageLoads("/stack/");
		stack.opreations_stack_btn();
		//base.waitUntilPageLoads("/operations-in-stack/");
		stack.tryhere_stack();
		//base.waitUntilPageLoads("/tryEditor");
		String currentUrl = stack.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of operations in stack page");

	}
	
	
	@Test(priority = 4)
	public void StackoperationsTryingEmptyEditor() {
		stack.stack_btn();
		stack.opreations_stack_btn();
		stack.tryhere_stack();
		base.clickRunBtn();
		//Assert.assertEquals("Code editor is empty", base.alert_message());
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail("Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering anhy code in it");
		
	}

}
