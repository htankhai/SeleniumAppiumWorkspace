package com.androidDriver;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.AndroidDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AndriodDriver {
	  /**
	   * Create WebDriver as static variable
	   */
	  private static WebDriver driver;
	  
	  
	  /**
	 * Setup some variable to run your script test
	 */
	@BeforeTest
	public void beforeTest() {
	    driver =  new AndroidDriver();
	  }
	  
	  /**
	 * your test script
	 */
	@Test
	  public void f() {
	  driver.get("https://automationplace.blogspot.com");
	  //create more test script here
	  }
	  
	  
	  /**
	 * after run your script test , use this code to close your browser
	 */
	@AfterTest
	  public void afterTest() {
	    driver.quit();
	  }
}
