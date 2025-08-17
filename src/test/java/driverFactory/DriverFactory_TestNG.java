package driverFactory;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory_TestNG {

	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_browser(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
//	        	ChromeOptions optionsChrome = new ChromeOptions();
//				optionsChrome.addArguments("--headless=new");
//	        	driver.set(new ChromeDriver(optionsChrome));
			tldriver.set(new ChromeDriver());
			break;
		case "edge":
//	        	EdgeOptions optionsEdge = new EdgeOptions();
//				optionsEdge.addArguments("--headless=new");
//	        	driver.set(new EdgeDriver(optionsEdge));
			tldriver.set(new EdgeDriver());
			break;
		case "firefox":
//	        	FirefoxOptions optionsFirefox = new FirefoxOptions();
//				optionsFirefox.addArguments("--headless");
//	        	driver.set(new FirefoxDriver(optionsFirefox));
			tldriver.set(new FirefoxDriver());
			break;
		default:
			tldriver.set(new ChromeDriver());
			break;
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));

		return getDriver();

	}

	public static WebDriver getDriver() {
		if (Objects.isNull(tldriver.get())) {
			throw new IllegalStateException("WebDriver is not initialized");
		}
		return tldriver.get();

	}

	public static void tear_driver() {
		if (tldriver.get()!=null) {
			tldriver.get().quit();
			tldriver.remove();
		}

	}

}