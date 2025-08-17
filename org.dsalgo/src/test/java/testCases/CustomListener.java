package testCases;


import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTest implements ITestListener {

	public CustomListener() throws IOException {
		super();

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