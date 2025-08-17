package testCases;


import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import pageFactory.Login_pf;
import utils.Dataprovider;
import utils.LoggerLoad;

//@Listeners({ CustomListener.class })
public class LoginTest extends BaseTest{
 
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Launch_pf Launchpf;
	 Home_pf Homepf;
	 LoggerLoad log;
	 Login_pf Loginpf;
	 private Map<String, String> testData;
	 private Map<String, String> testData1;
	 private Map<String, String> testData2;
	 private Map<String, String> testData3;
	 private Map<String, String> testData4;
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup() throws IOException, InterruptedException {
				
		 Launchpf = new Launch_pf();
		 Homepf =new Home_pf();
		 Loginpf =new Login_pf();
		 this.log = new LoggerLoad();
		 Launchpf.get_testUrl();
			Launchpf.clickgetstarted();
			  Loginpf.clickSigninLink();
		}

    @Test(dataProvider = "validandinvalidlogin",dataProviderClass=Dataprovider.class)
    public void validandinvalidlogin(String username, String password) throws IOException {
		testData= excelReader.readExcelRow("ValidCredential", "testdata");
		testData1 = excelReader.readExcelRow("Login1", "testdata");
		testData2 = excelReader.readExcelRow("Login2", "testdata");
		testData3 = excelReader.readExcelRow("Login3", "testdata");
		testData4 = excelReader.readExcelRow("Login4", "testdata");
		
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
        
        String usernameA= testData.get("UserName");
        String passwordA=testData.get("Password");
        String usernameB=testData1.get("UserName");
        String passwordB=testData1.get("Password");
        String usernameC=testData2.get("UserName");
        String passwordC=testData2.get("Password");
        String usernameD=testData3.get("UserName");
        String passwordD=testData3.get("Password");
        String usernameE=testData4.get("UserName");
        String passwordE=testData4.get("Password");
        
         if(username.equals(usernameA) && password.equals(passwordA))
         {
        	 String expsuccessmsg =testData.get("ExpectedMsg");   
             String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
             log.info("entering valid data");
       		Assert.assertEquals(actualsuccessfullmessage,expsuccessmsg,  "user is not logged in"); 
         }
        else if(username.equals(usernameB) && password.equals(passwordB))
       {
    	   String experrormsg = testData1.get("ErrorMessage");
          	String actualerrormessage = Loginpf.invalidAssertionusernamebox();
          	log.info("entering invalid data1");
          	Assert.assertEquals(actualerrormessage,experrormsg,  "user is not logged in");  
       }
       else if(username.equals(usernameC) && password.equals(passwordC))
       {
    	   String experrormsg = testData2.get("ErrorMessage");
         	String actualerrormessage = Loginpf.invalidAssertiopasswordbox();
         	log.info("entering invalid data2");
            Assert.assertEquals(actualerrormessage,experrormsg,  "user is not logged in");    
       }
       else if(username.equals(usernameD) && password.equals(passwordD))
       {
    	   String experrormsg = testData3.get("ErrorMessage");
        	String actualerrormessage =  Loginpf.invalidAssertionusernamebox();
        	log.info("entering invalid data3");
        	Assert.assertEquals(actualerrormessage,experrormsg,  "user is not logged in");    
       }
       else if(username.equals(usernameE) && password.equals(passwordE))
       {
    	   String experrormsg = testData4.get("ErrorMessage");
    	   String acterrormsg = Loginpf.invaliddatamessage();
    	   log.info("entering invalid data4");
   		Assert.assertEquals(acterrormsg,experrormsg,  "user is not able to see 'please fill out this field'message");
    	   
       }
    }
    

    

    }
