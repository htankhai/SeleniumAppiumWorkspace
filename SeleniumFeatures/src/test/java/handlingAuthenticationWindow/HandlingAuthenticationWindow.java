package handlingAuthenticationWindow;
//"http://" + login + ":" + password + "@" + url
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAuthenticationWindow {

	@Test
	public void auth_Firefox() {
		FirefoxProfile profile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.get("http://adminLogin:adminPassword@yoururl.com");
		//To check if we have landed in the correct place
		String text = driver.findElement(By.className("home")).getText();
		Assert.assertTrue(text.contains("Welcome"), "Basic Authentication failed");

	}

	public void auth_Chrome() {
		System.setProperty("webdriver.chrome.driver", "G:/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://adminLogin:adminPassword@yoururl.com");
		//To check if we have landed in the correct place
		String text = driver.findElement(By.className("home")).getText();
		Assert.assertTrue(text.contains("Welcome"), "Basic Authentication failed");

	}
}
