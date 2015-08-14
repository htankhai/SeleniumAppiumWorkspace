package seleniumProjectVersion2;
//writeSheet and UpdateReport do not work.

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;



import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static String  reportFlag ="";
	static BufferedWriter bw = null;
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/Checking.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String testScriptName;
		String run_NoRun;
		String ReportsPath = "C:/Users/htan/Desktop/Feb11 Framework/Report/";
		int iRowCount = recData.length;
		for(int i = 1; i < iRowCount; i++){
			reportFlag = "Pass";
			run_NoRun = recData[i][1];
			testScriptName = recData[i][2];
			if(run_NoRun.equalsIgnoreCase("Y")){
				projectFunction.startReport( testScriptName,  ReportsPath);
				// Reflexive API
				Method testCase = TestScript.class.getMethod(testScriptName);
				testCase.invoke(testCase);
				bw.close();
			}else{
				System.out.println("Test Script name " + testScriptName + " in Row no:" + i + " did not executed. ");
				reportFlag = "";
			}
			
			
			projectFunction.writeSheet(DataTablePath,"Sheet1", i, 3,  reportFlag);
			
		}


	}

}

