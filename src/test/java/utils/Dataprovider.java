package utils;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import driverFactory.DriverFactory_TestNG;
public class Dataprovider {
	ExcelReader excelReader;
	
	
	
	public Dataprovider( ) throws IOException
	{
		
		this.excelReader = new ExcelReader();}
	
 Map<String, String> testData;
	 Map<String, String> testData1;
	 Map<String, String> testData2;
	 Map<String, String> testData3;
	 Map<String, String> testData4;
	  HashMap<String, String> testData5;
	@DataProvider(name= "validandinvalidlogin")
	public String[][] getvalidinvalidData() throws IOException{
		 testData = excelReader.readExcelRow("ValidCredential", "testdata");
		 testData1 = excelReader.readExcelRow("Login1", "testdata");
  	     testData2 = excelReader.readExcelRow("Login2", "testdata");
         testData3 = excelReader.readExcelRow("Login3", "testdata");
	  	 testData4 = excelReader.readExcelRow("Login4", "testdata");
	  	 String[][] data={{"ValidCredential",testData.get("UserName"),testData.get("Password")},
	 			            {"Login1",testData1.get("UserName"),testData1.get("Password")},
	 			           {"Login2",testData2.get("UserName"),testData2.get("Password")},
	 			          {"Login3",testData3.get("UserName"),testData3.get("Password")},
	 			         {"Login4",testData4.get("UserName"),testData4.get("Password")}
	 	                    };
	    return data;
	    	    }
	
	
	@DataProvider(name= "validinvalidRegister")
	public String[][] getregister() throws IOException{
		 testData = excelReader.readExcelRow("validRegister", "testdata");
		 testData1 = excelReader.readExcelRow("Register1", "testdata");
    	 testData2 = excelReader.readExcelRow("Register2", "testdata");
    	  testData3 = excelReader.readExcelRow("Register3", "testdata");
    	  testData4 = excelReader.readExcelRow("Register4", "testdata");
          testData5 = excelReader.readExcelRow("Register5", "testdata");
          String[][] data={{"validRegister",testData.get("UserName"),testData.get("Password"),testData.get("Confirmpassword")},
 			  {"Register1",testData1.get("UserName"),testData1.get("Password"),testData1.get("Confirmpassword")},
 			 {"Register2",testData2.get("UserName"),testData2.get("Password"),testData2.get("Confirmpassword")},
 			{"Register3",testData3.get("UserName"),testData3.get("Password"),testData3.get("Confirmpassword")},
 			{"Register4",testData4.get("UserName"),testData4.get("Password"),testData4.get("Confirmpassword")},
 			{"Register5",testData5.get("UserName"),testData5.get("Password"),testData5.get("Confirmpassword")}
	 	   };
	 	                            
	    return data;
	    }
	
}









