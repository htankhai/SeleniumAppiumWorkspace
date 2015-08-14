package SeleniumFromOthers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestChapter6IE {
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new InternetExplorerDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testExamples(){
		WebElement element = driver.findElement(By.id("bid"));
		Assert.assertEquals("50", element.getText());
	}
}
