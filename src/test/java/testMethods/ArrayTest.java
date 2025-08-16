package testMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import pageObjects.Array_pf;
import pageObjects.Base_pf;
import utils.LoggerLoad;
import driverManager.DriverFactory;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

@Listeners(CustomListener.class)
public class ArrayTest extends BaseTest {

	Array_pf array_pf;
	Base_pf base_pf;
	LoggerLoad log;

	//WebDriver driver;

	@BeforeMethod
	public void array_page() throws IOException {
		base_pf = new Base_pf();
		array_pf = new Array_pf();
		this.log = new LoggerLoad();
		array_pf.clickArrayGetStarted();

	}

	@Test (priority = 1)
	public void testArraysInPythonLink() throws InterruptedException, IOException {

		array_pf.clickArraysInPython();
		array_pf.waitForUrlToContain("/arrays-in-python/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/arrays-in-python/",currentUrl);
	}

	@Test  (priority = 2)
	public void testArraysUsingListLink() throws IOException {

		array_pf.clickArraysUsingList();
		array_pf.waitForUrlToContain("/arrays-using-list/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/arrays-using-list/",currentUrl);
	}

	@Test  (priority = 3)
	public void testBasicOperationsLink() throws IOException {

		array_pf.clickBasicOperations();
		array_pf.waitForUrlToContain("/basic-operations-in-lists/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/",currentUrl);

	}

	@Test  (priority = 4) 
	public void testApplicationsOfArray() throws IOException {

		array_pf.clickApplicationsOfArray();
		array_pf.waitForUrlToContain("/applications-of-array/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/applications-of-array/",currentUrl);

	}

