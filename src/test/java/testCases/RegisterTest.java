package testCases;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import pageFactory.Register_pf;
import utils.Dataprovider;
import utils.LoggerLoad;

//@Listeners({ CustomListener.class })
public class RegisterTest extends BaseTest {
	public RegisterTest() throws IOException {
		super();
		
	}


	Launch_pf Launchpf;
	 Home_pf Homepf;
	 LoggerLoad log;
	 Register_pf Registerpf;
	 
	 private Map<String, String> testData;
	 private Map<String, String> testData1;
	 private Map<String, String> testData2;
	 private Map<String, String> testData3;
	 private Map<String, String> testData4;
	 private Map<String, String> testData5;


	
	 
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup() throws IOException, InterruptedException {
				
		 Launchpf = new Launch_pf();
		 Homepf =new Home_pf();
		 Registerpf =new Register_pf();
		 this.log = new LoggerLoad();
		 Launchpf.get_testUrl();
	   	Launchpf.clickgetstarted();
		Homepf.clickRegister();
		}
	 
	

	 @Test(dataProvider = "validinvalidRegister",dataProviderClass=Dataprovider.class)
	    public void validinvalidReg(String username, String password, String confirmpassword) throws IOException {
	    	testData = excelReader.readExcelRow("validRegister", "testdata");
	    	testData1 = excelReader.readExcelRow("Register1", "testdata");
	    	testData2 = excelReader.readExcelRow("Register2", "testdata");
	    	testData3 = excelReader.readExcelRow("Register3", "testdata");
	    	testData4 = excelReader.readExcelRow("Register4", "testdata");
	    	testData5 = excelReader.readExcelRow("Register5", "testdata");
	    	
	      
		 Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
	    
	      
	       String usernameA= testData.get("UserName");
	       String passwordA= testData.get("Password");
	       String confirmpasswordA= testData.get("Confirmpassword");
	       String usernameB= testData1.get("UserName");
	       String passwordB= testData1.get("Password");
	       String confirmpasswordB= testData1.get("Confirmpassword");
	       String usernameC= testData2.get("UserName");
	       String passwordC= testData2.get("Password");
	       String confirmpasswordC= testData2.get("Confirmpassword");
	       String usernameD= testData3.get("UserName");
	       String passwordD= testData3.get("Password");
	       String confirmpasswordD= testData3.get("Confirmpassword");
	       String usernameE= testData4.get("UserName");
	       String passwordE= testData4.get("Password"); 
	       String confirmpasswordE= testData4.get("Confirmpassword");
	       String usernameF=testData5.get("UserName");
	       String passwordF=testData5.get("Password");
	       String confirmpasswordF= testData5.get("Confirmpassword");
	     
	       if(username.equals(usernameA) && password.equals(passwordA) && confirmpassword.equals(confirmpasswordA) )
	       {
	    	   String experror =testData.get("ErrorMessage");
		      String  actualmessage = Registerpf.missmatchPasswordMessage();
		        allureScreenshot();
				log.error("Practice questions page is empty in queue module");
				log.info("entering valid regdata");
		  		Assert.assertEquals(actualmessage, experror, "user not able to see 'user is already registered'");
 
	       }
	       else if(username.equals(usernameB) && password.equals(passwordB) && confirmpassword.equals(confirmpasswordB))
	       {
	    	   String expsuccessmsg =testData1.get("ErrorMessage"); 
		        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		        log.info("entering invalid regdata1");
		  		Assert.assertEquals(actualmessage,expsuccessmsg,  "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameC) && password.equals(passwordC) && confirmpassword.equals(confirmpasswordC))
	       {
	    	   String expsuccessmsg = testData2.get("ErrorMessage");
		        String actualmessage =Registerpf.invalidAssertionPasswdnamebox();
		        log.info("entering invalid regdata2");
		  		Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameD) && password.equals(passwordD) && confirmpassword.equals(confirmpasswordD))
	       {
	    	   String expsuccessmsg =testData3.get("ErrorMessage");
		        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		        log.info("entering invalid regdata3");
		  		Assert.assertEquals(actualmessage,expsuccessmsg,  "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameE) && password.equals(passwordE) && confirmpassword.equals(confirmpasswordE))
	       {
	    	   String expsuccessmsg = testData4.get("ErrorMessage");
		        String actualmessage = Registerpf.invalidAssertionconfirmpswdbox();
		        log.info("entering invalid regdata4");
		  		Assert.assertEquals(actualmessage,expsuccessmsg,  "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameF) &&  password.equals(passwordF) && confirmpassword.equals(confirmpasswordF))
	       {
	    	   String expsuccessmsg = testData5.get("ErrorMessage");
		        String actualmessage =  Registerpf.missmatchPasswordMessage();
		        log.info("entering invalid regdata5");
		  		Assert.assertEquals(actualmessage,expsuccessmsg,  "user not able to see 'fill out this field message'");

	       }
	       

	         }


	 }
	 
	 
	 
	 
	 
	 
	 
