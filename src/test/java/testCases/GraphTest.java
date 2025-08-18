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
	HashMap<String, String> testDataValid;
	HashMap<String, String> testDataInValid;

	@BeforeMethod
	public void graphPage() throws InterruptedException, IOException {
		this.graphPg = new GraphPage();
		this.base = new BasePage();
		this.log = new LoggerLoad();
		this.excelReader= new ExcelReader();
		this.testDataValid = new HashMap<>();
		this.testDataInValid = new HashMap<>();
		base.launch_webpage();
		
	}

	//@Test(priority = 1)
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

	//@Test(priority = 2)
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

	
	//@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
	public void graphTryingValidAndInvalidCode(String code) throws InterruptedException, IOException {
		graphPg.getTograph();
		graphPg.click_Graph_link();
		graphPg.clickTryHere();
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
		base.validAndInvalidCode(code);
		String validCodedata = testDataValid.get("PythonCode");
		String invalidCodedata = testDataInValid.get("PythonCode");
		String expectedOutput = testDataValid.get("RunResult");
		String alertexpected = testDataInValid.get("RunResult");
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