	@Test   (priority = 5)
	public void testClickTryHereFromPythonLink() throws IOException {

		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		//log.info("Message1");
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);

	}

	@Test  (priority = 6) 
	public void testClickTryHereFromListLink() {
		array_pf.clickArraysUsingList();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);
	}

	@Test (priority = 7)
	public void testClickTryHereFromOperationsLink() {
		array_pf.clickBasicOperations();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);


	}

	@Test  (priority = 8)
	public void testClickTryHereFromApplicationsLink() {
		array_pf.clickApplicationsOfArray();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);

	}

	@Test  (priority = 9)
	public void testTryEditorPageWithNoInput() {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.clickRun();
		base_pf.getErrMsg_NoCode();
		log.error(
				"There is no alert message displayed when we click on run button without entering any code in the code editor in array module");
		String errorMsg = base_pf.alert_message();
		assertEquals("Enter code", errorMsg);

	}

	@Test (priority = 10)
	public void testTryEditorPageWithInvalidInput() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.tryEditor_invalidCode();
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	@Test (priority = 11)
	public void testTryEditorWithValidInput() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.tryEditor_validCode();
		base_pf.clickRun();
		String outputTxt = base_pf.output_text();

		assertEquals("hello", outputTxt);

	}

	@Test(priority = 12)
	public void testPracticeQuestionlink() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.waitForUrlToContain("/practice");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/practice",currentUrl);

	}

	//13
	@Test (priority = 13)
	public void testPracticeQ1() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.waitForUrlToContain("question/1");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/1",currentUrl);

	}

	//14
	@Test (priority = 14)
	public void testPracticeQ2() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.waitForUrlToContain("question/2");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/2",currentUrl);

	}

	//15
	@Test  (priority = 15)
	public void testPracticeQ3() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.waitForUrlToContain("question/3");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/3",currentUrl);

	}

	//16
	@Test  (priority = 16)
	public void testPracticeQ4() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.waitForUrlToContain("question/4");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/4",currentUrl);

	}

	//17
	@Test (priority = 17)
	public void testQ1NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//18
	@Test (priority = 18)
	public void testQ1NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.clickSubmit();
		String outputTxt = base_pf.output_text();
		assertEquals("Error occurred during submission", outputTxt);

	}

	//19
	@Test (priority = 19)
	public void testQ2NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//20
	@Test (priority = 20)
	public void testQ2NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.clickSubmit();
		String outputTxt = base_pf.output_text();
		assertEquals("Error occurred during submission", outputTxt);

	}

	//21
	@Test (priority = 21)
	public void testQ3NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//22
	@Test (priority = 22)
	public void testQ3NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.clickSubmit();
		String outputTxt = base_pf.output_text();
		assertEquals("Error occurred during submission", outputTxt);

	}

	//23
	@Test (priority = 23)
	public void testQ4NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//24
	@Test (priority = 24)
	public void testQ4NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.clickSubmit();
		String outputTxt = base_pf.output_text();
		assertEquals(" No tests were collected", outputTxt);

	}

	//HAVE TO WRITE CODE FOR VALID AND INVALID DATA IN ALL THE 4 QUESTIONS USING EXCEL
	//25
	@Test (priority = 25)
	public void testQ1InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_invalidCode_practiceQ();	
		//Thread.sleep(5000);
		base_pf.clickRun();
		base_pf.handle_alert();

	}
	//26
	@Test (priority = 26)
	public void testQ1InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_invalidCode_practiceQ();	
		array_pf.clickSubmit();
		String outputQ1= base_pf.output_text();
		//String expectedQ1= base_pf.getExcelExpOutput("Sheet1", "Try here Invalid code", "SubmitResult");
		assertEquals("Error occurred during submission", outputQ1);



	}
	//27
	@Test (priority = 27)
	public void testQ1ValidCode_Run() throws IOException {  //CHROME NOT TAKING VALID DATA IN CORRET FORMAT 
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_validCode_practiceQ1();
		base_pf.clickRun();
		String outputQ1= base_pf.output_text(); 
		System.out.println(outputQ1);

	}

	//28
	@Test (priority = 28)
	public void testQ1ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_validCode_practiceQ1();
		array_pf.clickSubmit();
		String outputQ1= base_pf.output_text(); 
		System.out.println(outputQ1);

	}

	//29
	@Test (priority = 29)
	public void testQ2InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_invalidCode_practiceQ();	
		//Thread.sleep(5000);
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//30
	@Test (priority = 30)
	public void testQ2InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_invalidCode_practiceQ();	
		array_pf.clickSubmit();
		String outputQ2= base_pf.output_text();
		//String expectedQ1= base_pf.getExcelExpOutput("Sheet1", "Try here Invalid code", "SubmitResult");
		assertEquals("Error occurred during submission", outputQ2);

	}


	//31
	@Test (priority = 31)
	public void testQ2ValidCode_Run() throws IOException {  //CHROME NOT TAKING VALID DATA IN CORRET FORMAT 
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_validCode_practiceQ2();
		base_pf.clickRun();
		String outputQ2= base_pf.output_text(); 
		System.out.println(outputQ2);

	}

	//32
	@Test (priority = 32)
	public void testQ2ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.tryEditor_validCode_practiceQ2();
		array_pf.clickSubmit();
		String outputQ2= base_pf.output_text(); 
		System.out.println(outputQ2);

	}
	//33
	@Test (priority = 33)
	public void testQ3InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_invalidCode_practiceQ();	
		//Thread.sleep(5000);
		base_pf.clickRun();
		base_pf.handle_alert();

	}
	//34
	@Test (priority = 34)
	public void testQ3InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_invalidCode_practiceQ();	
		array_pf.clickSubmit();
		String outputQ3= base_pf.output_text();
		//String expectedQ1= base_pf.getExcelExpOutput("Sheet1", "Try here Invalid code", "SubmitResult");
		assertEquals("Error occurred during submission", outputQ3);

	}

	//35
	@Test (priority = 35)
	public void testQ3ValidCode_Run() throws IOException {  //CHROME NOT TAKING VALID DATA IN CORRET FORMAT 
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_validCode_practiceQ3();
		base_pf.clickRun();
		String outputQ3= base_pf.output_text(); 
		System.out.println(outputQ3);

	}

	//36
	@Test (priority = 36)
	public void testQ3ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.tryEditor_validCode_practiceQ3();
		array_pf.clickSubmit();
		String outputQ3= base_pf.output_text(); 
		System.out.println(outputQ3);

	}
	//37
	@Test (priority = 37)
	public void testQ4InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_invalidCode_practiceQ();	
		//Thread.sleep(5000);
		base_pf.clickRun();
		base_pf.handle_alert();

	}

	//38
	@Test (priority = 38)
	public void testQ4InvalidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_invalidCode_practiceQ();	
		array_pf.clickSubmit();
		String outputQ4= base_pf.output_text();
		//String expectedQ1= base_pf.getExcelExpOutput("Sheet1", "Try here Invalid code", "SubmitResult");
		assertEquals(" No tests were collected", outputQ4);

	}


	//39
	@Test (priority = 39)
	public void testQ4ValidCode_Run() throws IOException {  //CHROME NOT TAKING VALID DATA IN CORRET FORMAT 
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_validCode_practiceQ3();
		base_pf.clickRun();
		String outputQ4= base_pf.output_text(); 
		System.out.println(outputQ4);

	}
	//40
	@Test (priority = 40)
	public void testQ4ValidCode_Submit() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.tryEditor_validCode_practiceQ3();
		array_pf.clickSubmit();
		String outputQ4= base_pf.output_text(); 
		System.out.println(outputQ4);

	}



}
