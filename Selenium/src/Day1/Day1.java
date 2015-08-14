package Day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 2; i ++){
			driver = new FirefoxDriver(); // Launch FireFox Browser
			//under the browser,
			Thread.sleep(1000);
			driver.get("https://login.salesforce.com/"); // Get the URL
			driver.manage().window().maximize();
			
			//			Object on FF  --> driver.findElement(By.id(""))

			//get id from Selenium IDE
			// Text box user name field. perform it.
			driver.findElement(By.id("username")).sendKeys("htankkhai2014@gmail.com");
			//TextBox 
			driver.findElement(By.id("password")).sendKeys("salesforcedemo123");
			
			//driver.findElement(By.name("username")).sendKeys("");
			//driver.findElement(By.cssSelector("#username")).sendKeys();

			//Click Login
			driver.findElement(By.id("Login")).click();
			Thread.sleep(1000);
			// Close the opened browser
			driver.close();
		}

	}
}



