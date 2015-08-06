package appium.HybridApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HybridAppiumApp {
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		File appDir = new File("src/test/java");
		File app = new File(appDir, "com.google.android-2.3.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("browserName", "Chrome");

		//capabilities.setCapability("device","Android");
		capabilities.setCapability("deveiceName","SimulatorGalaxy" );		
		capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app",app.getAbsolutePath());
		capabilities.setCapability("appPackage","com.android.chrome");
		capabilities.setCapability("appActivity","com.google.android.apps.chrome.");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	


	}

	//switch the content
	public static void switchWebViewContent(){

		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		((AppiumDriver) driver).context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

		//do some web testing
		WebElement myText = driver.findElement(By.id(".green_button"));
				myText .click();

		((AppiumDriver) driver).context("NATIVE_APP");

		// do more native testing if we want


	}

	public void loginTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);  
		
		driver.findElement(By.xpath("//EditText[@text='Email Address']")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//LinearLayout/EditText[2]")).sendKeys("Testerpwd");
		driver.findElement(By.xpath("//CheckBox")).click();
		driver.findElement(By.xpath("//Button[@text='Login']")).click();

		WebDriverWait wait = new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//Button[@text='Logout']")));  
		driver.findElement(By.xpath("//Button[@text='Logout']")).click();
	}

}
