package facebookTestScript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/
public class Facebook_TestScript {

	public WebDriver driver;
	//public WebDriver driver= new FirefoxDriver();

	String URL= "https://www.facebook.com/?_rdr";

	//Initialize object of FirefoxProfile
	FirefoxProfile profile = new FirefoxProfile();


	@Test(priority=0)
	public void loginToSFDC() throws IOException, InterruptedException{

		/*Read data Parameter*/
		String UN = "htan.khai@yahoo.com";
		String pwd = "Thisismine13";

		//Logger log = Logger.getLogger(SalesforceTestScript.class);

		//Configure Log4j Properties file
		//BasicConfigurator.configure();

		//System.out.println(log.getName());

		//set level
		//log.setLevel(Level.DEBUG);

		//Set up profile preferences
		profile.setPreference("browser.startup.homepage", "https://login.salesforce.com/");

		//set profile preference into driver
		driver = new FirefoxDriver(profile);

		//Track WebPage Load Time
		long start = System.currentTimeMillis();

		/*Launch Facebook application*/
		driver.get(URL);

		//implicit global wait for find element command 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver.manage().window().maximize();

		//Resize Browser window
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(600,500);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);

		/*Locate user name and enter user Name text field*/
		String unXpath = "//*[@id='email']";
		driver.findElement(By.xpath(unXpath)).getSize();
		driver.findElement(By.xpath(unXpath)).sendKeys(UN);

		//	log.info("Type In Text field.");


		/*Enter Password*/
		String pwdXpath = "//*[@id='pass']";
		driver.findElement(By.xpath(pwdXpath)).sendKeys(pwd);

		//	log.info("Type In Text field.");

		/*Click Login*/
		String objXPath = "//*[@id=''u_0_n']";
		driver.findElement(By.xpath(objXPath)).click();

		//log.info("Click the Login button");

		driver.navigate().refresh();

		//close owner window
		//driver.findElement(By.xpath("//*[@id='owner-choice']/p/label")).click();

		Thread.sleep(300);

		//close side bar
		//driver.findElement(By.xpath("//*[@id='walkthrough-sidebar-toggle']/img")).click();


