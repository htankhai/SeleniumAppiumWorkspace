package seleniumGrid;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid 
{
	@Test
	@Parameters({"UN","PWD","Browser"})
	public void Test(String UN, String PWD, String Browser) throws IOException{
		System.out.println("Starting the Grid testing");
		DesiredCapabilities  cab =null;
		if (Browser.equals("firefox")){
			cab = DesiredCapabilities.firefox();
			//Used by the selenium server for browser selection
			cab.setBrowserName("firefox");
			cab.setPlatform(Platform.ANY);
		}
		else if (Browser.equals("chrome")){
			cab = DesiredCapabilities.chrome();
			cab.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			cab.setPlatform(Platform.ANY);
		}else{
			cab = DesiredCapabilities.internetExplorer();
			cab.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			cab.setPlatform(Platform.ANY);
		}


		RemoteWebDriver driver = new RemoteWebDriver(cab);//
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(UN);

		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(PWD);

		/*Click Login*/
		String objXPath = "//*[@id='Login']";
		driver.findElement(By.xpath(objXPath)).click();
	}
}

/*DesiredCapabilites is used to set the type of browser and OS that we will automate
RemoteWebDriver is used to set which node (or machine) that our test will run against.*/

//DesiredCapabilities are used to customize and configure 
//a browser session optionally.
//Basically, the DesiredCapabilities help to set properties for the WebDriver. 
//A typical usecase would be to set the path for the FirefoxDriver if your local 
//installation doesn't correspond to the default settings.
