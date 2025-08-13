package driverFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	
	//ThreadLocal Driver 
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver initDriver(String browser) throws IOException {
		//for cross browser testing and setting tldriver to driver using set method
		
		switch (browser.toLowerCase()) {
		case "chrome":
			tldriver.set(new ChromeDriver());
			break;
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
		default:
			tldriver.set(new EdgeDriver());
			break;
		}
		getdriver().manage().window().maximize();
		getdriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));//need to check before or after url 
		getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getdriver();	
	}
	
	// used to get the driver with ThreadLocal for parallel testing
	// thread local is used to make sure that each thread(test cases) getting its
	// own isolated webdriver instance and passed through get driver method
	
public static WebDriver getdriver() {
	//using Objects.is Null method from java
	if (Objects.isNull(tldriver.get())) {
		throw new IllegalStateException("WebDriver not initialized for the current thread.");
	}
		return tldriver.get();
	}

public static void quitDriver() {
	if (tldriver.get() != null) {
		tldriver.get().quit();
		tldriver.remove();
	}

}	
	}
