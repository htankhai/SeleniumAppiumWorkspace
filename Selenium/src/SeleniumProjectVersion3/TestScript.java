package SeleniumProjectVersion3;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
		driver = new FirefoxDriver(); 
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

		/*String a[]=new String[5];
        int i=0;
        for(String winHandle:driver.getWindowHandles()){
            a[i]=winHandle.toString();
            i++;
        }
        driver.switchTo().window(a[1]);
        clickObject("//*[@id='tab-1179-btnEl']","close message box");
        driver.close();
        driver.switchTo().window(a[0]);*/
		
		//popup
		//Alert z = driver.switchTo().alert();
		//z.accept();//click on ok 
		//z.dismiss();//click on cancel
		//z.sendKeys("Hmmmm");//enter some value in pop...
		
		//String winHandle = driver.getWindowHandle();
		//Set<String> winHan1 = driver.getWindowHandles();


		//Set<String> l1 = driver.getWindowHandles();
		//Object[] a = null;
		//a = l1.toArray();
		

	}

	
	public static void LoginErrorMessage() throws IOException, InterruptedException{
		/*Validate error message*/
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

	
	public static void checkRememberMe() throws IOException, InterruptedException{
		/*Check RemeberMe*/
		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		driver = new FirefoxDriver(); 
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

	
	public static void editMyProfile() throws IOException, InterruptedException{
		/*Edit my Profile*/
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
		clickObject("//*[@id='aboutTab']/a", "CliCk on About Tab");

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
	}

	
	public static void createAccountReport() throws IOException, InterruptedException {
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a",  "Accounts");
		clickObject("//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a", " Accounts with last activity > 30 days");

		clickObject("//*[@id='ext-gen152']",  "Calendar Button" );
		clickObject( "//*[@id='ext-gen244']/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/a/em/span", "Today Date" );
		clickObject( "//*[@id='ext-gen158']", " Add "); 

		clickObject( "//*[@id='ext-gen290']",  " OK " );		
		clickObject( "//*[@id='ext-gen49']",   "Save ");
		//*[@id='ext-gen63']

		//Save Report is displayed
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/createAccountReport.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String reportName1 = recData[1][1];
		String reportName2 = recData[2][1];
		enterText("//*[@id='saveReportDlg_reportNameField']", reportName1 , "Report Name");
		enterText( "//*[@id='saveReportDlg_DeveloperName']",  "reportName2",  "Report Unique Name ");
		//SAVE THE UNSAVED REPORT.
		clickObject("//*[@id='ext-gen302']", "Save and Run" );

		clickObject("//*[@id='setupLink']", " Setup ");

		//clickObject("//*[@id='ext-gen81']", "Run Report");

		//clickObject("//*[@id='buttonUpdate']", "Update Now");

		//clickObject("//*[@id='ext-gen176']", "Close ");
		//clickObject("//*[@id='ext-gen311']", "Close");

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
	
	
	public static void checkMyContactsPage() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText("My Contacts");
		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");
	}
		
	
	public static void checkRecentlyViewContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText("Recently Viewed Contacts");
		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");

	}
	
	
	public static void checkRecentlyCreatedContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='hotlist_mode']")));
		dropDownList.selectByVisibleText("Recently Created");
		//	clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");

	}

	
	public static void viewContactinContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a", "Contact Name");

	}
	
	
	public static void createNewViewContact() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='filter_element']/div/span/span[2]/a", "Create New View");
		enterText("//*[@id='fname']", "Scenerio", "View Name");
		enterText("//*[@id='devname']", "DaynamicView", "View Unique Name");
		clickObject("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");
		Thread.sleep(3000);
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

		//validate 

		clickObject("//*[@id='bottomButtonRow']/input[1]", " Save ");
	}

	
	public static void mySettings() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject( "//*[@id='userNav-arrow']", "User Navigate Arrow ");
		clickObject("//*[@id='userNav-menuItems']/a[2]", "My Settings  ");
		
		clickObject("//*[@id='PersonalInfo_font']", " Personal ");
		clickObject("//*[@id='LoginHistory_font']", "Login History");
		//clickObject("//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Download Login history ");
		//clickObject("//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Open with ");
		//clickObject("//*[@id='bodyCell']", "OK");

		
		clickObject("//*[@id='DisplayAndLayout_font']", "Display And Layout  ");
		clickObject("//*[@id='CustomizeTabs_font']", "Customize My Tabs");
		selectDropdownListByVisibleText("//*[@id='p4']" , "Salesforce Chatter", "Salesforce Chatter" );
		selectDropdownListByVisibleText("//*[@id='duel_select_0']", "Reports", "Reports");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
				
		clickObject("//*[@id='EmailSetup_font']", "Email ");
		clickObject("//*[@id='EmailSettings_font']", " My Email Settings");
		
		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Feb11 Framework/DataFolder/mySettings.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String emailName = recData[1][1];
		String emailAddress = recData[1][2];
		enterText("//*[@id='sender_name']", emailName, "Email Name");
		enterText("//*[@id='sender_email']", emailAddress, "Email Address");
		SelectRadioButton("//*[@id='auto_bcc1']", "Yes");
		clickObject( "//*[@class='primary btn']", "Save");
		//clickObject("//*[@class='primary btn']", "OK");
		
		Alert z = driver.switchTo().alert();
		z.accept();//click on ok 
		//z.dismiss();//click on cancel
		
		//Thread.sleep(2000);
		clickObject("//*[@id='PersonalCollaboration_font']", "Chatter  ");
		Thread.sleep(2000);
		clickObject("//*[@id='CalendarAndReminders_font']", " CalendarAndReminders ");
		Thread.sleep(2000);
		driver.close();
	}
	
	
	public static void customizeTabs() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='AllTab_Tab']/a", "Tab ");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/table/tbody/tr/td[2]/input", "Customize My Tabs");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='duel_select_0']")));
		dropDownList.selectByVisibleText("Groups");

		//selectDropdownListByVisibleText("//*[@id='duel_select_0']/option[5]", "Product2",  "Products");
		//clickObject("//*[@id='duel_select_0_right']/img", "Add");
		//selectDropdownListByVisibleText("//*[@id='duel_select_0']/option[5]", "UserProfile",  "Profile");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
		clickObject("//*[@id='bottomButtonRow']/input[1]", " Save");
	}

	
	public static void logout() throws IOException, InterruptedException {
		loginToSFDC();
		/*Log out from the application*/
		clickObject("//*[@id='userNav-arrow']", "Navigation Drop Down");
		clickObject("//*[@id='userNav-menuItems']/a[4]"," Log Out Link");
		Update_Report("Pass", "Logout application "," Application has been logouted.");
		driver.quit();

	}
			
	
	public static void createdNewViewAccount() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a", "Accounts");
		clickObject("//*[@id='filter_element']/div/span/span[2]/a[2]", "Create New View");
		enterText("//*[@id='fname']", "New Account1", "View Name");
		enterText("//*[@id='devname']", "NewDailyAccount", "View Unique Name");
		clickObject("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");
		Thread.sleep(3000);
		driver.close();
		
	}
	
	
	public static void developersConsole() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='userNav-arrow']", "Navigate");
		clickObject("//*[@id='userNav-menuItems']/a[3]", "Developer Console");
		//Thread.sleep(2000);
			
		// Get windowHandler
		String a[]=new String[5];
        int i=0;
        for(String winHandle:driver.getWindowHandles()){
            a[i]=winHandle.toString();
            i++;
        }
        driver.switchTo().window(a[1]);
        //driver.getTitle();//get window title
        //Get button id from view state
       // clickObject("//*[@id='tab-1179-btnEl']","close message box");
        
        // Get button id from progress
       // clickObject("//*[@id='tab-1180-btnEl']","close message box");
       
        //Get button class from progress
        clickObject("//*[@class='x-tab-center']","close message box");
        
        driver.close();
        driver.switchTo().window(a[0]);
        
		clickObject("//*[@id='userNav-arrow']", "Navigate");
		clickObject("//*[@id='userNav-menuItems']/a[4]", "Logout");
		//driver.switchTo().window("Developer Console");
		driver.close();
		
	}
	
}
