package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Launch_pf;
import utils.LoggerLoad;


@Listeners({ CustomListener.class })
public class LaunchTest extends BaseTest  {
	
	public LaunchTest() throws IOException {
		super();
		
	}
	Launch_pf Launchpf;
	BasePage base;
	LoggerLoad log;
	
	@BeforeMethod
	
	public void setup() throws IOException, InterruptedException {
    this.log = new LoggerLoad();
	 Launchpf = new Launch_pf();
		Launchpf.get_testUrl();
	}
	
    @Test
    void checkmsg()
    {
    	
    	String expmsg="You are at the right place";
      	String actmsg = Launchpf.gettextmsg();
      	log.info("check succesfull message");
		Assert.assertEquals(actmsg, expmsg, "user is not able see the message 'you are at rightplace' ");
    }
    @Test
    void clickgetstarted()
    {    
    	
   	   	Launchpf.clickgetstarted();
   	 String actmsg = Launchpf.gettitle();
		String expmsg = "NumpyNinja";
		log.info("clicking on getstarted ");
		Assert.assertEquals(actmsg, expmsg, "user is not on the homepage with title numpyninja");
    }
    

}