package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.BasePage;
import pageFactory.Launch_pf;


public class LaunchTest extends BaseTest {

	public LaunchTest() throws IOException {
		super();

	}

	Launch_pf Launchpf;
	BasePage base;
	

	@BeforeMethod

	public void setup() throws IOException, InterruptedException {
	
		Launchpf = new Launch_pf();
		Launchpf.get_testUrl();
	}

	@Test
	public void checkmsg() {

		String expmsg = "You are at the right place";
		String actmsg = Launchpf.gettextmsg();
		log.info("check succesfull message");
		Assert.assertEquals(actmsg, expmsg, "user is not able see the message 'you are at rightplace' ");
	}

	@Test
	public void clickgetstarted() {

		Launchpf.clickgetstarted();
		String actmsg = Launchpf.gettitle();
		String expmsg = "NumpyNinja";
		log.info("clicking on getstarted ");
		Assert.assertEquals(actmsg, expmsg, "user is not on the homepage with title numpyninja");
	}

}