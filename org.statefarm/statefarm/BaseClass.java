package statefarm;
//Create configuration file include test script REfective API execution and report.
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static String  reportFlag ="";
	static BufferedWriter bw = null;

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException{
		String recData[][] = null;

		//create configuration file. create path of xls file
		String DataTablePath = "C:/Users/htan/LinkPagesRepo/Statefarm/configurationFile.xls";

			
		//read xl sheet 
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		
		//test script. run or no run
		String testScriptName;
		String run_NoRun;

		//create Report file
		String ReportsPath = "C:/Users/htan/LinkPagesRepo/Statefarm/Report/";
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

