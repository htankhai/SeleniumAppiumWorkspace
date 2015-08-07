package dragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropElements {
	WebDriver driver;

	@Test
	public void testDragAndDropExample() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://jqueryui.com/droppable/");
		//Wait for the frame to be available and switch to it
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));

		dragAndDrop(Sourcelocator,Destinationlocator);
		String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
		Assert.assertEquals(actualText, "Dropped!");
	}



	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		(new Actions(driver)).dragAndDrop(sourceElement, destinationElement).perform();
	}
}