package Day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Salesforce {
	public static void main(String[] args) 
	{
		WebDriver driver;
		driver = new FirefoxDriver();

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		//driver.findElement(By.xpath("//*[@id='username']")).clear();
		//driver.findElement(By.xpath("//*[@id='username']")).sendKeys("htankhai@gmail.com");

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("htankhai@gmail.com");


		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("testing123");

		driver.findElement(By.xpath("//*[@id='Login']")).click();

		//log out
		driver.findElement(By.xpath("//*[@id='userNavButton']")).click();
		driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[4]")).click();

		driver.close();

	}
}