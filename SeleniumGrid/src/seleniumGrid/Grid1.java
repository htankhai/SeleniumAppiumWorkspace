package seleniumGrid;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid1 {
	@Test
	@Parameters({"UN","PWD","Browser"})
	public void Test(String UN, String PWD, String Browser) throws IOException{
		System.out.println("Starting the Grid testing");
		//DesiredCapabilities  cab ;

		if 	(Browser.equals("firefox")){
			DesiredCapabilities cab = DesiredCapabilities.firefox();
			//Used by the selenium server for browser selection
			cab.setBrowserName("firefox");
			cab.setPlatform(Platform.WINDOWS);
			cab.setVersion("37.0.1");
			
			//String	nodeURL= "https://192.168.194.1:5555/wd/hub";
			String	nodeURL= "https://192.168.194.1:5555/wd/hub";
			//String	nodeURL= "https://localhost:4444/wd/hub";

			WebDriver driver = new RemoteWebDriver(new URL(nodeURL), cab);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(UN);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(PWD);

			/*Click Login*/
			String objXPath = "//*[@id='Login']";
			driver.findElement(By.xpath(objXPath)).click();
		}

		/*else if (Browser.equals("chrome")){

			DesiredCapabilities cab = DesiredCapabilities.chrome();
			cab.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			cab.setPlatform(Platform.ANY);

			RemoteWebDriver driver = new RemoteWebDriver(cab);
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(UN);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(PWD);

			//Click Login
			String objXPath = "//*[@id='Login']";
			driver.findElement(By.xpath(objXPath)).click();
		}
		else{
			DesiredCapabilities cab = DesiredCapabilities.internetExplorer();
			cab.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			cab.setPlatform(Platform.ANY);

			RemoteWebDriver driver = new RemoteWebDriver(cab);//
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(UN);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(PWD);

			Click Login
			String objXPath = "//*[@id='Login']";
			driver.findElement(By.xpath(objXPath)).click();
		}*/
	}
}
//DesiredCapabilities are used to customize and configure 
//a browser session optionally.
//Basically, the DesiredCapabilities help to set properties for the WebDriver. 
//A typical usecase would be to set the path for the FirefoxDriver if your local 
//installation doesn't correspond to the default settings.

//http://stackoverflow.com/questions/12836114/selenium-webdriver-remote-setup
