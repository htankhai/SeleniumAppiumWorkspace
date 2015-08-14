package SeleniumIEBrowser;

//salesforceTestcases
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	static String  reportFlag ="";
	public static BufferedWriter bw = null;
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String recData[][] = null;

		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/ConfigIE.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String testScriptName;
		String run_NoRun;
		String ReportsPath = "C:/Users/htan/Desktop/SalesforceFramework/Report/IE/";
		int iRowCount = recData.length;

		for(int i = 1; i < iRowCount; i++){
			reportFlag = "Pass";
			run_NoRun = recData[i][1];
			testScriptName = recData[i][2];
			if(run_NoRun.equalsIgnoreCase("Y")){
				String ieBrowser = recData[i][3];
				
				if(ieBrowser.equalsIgnoreCase("Y")){
					projectFunction.startReport( testScriptName,  ReportsPath);
					System.setProperty("webdriver.ie.driver", "C:/Users/htan/Desktop/Library/IEDriverServer.exe");
					//protected mode in IE is turn off
					//zoom is 100% level
					driver = new InternetExplorerDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Method testCase = TestScript.class.getMethod(testScriptName);
					testCase.invoke(testCase);
					bw.close();
					projectFunction.writeSheet(DataTablePath,"Sheet1", i, 3,  reportFlag);
				}
			
					}

		else{
			System.out.println("Test Script name " + testScriptName + " in Row no:" + i + " did not executed. ");
			reportFlag = "";
		}


		projectFunction.writeSheet(DataTablePath,"Sheet1", i, 3,  reportFlag);

	}


}

}
