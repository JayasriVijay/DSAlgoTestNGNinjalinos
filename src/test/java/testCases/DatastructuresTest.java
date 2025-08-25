package testCases;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.BasePage;
import pageFactory.Datastructure_pf;
import pageFactory.Home_pf;
import utils.Dataprovider;
import utils.LoggerLoad;


public class DatastructuresTest extends BaseTest {
	public DatastructuresTest() throws IOException {
		super();

	}

	BasePage base;
	Datastructure_pf Datastructurepf;
	Home_pf Homepf;

	@BeforeMethod
	public void queue_page() throws IOException {
		this.base = new BasePage();
		this.Datastructurepf = new Datastructure_pf();
		this.Homepf = new Home_pf();
		base.launch_webpage();
		Datastructurepf.clickgetstartedDatastructures();

	}

	@Test(priority = 1)
	public void Timecomplexity() {
		Datastructurepf.clickTimecomplexityLink();
		String exptitle = "Time Complexity";
		String acttitle = Datastructurepf.timecomplexitytitle();
		log.info("click Timecomplexity link");
		Assert.assertEquals(acttitle, exptitle, "the user is not on timecomplexity page");
	}

	@Test(priority = 2)
	public void practiceQ() {

		Datastructurepf.clickTimecomplexityLink();
		Datastructurepf.clickPracticeQuestionsLink();
		log.info("click on Practice questions");
		log.error("There are no practice questions available in the Datastructure module");
		Assert.fail("Failing this test case, there are no practice questions available in the Data Structures module");
	}

	@Test(priority = 3)
	public void tryeditor() {

		Datastructurepf.clickTimecomplexityLink();
		Datastructurepf.clickTryhereLink();
		String acturl = Datastructurepf.tryeditorurl();
		String expurl = "https://dsportalapp.herokuapp.com/tryEditor";
		log.info("click on tryhere");
		Assert.assertEquals(acturl, expurl, "the user is not on tryeditor page");
	}

	@Test(priority = 4)
	public void tryeditornocode() {

		Datastructurepf.clickTimecomplexityLink();
		Datastructurepf.clickTryhereLink();
		Datastructurepf.clickRunButton();
		String actmsg = Datastructurepf.alert_message();
		String expmsg = Datastructurepf.alertconfim();
		log.info("click on run tryedior page with no code");
		log.error("user is should able to see error message 'Please enter the code'");
		Assert.assertEquals(actmsg, expmsg, "alert msg is not displayed");
	}

	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid", dataProviderClass = Dataprovider.class)
	public void dsTryingValidAndInvalidCode(String ScenarioName, String code, String expectedOutput)
			throws IOException, InterruptedException {
		Datastructurepf.clickTimecomplexityLink();
		Datastructurepf.clickTryhereLink();
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
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
}