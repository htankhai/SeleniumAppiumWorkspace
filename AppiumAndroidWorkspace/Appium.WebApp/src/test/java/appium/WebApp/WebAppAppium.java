package appium.WebApp;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebAppAppium {
static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("browserName", "browser");
		capabilities.setCapability("deviceName", "SimulatorGalaxy");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion","5.0.1" );

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub" ),capabilities);
		
		//LaunchWebPage();
	}

	public static void LaunchWebPage(){
		driver.get("http://www.google.com");
		
	}
	
	
	
	
}
