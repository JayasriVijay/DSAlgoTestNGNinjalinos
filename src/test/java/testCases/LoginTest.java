package testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import pageFactory.Login_pf;
import utils.Dataprovider;


public class LoginTest extends BaseTest{
 
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Launch_pf Launchpf;
	 Home_pf Homepf;
	 Login_pf Loginpf;
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup() throws IOException, InterruptedException {
				
		 Launchpf = new Launch_pf();
		 Homepf =new Home_pf();
		 Loginpf =new Login_pf();
		 Launchpf.get_testUrl();
		 Launchpf.clickgetstarted();
		  Loginpf.clickSigninLink();
		}

    @Test(dataProvider = "validandinvalidlogin",dataProviderClass=Dataprovider.class)
    public void validandinvalidlogin(String SenarioName,String username, String password,String Expmsg) throws IOException {
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
      
         if(SenarioName.equalsIgnoreCase("ValidCredential"))
         {        	
             String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
             log.info("entering valid data");
       		Assert.assertEquals(actualsuccessfullmessage,Expmsg,  "user is not logged in"); 
         }
        else if(SenarioName.equalsIgnoreCase("Login1"))
       {
           	String actualerrormessage = Loginpf.invalidAssertionusernamebox();
          	log.info("entering invalid data1");
          	Assert.assertEquals(actualerrormessage,Expmsg,  "user is not logged in");  
       }
       else if(SenarioName.equalsIgnoreCase("Login2"))
       {
           	String actualerrormessage = Loginpf.invalidAssertiopasswordbox();
         	log.info("entering invalid data2");
            Assert.assertEquals(actualerrormessage,Expmsg,  "user is not logged in");    
       }
       else if(SenarioName.equalsIgnoreCase("Login3"))
       {
           	String actualerrormessage =  Loginpf.invalidAssertionusernamebox();
        	log.info("entering invalid data3");
        	Assert.assertEquals(actualerrormessage,Expmsg,  "user is not logged in");    
       }
       else if(SenarioName.equalsIgnoreCase("Login4"))
       {
       	   String acterrormsg = Loginpf.invaliddatamessage();
    	   log.info("entering invalid data4");
   		Assert.assertEquals(acterrormsg,Expmsg,  "user is not able to see 'please fill out this field'message");
    	   
       }
    }
    

    

    }
