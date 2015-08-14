package seleniumCrossBrowser;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript extends projectFunction{
	public static void loginToSFDC() throws IOException, InterruptedException{
		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	public static void LoginErrorMessage() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = "";


		/*Read TestData*/
		DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/LoginErrorMessage.xls";
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

		/*validate error message displyed*/
		validateMessageDisplayed("//*[@id='error']", expectedValue, "Error Message");
		driver.quit();

	}

	/*Check RemeberMe*/
	public static void checkRememberMe() throws IOException, InterruptedException{
		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		//driver = new FirefoxDriver(); 
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();
		/*Enter user Name*/
		String unXpath = "//*[@id='username']";
		enterText(unXpath, UN, "User Name");

		/*Enter Password*/
		String pwdXpath = "//*[@id='password']";
		enterText(pwdXpath, pwd, "Password");

		/* Check Check box */
		checkCheckBox("//input[@id='rememberUn']", " Remember Me");

		/*Click Login*/
		clickObject("//*[@id='Login']", "Login button ");


		/*Check company owner*/
		clickObject("//*[@id='owner-choice']/img", "Company owner image");


		/*Close message box*/
		clickObject("//*[@id='walkthrough-callout-close']/img", "Close message box");


		/*Log out from the application*/
		clickObject("//*[@id='userNav-arrow']", "Navigation Drop Down");
		clickObject("//*[@id='userNav-menuItems']/a[4]"," Log Out Link");

		/*Check for username in username field*/		
		validateTextBoxContent(unXpath, UN, "User Name");

		driver.quit();

	}

	/*Edit my Profile*/
	public static void editMyProfile() throws IOException, InterruptedException{
		loginToSFDC();

		/*Click on dropdown object*/
		clickObject("//*[@id='userNav-arrow']", "Dropdown ");

		/*CLick on my Profile*/
		clickObject("//*[@id='userNav-menuItems']/a[1]", "MyProfile");


		/*Click on Edit profile*/
		clickObject("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img", "Click on Edit Profile");


		/*Switch to frame*/

		//		List <WebElement>  iframe = driver.findElements(By.tagName("iframe"));
		//				
		//		driver.switchTo().frame(iframe.get(0));
		//		
		//		driver.switchTo().frame("Frame1");
		//		driver.switchTo().frame("FrameA");

		/*Enter FN*/

		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("Frame1");
		driver.switchTo().frame("FrameB");
		driver.switchTo().frame("FrameD");*/
		//Enter User Name/


		//Click Login
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("Frame1");
		//driver.switchTo().frame("FrameB");

		// Get iframe id from HTML. In iframe  of AboutTab, Primary Web page embedded another HTML page.
		driver.switchTo().frame("contactInfoContentId");
		/*click on About Tab*/
		clickObject("//*[@id='aboutTab']/a", "Clcik on About Tab");

		/*Enter Last name*/
		enterText("//*[@id='lastName']", "New Name", "Last Name");

		/*Save*/
		clickObject("//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save all button");
		//
		driver.switchTo().defaultContent();

	}

	public static void createAccount() throws IOException, InterruptedException {
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a", "AccountTab");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "new button");
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/createAccount.xls";
		recData = readSheet(DataTablePath, "Sheet1");

		String accountName = recData[1][1];
		enterText("//*[@id='acc2']", accountName , "Account Name");
		//enterText("//*[@id='acc2']", "bcd" , "Account Name");
		clickObject("//*[@id='topButtonRow']/input[1]", "Save button");
		validateMessageDisplayed("//*[@id='contactHeaderRow']/div[2]/h2", accountName, "Account name text");
		//Thread.sleep(2000);
		//driver.close();
	}

	public static void forgotPassword() throws IOException, InterruptedException {
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		//Launch the URL
		driver = new FirefoxDriver(); 
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();

		clickObject("//*[@id='forgot']/span[1]/a", "Forgot your password?" );
		enterText("//*[@id='un']", UN , "User Name");
		clickObject("//*[@id='continue']", "Continue");
	}


	public static void createAccountReport() throws IOException, InterruptedException {
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a",  "Accounts");
		clickObject("//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a", " Accounts with last activity > 30 days");

		/*clickObject("//*[@id='ext-gen152']",  "Calendar Button" );
		clickObject( "//*[@id='ext-gen244']/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/a/em/span", "Today Date" );
		clickObject( "//*[@id='ext-gen158']", " Add "); 
		clickObject( "//*[@id='ext-gen290']",  " OK " );*/	
		clickObject( "//*[@id='ext-gen49']",   "Save ");
	
		//Save Report is displayed
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/createAccountReport.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String reportName1 = recData[1][1];
		String reportName2 = recData[2][1];
		enterText("//*[@id='saveReportDlg_reportNameField']", reportName1 , "Report Name");
		enterText( "//*[@id='saveReportDlg_DeveloperName']",  reportName2,  "Report Unique Name ");
		clickObject("//*[@id='ext-gen255']", "Save " );
		clickObject("//*[@id='setupLink']", " Setup ");
		driver.close();
		}

	public static void createNewOpty() throws IOException, InterruptedException{ 
		loginToSFDC();
		clickObject("//*[@id='Opportunity_Tab']/a", " Opportunities ");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", " New ");

		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/createNewOpty.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String optyName = recData[1][1];
		String accountName = recData[1][2];
		String closeDate =  recData[1][3];
		enterText("//*[@id='opp3']", optyName , " Opportunity Name ");
		enterText("//*[@id='opp4']", accountName , " Account Name ");
		enterText("//*[@id='opp9']", closeDate , " Close Date ");
		
		clickObject( "//*[@id='opp11']", " Stage");
		/////CHECK validation
		
		clickObject("//*[@id='bottomButtonRow']/input[1]", " Save ");
		driver.close();
	}

	public static void mySettings() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject( "//*[@id='userNav-arrow']", "User Navigate Arrow ");
		clickObject("//*[@id='userNav-menuItems']/a[2]", "My Settings  ");
		clickObject("//*[@id='PersonalInfo_font']", " Personal ");
		Thread.sleep(2000);
		clickObject("//*[@id='DisplayAndLayout_font']", "Display And Layout  ");
		Thread.sleep(2000);
		clickObject("//*[@id='EmailSetup_font']", "Email ");
		Thread.sleep(2000);
		clickObject("//*[@id='PersonalCollaboration_font']", "Chatter  ");
		Thread.sleep(2000);
		clickObject("//*[@id='CalendarAndReminders_font']", " CalendarAndReminders ");
		Thread.sleep(2000);
		driver.close();
		}

	
	public static void createNewContact() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a",  " Contact Tab");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", " New ");
		
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/createNewContact.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String LastName = recData[1][1];
		String accountName = recData[1][2];
		enterText( "//*[@id='name_lastcon2']"," Tommy",  "  Last Name");
		enterText( "//*[@id='con4']", "BofA", " Account Name ");
		clickObject("//*[@id='topButtonRow']/input[1]", " Save");
		Thread.sleep(2000);
		driver.close();
		}
	
	public static void checkOnLeadsHome() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Lead_Tab']/a", " Leads");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");
		
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/checkOnLeadsHome.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String LastName = recData[1][1];
		String CompanyName = recData[1][2];
		enterText("//*[@id='name_lastlea2']", LastName , " Last Name" );
		enterText("//*[@id='lea3']", CompanyName, "CompanyName" );
		
		clickObject("//*[@id='bottomButtonRow']/input[1]", "Save");
		
		}
	
	}
