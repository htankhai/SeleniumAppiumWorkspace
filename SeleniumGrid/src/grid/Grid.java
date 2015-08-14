package grid;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {
	RemoteWebDriver driver; 
	String Node = "http://192.168.194.1:4444/wd/hub";
	String Url= "https://www.facebook.com/?_rdr";

	//@Test
	@BeforeClass
	@Parameters({"UN","PWD","Browser"})
	public void Testing(String UN, String PWD, String Browser) throws IOException{

		System.out.println("Starting the Grid testing");
		DesiredCapabilities  capabilities;
		if (Browser.equals("firefox")){
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);

		}else if (Browser.equals("chrome")){
			capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			capabilities.setPlatform(Platform.ANY);

		}else{
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			capabilities.setPlatform(Platform.ANY);

		}

		driver = new RemoteWebDriver(new URL(Node),capabilities);
		driver.get(Url);
		//driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(UN);

	}

	@Test(priority = 0)
	@Parameters({"UN","PWD"})
	public void loginToFB(String UN, String pwd) throws IOException, InterruptedException{

		//	String UN = "htan.khai@yahoo.com";
		//String pwd = "Thisismine13";


		//Track WebPage Load Time
		long start = System.currentTimeMillis();

		/*Launch Facebook application*/
		//	driver.get(URL);

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

	@Test(priority = 1, enabled = false)
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
