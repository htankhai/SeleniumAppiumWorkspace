package org.testNg_parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Parallel {
	private  WebDriver driver=null;
	
	@BeforeClass
	//parameter value will retrieved from testng.xml file's <parameter> tag.
	@Parameters ({"browser"})
	public void setup(String browser){//Method will pass value of parameter.
		if (browser.equals("FFX")) {//If value Is FFX then webdriver will open Firefox Browser.
			System.out.println("Test Starts Running In Firefox Browser.");
			driver = new FirefoxDriver();   
		}else if (browser.equals("CRM")){//If value Is CRM then webdriver will open chrome Browser.
			System.out.println("Test Starts Running In Google chrome.");
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\htan\\Software Library\\chromedriver.exe");
			driver = new ChromeDriver();   
		}
		
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");  
	} 
	//Both bellow given tests will be executed In both browsers.
	@Test
	public void verify_title(){   
		String title = driver.getTitle();
		Assert.assertEquals("Only Testing: LogIn", title);
		System.out.println("Title Is Fine.");   
	} 

	@Test
	public void verify_message(){  
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("UID1");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals("UserId Is : UID1  Password Is : pass1", alert);
		System.out.println("Alert Is Fine.");  
	} 
	
	@AfterClass 
	public void closebrowser(){
		driver.quit();  
	}
}
