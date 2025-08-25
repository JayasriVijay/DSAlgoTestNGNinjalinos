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


public class RegisterTest extends BaseTest {
	public RegisterTest() throws IOException {
		super();
	}

	Launch_pf Launchpf;
	Home_pf Homepf;	
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
		Homepf = new Home_pf();
		Registerpf = new Register_pf();	
		Launchpf.get_testUrl();
		Launchpf.clickgetstarted();
		Homepf.clickRegister();
	}

	@Test(dataProvider = "validinvalidRegister", dataProviderClass = Dataprovider.class)
	public void validinvalidReg(String SenarioName, String username, String password, String confirmpassword)
			throws IOException {
		testData = excelReader.readExcelRow("validRegister", "testdata");
		testData1 = excelReader.readExcelRow("Register1", "testdata");
		testData2 = excelReader.readExcelRow("Register2", "testdata");
		testData3 = excelReader.readExcelRow("Register3", "testdata");
		testData4 = excelReader.readExcelRow("Register4", "testdata");
		testData5 = excelReader.readExcelRow("Register5", "testdata");

		Registerpf.setdatas(username, password, confirmpassword);
		Registerpf.clickRegisterbutton();

		if (SenarioName.equalsIgnoreCase("validRegister")) {
			String experror = testData.get("ErrorMessage");
			String actualmessage = Registerpf.missmatchPasswordMessage();
			log.error("Practice questions page is empty in queue module");
			log.info("entering valid regdata");
			Assert.assertEquals(actualmessage, experror, "user not able to see 'user is already registered'");
		} else if (SenarioName.equalsIgnoreCase("Register1")) {
			String expsuccessmsg = testData1.get("ErrorMessage");
			String actualmessage = Registerpf.invalidAssertionUsernamebox();
			log.info("entering invalid regdata1");
			Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");
		} else if (SenarioName.equalsIgnoreCase("Register2")) {
			String expsuccessmsg = testData2.get("ErrorMessage");
			String actualmessage = Registerpf.invalidAssertionPasswdnamebox();
			log.info("entering invalid regdata2");
			Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");
		} else if (SenarioName.equalsIgnoreCase("Register3")) {
			String expsuccessmsg = testData3.get("ErrorMessage");
			String actualmessage = Registerpf.invalidAssertionUsernamebox();
			log.info("entering invalid regdata3");
			Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");
		} else if (SenarioName.equalsIgnoreCase("Register4")) {
			String expsuccessmsg = testData4.get("ErrorMessage");
			String actualmessage = Registerpf.invalidAssertionconfirmpswdbox();
			log.info("entering invalid regdata4");
			Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");
		} else if (SenarioName.equalsIgnoreCase("Register5")) {
			String expsuccessmsg = testData5.get("ErrorMessage");
			String actualmessage = Registerpf.missmatchPasswordMessage();
			log.info("entering invalid regdata5");
			Assert.assertEquals(actualmessage, expsuccessmsg, "user not able to see 'fill out this field message'");
		}

	}
}