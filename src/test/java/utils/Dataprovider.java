package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	ExcelReader excelReader;

	public Dataprovider() throws IOException {

		this.excelReader = new ExcelReader();
	}

	Map<String, String> testData;
	Map<String, String> testData1;
	Map<String, String> testData2;
	Map<String, String> testData3;
	Map<String, String> testData4;
	HashMap<String, String> testData5;
	HashMap<String, String> testDataValid;
	HashMap<String, String> testDataInValid;


	@DataProvider(name = "validandinvalidlogin")
	public String[][] getvalidinvalidData() throws IOException {
		testData = excelReader.readExcelRow("ValidCredential", "testdata");
		testData1 = excelReader.readExcelRow("Login1", "testdata");
		testData2 = excelReader.readExcelRow("Login2", "testdata");
		testData3 = excelReader.readExcelRow("Login3", "testdata");
		testData4 = excelReader.readExcelRow("Login4", "testdata");

	  	 String[][] data={{"ValidCredential",testData.get("UserName"),testData.get("Password"),testData.get("ExpectedMsg")},
	 			            {"Login1",testData1.get("UserName"),testData1.get("Password"),testData1.get("ErrorMessage")},
	 			           {"Login2",testData2.get("UserName"),testData2.get("Password"),testData2.get("ErrorMessage")},
	 			          {"Login3",testData3.get("UserName"),testData3.get("Password"),testData3.get("ErrorMessage")},
	 			         {"Login4",testData4.get("UserName"),testData4.get("Password"),testData4.get("ErrorMessage")}
	 	                    };
	    return data;
	    	    }

	@DataProvider(name = "validinvalidRegister")
	public String[][] getregister() throws IOException {
		testData = excelReader.readExcelRow("validRegister", "testdata");
		testData1 = excelReader.readExcelRow("Register1", "testdata");
		testData2 = excelReader.readExcelRow("Register2", "testdata");
		testData3 = excelReader.readExcelRow("Register3", "testdata");
		testData4 = excelReader.readExcelRow("Register4", "testdata");
		testData5 = excelReader.readExcelRow("Register5", "testdata");
		  String[][] data={{"validRegister",testData.get("UserName"),testData.get("Password"),testData.get("Confirmpassword"),testData.get("ErrorMessage")},
	 			  {"Register1",testData1.get("UserName"),testData1.get("Password"),testData1.get("Confirmpassword"),testData1.get("ErrorMessage")},
	 			 {"Register2",testData2.get("UserName"),testData2.get("Password"),testData2.get("Confirmpassword"),testData2.get("ErrorMessage")},
	 			{"Register3",testData3.get("UserName"),testData3.get("Password"),testData3.get("Confirmpassword"),testData3.get("ErrorMessage")},
	 			{"Register4",testData4.get("UserName"),testData4.get("Password"),testData4.get("Confirmpassword"),testData4.get("ErrorMessage")},
	 			{"Register5",testData5.get("UserName"),testData5.get("Password"),testData5.get("Confirmpassword"),testData5.get("ErrorMessage")}
	 
		 	   };
		 	                             
		    return data;
		    }
	
	@DataProvider(name = "pythonCodeValidandInvalid")
	public Object[][] pythonCodeTestData() throws IOException {
		testDataValid = excelReader.readExcelRow("ValidCode", "testdata");
		testDataInValid = excelReader.readExcelRow("InvalidCode", "testdata");
		Object[][] data = { { "ValidCode", testDataValid.get("PythonCode"), testDataValid.get("RunResult") },
				{ "InvalidCode", testDataInValid.get("PythonCode"), testDataInValid.get("RunResult") } };
		return data;

	}

}
