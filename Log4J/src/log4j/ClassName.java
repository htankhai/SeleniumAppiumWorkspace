package log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassName {
	WebDriver driver;
	String baseUrl;
	
	private static Logger Log = Logger.getLogger(ClassName.class);

	@BeforeTest
	public void setUp() throws Exception {
		Log.info("_______started server_______");
		Log.warn("Warn");
		baseUrl = "https://qa.knewknovel.com";    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAbi() throws Exception {
		driver.get(baseUrl + "/web/browse.v");
		Log.info("_______Test Inprogress_______");
	}

	@AfterTest
	public void tearDown() throws Exception {    
		Log.info("_______Stopping server_______");
		driver.quit();
	}
}