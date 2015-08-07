package javaScript.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PromptPopupHandling {
	WebDriver driver=new FirefoxDriver();

	@Test
	public void handlingPromptBox() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/htan/LinkPagesRepo/prompt.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Htan");
		alert.accept();
		System.out.println(alert.getText());
	}

}
