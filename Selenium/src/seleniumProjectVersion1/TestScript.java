package seleniumProjectVersion1;
// package Selenium Day4

import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;


public class TestScript extends projectFunction{


	public static void loginToSFDC() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SeleniumFramework/TestData/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		driver = new FirefoxDriver(); 
		driver.get(URL);
		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();
		/*Enter user Name*/
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		/*Enter Password*/
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		/*Click Login*/
		clickObject("//*[@id='Login']", "Login button ");

		Thread.sleep(3000);
		/*Check company owner*/
		clickObject("//*[@id='owner-choice']/img", "Company owner image");


		Thread.sleep(3000);
		/*Close message box*/
		clickObject("//*[@id='walkthrough-callout-close']/img", "Close message box");

	}

	/*Validate error message*/
	public static void ValidateErrorMessage() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SeleniumFramework/TestData/GlobalDatasheetofValidateErrorMessage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String URL = recData[1][1];
		String UN  = recData[1][2];
		String pwd = recData[1][3] ;


		/*Read TestData*/
		DataTablePath = "C:/Users/htan/Desktop/SeleniumFramework/TestData/ValidateErrorMessage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String expectedValue = recData[1][1];
		/*Launch SFDC application*/
		driver = new FirefoxDriver(); 
		driver.get(URL);
		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();
		/*Enter user Name*/
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		/*Enter Password*/
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		/*Click Login*/
		clickObject("//*[@id='Login']", "Login button ");

		/*validate error message displayed*/
		validateMessageDisplayed("//*[@id='error']", expectedValue, "Error Message");
		driver.quit();//close browsers

	}

	/*Validate error message*/
	public static void LoginErrorMessage() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String recData[][] = null;

		String DataTablePath = "C:/Users/htan/Desktop/SeleniumFramework/TestData/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = "";


		/*Read TestData*/
		DataTablePath = "C:/Users/htan/Desktop/SeleniumFramework/TestData/LoginErrorMessage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String expectedValue = recData[1][1];

		/*Launch SFDC application*/
		driver = new FirefoxDriver(); 
		driver.get(URL);
		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();
		/*Enter user Name*/
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		/*Enter Password*/
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		/*Click Login*/
		clickObject("//*[@id='Login']", "Login button ");

		/*validate error message displayed*/
		validateMessageDisplayed("//*[@id='error']", expectedValue, "Error Message");
		driver.quit();

	}

}
