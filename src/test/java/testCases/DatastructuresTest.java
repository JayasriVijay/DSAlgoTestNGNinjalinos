package testCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Datastructure_pf;
import pageFactory.Home_pf;
import utils.ExcelReader;
import utils.LoggerLoad;

//@Listeners({ CustomListener.class })
public class DatastructuresTest extends BaseTest {
  public DatastructuresTest() throws IOException {
		super();
	
	}
	
	BasePage base;
	LoggerLoad log;
	ExcelReader excelReader;
	Datastructure_pf Datastructurepf;
	
	HashMap<String, String> testDataValid;
	HashMap<String, String> testDataInValid;
	 Home_pf Homepf;
	
	 
	@BeforeMethod
	public void queue_page() throws IOException {
		this.base = new BasePage();
		this.Datastructurepf = new Datastructure_pf();
		this.Homepf =new Home_pf();
		this.log = new LoggerLoad();
		this.excelReader = new ExcelReader();
		this.testDataValid = new HashMap<>();
		this.testDataInValid = new HashMap<>();
		base.launch_webpage();
		Datastructurepf.clickgetstartedDatastructures();

	}

	

	   @Test(priority=1)
	    public void Timecomplexity() {
		
	    
	    	Datastructurepf.clickTimecomplexityLink();
	    	String exptitle ="Time Complexity";
	    	String acttitle = Datastructurepf.timecomplexitytitle();
	    	log.info("click Timecomplexity link");
			Assert.assertEquals(acttitle, exptitle,"the user is not on timecomplexity page");
	         }
        
	   @Test(priority=2)
	    public void practiceQ() {
	    	
			Datastructurepf.clickTimecomplexityLink();
			Datastructurepf.clickPracticeQuestionsLink();
			String acturl = Datastructurepf.practiceQueURl();
			allureScreenshot();
			log.info("click on Practice questions");
			log.error("There are no practice questions available in the Datastructure module");
			Assert.assertEquals(acturl, "https://dsportalapp.herokuapp.com/data-structures-introduction/practic",
					"user is not able to see practice questions, the page is empty");
				    }
	   @Test(priority=3)
	    public void tryeditor() {

			Datastructurepf.clickTimecomplexityLink();
			Datastructurepf.clickTryhereLink();
			String acturl = Datastructurepf.tryeditorurl();
			String expurl="https://dsportalapp.herokuapp.com/tryEditor";
			log.info("click on tryhere");
			Assert.assertEquals(acturl,expurl,"the user is not on tryeditor page");
	    }
	   @Test(priority=4)
	    public void tryeditornocode(){

			Datastructurepf.clickTimecomplexityLink();
			Datastructurepf.clickTryhereLink();
			Datastructurepf.clickRunButton();
			String actmsg = Datastructurepf.alert_message();
			String expmsg = Datastructurepf.alertconfim();
			allureScreenshot();
			log.info("click on run tryedior page with no code");
			log.error("user is should able to see error message 'Please enter the code'");
			Assert.assertEquals(actmsg, expmsg, "alert msg is not displayed");
	   }

		   @Test(priority = 5, dataProvider = "pythonCodeValidandInvalid")
			public void queueTryingValidAndInvalidCode(String code) throws IOException {
			  
			Datastructurepf.clickTimecomplexityLink();
			Datastructurepf.clickTryhereLink();
			testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
			testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
			base.validAndInvalidCode(code);
			String validCodedata = testDataValid.get("PythonCode");
			String invalidCodedata = testDataInValid.get("PythonCode");
			String expectedOutput = testDataValid.get("RunResult");
			String alertexpected = testDataInValid.get("RunResult");

			if (code.equals(validCodedata)) {
				log.info("click on run tryedior page with valid code");
				Assert.assertEquals(base.output_text(), expectedOutput, "did not get the expected output");

			} else if (code.equals(invalidCodedata)) {
				String alertmsg = base.alert_message();
				base.handle_alert();
				log.info("click on run tryedior page with valid code");
				Assert.assertEquals(alertmsg, alertexpected,
						"did not get correct alert message for giving an invalid code as input");

			} else {
				Assert.fail("Provided code did not match valid or invalid test data");
			}

		   }
	  
	  


	   
	   

			 
	
  
        }