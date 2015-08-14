package facebook_TestScript;
//Capture and Navigate all the Links
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class FacebookLinks {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new FirefoxDriver();
	
		String linkValue;
		driver.get("http://www.facebook.com");
		//driver.get("http://www.jcpenney.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//all links
		//Getting all the webelement with tagname "a" and store it in list i.e)List<Webelement>
		//loop to get the attribute value with name href i.e)getAttribute("href")
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (int i=0;i<allLinks.size();i++){
			linkValue= allLinks.get(i).getText();
			System.out.print(linkValue+" -->");
			System.out.println(allLinks.get(i).getAttribute("href"));
		}

		//Alternate
		driver.get("http://www.facebook.com");
		List<WebElement> no = driver.findElements(By.tagName("a"));
		System.out.println(no.size());
		for (WebElement pagelink : no) 	{
			System.out.print(pagelink.getText()+" ->");
			System.out.println(pagelink.getAttribute("href"));
		}





		driver.quit();

	}

}

/*
		List<WebElement> inputboxes = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println(inputboxes.size());*/

/*for (int j=1;j<inputboxes.size();j++){
			inputboxes.get(j).sendKeys("A");
		}*/