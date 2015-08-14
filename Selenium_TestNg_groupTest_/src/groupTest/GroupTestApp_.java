package groupTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupTestApp_ {
	private WebDriver driver;
	private String baseUrl;  

	@BeforeTest(groups = { "Group1", "Group2" })
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.justdial.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = { "Group1" }, priority=3)
	public void test1() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("what")).sendKeys("G1a");
		driver.findElement(By.id("where")).sendKeys("Chennai");
		System.out.println("I am G1a");
	}

	@Test(groups = { "Group1" }, priority=2)
	public void test2() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("what")).sendKeys("G1b");
		driver.findElement(By.id("where")).sendKeys("Chennai");
		System.out.println("I am G1b");
	}

	@Test(groups = { "Group2" })
	public void test3() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("what")).sendKeys("G2a");
		driver.findElement(By.id("where")).sendKeys("Chennai");
		System.out.println("I am G2a");
	}

	@Test(groups = { "Group1" })
	public void test4() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("what")).sendKeys("G1c");
		driver.findElement(By.id("where")).sendKeys("Chennai");
		System.out.println("I am G1c");
	}

	@Test(groups = { "Group2" })
	public void test5() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("what")).sendKeys("G2b");
		driver.findElement(By.id("where")).sendKeys("Chennai");
		System.out.println("I am G2b");
	}

	@AfterTest(groups = { "Group1", "Group2" })
	public void tearDown() throws Exception {
		driver.quit();    
	}
}
