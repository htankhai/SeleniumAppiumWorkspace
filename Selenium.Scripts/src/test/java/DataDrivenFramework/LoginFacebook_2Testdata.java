package DataDrivenFramework;
//Open Facebook and type username and password and login
//run 2 times with different set of data provided in 2D array
//login with 2 test data set and highlight on username.
//Scroll into view
//TesNg - DataProvider
//JavaScriptExecutor
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFacebook_2Testdata {

	@Test(dataProvider="testdata")
	public void TestFireFox(String uname,String password) throws AWTException{

		// Open browser
		WebDriver driver=new FirefoxDriver();


		// Maximize browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Load application
		driver.get("http://www.facebook.com");

		System.out.println("Highlight element -----------------");
		
		// Inspect element
		WebElement username= driver.findElement(By.id("email")); 

		// Call highlight method on username
		highLightElement(driver,username);
		
		
		
		System.out.println("Scroll into view--------------------");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if (driver instanceof JavascriptExecutor) {
			js.executeScript("arguments[0].scrollIntoView(true);", username);
			}


		System.out.println("Scroll down page 400 pixel range -----------");
		{	int range = 400;
		js.executeScript("window.scrollBy(0," + range + ")", "");
		
	}
	
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	
		//login
		Robot rbt= new Robot();                        // Create object of Robot class
		rbt.keyPress(KeyEvent.VK_ENTER);      // Press Enter
		rbt.keyRelease(KeyEvent.VK_ENTER);  // Release Enter
		
		//driver.findElement(By.id("u_0_n")).click();

		
		driver.quit();


	}


	// DataProvider feed data to test cases 
	//array with 2 rows and 2 column. It will run our test case two times because we have taken 2 rows.
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed(){

		// Create object array with 2 rows and 2 column- 
		Object [][] facebookdata=new Object[2][2];

		facebookdata[0][0]="htan.khai@yahoo.com";

		facebookdata[0][1]="Thisismine13";

		facebookdata[1][0]="htankhai@live.com";

		facebookdata[1][1]="Thisismine13";

		// return arrayobject to testscript
		return facebookdata;
	}


	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red')", element); 

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 

	}


}
