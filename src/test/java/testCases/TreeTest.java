package testCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.TreePage;
import utils.ExcelReader;
import utils.LoggerLoad;

@Listeners(CustomListener.class)
public class TreeTest extends BaseTest{
	
	public TreeTest() throws IOException {
		super();
	}

	TreePage treePg;
	BasePage base;	
    LoggerLoad log;
    ExcelReader excelReader;
	HashMap<String, String> testDataValid;
	HashMap<String, String> testDataInValid;
	
	@BeforeMethod
	public void graphPage() throws InterruptedException, IOException {
		this.base = new BasePage();
		this.treePg = new TreePage();
		this.log = new LoggerLoad();
		this.excelReader= new ExcelReader();
		this.testDataValid = new HashMap<>();
		this.testDataInValid = new HashMap<>();
		base.launch_webpage();
	}
	
	@Test
	public void verifyTreeLinks() throws InterruptedException, IOException {
		log.info("Verifying the links in Tree Page");
		treePg.getToTree();
		treePg.verifyLinks();
	
	}
	@Test
	public void clickOverview() throws InterruptedException, IOException {		
		log.info("Navigating the Overview Tree Page");
		treePg.getToTree();
		treePg.click_Overview();
		String actualTitle = base.getTitle();
		String expectedTitle= "Overview of Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in overview page");
		treePg.click_TryHere();
		
		
	}
	@Test
	public void clickTerminology() throws InterruptedException, IOException {
		log.info("Navigating the Terminilogy Tree Page");
		treePg.getToTree();
		treePg.click_Terminilogy();
		String actualTitle = base.getTitle();
		String expectedTitle= "Terminologies";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Terminology page");
		treePg.click_TryHere();
	}
	@Test
	public void typesTree() throws InterruptedException, IOException {
		log.info("Navigating the Types of Tree Page");
		treePg.getToTree();
		treePg.typesOfTrees();
		String actualTitle = base.getTitle();
		String expectedTitle= "Types of Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Types of Tree page");
		treePg.click_TryHere();
	}
	
	@Test
		public void tree_Traversals() throws InterruptedException, IOException {
			log.info("Navigating the Tree Traversals");
			treePg.getToTree();
			treePg.tree_Trav();
			String actualTitle = base.getTitle();
			String expectedTitle= "Tree Traversals";
			Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Tree Traversals");
		}

	
	@Test
	public void Traversals_Illus() throws InterruptedException, IOException {
		log.info("Navigating the Tree traversals-illustration");
		treePg.getToTree();
		treePg.Traversal_Illustra();
		String actualTitle = base.getTitle();
		String expectedTitle= "Traversals-Illustration";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Traversals-Illustration");
	}

	
	@Test
	public void binary_Tree() throws InterruptedException, IOException {
		log.info("Navigating the Binary Tree");
		treePg.getToTree();
		treePg.binary_Tree();
		String actualTitle = base.getTitle();
		String expectedTitle= "Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Binary Trees");
	}
	
	@Test
	public void types_OfBinaryTree() throws InterruptedException, IOException {
		log.info("Navigating the Types of Binary Tree");
		treePg.getToTree();
		treePg.types_ofBinary();
		String actualTitle = base.getTitle();
		String expectedTitle= "Types of Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Types of Binary Tree");
	}


	@Test
	public void implement_OfPython() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation of Python");
		treePg.getToTree();
		treePg.Impl_in_Python();
		String actualTitle = base.getTitle();
		String expectedTitle= "Implementation in Python";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Implementation of Python");
	}

	@Test
	public void binaryTreTraver() throws InterruptedException, IOException {
		log.info("Naviagating to Binary Tree Traversals");
		treePg.getToTree();
		treePg.binary_Tree_Travers();	
		String actualTitle = base.getTitle();
		String expectedTitle= "Binary Tree Traversals";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in  Binary Tree Traversals");
	}
	
	
	
	@Test
	public void impl_OfBinaryTrees() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation of Binary Trees");
		treePg.getToTree();
		treePg.imp_of_binaryTrees();
		String actualTitle = base.getTitle();
		String expectedTitle= "Implementation of Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in  Implementation of Binary Tree");
	}
	
	
	@Test
	public void appBinaryTree() throws InterruptedException, IOException {
		log.info("Naviagating to Applications of Binary trees");
		treePg.getToTree();
		treePg.app_of_binaryTrees();	
		String actualTitle = base.getTitle();
		String expectedTitle= "Applications of Binary trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in  Applications of Binary trees");
	}
	
	@Test
	public void binarySearch() throws InterruptedException, IOException {
		log.info("Naviagating to Binary Search Trees");
		treePg.getToTree();
		treePg.binary_Search();	
		String actualTitle = base.getTitle();
		String expectedTitle= "Binary Search Trees";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched in Binary Search Trees");
	}
	
	
	@Test
	public void impOfBst() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation Of BST");
		treePg.getToTree();
		treePg.Implement_OfBst();	
		String actualTitle = base.getTitle();
		String expectedTitle= "Implementation Of BST";
		Assert.assertEquals(actualTitle, expectedTitle, "Implementation Of BST");
	}
	
	
	@Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
	public void treeTryingValidAndInvalidCode(String ScenarioName, String code, String expectedOutput) throws InterruptedException, IOException {
		treePg.getToTree();
		treePg.click_Overview();
		treePg.click_TryHere();
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
		base.validAndInvalidCode(code);
		if (ScenarioName.equalsIgnoreCase("ValidCode")) {
			String actualOutput = base.output_text();
			System.out.println("checking the actual ouput :" + actualOutput);
			Assert.assertEquals(actualOutput, expectedOutput, "did not get the expected output");
	  } else if (ScenarioName.equalsIgnoreCase("InvalidCode")) {
		  boolean alertmsg = base.isAlertOpen();
		  base.handle_alert();
		  Assert.assertTrue(alertmsg, "The user is not able to see an alert window to display error message.");
	  }  else {
			Assert.fail("Provided code did not match valid or invalid test data");
		}
	
}

	
	
	@Test(priority = 3)
	public void runWithoutCode() throws InterruptedException, IOException {
		treePg.getToTree();
		treePg.click_Overview();
		treePg.click_TryHere();
		base.clickRunBtn();
		log.error("Alert message for no code entered in editor is not displayed");
		Assert.fail(
				"Failing this test case to show the bug which is, no alert message comes up when clicking on run button without entering any code in it");
	}
		
	@Test(priority = 6)
	public void practQuestion() throws InterruptedException, IOException {
		treePg.getToTree();
		treePg.click_Overview();
        treePg.practice_Tree();
    	log.error("Practice Question Page is blank, log the bug in JIRA");
		Assert.fail("Practice Question is blank and failed the testcases to show the bug");
	
	}
	
}