package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedListPage extends BasePage {

	public LinkedListPage() {
	    super();
		
    }
	 @FindBy(xpath="//*[@href='introduction']")
	 WebElement introPageLink;
	 @FindBy(xpath="//*[contains(text(),'Practice Questions')]")
	 WebElement practicePageLink;
	 @FindBy(xpath="//*[@href='linked-list']")
	 WebElement linkedListButton;
	 @FindBy(xpath="//*[@href='/tryEditor']")
	 WebElement tryHereButton;
	 @FindBy(xpath="//*[@class='CodeMirror-scroll']")
	 WebElement tryEditor;
	 @FindBy(xpath="//*[contains(text(),'Run')]")
	 WebElement runButton;
	 @FindBy(xpath="//*[@id='output']")
	 WebElement output;
	 @FindBy(xpath="//*[@href='creating-linked-list']")
	 WebElement createLinkedListLink;
	 @FindBy(xpath="//*[@href='types-of-linked-list']")
	 WebElement typesofLinkedListLink;
	 @FindBy(xpath="//*[@href='implement-linked-list-in-python']")
	 WebElement implementLinkedListLink;
	 @FindBy(xpath="//*[@href='traversal']")
	 WebElement traversalLink;
	 @FindBy(xpath="//*[@href='insertion-in-linked-list']")
	 WebElement insertionLink;
	 @FindBy(xpath="//*[@href='deletion-in-linked-list']")
	 WebElement deletionLink;
	 
	 public void getToLinkedList(){
		 linkedListButton.click();     			
		}
	 
	 public void clickOnIntroLink(){
		 introPageLink.click();     	
	}
	 
	 public void clickOnPracticeQuestion() {
		 practicePageLink.click();
	 }
	 
	 public void clickOncreateLinkedListLink() {
		 createLinkedListLink.click();
	 }
	 public void clickOntypesofLinkedList() {
		 typesofLinkedListLink.click();
	 }
	 public void clickOnimplementLinkedList() {
		 implementLinkedListLink.click();
	 }
	 public void clickOntraversal() {
		 traversalLink.click();
	 }
	 public void clickOninsertion() {
		 insertionLink.click();
	 }
	 public void clickOndeletionLink() {
		 deletionLink.click();
	 }
	 
	 

}
