package listener_;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Customlistner extends TestListenerAdapter{
	
	
 //Override some methods 
 public void onTestFailure(ITestResult tr) 
 {WebDriver driver= new FirefoxDriver();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     // Now you can do whatever you need to do with it, for example copy somewhere
     try {
            FileUtils.copyFile(scrFile, new File("D:\\failure.png"));
     } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     }
 System.out.println("When testcase is failed generate reports ");
 
}
 public void onTestSuccess(ITestResult tr)  {
  
  System.out.println("When testcase is pass Take snapshot");
 }
 public void onTestSkipped(ITestResult tr)   {
  
  System.out.println("Testcase is skipped do some activity");
 }
 

}
