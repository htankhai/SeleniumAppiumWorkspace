package Day3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day3 {

	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 0;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	public static void main(String[] args) throws InterruptedException, IOException {
		startReport("MyExe","C:/Users/htan/Desktop/");
		driver = new FirefoxDriver(); // Launch Fire fox Browser
		Thread.sleep(1000);
		driver.get("https://login.salesforce.com/"); // Get the URL
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		String un = "htankkhai2014@gmail.com";
		String unXpath = "//*[@id='username']";
		// Enter text into username field
		enterText( unXpath,  un,  "UserName");

		//Get attribute value of enteredValue from XPath of FirePath
		String enteredValue = driver.findElement(By.xpath(unXpath)).getAttribute("value");
		System.out.println("Attribute 'value' content  is : " + enteredValue);
		validateTextBoxContent(unXpath, un, "UserName");

		enteredValue = driver.findElement(By.xpath(unXpath)).getAttribute("value");
		System.out.println("Attribute 'value' content  is : " + enteredValue);
		validateTextBoxContent(unXpath, "salesforcedemo@gmail.com", "UserName");

		String pw = "salesforcedemo123";
		String pwdXpath = "//*[@id='password']";

		// Enter password
		enterText(pwdXpath, pw, "Password");

		//Get attribute value of enteredValue from XPath of FirePath
		String enteredPasswordValue = driver.findElement(By.xpath(pwdXpath)).getAttribute("placeholder");
		System.out.println("Attribute 'value' content  is : " + enteredPasswordValue);
		validateTextBoxContent(pwdXpath, pw, "Password");

		enteredPasswordValue = driver.findElement(By.xpath(pwdXpath)).getAttribute("placeholder");
		System.out.println("Attribute 'value' content  is : " + enteredPasswordValue);
		validateTextBoxContent(pwdXpath, "salesforcedemo", "Password");

		//Click Login
		/*driver.findElement(By.id("Login")).click();*/
		String loginXpath = "//*[@id='Login']" ;
		clickObject(loginXpath , "Login");
		Thread.sleep(2000);
		// Close the browser
		driver.close();

		bw.close();
	}

	/* Name of the method: enterText
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, enterValue --> value to be entered, objectName --> Name of the textbox
	 * Created by: BSS systems
	 * Creation Date: Feb 25 2014
	 * Last modified: Feb 25 2014
	 * */
	public static void enterText(String objXpath, String enterValue, String objectName) throws IOException{

		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			driver.findElement(By.xpath(objXpath)).clear();
			driver.findElement(By.xpath(objXpath)).sendKeys(enterValue);
			Update_Report( "Pass", "enterText", objectName + " "+ enterValue + " is entered in " + objectName + " field");
		}else{
			Update_Report( "Fail", "enterText", objectName +  " field does not exist in the application");
		}
	}

	/* Name of the method: validateTextBoxContent
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, expectedValue --> value to be validated, objectName --> Name of the textbox
	 * Created by: BSS systems
	 * Creation Date: Feb 26 2014
	 * Last modified: Feb 26 2014
	 * */

	public static void validateTextBoxContent(String objXpath, String expectedValue, String objectName) throws IOException{
		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			String actualValue;
			actualValue = driver.findElement(By.xpath(objXpath)).getAttribute("value").trim();

			if(actualValue.equals(expectedValue)){
				Update_Report( "Pass", "validateTextBoxContent", "Actual and expected value in the test box " + objectName + 
						" are same. Actual value is '"+ actualValue + "'.");


			}else{
				Update_Report( "Fail", "validateTextBoxContent",  "Actual value "+ actualValue+ " did not match with expected value "
						+ expectedValue+ ",  in the text box "+ objectName);

			}

		}else{
			Update_Report( "Fail", "validateTextBoxContent",  objectName +  " field does not exist in the application");

		}
	}
	/* Name of the method: clickButton
	 * Method Description: Click the button
	 * Arguments: objXpath --> Xpath of object, objectName --> Name of the Button
	 * Created by: Praveena
	 * Creation Date: Feb 25 2014
	 * Last modified: Feb 25 2014
	 * */

	public static void clickObject(String objXPath, String objName) throws InterruptedException, IOException 
	{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())
		{
			driver.findElement(By.xpath(objXPath)).click();
			Thread.sleep(1000);
			Update_Report( "Pass", "clickObject", objName+" is clicked");

		}
		else
		{
			Update_Report( "Fail", "clickObject", objName+"  does not exist, please check the application");

		}
	}

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName + "/" + "FireFox/"; 
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";
		File f = new File(strResultPath);
		f.mkdirs();

		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD>"
				+ "<TD COLSPAN=6 BGCOLOR=#66699><FONTFACE=VERDANA COLOR=WHITE SIZE=2><B>"+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#FFCC99 WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detailed Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ result + "</FONT></TD></TR>");

		} 
	}


}
