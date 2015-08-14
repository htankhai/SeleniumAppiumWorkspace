package SeleniumProjectVersion5;




import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static String  reportFlag ="";
	static BufferedWriter bw = null;
	static WebDriver driver;

	@Before
	public void beforeMethod(){
		System.out.println("Environment Set up activity..");
		
	}
	
	@Test
	public  void runMe() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String recData[][] = null;

		String DataTablePath = "C:/Users/Selenium/Desktop/Feb11 Framework/ConfigurationFile.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String testScriptName;
		String run_NoRun;
		String ReportsPath = "C:/Users/Selenium/Desktop/Feb11 Framework/";
		int iRowCount = recData.length;

		for(int i = 1; i < iRowCount; i++){
			reportFlag = "Pass";
			run_NoRun = recData[i][1];
			testScriptName = recData[i][2];
			if(run_NoRun.equalsIgnoreCase("Y")){

				String fireFoxBrowser = recData[i][3];

				String chromeBrowser = recData[i][4];

				try{
					if(fireFoxBrowser.equalsIgnoreCase("Y")){
						projectFunction.startReport( testScriptName,  ReportsPath);
						driver = new FirefoxDriver();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Method testCase = TestScript.class.getMethod(testScriptName);
						testCase.invoke(testCase);
						bw.close();
						projectFunction.writeSheet(DataTablePath,"Sheet1", i, 3,  reportFlag);
					}

					if(chromeBrowser.equalsIgnoreCase("Y")){
						projectFunction.startReport( testScriptName,  ReportsPath);
						System.setProperty("webdriver.chrome.driver", "C:/Users/Selenium/Google Drive/Training/Lib/chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Method testCase = TestScript.class.getMethod(testScriptName);
						testCase.invoke(testCase);
						bw.close();
						projectFunction.writeSheet(DataTablePath,"Sheet1", i, 4,  reportFlag);
					}	
				} catch (Throwable t){
					System.out.println("Script execution stopped " + t);
				}





			}else{
				System.out.println("Test Script name " + testScriptName + " in Row no:" + i + " did not executed ");
				reportFlag = "";
			}




		}


	}

}
