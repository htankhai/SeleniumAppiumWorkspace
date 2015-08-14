package SeleniumFromOthers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCha6 {
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new ChromeDriver();
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
