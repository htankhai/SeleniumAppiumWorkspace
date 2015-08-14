package selenium.ScreenShootFeature;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumScreenShoot {
	public static void main(String[] args) throws IOException{
		WebDriver driver= new FirefoxDriver();

		//startTheTest
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		//screeenShoot
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd HH_mm_ss");
		Date date = new Date();
		String time=dateFormat.format(date);
		System.out.println("Screen shoot at C:\\Users\\htan\\Screenshoot " + time);

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = UUID.randomUUID().toString();
		FileUtils.copyFile(file, new File("C:\\Users\\htan\\Screenshoot\\" +fileName +time +".png"));

		//Capturing the SS in Webdriver
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:/Users/htan/LinkPages/Software.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		System.out.print("Screenshot is captured and stored in your Drive");




		//closeTest
		driver.close();
	}


}
