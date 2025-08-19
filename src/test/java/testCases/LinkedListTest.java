package testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageFactory.BasePage;
import pageFactory.LinkedList_pf;
import utils.LoggerLoad;

@Listeners({ CustomListener.class })
public class LinkedListTest extends BaseTest {

	public LinkedListTest() throws IOException {
		super();

	}

	LinkedList_pf linkedListPg;
	LoggerLoad log;
	String Input;
	String actualOutput;
	String expectedOutput;
	BasePage base;

	@BeforeMethod
	public void initPageObjects() throws IOException {
		linkedListPg = new LinkedList_pf();
		base = new BasePage();
		base.launch_webpage();
		linkedListPg.getToLinkedList();
		log = new LoggerLoad();
	}

	public void verifyPracticeQuestionsPageTitle() {
		linkedListPg.clickOnPracticeQuestion();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Practice Questions";
		Assert.assertEquals(actualTitle, expectedTitle, "Practice Questions Page Title did not match!");

	}

	public void verifyTryEditorPageTitle() {
		linkedListPg.clickTryHere();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Assessment";
		Assert.assertEquals(actualTitle, expectedTitle, "Try Editotr PageTitle did not match!");
	}

	@Test(priority = 1)
	public void verifyIntroPageTitle() {
		log.info("Navigating to Linked List Intro Page...");
		linkedListPg.clickOnIntroLink();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Introduction";
		Assert.assertEquals(actualTitle, expectedTitle, "Intro Page Title did not match!");
	}

	@Test(priority = 2)
	public void verifyPracticeQuestionsPageTitle_Intro() {
		log.info("Navigating to Practice Questions Page from Intro...");
		linkedListPg.clickOnIntroLink();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 3)
	public void verifytryEditorPageTitle_Intro() {
		log.info("Navigating to Try Editor Page from Intro...");
		linkedListPg.clickOnIntroLink();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 4)
	public void verifytryEditorforValidandInvalidCode_Intro(String ScenarioName, String code, String expectedOutput)
			throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateToIntroTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 5)
	public void verifycreateLinkedListPageTitle() {
		log.info("Navigating to Create Linked List Page...");
		linkedListPg.clickOncreateLinkedListLink();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Creating Linked LIst"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Create Linked List Page Title did not match!");
	}

	@Test(priority = 6)
	public void verifyPracticeQuestionsPageTitle_CreateLinkedList() {
		log.info("Navigating to Practice Questions Page from CreateLinkedList...");
		linkedListPg.clickOncreateLinkedListLink();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 7)
	public void verifytryEditorPageTitle_CreateLinkedList() {
		log.info("Navigating to Try Editor Page from CreateLinkedList...");
		linkedListPg.clickOncreateLinkedListLink();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 8)
	public void verifytryEditorforValidandInvalidCode_CreateLinkedList(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateToCreateLinkedListTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 9)
	public void verifyTypesofLinkedListPageTitle() {
		log.info("Navigating to Types of Linked List Page...");
		linkedListPg.clickOntypesofLinkedList();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Types of Linked List"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Types of Linked List Page Title did not match!");
	}

	@Test(priority = 10)
	public void verifyPracticeQuestionsPageTitle_TypesofLinkedList() {
		log.info("Navigating to Practice Questions Page from Types of Linked List Page...");
		linkedListPg.clickOntypesofLinkedList();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 11)
	public void verifytryEditorPageTitle_TypesofLinkedList() {
		log.info("Navigating to Try Editor Page from Types of Linked List Page...");
		linkedListPg.clickOntypesofLinkedList();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 12)
	public void verifytryEditorforValidandInvalidCode_TypesofLinkedList(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateToTypesofLinkedListTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 13)
	public void verifyImplementLinkedListPageTitle() {
		log.info("Navigating to Implement Linked List Page...");
		linkedListPg.clickOnimplementLinkedList();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Implement Linked List in Python"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
	}

	@Test(priority = 14)
	public void verifyPracticeQuestionsPageTitle_ImplementLinkedList() {
		log.info("Navigating to Practice Questions Page from ImplementLinkedList Page...");
		linkedListPg.clickOnimplementLinkedList();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 15)
	public void verifytryEditorPageTitle_ImplementLinkedList() {
		log.info("Navigating to Try Editor Page from ImplementLinkedList Page...");
		linkedListPg.clickOnimplementLinkedList();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 16)
	public void verifytryEditorforValidandInvalidCode_ImplementLinkedList(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateToImplementLinkedListTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 17)
	public void verifyTraversalPageTitle() {
		log.info("Navigating to Implement Linked List Page...");
		linkedListPg.clickOntraversal();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Traversal"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
	}

	@Test(priority = 18)
	public void verifyPracticeQuestionsPageTitle_TraversalPage() {
		log.info("Navigating to Practice Questions Page from TraversalPage Page...");
		linkedListPg.clickOntraversal();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 19)
	public void verifytryEditorPageTitle_TraversalPage() {
		log.info("Navigating to Try Editor Page from TraversalPage Page...");
		linkedListPg.clickOntraversal();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 20)
	public void verifytryEditorforValidandInvalidCode_TraversalPage(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateTonavigateToTraversalTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 21)
	public void verifyInsertionPageTitle() {
		log.info("Navigating to Insertion Page...");
		linkedListPg.clickOninsertion();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Insertion"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Insertion Page Title did not match!");
	}

	@Test(priority = 22)
	public void verifyPracticeQuestionsPageTitle_InsertionPage() {
		log.info("Navigating to Practice Questions Page from Insertion Page...");
		linkedListPg.clickOninsertion();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 23)
	public void verifytryEditorPageTitle_InsertionPage() {
		log.info("Navigating to Try Editor Page from Insertion Page...");
		linkedListPg.clickOninsertion();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 24)
	public void verifytryEditorforValidandInvalidCode_InsertionPage(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateTonavigateToInsertionTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}

	@Test(priority = 25)
	public void verifyDeletionPageTitle() {
		log.info("Navigating to Deletion Page...");
		linkedListPg.clickOndeletionLink();
		String actualTitle = linkedListPg.getTitle();
		String expectedTitle = "Deletion"; 
		Assert.assertEquals(actualTitle, expectedTitle, "Deletion Page Title did not match!");
	}

	@Test(priority = 26)
	public void verifyPracticeQuestionsPageTitle_DeletionPage() {
		log.info("Navigating to Practice Questions Page from Deletion Page...");
		linkedListPg.clickOndeletionLink();
		verifyPracticeQuestionsPageTitle();
	}

	@Test(priority = 27)
	public void verifytryEditorPageTitle_DeletionPage() {
		log.info("Navigating to Try Editor Page from Deletion Page...");
		linkedListPg.clickOndeletionLink();
		verifyTryEditorPageTitle();
	}

	@Test(dataProvider = "pythonCodeValidandInvalid", dataProviderClass = BaseTest.class, priority = 28)
	public void verifytryEditorforValidandInvalidCode_DeletionPage(String ScenarioName, String code,
			String expectedOutput) throws InterruptedException {
		log.info("Checking for Valid and Invalid Code...");
		linkedListPg.navigateTonavigateToDeletionTryEditor();
		linkedListPg.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
		} else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
			boolean alertmsg = base.isAlertOpen();
			linkedListPg.handle_alert();
			Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
		} else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	}
}
