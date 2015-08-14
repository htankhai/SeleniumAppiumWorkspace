package org.pom.testCases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.pom.pageobjects.SearchPage;

public class SearchPageTest {
	public static void main(String[] args) throws AWTException {
		// Create a new instance of a driver
		WebDriver driver = new FirefoxDriver();
		SearchPage page;

		//Launch Browser
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		page = new SearchPage(driver) ;

		page.searchFor("Cheese");

	}
} 