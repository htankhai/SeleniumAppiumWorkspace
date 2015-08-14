package seleniumProjectVersion2;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class workShop {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	// get it from Selenium IDE. Export test case as Junit4/WebDriver

	@Test
	public void testSample() throws Exception {
		//driver = new InternetExplorerDriver();
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/htan/Desktop/city.HTML");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));

		dropDownList.selectByIndex(0);
		dropDownList.selectByIndex(1);
		dropDownList.selectByIndex(2);
		dropDownList.selectByIndex(3);

		dropDownList.selectByValue("B");
		dropDownList.selectByValue("M");
		dropDownList.selectByValue("S");
		dropDownList.selectByValue("C");
		dropDownList.selectByValue("D");

		dropDownList.selectByVisibleText("San Francisco");
		dropDownList.selectByVisibleText("Daly City");
		dropDownList.selectByVisibleText("Delhi");
		dropDownList.selectByVisibleText("Bangalore");

		//if( dropDownList.isMultiple()){	}
		Thread.sleep(3000);
		dropDownList.deselectAll();


		//    Select s = new Select(driver.findElement(By.xpath("")));
		//driver.close();
		//driver.quit();
	}	
	public void getAllSelectedOptions() {
		WebElement selectElement = driver.findElement(By.xpath("//*[@id='City']")); 
		Select select = new Select(selectElement); 
		List <WebElement> options = select.getOptions(); 
		for (WebElement option: options) { 
			if(option.getText().equals("San Francisco")){
				option.click();
				break;

			}
		}
	}
}


/*
@Test
public void testSample() throws Exception {
    driver = new FirefoxDriver();
    driver.get("file:///C:/Users/anamika/Downloads/city.HTML");

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    selectByIndex();
    deselectAll();
    selectByValue();
    selectByVisibleText();
    driver.close();
    driver.quit();
}
//Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));
//    Select s = new Select(driver.findElement(By.xpath("")));
public void deselectAll() {
    Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));        
    dropDownList.deselectAll();
}

public void getAllSelectedOptions() {
    WebElement selectElement = driver.findElement(By.xpath("//*[@id='City']")); 
    Select select = new Select(selectElement); 
    List <WebElement> options = select.getOptions(); 
    for (WebElement option: options) { 
        if(option.getText().equals("Delhi")){
            option.click();
break;
}
}
}

public void selectByIndex() { 
    Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));        
    dropDownList.selectByIndex(0);
    dropDownList.selectByIndex(1);
    dropDownList.selectByIndex(2);
    dropDownList.selectByIndex(3);    
    dropDownList.selectByIndex(5);
    } 
public void selectByValue(){
    Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));
    dropDownList.selectByValue("B");
    dropDownList.selectByValue("M");
}
public void selectByVisibleText(){
    Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='City']")));
    dropDownList.selectByVisibleText("Delhi");
}
}
 */


/*
package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSample() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("rememberUn")).click();
    driver.findElement(By.id("rememberUn")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
 */

/*
package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class City {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCity() throws Exception {
    driver.get(baseUrl + "file:///C:/Users/htan/Google%20Drive/Feb%2011/Read%20only/Documentation/city.HTML");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=Chennai]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=MYsore]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=Bangalore]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=Chennai]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=Bangalore]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=Chennai]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=Chennai]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=Delhi]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=Delhi]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=Mumbai]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=City | label=Mumbai]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=City | label=MYsore]]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

 */