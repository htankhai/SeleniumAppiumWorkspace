package chromeInternetExplorerBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeBrowser {

	@Test(priority = 0)
	public void executeChromeBrowsers() {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/htan/Software Library/chromedriver.exe");
         WebDriver driver=new ChromeDriver(); 
         driver.get("https://www.google.com");

	}
	
	@Test(priority = 1)
	public void executeInternetExplorerBrowsers() {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/htan/Software Library/IEDriverServer.exe");
        WebDriver driver=new ChromeDriver(); 
        driver.get("https://www.google.com");

	}


}
