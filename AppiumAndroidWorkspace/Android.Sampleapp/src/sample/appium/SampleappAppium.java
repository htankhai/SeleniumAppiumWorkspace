package sample.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SampleappAppium {
	WebDriver ADriver;

	@Test
	public void SampleappinAppium() throws MalformedURLException{
		File srcDir = new File("src");
		File app = new File (srcDir,"sample.apk" );

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "Android");
		cap.setCapability(CapabilityType.PLATFORM, "Android");
		cap.setCapability("DEVICE_NAME", "Emulator1000");
		cap.setCapability( "VERSION" , "4.4.2");
		cap.setCapability("app", app.getAbsolutePath());


		//Parameters as Appium Server and cap 
		ADriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap ); 
	}

}
