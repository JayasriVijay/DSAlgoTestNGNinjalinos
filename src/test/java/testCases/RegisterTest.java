package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import pageFactory.Register_pf;
import utils.Dataprovider;


public class RegisterTest extends BaseTest {
	public RegisterTest() throws IOException {
		super();
		
	}


	Launch_pf Launchpf;
	 Home_pf Homepf;
	 Register_pf Registerpf;

	 @BeforeMethod
		@Parameters("browser")
		public void setup() throws IOException, InterruptedException {
				
		 Launchpf = new Launch_pf();
		 Homepf =new Home_pf();
		 Registerpf =new Register_pf();
		 Launchpf.get_testUrl();
	   	Launchpf.clickgetstarted();
		Homepf.clickRegister();
		}
	 
		 @Test(dataProvider = "validinvalidRegister",dataProviderClass=Dataprovider.class)
	    public void validinvalidReg(String SenarioName,String username, String password, String confirmpassword,String Expmsg) throws IOException {

		 Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
	    	       if(SenarioName.equalsIgnoreCase("validRegister") )
	       {
		      String  actualmessage = Registerpf.missmatchPasswordMessage();
				log.error("Practice questions page is empty in queue module");
				log.info("entering valid regdata");
		  		Assert.assertEquals(actualmessage, Expmsg, "user not able to see 'user is already registered'");
 
	       }
	       else if(SenarioName.equalsIgnoreCase("Register1"))
	       {
	   	        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		        log.info("entering invalid regdata1");
		  		Assert.assertEquals(actualmessage,Expmsg,  "user not able to see 'fill out this field message'");

	       }
	       else if(SenarioName.equalsIgnoreCase("Register2"))
	       {
		        String actualmessage =Registerpf.invalidAssertionPasswdnamebox();
		        log.info("entering invalid regdata2");
		  		Assert.assertEquals(actualmessage, Expmsg, "user not able to see 'fill out this field message'");
	       }
	       else if(SenarioName.equalsIgnoreCase("Register3"))
	       {
		        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		        log.info("entering invalid regdata3");
		  		Assert.assertEquals(actualmessage,Expmsg,  "user not able to see 'fill out this field message'");
	       }
	       else if(SenarioName.equalsIgnoreCase("Register4"))
	       {
		        String actualmessage = Registerpf.invalidAssertionconfirmpswdbox();
		        log.info("entering invalid regdata4");
		  		Assert.assertEquals(actualmessage,Expmsg,  "user not able to see 'fill out this field message'");
	       }
	       else if(SenarioName.equalsIgnoreCase("Register5"))
	       {
		        String actualmessage =  Registerpf.missmatchPasswordMessage();
		        log.info("entering invalid regdata5");
		  		Assert.assertEquals(actualmessage,Expmsg,  "user not able to see 'fill out this field message'");
	       }
	       

	         }


	 }
	 
	 
	 
	 
	 
	 
	 

