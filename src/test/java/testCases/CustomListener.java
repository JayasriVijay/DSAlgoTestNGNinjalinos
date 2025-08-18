package testCases;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.BaseTest;

public class CustomListener extends BaseTest implements ITestListener {
	
	public CustomListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			failed_screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}


//THIS OVERRRIDE THING DIDNOT COME AUTOMATICALLY FOR ME ,I WROTE IT FROM VIDEO