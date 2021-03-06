package firefoxProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfileStartUpPage {
	WebDriver driver;

	@Test
	public void myProfile(){
		//my profile
		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("SoftwareDevelopment");

		WebDriver driver = new FirefoxDriver(myprofile);
		driver.get("http://google.com");

		//enter 100 into text box field
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("googlemail");

		WebElement element2 = driver.findElement(By.name("btnG"));
		element2.click();

	}

	//@Test
	public void defaultProfile(){
		//setting up default profile's start up home page
		FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.startup.homepage",
						"http://www.google.com");
		driver = new FirefoxDriver(profile);

		//enter 100 into text box field
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("googlemail");

		WebElement element2 = driver.findElement(By.name("btnG"));
		element2.click();

	}
}