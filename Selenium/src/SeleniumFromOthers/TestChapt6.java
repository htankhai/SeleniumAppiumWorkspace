package SeleniumFromOthers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestChapt6 {
	WebDriver driver;
	@Before
	public void setUp(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage",
				"http://book,theautomatedtester.co.uk/chapter4");
		driver = new FirefoxDriver(profile);
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testExamples(){
		WebElement element = driver.findElement(By.id("nextBid"));
		element.sendKeys("100");
	}
}