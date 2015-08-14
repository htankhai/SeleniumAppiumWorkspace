package seleniumProjectVersion2;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;


public class TestScript extends projectFunction{

	/*public static void createAccount() throws IOException{
		Update_Report("Pass", "createAccount", "Create Account test script is executing...");		
		reportFlag = "Pass";
	}

	public static void createOpty() throws IOException{
		Update_Report("Pass", "createOpty", "Create opty test script is executing...");		
		reportFlag = "Pass";

	}

	public static void createContact() throws IOException{
		Update_Report("Pass", "createContact", "Create contact test script is executing...");	
		reportFlag = "Pass";
	}


	public static void validateLoginErrorMessage() throws IOException{
		Update_Report("Pass", "validateLoginErrorMessage", "Validate login error message  test script is executing...");
		reportFlag = "Fail";
	}*/


	public static void loginToSFDC() throws IOException, InterruptedException{

		//Read data Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		//Launch SFDC application
		driver = new FirefoxDriver(); 
		driver.get(URL);
		//dynamic wait evey object for maximum 30 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();
		//Enter user Name
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		//Enter Password
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		//Click Login
		clickObject("//*[@id='Login']", "Login button ");

		//static wait after login 
		Thread.sleep(3000);
		//Check company owner
		clickObject("//*[@id='owner-choice']/img", "Company owner image");

		Thread.sleep(3000);
		//Close message box		  

	}

	
	//Check RemeberMe
	public static void checkRememberMe() throws IOException, InterruptedException{
		//Read data Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		//Launch SFDC application
		driver = new FirefoxDriver(); 
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		//Thread.sleep(1000);
		driver.manage().window().maximize();

		//Enter user Name
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		//Enter Password
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		//Check Check box
		checkCheckBox("//input[@id='rememberUn']", " Remember Me");

		//Click Login
		clickObject("//*[@id='Login']", "Login button ");

		//Check company owner
		clickObject("//*[@id='owner-choice']/img", "Company owner image");

		//Close message box
		clickObject("//*[@id='walkthrough-callout-close']/img", "Close message box");

		//Log out from the application
		clickObject("//*[@id='userNav-arrow']", "Navigation Drop Down");
		clickObject("//*[@id='userNav-menuItems']/a[4]"," Log Out Link");

		//Check for username in username field		
		validateTextBoxContent(unXpath, UN, "User Name");
		driver.quit();

	}

	//Validate error message
		public static void loginErrorMessage() throws IOException, InterruptedException{

			//Read data Parameter
			String recData[][] = null;
			String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
			recData = projectFunction.readSheet(DataTablePath, "Sheet1");

			String URL = recData[1][1];
			String UN = recData[1][2];
			String pwd = "";


			//Read TestData
			DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/LoginErrorMessage.xls";
			recData = projectFunction.readSheet(DataTablePath, "Sheet1");
			String expectedValue = recData[1][1];
			//Launch SFDC application
			driver = new FirefoxDriver(); 
			driver.get(URL);
			Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
			driver.manage().window().maximize();
			//Enter user Name
			String unXpath = "//*[@id='username']";
			enterText(unXpath, UN, "User Name");

			//Enter Password
			String pwdXpath = "//*[@id='password']";
			enterText(pwdXpath, pwd, "Password");

			//Click Login
			clickObject("//*[@id='Login']", "Login button ");

			//validate error message displyed
			validateMessageDisplayed("//*[@id='error']", expectedValue, "Error Message");
			driver.quit();

		}

	
}
