package actions.MouseHover_SetWindowSize_UploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//With the actions object you should first move the menu title, and then move to the sub menu item and click it.
public class MouseHoverSwitchMenu_SetWindowSize_UploadFile {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void menuMouseHover(){
		driver.get("https://www.statefarm.com/");

		Actions actions = new Actions(driver);

		//Insurance Menu as main menu
		WebElement mainMenu = driver.findElement(By.cssSelector(".nav-label"));
		actions.moveToElement(mainMenu);

		//Auto sub menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id='insurance']/div[1]/ul/li[1]/a"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();


	}

	@Test
	public void setWindowSize(){
		//Set Width and height of window size
		Dimension dimension = new Dimension(420,600);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(dimension);
	}
	
	@Test
	//upload file -passing file path to the upload button control
	public void uploadFile(){
		//Find the element of upload button (name = "datafile") and send the path
		WebElement element= driver.findElement(By.name("datafile"));
		element.sendKeys("C:/Users/htan/Desktop/uploadFile.txt");
	}
}
