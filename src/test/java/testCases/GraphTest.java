package testCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import pageFactory.BasePage;
import pageFactory.GraphPage;
import utils.ExcelReader;
import utils.LoggerLoad;


@Listeners(CustomListener.class)
public class GraphTest extends BaseTest {
	
	public GraphTest() throws IOException {
		super();
	}

	GraphPage graphPg;
	BasePage base;
	BaseTest baseTest;
	ExcelReader excelReader;
	LoggerLoad log;


	@BeforeMethod
	public void graphPage() throws InterruptedException, IOException {
		this.graphPg = new GraphPage();
		this.base = new BasePage();
		this.log = new LoggerLoad();
		this.excelReader= new ExcelReader();
		base.launch_webpage();
		
	}

	@Test(priority = 1)
	public void getClick_Graph() throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_Graph_link();
		log.info("Clicking the Graph link");
		ChainTestListener.log("Clicking the Graph link");
		String actualTitle = graphPg.checkNavigation();
		String expectedTitle = "Graph";
		log.info("User logged in "+expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
	}

	@Test(priority = 2)
	public void getClick_GraphRepre() throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_GraphRepre();
		log.info("Clicking the Graph Representation link");
		ChainTestListener.log("Clicking the Graph link");
		String actualTitle = graphPg.checkNavigation();
		String expectedTitle = "Graph Representations";
		log.info("User logged in "+expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
	}

	
	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class)
	public void graphTryingValidAndInvalidCode(String ScenarioName, String code, String expectedOutput) throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_Graph_link();
		graphPg.clickTryHere();
		base.validAndInvalidCode(code);
			if (ScenarioName.equalsIgnoreCase("ValidCode")) {
				String actualOutput = base.output_text();
				System.out.println("checking the actual ouput :" + actualOutput);
				Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		  }  else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
				boolean alertmsg = base.isAlertOpen();
	            base.handle_alert();
			  Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		  }  else {
				Assert.fail("Provided code did not match valid or invalid test data");
			}
		
	}
	
	@Test(priority = 3)
	public void runWithoutCode() throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_Graph_link();
		graphPg.clickTryHere();
		base.clickRunBtn();
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail(
				"Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering any code in it");
	}
	
	@Test(priority = 4)
	public void practQuestion() throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_Graph_link();
		graphPg.click_practQuest();
		log.error("Practice questions page is empty in queue module");
		Assert.fail(
				"Failing this test case to show the bug which is,there are no practice questions available for queue module");
	}

}