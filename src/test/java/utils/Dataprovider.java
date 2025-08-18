package utils;

import java.io.IOException;
import java.time.Duration;
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
	//ExcelReader	excelReader = new ExcelReader();
	private Map<String, String> testData;
	private Map<String, String> testData1;
	private Map<String, String> testData2;
	private Map<String, String> testData3;
	private Map<String, String> testData4;

	@DataProvider(name= "validandinvalidlogin")

	public String[][] getvalidinvalidData() throws IOException{
		 testData = excelReader.readExcelRow("ValidCredential", "testdata");
		 
		 String username =testData.get("UserName");
		 String password = testData.get("Password");
		
		 testData1 = excelReader.readExcelRow("Login1", "testdata");
	  	   String username1 = testData1.get("UserName");
	  	   String password1 = testData1.get("Password");
	  	   
  	   testData2 = excelReader.readExcelRow("Login2", "testdata");
  	 String username2 = testData2.get("UserName");
  	 String password2 = testData2.get("Password");
  	 
  	  testData3 = excelReader.readExcelRow("Login3", "testdata");
	  	 String username3 = testData3.get("UserName");
	  	 String password3 = testData3.get("Password");
	  	 
	  	 testData4 = excelReader.readExcelRow("Login4", "testdata");
	  	 String username4 = testData4.get("UserName");
	  	 String password4 = testData4.get("Password");
  	 
	 	   String[][] data={{username,password},
	 			            {username1,password1},
	 	                    {username2,password2},
	 	                    {username3,password3},
	 	                    {username4,password4}
	 	                    };
	    return data;
	    	    }
	@DataProvider(name= "validinvalidRegister")
	public String[][] getregister() throws IOException{
		Map<String, String> testData = excelReader.readExcelRow("validRegister", "testdata");
	  	   String username = testData.get("UserName");
	  	   String password = testData.get("Password");
	  	 String confirmpassword = testData.get("Confirmpassword");
		
		Map<String, String> testData1 = excelReader.readExcelRow("Register1", "testdata");
	  	   String username1 = testData1.get("UserName");
	  	   String password1 = testData1.get("Password");
	  	 String confirmpassword1 = testData1.get("Confirmpassword");
	  	 
	  	Map<String, String> testData2 = excelReader.readExcelRow("Register2", "testdata");
	  	   String username2 = testData2.get("UserName");
	  	   String password2 = testData2.get("Password");
	  	 String confirmpassword2 = testData2.get("Confirmpassword");
	  	 
	  	Map<String, String> testData3 = excelReader.readExcelRow("Register3", "testdata");
	  	   String username3 = testData3.get("UserName");
	  	   String password3 = testData3.get("Password");
	  	 String confirmpassword3 = testData3.get("Confirmpassword");
	  	 
	  	Map<String, String> testData4 = excelReader.readExcelRow("Register4", "testdata");
	  	   String username4 = testData4.get("UserName");
	  	   String password4 = testData4.get("Password");
	  	 String confirmpassword4 = testData4.get("Confirmpassword");
	  	 
	  	Map<String, String> testData5 = excelReader.readExcelRow("Register5", "testdata");
	  	   String username5 = testData5.get("UserName");
	  	   String password5 = testData5.get("Password");
	  	 String confirmpassword5 = testData5.get("Confirmpassword");
	  	   
	 	   String[][] data={{username,password,confirmpassword},
	 			  {username1,password1,confirmpassword1},
	 			  {username2,password2,confirmpassword2},
	 			 {username3,password3,confirmpassword3},
 			 {username4,password4,confirmpassword4},
 			{username5,password5,confirmpassword5}
	 	   };
	 	                             
	    return data;
	    }
	
 
}
