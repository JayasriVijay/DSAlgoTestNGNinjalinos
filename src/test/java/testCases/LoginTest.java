package testCases;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.Home_pf;
import pageFactory.Launch_pf;
import pageFactory.Login_pf;
import utils.Dataprovider;
import utils.LoggerLoad;

@Listeners({ CustomListener.class })
public class LoginTest extends BaseTest {
	public LoginTest() throws IOException {
		super();
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
		Homepf = new Home_pf();
		Loginpf = new Login_pf();
		this.log = new LoggerLoad();
		Launchpf.get_testUrl();
		Launchpf.clickgetstarted();
		Loginpf.clickSigninLink();
	}

	@Test(dataProvider = "validandinvalidlogin", dataProviderClass = Dataprovider.class)
	public void validandinvalidlogin(String SenarioName, String username, String password) throws IOException {
		testData = excelReader.readExcelRow("ValidCredential", "testdata");
		testData1 = excelReader.readExcelRow("Login1", "testdata");
		testData2 = excelReader.readExcelRow("Login2", "testdata");
		testData3 = excelReader.readExcelRow("Login3", "testdata");
		testData4 = excelReader.readExcelRow("Login4", "testdata");

		Loginpf.setdata(username, password);
		Loginpf.clickLoginbutton();
		if (SenarioName.equalsIgnoreCase("ValidCredential")) {
			String expsuccessmsg = testData.get("ExpectedMsg");
			String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
			log.info("entering valid data");
			Assert.assertEquals(actualsuccessfullmessage, expsuccessmsg, "user is not logged in");
		} else if (SenarioName.equalsIgnoreCase("Login1")) {
			String experrormsg = testData1.get("ErrorMessage");
			String actualerrormessage = Loginpf.invalidAssertionusernamebox();
			log.info("entering invalid data1");
			Assert.assertEquals(actualerrormessage, experrormsg, "user is not logged in");
		} else if (SenarioName.equalsIgnoreCase("Login2")) {
			String experrormsg = testData2.get("ErrorMessage");
			String actualerrormessage = Loginpf.invalidAssertiopasswordbox();
			log.info("entering invalid data2");
			Assert.assertEquals(actualerrormessage, experrormsg, "user is not logged in");
		} else if (SenarioName.equalsIgnoreCase("Login3")) {
			String experrormsg = testData3.get("ErrorMessage");
			String actualerrormessage = Loginpf.invalidAssertionusernamebox();
			log.info("entering invalid data3");
			Assert.assertEquals(actualerrormessage, experrormsg, "user is not logged in");
		} else if (SenarioName.equalsIgnoreCase("Login4")) {
			String experrormsg = testData4.get("ErrorMessage");
			String acterrormsg = Loginpf.invaliddatamessage();
			log.info("entering invalid data4");
			Assert.assertEquals(acterrormsg, experrormsg,
					"user is not able to see 'please fill out this field'message");

		}
	}
}