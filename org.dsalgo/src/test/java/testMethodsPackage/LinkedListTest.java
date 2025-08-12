package testMethodsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

import org.testng.Assert;
import pageObjects.LinkedListPage;
import utils.ExcelReaderTestNg;


public class LinkedListTest extends BaseTest {

    LinkedListPage linkedListPg;
    private Map<String, String> testData;
    String Input;
    String actualOutput;
    String expectedOutput;

    @BeforeMethod
    public void initPageObjects() {
        linkedListPg = new LinkedListPage();
        linkedListPg.getToLinkedList();
    }
    
    public void navigateToIntroTryEditor() {
        linkedListPg.clickOnIntroLink();
        linkedListPg.clickTryHere();
    }
    public void navigateToCreateLinkedListTryEditor() {
        linkedListPg.clickOncreateLinkedListLink();
        linkedListPg.clickTryHere();
    }
    public void navigateToTypesofLinkedListTryEditor() {
        linkedListPg.clickOntypesofLinkedList();
        linkedListPg.clickTryHere();
    }
    public void navigateToImplementLinkedListTryEditor() {
        linkedListPg.clickOnimplementLinkedList();
        linkedListPg.clickTryHere();
    }
    public void navigateTonavigateToTraversalTryEditor() {
        linkedListPg.clickOntraversal();
        linkedListPg.clickTryHere();
    }
    public void navigateTonavigateToInsertionTryEditor() {
        linkedListPg.clickOninsertion();
        linkedListPg.clickTryHere();
    }
    public void navigateTonavigateToDeletionTryEditor() {
        linkedListPg.clickOndeletionLink();
        linkedListPg.clickTryHere();
    }
    
    
    public void passingCodetoTryEditer() {
    	Input = testData.get("Input"); //Getting the Column name
        expectedOutput=linkedListPg.enterData(Input);
        actualOutput = testData.get("Output");
        Assert.assertEquals(actualOutput, expectedOutput, "Output didn't Match");
    }
    public void verifyPracticeQuestionsPageTitle() {
    	linkedListPg.clickOnPracticeQuestion();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Practice Questions";  
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Practice Questions Page Title did not match!");
    	
    }
    public void verifyTryEditorPageTitle() {
        linkedListPg.clickTryHere();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Assessment";  
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Try Editotr PageTitle did not match!");
    }

