package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
	        	ChromeOptions optionsChrome = new ChromeOptions();
				optionsChrome.addArguments("--headless=new");
	        	tlDriver.set(new ChromeDriver(optionsChrome));
			//tlDriver.set(new ChromeDriver());
			break;
		case "safari":
	        	tlDriver.set(new SafariDriver());
			break;
		case "firefox":
	        	FirefoxOptions optionsFirefox = new FirefoxOptions();
			    optionsFirefox.addArguments("--headless");
	        	tlDriver.set(new FirefoxDriver(optionsFirefox));
			//tlDriver.set(new FirefoxDriver());
			break;
		default:
			tlDriver.set(new ChromeDriver());
			break;
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));

		return getDriver();

	}

    
    
 // MY EARLIER CODE FOR SETTING UP DRIVER   
    
//    //Set the driver for the current thread
//    public static void setDriver(String browser) throws InterruptedException {
//        if (browser.equalsIgnoreCase("chrome")) {
//              WebDriverManager.chromedriver().setup();
//            tlDriver.set(new ChromeDriver());
//        } else if (browser.equalsIgnoreCase("firefox")) {
//        	WebDriverManager.firefoxdriver().setup();
//            tlDriver.set(new FirefoxDriver());
//        } else if (browser.equalsIgnoreCase("safari")) {
//            tlDriver.set(new SafariDriver());
//        } else {
//            System.out.println("Please enter valid browser name");
//        }
//        
//        getDriver().manage().deleteAllCookies();
//        getDriver().manage().window().maximize();
//		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		//getDriver().get("https://dsportalapp.herokuapp.com");
//		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
//		
//		
//        
//        
//    }
    
    public static WebDriver getDriver() {
        return tlDriver.get();  // Gets the driver for the current thread
    }


  
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();  // Close browser
            tlDriver.remove();      // Remove driver from ThreadLocal memory
        }
    }
}





//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//public class DriverFactory {
//	
//	WebDriver driver;
//	
//	public  WebDriver getDriver(String br) throws InterruptedException {
//		switch(br.toLowerCase()) {
//		case "chrome":
//			driver = new ChromeDriver(); break;
//		case "firefox":
//			driver = new FirefoxDriver(); break;
//		case "safari":
//			driver = new SafariDriver(); break;
//				
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://dsportalapp.herokuapp.com");
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		
//		return driver;
//		
//	}
//	
//	public void quitDriver() {
//		driver.quit();
//	}
//	 
//}
