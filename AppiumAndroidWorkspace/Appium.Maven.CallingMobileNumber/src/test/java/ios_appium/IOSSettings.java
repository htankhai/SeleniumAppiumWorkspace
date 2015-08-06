package ios_appium;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSSettings {
	static AppiumDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("PlatformName", "iOS");
		capabilities.setCapability("PlatformVersion", "8.1");
		capabilities.setCapability("deviceName", "iPhone5");
		
		//open settings on ios device
		capabilities.setCapability("app", "settings");

		driver= new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),    capabilities);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}

}
//install Xcode and command Line Tools for ios simulator execution
//https://www.youtube.com/watch?v=BULjgsTpw2c