package dataProvider_google;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderClass {
	private WebDriver driver;

	@DataProvider(name="keywords")
	public Object[][] data() throws Exception {
		HashMap<String,String[]> dataSet= new Text_TestData(System.getProperty("user.dir")+"\\config.txt").getData();

		String search1Strings[]=dataSet.get("search1");
		String search2Strings[]=dataSet.get("search2");
		int size =search1Strings.length;

		// modify 2 upon the no. of rows; Here, I used two rows, 'search1' & 'search2'
		Object[][] creds = new Object[size][2];  
		for(int i=0;i<size;i++)
		{
			creds[i][0]=search1Strings[i];
			creds[i][1]=search2Strings[i];
		}
		return creds;
	}


	@BeforeTest
	public void setUp() throws Exception {
		driver = new ChromeDriver();

	}

	@Test(dataProvider = "keywords", description = "Google_Test")
	public void search(String search1, String search2) throws Exception {

		driver.get("http://www.google.co.in");

		// search google via keyword 1
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("" + search1);
		driver.findElement(By.name("q")).submit();
		Thread.sleep(4000);

		// search google via keyword 1
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("" + search2);
		driver.findElement(By.name("q")).submit();
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
