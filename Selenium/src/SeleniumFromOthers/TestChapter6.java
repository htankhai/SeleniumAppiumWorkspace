package SeleniumFromOthers;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.io.File;
import java.util.Dictionary;
public class TestChapter6 {
	WebDriver driver;
	@Before
	public void setUp(){
		//driver = //we will update this part with each section
				driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testExamples(){
		// We will put examples in here
	}
}