package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.BasePage;
import pageFactory.Queue_pf;
import utils.Dataprovider;

public class QueueTest extends BaseTest {

	public QueueTest() throws IOException {
		super();

	}

	Queue_pf queue;
	BasePage base;

	@BeforeMethod
	public void queue_page() throws IOException {
		this.base = new BasePage();
		this.queue = new Queue_pf();
		base.launch_webpage();

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
		Assert.assertTrue(currentUrl.contains("queue/implementation-lists/"),
				"not in try here page of implemetation of queue in python page");
	}

	@Test(priority = 3)
	public void queueImplementationCodeEditor() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 4)
	public void queueTryingEmptyEditor() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		base.clickRunBtn();
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail(
				"Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering any code in it");

	}

	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid", dataProviderClass = Dataprovider.class)
	public void queueTryingValidAndInvalidCode(String ScenarioName, String code, String expectedOutput)
			throws InterruptedException, IOException {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		base.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();

			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			base.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 6)
	public void queueImplementationUsingCollection() {
		queue.queue_btn();
		queue.implementation_collection_btn();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/queue/implementation-collections/"));
	}

	@Test(priority = 7)
	public void queueImplementationUsingCollectionCodeEditor() {
		queue.queue_btn();
		queue.implementation_collection_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 8)
	public void queueImplementationUsingArray() {
		queue.queue_btn();
		queue.implementation_array_btn();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/queue/Implementation-array/"));
	}

	@Test(priority = 9)
	public void queueImplementationUsingArrayCodeEditor() {
		queue.queue_btn();
		queue.implementation_array_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 10)
	public void queueOperations() {
		queue.queue_btn();
		queue.queue_operations_btn();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/queue/QueueOp/"));
	}

	@Test(priority = 11)
	public void queueOperationsCodeEditor() {
		queue.queue_btn();
		queue.queue_operations_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 12)
	public void queueOpenPracticeQuestions() {
		queue.queue_btn();
		queue.queue_operations_btn();
		queue.practice_queue();
		log.error("Practice questions page is empty in queue module");
		Assert.fail(
				"Failing this test case to show the bug which is,there are no practice questions available for queue module");

	}

}
