package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GoogleSearch {
	WebDriver driver  = null;

	@BeforeClass
	//parameter value will retrieved from testng.xml file's <parameter> tag.
	@Parameters ({"browser"})
	public void setup(String browser){//Method will pass value of parameter.
		if (browser.equals("FFX")) {//If value Is FFX then webdriver will open Firefox Browser.
			System.out.println("Test Starts Running In Firefox Browser.");
			driver = new FirefoxDriver();   
			
		}else if (browser.equals("CRM")){//If value Is CRM then webdriver will open chrome Browser.
			System.out.println("Test Starts Running In Google chrome.");
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\htan\\Software Library\\chromedriver.exe");
			driver = new ChromeDriver();   
		}
	}

	@Test
	public void getGoogleTitle(){

		driver.navigate().to("http://google.com");
		driver.manage().window().maximize();
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);

	}

	@AfterClass 
	public void closebrowser(){
		driver.quit();  
	}

}
//<suiteXmlFile>src/main/resources/GoogleSearchTestNg.xml</suiteXmlFile>