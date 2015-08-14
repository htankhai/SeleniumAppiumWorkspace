package SeleniumProjectVersion5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class workShop {
	private WebDriver driver;
	private String baseUrl;
	@Test
	public void testSample() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://login.salesforce.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("kumarprachi25@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Automation1");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//*[@id='owner-choice']/img")).click();
		driver.findElement(By.xpath("//*[@id='walkthrough-callout-close']/img")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		
		
		
		List<WebElement> rowCount = driver.findElement(By.xpath("//*[@id='inningsBat1']/tbody")).findElements(By.tagName("tr"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		List<WebElement> rows = driver.findElement(By.xpath("//*[@id='inningsBowl1']/tbody")).findElements(By.tagName("tr"));
		
		for(int i = 0; i <rows.size(); i++ ){
			System.out.println(rows.get(i).getText());
			
			List<WebElement> colum = rows.get(i).findElements(By.tagName("td"));
			
			for(int j = 0; j < colum.size(); j++){
				System.out.println(colum.get(j).getText());
				
			}
		}
		
		
		
		List <WebElement> links = driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[1]")).findElements(By.tagName("a"));
		for(int i = 0; i < links.size(); i++){
			System.out.println(links.get(i).getText());
			
		}
		
		
		driver.findElement(By.name("new")).click();
		
		List <WebElement> img = driver.findElements(By.tagName("img"));
		for(int i = 0; i < img.size(); i++){
			System.out.println(img.get(i).getAttribute("title"));
			if(img.get(i).getAttribute("title").equals("Account Name Lookup (New Window)")){
				img.get(i).click();
			}
		}
		
		
		driver.findElement(By.cssSelector("img.lookupIconOn")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | lookup | 30000]]
	}



}
