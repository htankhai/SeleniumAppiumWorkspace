package SeleniumFromOthers;
//Chrome extension
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCh6Chrome {
	WebDriver driver;
	@Before
	public void setUp(){
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/path/to/location");
		driver = new ChromeDriver(options);
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testExamples(){
		WebElement element = driver.findElement(
				By.id("selectLoad"));
		String value = element.getAttribute("value");
		Assert.assertEquals("Click to load the select below",
				value);
	}
}
