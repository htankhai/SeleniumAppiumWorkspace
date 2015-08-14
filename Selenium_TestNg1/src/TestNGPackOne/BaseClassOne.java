package TestNGPackOne;
//base class to initialize and close webdriver instance.
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassOne {
		public static WebDriver driver = new FirefoxDriver();

	//@BeforeSuite annotation describes this method has to run before all suites
	@BeforeSuite 
	public void setup() throws Exception { 
		driver.get("http://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	} 
	//@AfterSuite annotation describes this method has to run after execution of all suites
	@AfterSuite
	public void tearDown() throws Exception { 
		driver.quit(); 
	} 
}
