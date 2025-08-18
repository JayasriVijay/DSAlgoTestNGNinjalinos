package testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageFactory.BasePage;
import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import utils.LoggerLoad;
@Listeners({ CustomListener.class })
public class HomeTest extends BaseTest  {
public HomeTest() throws IOException {
		super();
		
	}
Launch_pf Launchpf;
Home_pf Homepf;
BasePage base;
LoggerLoad log;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup() throws IOException, InterruptedException {
			
	 Launchpf = new Launch_pf();
	 Homepf =new Home_pf();
	 this.log = new LoggerLoad();
	 Launchpf.get_testUrl();
	 Launchpf.clickgetstarted();
	}
		 
			@Test(priority=1)
		    void ClicksDataStBtn()
		    {
				Homepf.clickgetstartedDatastructures();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("check DS getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
	
		 @Test(priority=2)
		    void ClickArrayBtn()
		    {
			 Homepf.clickgetstartedArray();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on Array getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
		
		 @Test(priority=3)
		    void ClickLinkedlstBtn() 
		    {
			 
			 Homepf.clickgetstartedLinkedList();
			
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on LinkedLst getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
		
		 @Test(priority=4)
		    void ClickStacktBtn() 
		    {
			 
			 Homepf.clickgetstartedStack();
			
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on Stack getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
		
		
		
		

		 @Test(priority=5)
		    void ClickQueueBtn() throws InterruptedException
		    {
			 
			 Homepf.clickgetstartedQueue();
			
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on Queue getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
	
		 @Test(priority=6)
		    void ClickTreeBtn() 
		    {
			 
			 Homepf.clickgetstartedTree();
			
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on Tree getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
	
		 @Test(priority=7)
		    void ClickGraphBtn() 
		    {
			 
			 Homepf.clickgetstartedGraph();
			
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				log.info("click on Graph getstarted");
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
		    }
	
		@Test(priority=8)
		void DropdownDS()
		{
			Homepf.clickDropdownbox();
			allureScreenshot();
			log.error("the user is not able to see mesg your are not logged in because no option in the dropdown");
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			log.info("click on Dropdown DS ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=9)
		void DropdownArray()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownArrays();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Array ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=10)
		void DropdownLinkedlst()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownLinkedList();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Linkedlst");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=11)
		void DropdownStack()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownStack();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Stack ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=12)
		void DropdownQueue()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownQueue();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Queue ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=13)
		void DropdownTree()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownTree();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Tree ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=14)
		void DropdownGraph()
		{
			Homepf.clickDropdownbox();
			Homepf.clickDropdownGraph();
			String actmsg = Homepf.notloggedinmesg();
			String expmsg = "You are not logged in";
			Log.info("click on Dropdown Graph ");
			Assert.assertEquals(actmsg, expmsg,
					"the user is not able to see mesg your are not logged in because no option in the dropdown");
		}
		@Test(priority=15)
		 void clickregister() {
			Homepf.clickRegister();
		}

		 

}