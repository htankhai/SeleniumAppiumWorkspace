package SeleniumIEBrowser;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

//import salesforce.projectFunction;

public class TestScript extends projectFunction{


	public static void loginToSFDC() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		driver = new InternetExplorerDriver(); 
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


		/*Close message box*/
		clickObject("//*[@id='walkthrough-callout-close']/img", "Close message box");

		/*// Get windowHandler
				String a[]=new String[5];
				int i=0;
				for(String winHandle:driver.getWindowHandles()){
					a[i]=winHandle.toString();
					i++;
				}
				driver.switchTo().window(a[1]);
				//clickObject("//*[@class='x-tab-center']","close message box");

				driver.close();
				driver.switchTo().window(a[0]);*/

		//driver.quit();
		//driver.close();
	}


	public static void loginErrorMessage() throws IOException, InterruptedException{
		/*Validate error message*/
		/*Read data Parameter*/
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = "";


		/*Read TestData*/
		DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/LoginErrorMessage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String expectedValue = recData[1][1];
		/*Launch SFDC application*/
		driver = new InternetExplorerDriver(); 
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
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/GlobalDatasheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];

		/*Launch SFDC application*/
		driver = new InternetExplorerDriver(); 
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

		//driver.quit();
		driver.close();
	}


	public static void forgotPassword() throws IOException, InterruptedException {
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/forgotPassword.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		//Launch the URL
		driver = new InternetExplorerDriver(); 
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Update_Report("Pass", "Launch application "," Application has been launched wth URL " + URL);
		driver.manage().window().maximize();

		clickObject("//*[@id='forgot']/span[1]/a", "Forgot your password?" );
		enterText("//*[@id='un']", UN , "User Name");
		clickObject("//*[@id='continue']", "Continue");
		driver.close();
	}


	public static void editMyProfile() throws IOException, InterruptedException{
		/*Edit my Profile*/
		loginToSFDC();

		/*Click on dropdown object*/
		clickObject("//*[@id='userNav-arrow']", "Dropdown");

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
		//iframe id="contactInfoContentId"
		driver.switchTo().frame("contactInfoContentId");
		/*click on About Tab*/
		clickObject("//*[@id='aboutTab']/a", "Click on About Tab");

		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/editMyProfile.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String newLastName = recData[1][1];


		/*Enter Last name*/
		enterText("//*[@id='lastName']", newLastName , "Last Name");

		/*Save*/
		clickObject("//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save all button");
		//switch to parent default content
		driver.switchTo().defaultContent();
		driver.close();
	}


	public static void createAccount() throws IOException, InterruptedException {
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a", "AccountTab");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "new button");
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/createAccount.xls";
		recData = readSheet(DataTablePath, "Sheet1");
		String accountName1 = recData[1][1];
		String accountName2 = recData[1][2];

		//enterText("//*[@id='acc2']", accountName1 , "Account Name");
		enterText("//*[@id='acc2']", accountName2 , "Account Name");
		clickObject("//*[@id='topButtonRow']/input[1]", "Save button");
		validateMessageDisplayed("//*[@id='contactHeaderRow']/div[2]/h2", accountName2, "Account name text");
		//driver.close();
	}


	public static void createAccountReport() throws IOException, InterruptedException {
		//detail
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a",  "Accounts");
		clickObject("//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a", " Accounts with last activity > 30 days");


		//Show Label
		clickObject("//*[@id='ext-gen145']", "Show");
		//clickObject("//*[@class='x-combo-list-inner']/div[1]", "My accounts");
		//clickObject("//*[@class='x-combo-list-inner']/div[2]", "All team accounts");
		clickObject("//*[@class='x-combo-list-inner']/div[3]", "All accounts");

		//Date Field Label
		clickObject( "//*[@id='ext-gen148']", "date field arrow");
		clickObject( "//*[@class='x-combo-list-inner']/div[2]", "date field");//last activity


		//Range Label
		clickObject("//*[@id='ext-gen150']", "Range Field");
		clickObject("//*[@class='x-combo-list-inner']/div[2]", "Custom");

		//Save Report is displayed
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/createAccountReport.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String date1 = recData[1][1];
		String date2 = recData[2][1];

		//From calendar
		clickObject("//*[@id='ext-gen152']",  "Calendar Button" );
		enterText( "//*[@id='ext-comp-1042']", date1, "date");

		//To calendar
		clickObject("//*[@id='ext-gen154']",  "Calendar Button" );
		enterText( "//*[@id='ext-comp-1045']", date2, "date");

		clickObject( "//*[@id='ext-gen49']",   "Save");

		String reportName1 = recData[1][2];
		String reportName2 = recData[2][2];
		enterText("//*[@id='saveReportDlg_reportNameField']", reportName1 , "Report Name");
		enterText( "//*[@id='saveReportDlg_DeveloperName']",  reportName2,  "Report Unique Name");



		//SAVE THE UNSAVED REPORT.
		clickObject("//*[@id='ext-gen289']", "Save");
		//clickObject("//*[@id='ext-gen291']" , "Save and Run Report");
		clickObject("//*[@id='setupLink']", "Setup");

		driver.close();

	}


	public static void createNewContact() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a",  "Contact Tab");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");

		//contact information
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/createNewContact.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String lastName = recData[1][1];
		String accountName = recData[1][2];
		enterText( "//*[@id='name_lastcon2']", lastName ,  "Last Name");
		enterText( "//*[@id='con4']", accountName , "Account Name");

		clickObject("//*[@id='topButtonRow']/input[1]", "Save");
		//clickObject("//*[@id='topButtonRow']/input[2]", "Save & New");

		driver.close();
	}


	public static void checkMyContactsPage() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText("My Contacts");

		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");
		driver.close();
	}


	public static void checkRecentlyViewContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText("Recently Viewed Contacts");

		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");
		driver.close();

	}


	public static void checkRecentlyCreatedContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='hotlist_mode']")));
		dropDownList.selectByVisibleText("Recently Created");
		driver.close();

	}


	public static void viewContactinContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a", "Contact Name 1 ");

		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[3]/th/a", "Contact Name 2");
		driver.close();

	}


	public static void createNewViewContact() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='filter_element']/div/span/span[2]/a", "Create New View");


		String recData[][] = null;
		String scenarioTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/createNewViewContact.xls";
		recData = projectFunction.readSheet(scenarioTablePath, "Sheet1");
		String scenarioName = recData[1][1];
		String uniqueName = recData[1][2];

		enterText("//*[@id='fname']", scenarioName, "View Name");
		enterText("//*[@id='devname']", uniqueName, "View Unique Name");
		clickObject("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");

		driver.close();
	}


	public static void checkOnLeadsHome() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Lead_Tab']/a", " Leads");
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");

		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/checkOnLeadsHome.xls";
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

		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");

		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/createNewOpty.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String optyName = recData[1][1];
		String accountName = recData[1][2];
		String closeDate =  recData[1][3];
		enterText("//*[@id='opp3']", optyName , " Opportunity Name ");
		enterText("//*[@id='opp4']", accountName , " Account Name ");
		enterText("//*[@id='opp9']", closeDate , " Close Date ");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='opp11']")));
		dropDownList.selectByVisibleText("Prospecting");//Stage
		//validate 
		clickObject("//*[@id='bottomButtonRow']/input[1]", " Save ");

		//
		////new opportunity. Edit. 
		/* String a[]=new String[3];
         int i=0;
         for(String winHandle:driver.getWindowHandles()){
             a[i]=winHandle.toString();
             i++;
         }
         driver.switchTo().window(a[1]);
         driver.switchTo().frame("searchFrame");
         enterText("//*[@id='lksrch']", "mina", "lookup");
         clickObject("//*[@id='theForm']/div/div[2]/input[2]", "Go Button");
         driver.switchTo().defaultContent();    

         driver.switchTo().frame("resultsFrame");
         System.out.println("resultframe");
         clickObject("//*[@id='new']/div/div[3]/div/div[2]/table/tbody/tr[2]/th/a", "first account name");

         //clickObject(AccountNameXpath,AccountName);
                 //clickObject("//form[@id='new']/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a",AccountName);
         driver.switchTo().defaultContent();                
         driver.close();
         driver.switchTo().window(a[0]);*/

		driver.close();
	}


	public static void mySettings() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject( "//*[@id='userNav-arrow']", "User Navigate Arrow ");
		clickObject("//*[@id='userNav-menuItems']/a[2]", "My Settings  ");

		clickObject("//*[@id='PersonalInfo_font']", " Personal ");
		clickObject("//*[@id='LoginHistory_font']", "Login History");
		clickObject("//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Click Download Login history ");




		//click open with and ok
		/* String a[]=new String[2];
        int i=0;
        for(String winHandle:driver.getWindowHandles()){
            a[i]=winHandle.toString();
            i++;
        }
        driver.switchTo().window(a[1]);
         clickObject("//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Open with");
        clickObject("//*[@id='RelatedUserLoginHistoryList_body']/div/a", "OK" );
        //driver.switchTo().defaultContent();    
       // driver.close();
        driver.switchTo().window(a[0]);*/

		clickObject("//*[@id='DisplayAndLayout_font']", "Display And Layout");
		clickObject("//*[@id='CustomizeTabs_font']", "Customize My Tabs");
		selectDropdownListByVisibleText("//*[@id='p4']" , "Salesforce Chatter", "Salesforce Chatter" );
		selectDropdownListByVisibleText("//*[@id='duel_select_0']", "Reports", "Reports");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");

		clickObject("//*[@id='EmailSetup_font']", "Email");
		clickObject("//*[@id='EmailSettings_font']", "My Email Settings");

		//Read data Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/mySettings.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String emailName = recData[1][1];
		String emailAddress = recData[1][2];
		enterText("//*[@id='sender_name']", emailName, "Email Name");
		enterText("//*[@id='sender_email']", emailAddress, "Email Address");
		clickObject("//*[@id='auto_bcc1']", "Yes");
		clickObject( "//*[@id='bottomButtonRow']/input[1]", "Save");

		Alert al = driver.switchTo().alert();
		al.accept();//click on ok 
		//al.dismiss();//click on cancel

		clickObject("//*[@id='PersonalCollaboration_font']", "Chatter");
		clickObject("//*[@id='CalendarAndReminders_font']", "CalendarAndReminders");
		driver.close();
	}


	public static void customizeTabs() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='AllTab_Tab']/a/img", "All Tab ");
		clickObject("//*[@id='bodyCell']/div[2]/a", "add a tab");

		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='duel_select_0']")));
		dropDownList.selectByVisibleText("Groups");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
		dropDownList.selectByVisibleText("Chatter");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
		dropDownList.selectByVisibleText("Products");

		clickObject("//*[@id='bottomButtonRow']/input[1]", "Save");
		driver.close();
	}


	public static void logout() throws IOException, InterruptedException {
		loginToSFDC();
		/*Log out from the application*/
		clickObject("//*[@id='userNav-arrow']", "Navigation Drop Down");
		clickObject("//*[@id='userNav-menuItems']/a[4]"," Log Out Link");
		Update_Report("Pass", "Logout application "," Application has been log out.");
		driver.close();

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
		//Read data 
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/SalesforceFramework/DataFolder/developersConsole.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String navi = recData[1][4];
		String objPropName1 = recData[1][5];
		String devCon = recData[1][6];
		String objPropName2 = recData[1][7];
		String lout = recData[1][8];
		String objPropName3 = recData[1][9];

		clickObject(objPropName1 , navi);
		clickObject(objPropName2, devCon);

		// Get windowHandler
		String a[]=new String[2];
		int i=0;
		for(String winHandle:driver.getWindowHandles()){
			a[i]=winHandle.toString();
			i++;
		}

		driver.switchTo().window(a[1]);

		// Get button id from progress
		clickObject("//*[@id='tab-1180-btnEl']","close message box");
		//Get button class from progress
		//clickObject("//*[@class='x-tab-center']","close message box");

		driver.close();
		driver.switchTo().window(a[0]);

		clickObject(objPropName1 , navi);
		clickObject(objPropName3, lout);
		driver.quit();


	}

}
