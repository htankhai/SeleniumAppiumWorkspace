package javaScript.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopupAlertHandling {
	WebDriver driver=new FirefoxDriver();

	@Test
	public void handlingAlert() throws InterruptedException	{
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/htan/LinkPagesRepo/alerts.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='alertFunction100()']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.close();
	}
	
}
