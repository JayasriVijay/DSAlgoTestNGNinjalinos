package testMethodsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Map;
import org.testng.Assert;
import pageObjects.LinkedListPage;

import utils.ExcelReaderTestNg;
import utils.LoggerLoad;

@Listeners({ CustomListener.class })
public class LinkedListTest extends BaseTest {
	

    LinkedListPage linkedListPg;
    LoggerLoad log;
    private Map<String, String> testData;
    String Input;
    String actualOutput;
    String expectedOutput;
    ExcelReaderTestNg excelReader;
   
    
    @BeforeMethod
    public void initPageObjects() {
        linkedListPg = new LinkedListPage();
        linkedListPg.getToLinkedList(); 
        this.excelReader = new ExcelReaderTestNg();
        log = new LoggerLoad();
    }
    
    public void passingCodetoTryEditer() {
    	Input = testData.get("PythonCode"); //Getting the Column name
        expectedOutput=linkedListPg.enterData(Input);
        actualOutput = testData.get("RunResult");
        Assert.assertEquals(actualOutput, expectedOutput, "Output didn't Match");
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
        String expectedTitle = "Introduction";  // Update with correct expected title if different
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
    
    @Test(priority = 4)
    public void verifytryEditorforValidCode_Intro() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateToIntroTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 5)
    public void verifytryEditorforInvalidCode_Intro() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateToIntroTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 6)
    public void verifytryEditorforEmptyInput_Intro() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateToIntroTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    }
    @Test(priority = 7)
    public void verifycreateLinkedListPageTitle() {
    	log.info("Navigating to Create Linked List Page...");
        linkedListPg.clickOncreateLinkedListLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Creating Linked LIst";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Create Linked List Page Title did not match!");
    }
    
    @Test(priority = 8)
    public void verifyPracticeQuestionsPageTitle_CreateLinkedList() {
    	log.info("Navigating to Practice Questions Page from CreateLinkedList...");
        linkedListPg.clickOncreateLinkedListLink();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 9)
    public void verifytryEditorPageTitle_CreateLinkedList() {
    	log.info("Navigating to Try Editor Page from CreateLinkedList...");
        linkedListPg.clickOncreateLinkedListLink();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 10)
    public void verifytryEditorforValidCode_CreateLinkedList() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateToCreateLinkedListTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 11)
    public void verifytryEditorforInvalidCode_CreateLinkedList() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateToCreateLinkedListTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 12)
    public void verifytryEditorforEmptyInput_CreateLinkedList() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateToCreateLinkedListTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 13)
    public void verifyTypesofLinkedListPageTitle() {
    	log.info("Navigating to Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Types of Linked List";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Types of Linked List Page Title did not match!");
    }
    
    @Test(priority = 14)
    public void verifyPracticeQuestionsPageTitle_TypesofLinkedList() {
    	log.info("Navigating to Practice Questions Page from Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 15)
    public void verifytryEditorPageTitle_TypesofLinkedList() {
    	log.info("Navigating to Try Editor Page from Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 16)
    public void verifytryEditorforValidCode_TypesofLinkedList() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateToTypesofLinkedListTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 17)
    public void verifytryEditorforInvalidCode_TypesofLinkedList() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateToTypesofLinkedListTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 18)
    public void verifytryEditorforEmptyInput_TypesofLinkedList() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateToTypesofLinkedListTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 19)
    public void verifyImplementLinkedListPageTitle() {
    	log.info("Navigating to Implement Linked List Page...");
        linkedListPg.clickOnimplementLinkedList();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Implement Linked List in Python";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
    }
    
    @Test(priority = 20)
    public void verifyPracticeQuestionsPageTitle_ImplementLinkedList() {
    	log.info("Navigating to Practice Questions Page from ImplementLinkedList Page...");
        linkedListPg.clickOnimplementLinkedList();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 21)
    public void verifytryEditorPageTitle_ImplementLinkedList() {
    	log.info("Navigating to Try Editor Page from ImplementLinkedList Page...");
        linkedListPg.clickOnimplementLinkedList();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 22)
    public void verifytryEditorforValidCode_ImplementLinkedList() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateToImplementLinkedListTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 23)
    public void verifytryEditorforInvalidCode_ImplementLinkedList() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateToImplementLinkedListTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 24)
    public void verifytryEditorforEmptyInput_ImplementLinkedList() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateToImplementLinkedListTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 25)
    public void verifyTraversalPageTitle() {
    	log.info("Navigating to Implement Linked List Page...");
        linkedListPg.clickOntraversal();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Traversal";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
    }
    
    @Test(priority = 26)
    public void verifyPracticeQuestionsPageTitle_TraversalPage() {
    	log.info("Navigating to Practice Questions Page from TraversalPage Page...");
        linkedListPg.clickOntraversal();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 27)
    public void verifytryEditorPageTitle_TraversalPage() {
    	log.info("Navigating to Try Editor Page from TraversalPage Page...");
        linkedListPg.clickOntraversal();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 28)
    public void verifytryEditorforValidCode_TraversalPage() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateTonavigateToTraversalTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 29)
    public void verifytryEditorforInvalidCode_TraversalPage() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateTonavigateToTraversalTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 30)
    public void verifytryEditorforEmptyInput_TraversalPage() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateTonavigateToTraversalTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 31)
    public void verifyInsertionPageTitle() {
    	log.info("Navigating to Insertion Page...");
        linkedListPg.clickOninsertion();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Insertion";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Insertion Page Title did not match!");
    }
    
    @Test(priority = 32)
    public void verifyPracticeQuestionsPageTitle_InsertionPage() {
    	log.info("Navigating to Practice Questions Page from Insertion Page...");
        linkedListPg.clickOninsertion();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 33)
    public void verifytryEditorPageTitle_InsertionPage() {
    	log.info("Navigating to Try Editor Page from Insertion Page...");
        linkedListPg.clickOninsertion();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 34)
    public void verifytryEditorforValidCode_InsertionPage() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateTonavigateToInsertionTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 35)
    public void verifytryEditorforInvalidCode_InsertionPage() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateTonavigateToInsertionTryEditor();
        testData =excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 36)
    public void verifytryEditorforEmptyInput_InsertionPagee() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateTonavigateToInsertionTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 37)
    public void verifyDeletionPageTitle() {
    	log.info("Navigating to Deletion Page...");
        linkedListPg.clickOndeletionLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Deletion";  // Update with correct expected title if different
        Assert.assertEquals(actualTitle, expectedTitle, "Deletion Page Title did not match!");
    }
    
    @Test(priority = 38)
    public void verifyPracticeQuestionsPageTitle_DeletionPage() {
    	log.info("Navigating to Practice Questions Page from Deletion Page...");
        linkedListPg.clickOndeletionLink();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 39)
    public void verifytryEditorPageTitle_DeletionPage() {
    	log.info("Navigating to Try Editor Page from Deletion Page...");
        linkedListPg.clickOndeletionLink();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 40)
    public void verifytryEditorforValidCode_DeletionPage() throws InterruptedException {
    	log.info("Checking for Valid Code...");
        linkedListPg.navigateTonavigateToDeletionTryEditor();
        testData = excelReader.readExcelRow("ValidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 41)
    public void verifytryEditorforInvalidCode_DeletionPage() throws InterruptedException {
    	log.info("Checking for InValid Code...");
        linkedListPg.navigateTonavigateToDeletionTryEditor();
        testData = excelReader.readExcelRow("InvalidCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 42)
    public void verifytryEditorforEmptyInput_DeletionPage() throws InterruptedException {
    	log.info("Checking for EmptyInput...");
        linkedListPg.navigateTonavigateToDeletionTryEditor();
        testData = excelReader.readExcelRow("EmptyCode", "testdata");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
   
    
    
}

