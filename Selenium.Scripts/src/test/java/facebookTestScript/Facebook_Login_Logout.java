package facebookTestScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook_Login_Logout {
	public WebDriver driver= null;
	String URL= "https://www.facebook.com/?_rdr";

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

	@Test(priority=0)
	public void loginToFB() throws IOException, InterruptedException{

		String UN = "htan.khai@yahoo.com";
		String pwd = "Thisismine13";


		//Track WebPage Load Time
		long start = System.currentTimeMillis();

		/*Launch Facebook application*/
		driver.get(URL);

		//implicit global wait for find element command 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		//Resize Browser window
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(1000,700);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);

		/*Locate user name and enter user Name text field*/
		String unXpath = "//*[@id='email']";
		driver.findElement(By.xpath(unXpath)).getSize();
		driver.findElement(By.xpath(unXpath)).sendKeys(UN);


		/*Enter Password*/
		String pwdXpath = "//*[@id='pass']";
		driver.findElement(By.xpath(pwdXpath)).sendKeys(pwd);


		/*Click Login*/
		String objXPath = "//*[@id='u_0_n']";
		driver.findElement(By.xpath(objXPath)).click();


		driver.navigate().refresh();

		Thread.sleep(300);

		long finish = System.currentTimeMillis();
		long TotalTime = finish - start;
		System.out.println("Total Time for page load - "+TotalTime); 

	}


	@Test(priority = 1)
	public void Logout() throws IOException, InterruptedException{
		//String pageLoginAnchor = "//*[@id='pageLoginAnchor']";
		//String  logout ="//*[@id='logoutButton']/input";

		//driver.findElement(By.xpath(pageLoginAnchor )).click();
		//driver.findElement(By.xpath(logout)).click();

		WebElement pageLoginAnchor = driver.findElement(By.xpath("//*[@id='pageLoginAnchor']"));
		WebElement logout = driver.findElement(By.xpath("//*[@id='logoutButton']/input"));
		
		//Create instance of action class
				Actions action = new Actions(driver);

				action.moveToElement(pageLoginAnchor).click().build();
					
				//move mouse over the menu.
				action.click(logout ).perform();
	}

	@AfterClass 
	public void closebrowser(){
		driver.quit();  
	}
}
