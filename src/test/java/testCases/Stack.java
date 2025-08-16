package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Stack_pf;
import utils.LoggerLoad;

@Listeners({ CustomListener.class })
public class Stack extends BaseTest {

	public Stack() throws IOException {
		super();

	}

	Stack_pf stack;
	BasePage base;
	LoggerLoad log;

	@BeforeMethod
	public void stack_page() throws IOException {
		this.base = new BasePage();
		this.stack = new Stack_pf();
		this.log = new LoggerLoad();
		base.launch_webpage();

	}

	@Test(priority = 1)
	public void open_stac_page() {
		stack.stack_btn();
	}

	@Test(priority = 2)
	public void stackOperations() {
		stack.stack_btn();
		stack.opreations_stack_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/stack/operations-in-stack/", currentUrl,
				"not in operations in stack page");
	}

	@Test(priority = 3)
	public void stackoperationsCodeEditor() {
		stack.stack_btn();
		stack.opreations_stack_btn();
		stack.tryhere_stack();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

	@Test(priority = 4)
	public void StackTryingEmptyEditor() {
		stack.stack_btn();
		stack.opreations_stack_btn();
		stack.tryhere_stack();
		base.clickRunBtn();
		allureScreenshot();
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail(
				"Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering anhy code in it");

	}

	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
	public void StackTryingValidAndInvalidCode(String code) throws IOException {
		stack.stack_btn();
		stack.opreations_stack_btn();
		stack.tryhere_stack();
		base.validAndInvalidCode(code);
		String validCodedata = base.validCode();
		String invalidCodedata = base.inValidCode();
		String expectedOutput = base.validOutput();
		String alertexpected = base.expectedAlert();

		if (code.equals(validCodedata)) {
			Assert.assertEquals(base.output_text(), expectedOutput, "did not get the expected output");

		} else if (code.equals(invalidCodedata)) {
			String alertmsg = base.alert_message();
			base.handle_alert();

			Assert.assertEquals(alertmsg, alertexpected,
					"did not get correct alert message for giving an invalid code as input");

		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}

	}

	@Test(priority = 6)
	public void stackimplementation() {
		stack.stack_btn();
		stack.implementation_stack_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/stack/implementation/", currentUrl,
				"not in implementation in stack page");

	}

	@Test(priority = 7)
	public void stackimplementationCodeEditor() {
		stack.stack_btn();
		stack.implementation_stack_btn();
		stack.tryhere_stack();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl, "not in implementation in stack page");

	}

	@Test(priority = 8)
	public void stackapplication() {
		stack.stack_btn();
		stack.application_stack_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/stack/stack-applications/", currentUrl,
				"not in implementation in stack page");

	}

	@Test(priority = 9)
	public void stackapplicationCodeEditor() {
		stack.stack_btn();
		stack.application_stack_btn();
		stack.tryhere_stack();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl, "not in implementation in stack page");

	}

	@Test(priority = 10)
	public void StackopenPracticeQuestions() {
		stack.stack_btn();
		stack.application_stack_btn();
		stack.practice_stack();
		allureScreenshot();
		log.error("Practice questions page is empty in stack module");
		Assert.fail(
				"Failing this test case to show the bug which is,there are no practice questions available for stack module");

	}

}
