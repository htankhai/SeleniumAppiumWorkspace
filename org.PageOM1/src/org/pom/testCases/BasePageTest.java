package org.pom.testCases;
import org.openqa.selenium.WebDriver;
import org.pom.base.TestBaseSetup;
import org.pom.pageobjects.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasePageTest extends TestBaseSetup{

	private WebDriver driver;
	BasePage basePage;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test
	public void verifyHomePage() {
		System.out.println("Home page test...");
		basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	
	}


}
