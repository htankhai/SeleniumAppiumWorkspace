package select;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectProduct {
	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args){
		driver.get("https://www.statefarm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		selectOptionByText(driver.findElement(By.id("sType")), "Homeowners");
		System.out.println("succeed.");
		tearDown(); 
	}



	public void selectProduct(){
		WebElement element=driver.findElement(By.name("ProductName"));
		Select se=new Select(element);
		se.selectByValue("HomeOwners");
	}


	public static void selectOptionByText(WebElement element, String textOptionToSelect) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(textOptionToSelect);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}
	}


	public static void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
