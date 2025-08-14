package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Queue_pf;
import utils.LoggerLoad;

@Listeners(CustomListener.class)
public class Queue extends BaseTest {

	public Queue() throws IOException {
		super();

	}

	Queue_pf queue;
	BasePage base;
	LoggerLoad log;

	@BeforeMethod
	public void queue_page() throws IOException {
		this.base = new BasePage();
		this.queue = new Queue_pf();
		this.log = new LoggerLoad();

	}

	@Test(priority = 1)
	public void open_queue_page() {

		queue.queue_btn();

	}

	@Test(priority = 2)
	public void queueImplementation() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/implementation-lists/", currentUrl,
				"not in implementation of queue in python page");
	}

	@Test(priority = 3)
	public void queueImplementationCodeEditor() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}
	
	@Test(priority = 4)
	public void queueTryingEmptyEditor() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		base.clickRunBtn();
		//Assert.assertEquals("Code editor is empty", base.alert_message());
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail("Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering anhy code in it");
		
	}
	
	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
	public void queueTryingValidAndInvalidCode(String code) throws IOException {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		base.validAndInvalidCode(code);
		String validCodedata = base.validCode();
		String invalidCodedata = base.inValidCode();
		String expectedOutput = base.validOutput();
		String alertexpected = base.expectedAlert();
		
		
		if(code.equals(validCodedata)) 
		{
		Assert.assertEquals(base.output_text(),expectedOutput, "did not get the expected output");
			
			}
		else if(code.equals(invalidCodedata))
		{
		String alertmsg = base.alert_message();
		base.handle_alert();
		
		Assert.assertEquals(alertmsg, alertexpected, "did not get correct alert message for giving an invalid code as input" );	
		
		}
		else {
		    Assert.fail("Provided code did not match valid or invalid test data");
		}
		
	}
	
	
	
	

}