    @Test(priority = 1)
    public void verifyIntroPageTitle() {
        System.out.println("Navigating to Linked List Intro Page...");
        linkedListPg.clickOnIntroLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Introduction";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Intro Page Title did not match!");
    }

    @Test(priority = 2)
    public void verifyPracticeQuestionsPageTitle_Intro() {
        System.out.println("Navigating to Practice Questions Page from Intro...");
        linkedListPg.clickOnIntroLink();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 3)
    public void verifytryEditorPageTitle_Intro() {
        System.out.println("Navigating to Try Editor Page from Intro...");
        linkedListPg.clickOnIntroLink();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 4)
    public void verifytryEditorforValidCode_Intro() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToIntroTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 5)
    public void verifytryEditorforInvalidCode_Intro() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateToIntroTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 6)
    public void verifytryEditorforEmptyInput_Intro() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateToIntroTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    }
    @Test(priority = 7)
    public void verifycreateLinkedListPageTitle() {
        System.out.println("Navigating to Create Linked List Page...");
        linkedListPg.clickOncreateLinkedListLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Creating Linked LIst";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Create Linked List Page Title did not match!");
    }
    
    @Test(priority = 8)
    public void verifyPracticeQuestionsPageTitle_CreateLinkedList() {
        System.out.println("Navigating to Practice Questions Page from CreateLinkedList...");
        linkedListPg.clickOncreateLinkedListLink();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 9)
    public void verifytryEditorPageTitle_CreateLinkedList() {
        System.out.println("Navigating to Try Editor Page from CreateLinkedList...");
        linkedListPg.clickOncreateLinkedListLink();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 10)
    public void verifytryEditorforValidCode_CreateLinkedList() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToCreateLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 11)
    public void verifytryEditorforInvalidCode_CreateLinkedList() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateToCreateLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 12)
    public void verifytryEditorforEmptyInput_CreateLinkedList() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateToCreateLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 13)
    public void verifyTypesofLinkedListPageTitle() {
        System.out.println("Navigating to Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Types of Linked List";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Types of Linked List Page Title did not match!");
    }
    
    @Test(priority = 14)
    public void verifyPracticeQuestionsPageTitle_TypesofLinkedList() {
        System.out.println("Navigating to Practice Questions Page from Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 15)
    public void verifytryEditorPageTitle_TypesofLinkedList() {
        System.out.println("Navigating to Try Editor Page from Types of Linked List Page...");
        linkedListPg.clickOntypesofLinkedList();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 16)
    public void verifytryEditorforValidCode_TypesofLinkedList() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToTypesofLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 17)
    public void verifytryEditorforInvalidCode_TypesofLinkedList() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateToTypesofLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 18)
    public void verifytryEditorforEmptyInput_TypesofLinkedList() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateToTypesofLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 19)
    public void verifyImplementLinkedListPageTitle() {
        System.out.println("Navigating to Implement Linked List Page...");
        linkedListPg.clickOnimplementLinkedList();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Implement Linked List in Python";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
    }
    
    @Test(priority = 20)
    public void verifyPracticeQuestionsPageTitle_ImplementLinkedList() {
        System.out.println("Navigating to Practice Questions Page from ImplementLinkedList Page...");
        linkedListPg.clickOnimplementLinkedList();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 21)
    public void verifytryEditorPageTitle_ImplementLinkedList() {
        System.out.println("Navigating to Try Editor Page from ImplementLinkedList Page...");
        linkedListPg.clickOnimplementLinkedList();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 22)
    public void verifytryEditorforValidCode_ImplementLinkedList() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToImplementLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 23)
    public void verifytryEditorforInvalidCode_ImplementLinkedList() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateToImplementLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 24)
    public void verifytryEditorforEmptyInput_ImplementLinkedList() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateToImplementLinkedListTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 25)
    public void verifyTraversalPageTitle() {
        System.out.println("Navigating to Implement Linked List Page...");
        linkedListPg.clickOntraversal();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Traversal";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Implement Linked List Page Title did not match!");
    }
    
    @Test(priority = 26)
    public void verifyPracticeQuestionsPageTitle_TraversalPage() {
        System.out.println("Navigating to Practice Questions Page from TraversalPage Page...");
        linkedListPg.clickOntraversal();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 27)
    public void verifytryEditorPageTitle_TraversalPage() {
        System.out.println("Navigating to Try Editor Page from TraversalPage Page...");
        linkedListPg.clickOntraversal();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 28)
    public void verifytryEditorforValidCode_TraversalPage() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateTonavigateToTraversalTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 29)
    public void verifytryEditorforInvalidCode_TraversalPage() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateTonavigateToTraversalTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 30)
    public void verifytryEditorforEmptyInput_TraversalPage() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateTonavigateToTraversalTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 31)
    public void verifyInsertionPageTitle() {
        System.out.println("Navigating to Insertion Page...");
        linkedListPg.clickOninsertion();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Insertion";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Insertion Page Title did not match!");
    }
    
    @Test(priority = 32)
    public void verifyPracticeQuestionsPageTitle_InsertionPage() {
        System.out.println("Navigating to Practice Questions Page from Insertion Page...");
        linkedListPg.clickOninsertion();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 33)
    public void verifytryEditorPageTitle_InsertionPage() {
        System.out.println("Navigating to Try Editor Page from Insertion Page...");
        linkedListPg.clickOninsertion();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 34)
    public void verifytryEditorforValidCode_InsertionPage() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateTonavigateToInsertionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 35)
    public void verifytryEditorforInvalidCode_InsertionPage() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateTonavigateToInsertionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 36)
    public void verifytryEditorforEmptyInput_InsertionPagee() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateTonavigateToInsertionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
    @Test(priority = 37)
    public void verifyDeletionPageTitle() {
        System.out.println("Navigating to Deletion Page...");
        linkedListPg.clickOndeletionLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Deletion";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Deletion Page Title did not match!");
    }
    
    @Test(priority = 38)
    public void verifyPracticeQuestionsPageTitle_DeletionPage() {
        System.out.println("Navigating to Practice Questions Page from Deletion Page...");
        linkedListPg.clickOndeletionLink();
        verifyPracticeQuestionsPageTitle();
    }
    @Test(priority = 39)
    public void verifytryEditorPageTitle_DeletionPage() {
        System.out.println("Navigating to Try Editor Page from Deletion Page...");
        linkedListPg.clickOndeletionLink();
        verifyTryEditorPageTitle();
    }
    
    @Test(priority = 40)
    public void verifytryEditorforValidCode_DeletionPage() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateTonavigateToDeletionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("ValidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();
        
    }
    @Test(priority = 41)
    public void verifytryEditorforInvalidCode_DeletionPage() throws InterruptedException {
        System.out.println("Checking for InValid Code...");
        navigateTonavigateToDeletionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("InvalidInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();     
        
    }
    @Test(priority = 42)
    public void verifytryEditorforEmptyInput_DeletionPage() throws InterruptedException {
        System.out.println("Checking for EmptyInput...");
        navigateTonavigateToDeletionTryEditor();
        testData = ExcelReaderTestNg.readExcelRow("EmptyInput", "Sheet1");// This is taking the rowName and SheetName
        passingCodetoTryEditer();   
        
    } 
   
    
    
}

