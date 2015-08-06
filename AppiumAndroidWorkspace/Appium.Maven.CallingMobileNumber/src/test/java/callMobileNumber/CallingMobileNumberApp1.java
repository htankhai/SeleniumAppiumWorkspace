package callMobileNumber;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class CallingMobileNumberApp1 {
	WebDriver driver = null;

	@Test
	public void callNumber() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SimulatorGalaxy");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion","5.0.1 " );


		//Given appium server's hub to Android driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub" ),capabilities);


		//locate the element to dial the numbers
		//415
		/*WebElement four =driver.findElement(By.name("4"));
		four.click();
		WebElement one =driver.findElement(By.name("1"));
		one.click();
		WebElement five =driver.findElement(By.name("5"));
		five.click();

		//232
		WebElement two =driver.findElement(By.name("2"));
		two.click();
		WebElement three =driver.findElement(By.name("3"));
		three.click();
		WebElement two_again =driver.findElement(By.name("2"));
		two_again.click();

		//2960
		WebElement two_again_again =driver.findElement(By.name("2"));
		two_again_again.click();
		WebElement nine =driver.findElement(By.name("9"));
		nine.click();
		WebElement six =driver.findElement(By.name("6"));
		six.click();
		WebElement zero =driver.findElement(By.name("0"));
		zero.click();*/

	}
	
	public void testCal() throws Exception {
		//locate the Text on the calculator by using By.name()
		WebElement two=driver.findElement(By.name("2"));
		two.click();
		WebElement plus=driver.findElement(By.name("+"));
		plus.click();
		WebElement four=driver.findElement(By.name("4"));
		four.click();
		WebElement equalTo=driver.findElement(By.name("="));
		equalTo.click();
		//locate the edit box of the calculator by using By.tagName()
		WebElement results=driver.findElement(By.tagName("EditText"));
		//Check the calculated value on the edit box
		assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

	}

}
