package testCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.Array_pf;
import pageFactory.BasePage;
import utils.Dataprovider;
import utils.LoggerLoad;


public class ArrayTest extends BaseTest {

	public ArrayTest() throws IOException {
		super();

	}

	Array_pf array_pf;
	BasePage base;
	LoggerLoad log;
	HashMap<String, String> resultTestData;
	String actualOutput;
	String expectedOutput;

	@BeforeMethod
	public void array_page() throws IOException {
		base = new BasePage();
		array_pf = new Array_pf();
		this.log = new LoggerLoad();
		base.launch_webpage();
		array_pf.clickArrayGetStarted();
		resultTestData = excelReader.readExcelRow("Result", "practiceQ");
	}

	@Test(priority = 1)
	public void testArraysInPythonLink() throws InterruptedException, IOException {

		array_pf.clickArraysInPython();
		array_pf.waitForUrlToContain("/arrays-in-python/");
		String currentUrl = array_pf.getURL();
		log.info("Navigating to arryas in python link");
		Assert.assertTrue(currentUrl.contains("array/arrays-in-python/"),
				"not in try here page of implemetation of arrays in python page");
	}

	@Test(priority = 2)
	public void testArraysUsingListLink() throws IOException {

		array_pf.clickArraysUsingList();
		array_pf.waitForUrlToContain("/arrays-using-list/");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("array/arrays-using-list/"));

	}

	@Test(priority = 3)
	public void testBasicOperationsLink() throws IOException {

		array_pf.clickBasicOperations();
		array_pf.waitForUrlToContain("/basic-operations-in-lists/");
		String currentUrl = array_pf.getURL();
		log.info("Navigating to basic operations link");
		Assert.assertTrue(currentUrl.contains("array/basic-operations-in-lists/"));

	}

	@Test(priority = 4)
	public void testApplicationsOfArray() throws IOException {

		array_pf.clickApplicationsOfArray();
		array_pf.waitForUrlToContain("/applications-of-array/");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("array/applications-of-array/"));

	}

	@Test(priority = 5)
	public void testClickTryHereFromPythonLink() throws IOException {

		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		log.info("Navigating to tryhere page");
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 6)
	public void testClickTryHereFromListLink() {
		array_pf.clickArraysUsingList();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));
	}

	@Test(priority = 7)
	public void testClickTryHereFromOperationsLink() {
		array_pf.clickBasicOperations();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 8)
	public void testClickTryHereFromApplicationsLink() {
		array_pf.clickApplicationsOfArray();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/tryEditor"));

	}

	@Test(priority = 9)
	public void testTryEditorPageWithNoInput() {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base.clickRunBtn();
		array_pf.getErrMsg_NoCode();
		log.error(
				"There is no alert message displayed when we click on run button without entering any code in the code editor in array module");
		String errorMsg = base.alert_message();
		Assert.assertEquals("Enter code", errorMsg);

	}

	@Test(priority = 10, dataProvider = "pythonCodeValidandInvalid", dataProviderClass = Dataprovider.class)
	public void arrayTryingValidAndInvalidCode(String ScenarioName, String code, String expectedOutput)
			throws InterruptedException, IOException {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
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

	@Test(priority = 12)
	public void testPracticeQuestionlink() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.waitForUrlToContain("/practice");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/array/practice"));

	}

	// 13
	@Test(priority = 13)
	public void testPracticeQ1() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.waitForUrlToContain("question/1");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/question/1"));

	}

	// 14
	@Test(priority = 14)
	public void testPracticeQ2() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.waitForUrlToContain("question/2");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/question/2"));

	}

	// 15
	@Test(priority = 15)
	public void testPracticeQ3() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.waitForUrlToContain("question/3");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/question/3"));

	}

	// 16
	@Test(priority = 16)
	public void testPracticeQ4() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.waitForUrlToContain("question/4");
		String currentUrl = array_pf.getURL();
		Assert.assertTrue(currentUrl.contains("/question/4"));

	}

	// 17
	@Test(priority = 17)
	public void testQ1NoCode_Run() throws InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 18
	@Test(priority = 18)
	public void testQ1NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);

	}

	// 19
	@Test(priority = 19)
	public void testQ2NoCode_Run() throws InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 20
	@Test(priority = 20)
	public void testQ2NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);

	}

	// 21
	@Test(priority = 21)
	public void testQ3NoCode_Run() throws InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 22
	@Test(priority = 22)
	public void testQ3NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);

	}

	// 23
	@Test(priority = 23)
	public void testQ4NoCode_Run() throws InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 24
	@Test(priority = 24)
	public void testQ4NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		Assert.assertEquals(" No tests were collected", outputTxt);

	}

	// 25
	@Test(priority = 25)
	public void testQ1InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_invalidCode_practiceQ();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 26
	@Test(priority = 26)
	public void testQ1InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_invalidCode_practiceQ();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);
	}

	// 27
	@Test(priority = 27)
	public void testQ1ValidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_validCode_practiceQ1();
		base.clickRunBtn();
		String outputQ1 = base.output_text();
		String expectedOP = resultTestData.get("PracticeQ1validcode");
		Assert.assertEquals(expectedOP, outputQ1);

	}

	// 28
	@Test(priority = 28)
	public void testQ1ValidCode_Submit() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_validCode_practiceQ1();
		array_pf.clickSubmit();
		String outputQ1 = base.output_text();
		String expectedOP = resultTestData.get("SubmitResult");
		Assert.assertEquals(expectedOP, outputQ1);

	}

	// 29
	@Test(priority = 29)
	public void testQ2InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_invalidCode_practiceQ();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 30
	@Test(priority = 30)
	public void testQ2InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_invalidCode_practiceQ();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);
	}

	// 31
	@Test(priority = 31)
	public void testQ2ValidCode_Run() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_validCode_practiceQ2();
		base.clickRunBtn();
		String outputQ2 = base.output_text();
		String expectedOP = resultTestData.get("PracticeQ2validcode");
		Assert.assertEquals(expectedOP, outputQ2);

	}

	// 32
	@Test(priority = 32)
	public void testQ2ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_validCode_practiceQ2();
		array_pf.clickSubmit();
		String outputQ2 = base.output_text();
		String expectedOP = resultTestData.get("SubmitResult");

		Assert.assertEquals(expectedOP, outputQ2);

	}

	// 33
	@Test(priority = 33)
	public void testQ3InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_invalidCode_practiceQ();
		base.clickRunBtn();
		base.handle_alert();

	}

	@Test(priority = 34)
	public void testQ3InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_invalidCode_practiceQ();
		array_pf.clickSubmit();
		String outputTxt = base.output_text();
		String expectedOutput = resultTestData.get("Error Message");
		Assert.assertEquals(expectedOutput, outputTxt);

	}

	// 35
	@Test(priority = 35)
	public void testQ3ValidCode_Run() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_validCode_practiceQ3();
		base.clickRunBtn();
		String outputQ3 = base.output_text();
		String expectedOP = resultTestData.get("PracticeQ3validcode");
		Assert.assertEquals(expectedOP, outputQ3);

	}

	// 36
	@Test(priority = 36)
	public void testQ3ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_validCode_practiceQ3();
		array_pf.clickSubmit();
		String outputQ3 = base.output_text();
		String expectedOP = resultTestData.get("SubmitResult");
		Assert.assertEquals(expectedOP, outputQ3);

	}

	// 37
	@Test(priority = 37)
	public void testQ4InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_invalidCode_practiceQ();
		base.clickRunBtn();
		base.handle_alert();

	}

	// 38
	@Test(priority = 38)
	public void testQ4InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_invalidCode_practiceQ();
		array_pf.clickSubmit();
		String outputQ4 = base.output_text();
		Assert.assertEquals(" No tests were collected", outputQ4);

	}

	// 39
	@Test(priority = 39)
	public void testQ4ValidCode_Run() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_validCode_practiceQ4();
		base.clickRunBtn();
		String outputQ4 = base.output_text();
		String expectedOP = resultTestData.get("PracticeQ4validcode");
		Assert.assertEquals(expectedOP, outputQ4);

	}

	// 40
	@Test(priority = 40)
	public void testQ4ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_validCode_practiceQ4();
		array_pf.clickSubmit();
		String outputQ4 = base.output_text();
		String expectedOP = resultTestData.get("SubmitResult");
		log.error("There is a bug in Q4, even after submiiting valid Q it gives error");
		Assert.assertEquals(expectedOP, outputQ4);

	}

}