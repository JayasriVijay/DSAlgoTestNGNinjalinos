package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Queue_pf;
import utils.ExcelReader;
import utils.LoggerLoad;

@Listeners({ CustomListener.class })
public class QueueTest extends BaseTest {

	public QueueTest() throws IOException {
		super();

	}

	Queue_pf queue;
	BasePage base;
	LoggerLoad log;
	ExcelReader excelReader;
	HashMap<String, String> testDataValid;
	HashMap<String, String> testDataInValid;

	@BeforeMethod
	public void queue_page() throws IOException {
		this.base = new BasePage();
		this.queue = new Queue_pf();
		this.log = new LoggerLoad();
		this.excelReader = new ExcelReader();
		this.testDataValid = new HashMap<>();
		this.testDataInValid = new HashMap<>();
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
		Assert.assertTrue(currentUrl.contains("queue/implementation-lists/"),"not in try here page of implemetation of queue in python page");
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
		allureScreenshot();
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail(
				"Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering any code in it");

	}

	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
	public void queueTryingValidAndInvalidCode(String code) throws IOException {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
		base.validAndInvalidCode(code);
		String validCodedata = testDataValid.get("PythonCode");
		String invalidCodedata = testDataInValid.get("PythonCode");
		String expectedOutput = testDataValid.get("RunResult");
		String alertexpected = testDataInValid.get("RunResult");

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
	public void queueImplementationUsingCollection() {
		queue.queue_btn();
		queue.implementation_collection_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/implementation-collections/", currentUrl,
				"not in implementation of queue in python page");
	}

	@Test(priority = 7)
	public void queueImplementationUsingCollectionCodeEditor() {
		queue.queue_btn();
		queue.implementation_collection_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

	@Test(priority = 8)
	public void queueImplementationUsingArray() {
		queue.queue_btn();
		queue.implementation_array_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/Implementation-array/", currentUrl,
				"not in implementation of queue in python page");
	}

	@Test(priority = 9)
	public void queueImplementationUsingArrayCodeEditor() {
		queue.queue_btn();
		queue.implementation_array_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

	@Test(priority = 10)
	public void queueOperations() {
		queue.queue_btn();
		queue.queue_operations_btn();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/QueueOp/", currentUrl,
				"not in implementation of queue in python page");
	}

	@Test(priority = 11)
	public void queueOperationsCodeEditor() {
		queue.queue_btn();
		queue.queue_operations_btn();
		queue.tryhere_queue();
		String currentUrl = base.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

	@Test(priority = 12)
	public void queueOpenPracticeQuestions() {
		queue.queue_btn();
		queue.queue_operations_btn();
		queue.practice_queue();
		allureScreenshot();
		log.error("Practice questions page is empty in queue module");
		Assert.fail(
				"Failing this test case to show the bug which is,there are no practice questions available for queue module");

	}

}
