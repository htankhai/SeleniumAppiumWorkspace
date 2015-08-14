package SeleniumChromeBrowser;

//salesforceTestcases
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import seleniumCrossBrowser.TestScript;
//import seleniumCrossBrowser.projectFunction;

public class BaseClass extends projectFunction{

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/Configure.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String testScriptName;
		String run_NoRun;
		String ReportsPath = "C:/Users/htan/Desktop/SalesforceFramework/Report/Chrome/";
		int iRowCount = recData.length;

		for(int i = 1; i < iRowCount; i++){
			reportFlag = "Pass";
			run_NoRun = recData[i][1];
			testScriptName = recData[i][2];
			if(run_NoRun.equalsIgnoreCase("Y")){
				String chromeBrowser = recData[i][4];

				//verify browser
				if(chromeBrowser.equalsIgnoreCase("Y")){
					projectFunction.startReport( testScriptName,  ReportsPath);
					
					//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver", "C:/Users/htan/Desktop/Library/chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Method testCase = TestScript.class.getMethod(testScriptName);
					testCase.invoke(testCase);
					bw.close();
					projectFunction.writeSheet(DataTablePath,"Sheet1", i, 4,  reportFlag);
					driver.close();
				}

			}

			else{
				System.out.println("Test Script name " + testScriptName + " in Row no:" + i + " did not executed. ");
				reportFlag = "";
			}


			projectFunction.writeSheet(DataTablePath,"Sheet1", i, 4,  reportFlag);

		}


	}

}
