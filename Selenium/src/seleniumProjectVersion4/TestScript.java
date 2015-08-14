package seleniumProjectVersion4;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		/*Check company owner*/
		clickObject("//*[@id='owner-choice']/img", "Company owner image");
		/*Close message box*/
		clickObject("//*[@id='walkthrough-callout-close']/img", "Close message box");
	}

	/*Validate error message*/
	public static void loginErrorMessage() throws IOException, InterruptedException{
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
		//driver.quit();

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
//		if(Browser.equals("Chrome")){
//			clickChromeObj();
//		}else{
			clickObject("//*[@id='Login']", "Login button ");
//		}
		
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
		/*List <WebElement>  iframe = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(iframe.get(0));
		driver.switchTo().frame("Frame1");
		driver.switchTo().frame("FrameA");
		Enter FN

		driver.switchTo().defaultContent();
		driver.switchTo().frame("Frame1");
		driver.switchTo().frame("FrameB");
		driver.switchTo().frame("FrameD");
		Enter User Name

		Click Login
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Frame1");
		driver.switchTo().frame("FrameB");*/		
		
		// Get iframe id from HTML. In iframe  of AboutTab, Primary Web page embedded another HTML page.
		driver.switchTo().frame("contactInfoContentId");
		/*click on About Tab*/
		clickObject("//*[@id='aboutTab']/a", "About");
		/*Enter Last name*/
		enterText("//*[@id='lastName']", "New LName", "Last Name");
		/*Save*/
		clickObject("//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save All");
		driver.switchTo().defaultContent();
		//driver.close();
	}
	public static void customizeTabs() throws IOException, InterruptedException{
		loginToSFDC();
		clickObject("//*[@id='AllTab_Tab']/a", "Tab ");
		clickObject("//*[@id='bodyCell']/div[3]/div[1]/table/tbody/tr/td[2]/input", "Customize My Tabs");
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='duel_select_0']")));
		dropDownList.selectByVisibleText("Contracts");
		
		//selectDropdownListByVisibleText("//*[@id='duel_select_0']/option[5]", "Product2",  "Products");
		//clickObject("//*[@id='duel_select_0_right']/img", "Add");
		//selectDropdownListByVisibleText("//*[@id='duel_select_0']/option[5]", "UserProfile",  "Profile");
		clickObject("//*[@id='duel_select_0_right']/img", "Add");
		
		//Select CustomApp = new Select(driver.findElement(By.xpath("//*[@id='p4']")));
		//CustomApp.selectByVisibleText("Call Center");
		
		clickObject("//*[@id='bottomButtonRow']/input[1]", " Save");
		//driver.quit();
		
	}
	
	public static void sample() throws IOException{
		
		Update_Report( "Pass", "clickObject", " is clicked");
	}
}
