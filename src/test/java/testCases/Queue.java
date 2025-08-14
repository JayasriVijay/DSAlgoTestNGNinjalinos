package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/implementation-lists/", currentUrl,
				"not in implementation of queue in python page");
	}

	@Test(priority = 3)
	public void queueImplementationCodeEditor() {
		queue.queue_btn();
		queue.implementation_queue_python_btn();
		queue.tryhere_queue();
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

}
