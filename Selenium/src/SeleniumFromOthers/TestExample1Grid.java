package SeleniumFromOthers;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;

import java.io.File;
import java.net.URL;
import java.util.Dictionary;
public class TestExample1Grid {
	WebDriver driver;
	@Before
	public void setUp(){
		DesiredCapabilities capability =
				DesiredCapabilities.firefox();
		capability.setBrowserName("firefox" );
		//Set the platform we want our tests to run on
		capability.setPlatform("WINDOWS");
		driver = new RemoteWebDriver(new URL("http://<grid hub>:4444/wd/hub"), capability);
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testExamples(){
		//We will put examples in here
	}
}