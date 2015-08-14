package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RunSeleniumGrid_App1 {
	static WebDriver driver;
	static String hubUrl = "http://192.168.70.1:4444/wd/hub";
	static String webUrl = "www.google.com";

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setCapability("browserName", "firefox");
		capability.setCapability("platform", Platform.WINDOWS);
		capability.setCapability("version", "39.0");

		driver = new RemoteWebDriver(new URL(hubUrl ), capability );

		driver.get(webUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		Thread.sleep(3000);

		driver.quit();

	}

}