		//long finish = System.currentTimeMillis();
		//long TotalTime = finish - start;
		//System.out.println("Total Time for page load - "+TotalTime); 

	}


	//@Test(priority =0)
	//log out
	public void Logout() throws IOException, InterruptedException{
		/*Read data Parameter*/
		String UN = "htan.khai@yahoo.com";
		String pwd = "automation123456";

		/*Launch SFDC application*/
		driver.get(URL);

		//implicit global wait for find element command 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		/*Enter user Name*/
		String unXpath = "//*[@id='username']";
		driver.findElement(By.xpath(unXpath)).sendKeys(UN);

		/*Enter Password*/
		String pwdXpath = "//*[@id='password']";
		driver.findElement(By.xpath(pwdXpath)).sendKeys(pwd);

		/*Click Login*/
		String objXPath = "//*[@id='Login']";
		driver.findElement(By.xpath(objXPath)).click();

		//close owner window
		//driver.findElement(By.xpath("//*[@id='owner-choice']/p/label")).click();

		//close side bar
		//driver.findElement(By.xpath("//*[@id='walkthrough-sidebar-toggle']/img")).click();


		//Log out from the application
		//Navigation Drop Down
		driver.findElement(By.xpath("//*[@id='userNavButton']")).click();

		//Log Out Link 

		driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[4]")).click();

		driver.close();

	}

	//@Test(priority = 0)
	public void forgotPassword() throws IOException, InterruptedException {

		/*Read data Parameter*/
		String UN = "htan.khai@yahoo.com";
		String pwd = "automation123456";

		/*Launch SFDC application*/
		driver.get(URL);

		//implicit global wait for find element command 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//forgot password link 
		driver.findElement(By.xpath("//*[@id='forgot']/span[1]/a")).click();

		/*Enter user Name*/
		String unXpath100 = "//*[@id='un']";
		driver.findElement(By.xpath(unXpath100)).sendKeys(UN);

		//continue button
		String continueXpath= "//*[@id='continue']";
		driver.findElement(By.xpath(continueXpath)).click();
		driver.quit();
	}

	//@Test(priority=1)
	public void createAccount() throws IOException, InterruptedException {
		//Account tab
		driver.findElement(By.xpath("//*[@id='Account_Tab']/a")).click();

		//Click new button
		driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();

		//Account information
		//Account Name text field
		driver.findElement(By.xpath("//*[@id='acc2']")).sendKeys("Account100");

		//select type of account
		Select select = new Select (driver.findElement(By.xpath("//*[@id='acc6']")));
		select.selectByVisibleText("Analyst"); 

		//website
		driver.findElement(By.xpath("//*[@id='acc12']")).sendKeys("http://www.htankhai.com");

		//click save button
		driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]")).click();

		driver.close();
	}


	//@Test(priority=2)
	//Calender table tab//save report
	public void createAccountReport() throws IOException, InterruptedException {
		//Account tab
		driver.findElement(By.xpath("//*[@id='Account_Tab']/a")).click();

		//Report 30 days account. Accounts with last activity > 30 days
		driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a")).click();

		//Click on Show arrow tab
		driver.findElement(By.xpath("//*[@id='ext-gen145']")).click();

		//submit My accounts
		driver.findElement(By.xpath("//*[@id='ext-gen145']")).sendKeys("My accounts");
		//driver.findElement(By.xpath("//*[@id='ext-gen242']/div[1]")).click();

		//close owner pop up window
		driver.findElement(By.xpath("//*[@id='owner-choice']/p/label")).click();

		Thread.sleep(300);

		//close side bar pop upwindow
		driver.findElement(By.xpath("//*[@id='walkthrough-sidebar-toggle']/img")).click();

		//Date Field  arrow tab
		driver.findElement(By.xpath("//*[@id='ext-gen148']")).click();

		//Choose created date
		driver.findElement(By.xpath("//*[@id='ext-gen148']")).sendKeys("Last Activity");
		//( "//*[@class='x-combo-list-inner']/div[2]")

		//Range arrow tab
		driver.findElement(By.xpath("//*[@id='ext-gen150']")).click();

		//Choose All time
		driver.findElement(By.xpath("//*[@id='ext-gen150']")).sendKeys("Custom");
		//driver.findElement(By.xpath("//*[@class='x-combo-list-inner']/div[1]")).click();

		//From Calendar table box
		driver.findElement(By.xpath("//*[@id='ext-comp-1042']")).sendKeys("02/03/2015");
		/*
		driver.findElement(By.xpath("//*[@id='ext-gen152']")).click();

		//click next button for next month
		driver.findElement(By.xpath("//*[@id='ext-gen269']")).click();

		//datewidget is a calender table it contain rows and colums. Pick number 21
		WebElement datewidget=driver.findElement(By.id("ext-gen152"));
		List<WebElement> rows=datewidget.findElements(By.tagName("tr"));
		List<WebElement> columns=datewidget.findElements(By.tagName("td"));

		for(WebElement cell : columns)
		{
			if(cell.getText().equals("21"))
			{
				cell.findElement(By.linkText("21")).click();
				break;
			}
		}*/

		//To Calendar box
		//driver.findElement(By.xpath("//*[@id='ext-comp-1045']")).sendKeys("04/01/2015");

		//Click on save button
		driver.findElement(By.xpath("//*[@id='ext-gen49']")).click();

		//Save Report window is displayed
		//enter report name
		driver.findElement(By.xpath("//*[@id='saveReportDlg_reportNameField']")).sendKeys("Report1006");

		//enter Report Unique Name
		driver.findElement(By.xpath("//*[@id='saveReportDlg_DeveloperName']")).sendKeys("SectionReport1006");

		//Save button. Then display unsaved report.
		driver.findElement(By.xpath("//*[@id='ext-gen271']")).click();

		//Click on setup tab
		driver.findElement(By.xpath("//*[@id='setupLink']")).click();

		driver.close();

	}

	//@Test(priority=1)
	public void createNewContact() throws IOException, InterruptedException{

		//Click Contacts tab on main panel
		driver.findElement(By.xpath("//*[@id='Contact_Tab']/a")).click();

		//click on new
		driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();

		//contact information
		//Enter last Name
		driver.findElement(By.xpath("//*[@id='name_lastcon2']")).sendKeys("Htan");
		//Account name
		driver.findElement(By.xpath("//*[@id='con4']")).sendKeys("Htan");

		//Clink on Save and new button
		driver.findElement(By.xpath("//*[@id='topButtonRow']/input[2]")).click();
		driver.close();
	}


	/*public void checkMyContactsPage() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/checkMyContactsPage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String contactName = recData[1][1];

		//View tab. select My Contact
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText(contactName);

		//Go! button
		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");

		Thread.sleep(5000);
		driver.quit();
	}


	public void checkRecentlyViewContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		//Contacts tab
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/checkRecentlyViewContactPage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String contactName = recData[1][1];

		//select recently view contacts
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='fcf']")));
		dropDownList.selectByVisibleText(contactName);

		//Go!
		clickObject("//*[@id='filter_element']/div/span/span[1]/input", "Go");
		Thread.sleep(5000);
		driver.quit();

	}


	public void checkRecentlyCreatedContactPage() throws InterruptedException, IOException{
		loginToSFDC();
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/checkRecentlyCreatedContactPage.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String contactName = recData[1][1];

		//select list - "Recently created" 
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='hotlist_mode']")));
		dropDownList.selectByVisibleText(contactName);

		Thread.sleep(5000);
		driver.quit();

	}


	public void viewContactinContactPage() throws InterruptedException, IOException{
		loginToSFDC();

		//Contacts tab
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		//Contact name 
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a", "Contact Name 1");

		//Contact name
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[3]/th/a", "Contact Name 2");

		Thread.sleep(5000);
		driver.quit();

	}


	public void createNewViewContact() throws IOException, InterruptedException{
		loginToSFDC();

		//Contacts tab
		clickObject("//*[@id='Contact_Tab']/a", "Contacts");

		//Create New View 
		clickObject("//*[@id='filter_element']/div/span/span[2]/a", "Create New View");

		//read parameter
		String recData[][] = null;
		String scenarioTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/createNewViewContact.xls";
		recData = projectFunction.readSheet(scenarioTablePath, "Sheet1");
		String scenarioName = recData[1][1];
		String uniqueName = recData[1][2];

		//View Name
		enterText("//*[@id='fname']", scenarioName, "View Name");

		//View Unique Name
		enterText("//*[@id='devname']", uniqueName, "View Unique Name");

		//Save 
		clickObject("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");
		Thread.sleep(4000);
		driver.close();
	}


	public static void checkOnLeadsHome() throws IOException, InterruptedException{
		loginToSFDC();

		//Leads tab
		clickObject("//*[@id='Lead_Tab']/a", " Leads");

		//New tab
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/checkOnLeadsHome.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String LastName = recData[1][1];
		String CompanyName = recData[1][2];

		//last name
		enterText("//*[@id='name_lastlea2']", LastName , " Last Name" );

		//company name
		enterText("//*[@id='lea3']", CompanyName, "CompanyName" );

		//save 
		clickObject("//*[@id='topButtonRow']/input[1]", "Save");

		Thread.sleep(4000);
		driver.quit();

	}


	public void createNewOpty() throws IOException, InterruptedException{ 
		loginToSFDC();

		//opportunities tab
		clickObject("//*[@id='Opportunity_Tab']/a", " Opportunities ");

		//new 
		clickObject("//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/createNewOpty.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String optyName = recData[1][1];
		String accountName = recData[1][2];
		String closeDate =  recData[1][3];

		//opportunity name
		enterText("//*[@id='opp3']", optyName , "Opportunity Name");

		//account name
		enterText("//*[@id='opp4']", accountName , "Account Name");

		//close date
		enterText("//*[@id='opp9']", closeDate , "Close Date");

		//select- stage
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='opp11']")));
		dropDownList.selectByVisibleText("Prospecting");

		//save 
		clickObject("//*[@id='topButtonRow']/input[1]", " Save ");
		Update_Report("Pass", "New Opy"," New Opy application has been created");
		driver.close();

	}


	public void customizeTabs() throws IOException, InterruptedException{
		loginToSFDC();

		//+ tab
		clickObject("//*[@id='AllTab_Tab']/a/img", "+ All Tab");

		//add a tab link
		clickObject("//*[@id='bodyCell']/div[2]/a", "add a tab");

		//Read Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/customizeTabs.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String tabName1 = recData[1][4];
		String tabName2 = recData[1][5];
		String tabName3 = recData[1][6];

		//select - group, 
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='duel_select_0']")));
		dropDownList.selectByVisibleText(tabName1);
		clickObject("//*[@id='duel_select_0_right']/img", "Add");

		//people
		dropDownList.selectByVisibleText(tabName2);
		clickObject("//*[@id='duel_select_0_right']/img", "Add");

		//products
		dropDownList.selectByVisibleText(tabName3);
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
		clickObject("//*[@id='bottomButtonRow']/input[1]", "Save");
		driver.close();
	}


	public void createdNewViewAccount() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='Account_Tab']/a", "Accounts");
		clickObject("//*[@id='filter_element']/div/span/span[2]/a[2]", "Create New View");

		//Read data Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/createdNewViewAccount.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String viewName = recData[1][4];
		String viewUniqueName = recData[1][5];

		//View name
		enterText("//*[@id='fname']", viewName , "View Name");

		//View Unique name
		enterText("//*[@id='devname']", viewUniqueName , "View Unique Name");
		clickObject("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");
		Thread.sleep(3000);
		driver.close();

	}
	Edit my Profile
	public void editMyProfile() throws IOException, InterruptedException{
		loginToSFDC();

		Click on drop down object
		clickObject("//*[@id='userNav-arrow']", "NavDropdown");

		CLick on my Profile
		clickObject("//*[@id='userNav-menuItems']/a[1]", "MyProfile");

		Click on Edit profile
		clickObject("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img", "Click on Edit Profile");

		Switch to frame
		driver.switchTo().frame("contactInfoContentId");

		//driver.switchTo().frame(driver.findElement(By.id("contactInfoContent")));//check?

		click on About Tab
		clickObject("//*[@id='aboutTab']/a", "Click on About Tab");

		//read parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/editMyProfile.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String newLName = recData[1][1];

		Enter Last name
		enterText("//*[@id='lastName']", newLName , "Last Name");

		Save All
		clickObject("//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save all button");

		//default content
		driver.switchTo().defaultContent();
		driver.close();
	}


	public void mySettings() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject( "//*[@id='userNav-arrow']", "User Navigate Arrow");
		clickObject("//*[@id='userNav-menuItems']/a[2]", "My Settings");

		//Personal Section
		clickObject("//*[@id='PersonalInfo_font']", "Personal");
		clickObject("//*[@id='PersonalInformation_font']", "Personal Infomation");
		clickObject("//*[@id='ChangePassword_font']", "Change My Password");
		clickObject("//*[@id='LanguageAndTimeZone_font']","Language and Time Zone");
		clickObject("//*[@id='GrantLoginAccess_font']", "Grant Login Access");
		clickObject("//*[@id='Groups_font']", "My Groups");
		clickObject("//*[@id='ResetApiToken_font']","Reset My Security Button");
		clickObject("//*[@id='Connections_font']","Connections");
		clickObject("//*[@id='AdvancedUserDetails_font']", "Advanced User Detials");

		//Display and Layout Section
		clickObject("//*[@id='DisplayAndLayout_font']", "Display And Layout");
		//customize my tabs
		clickObject("//*[@id='CustomizeTabs_font']", "Customize My Tabs");
		selectDropdownListByVisibleText("//*[@id='p4']" , "Salesforce Chatter", "Salesforce Chatter" );
		selectDropdownListByVisibleText("//*[@id='duel_select_0']", "Reports", "Reports");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");

		//Email Section
		clickObject("//*[@id='EmailSetup_font']", "Email");
		clickObject("//*[@id='EmailSettings_font']", "My Email Settings");

		//Read data Parameter
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/Salesforce/DataFolder/mySettings.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");
		String emailName = recData[1][1];
		String emailAddress = recData[1][2];
		enterText("//*[@id='sender_name']", emailName, "Email Name");
		enterText("//*[@id='sender_email']", emailAddress, "Email Address");
		clickObject("//*[@id='auto_bcc1']", "Yes");
		clickObject( "//*[@id='bottomButtonRow']/input[1]", "Save");

		Alert newAlert = driver.switchTo().alert();
		newAlert.accept(); 

		//Chatter Section
		clickObject("//*[@id='PersonalCollaboration_font']", "Chatter");
		clickObject("//*[@id='CollaborationMyFeedsSettings_font']", "My Feeds");
		clickObject("//*[@id='start_following']", "Automatic Record");
		clickObject("//*[@id='bottomButtonRow']/input[1]", "Save");

		//CalendarAndReminders Section
		clickObject("//*[@id='CalendarAndReminders_font']", "CalendarAndReminders");
		clickObject("//*[@id='Reminders_font']","Reminders");
		clickObject("//*[@id='bottomButtonRow']/input[1]","Save");

		//Desktop Add-Ons Section
		clickObject("//*[@id='DesktopIntegration_font']", "Desktop Add-Ons");
		clickObject("//*[@id='CheckForClientUpdate_font']", "Check for Updates");
		clickObject("//*[@id='OfficeSetup_font']", "Connect for Office");
		clickObject("//*[@id='installButtonDiv']/input","Install Now");
		driver.quit();
	}

	 */


}
