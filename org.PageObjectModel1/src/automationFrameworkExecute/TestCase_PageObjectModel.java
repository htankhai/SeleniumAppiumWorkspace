package automationFrameworkExecute;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.FaceBook.FaceBookHome_PG;
import pageObjects.FaceBook.FaceBookLogIn_PG;
import pageObjects.Flight.*;
import pageObjects.Google.GooglePage;
import pageObjects.Insurance.Aboutpage;
import pageObjects.Insurance.AutomobilePage;
import pageObjects.Insurance.AutomobileQuote;
import pageObjects.Insurance.HomePage;
import pageObjects.Insurance.LoginInsurancePage;
import pageObjects.Insurance.Registrationpage;
import pageObjects.Selenium.SeleniumPage;


public class TestCase_PageObjectModel {
	WebDriver driver;

	//Create instances of the Pages
	FaceBookHome_PG	homePage = new FaceBookHome_PG(driver);
	FaceBookLogIn_PG loginPage = new FaceBookLogIn_PG(driver);


	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//	driver.get("https://www.facebook.com/");
		//System.out.println("Launching facebook page");

	}


	@Test(enabled= false, priority=0)
	public void test() {
		//Welcome to Home Page
		homePage.printHomePage();

		//Login Page
		//loginPage.LogIn_Button("htan.khai@yahoo.com", "Thisismine13");
		//System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		//logout from home page
		//homePage.logout_Button();

		loginPage.login_TransitingGooglePage(driver);

	}

	@Test(priority = 1)
	public void googlePageTest() throws InterruptedException{

		driver.get("https://www.google.com/?gws_rd=ssl");

		Thread.sleep(3000);

		GooglePage googlePage = new GooglePage(driver);

		//enter Selenium WebDriver 2.0 into text box
		googlePage.SearchTextGoogle("Selenium WebDriver 2.0");


		//click on Search button
		googlePage.clickonSearchButton();
		System.out.println("click on searach button");

		googlePage.clickonLinkSelenium();
		System.out.println("click on selenium link");

		//Inter-transition of Pages
		Thread.sleep(1000);

	
		//create Selenium page
		SeleniumPage seleniumPage = new SeleniumPage(driver); 
		//execute selenium page after switch to from Google page to Selenium Page

		
		seleniumPage.enabledLnkDownload();

	}

	@Test(enabled = false, priority=2)
	public void FindFlightPageTest(){
		// navigate to NewTours app
		driver.get("http://newtours.com");

		// verify if page is valid
		/*  if (driver.getTitle() != "Welcome: Tours")
		             throw new NoSuchWindowException("This is not the Login page");*/

		// instantiate LoginPage
		LoginFlightPage Login = new LoginFlightPage(driver);        

		// Login.Do returns the FindFlightsPage PageObject
		FindFlightsPage FindFlights = Login.login("James", "Flight777");
		if (FindFlights != null) 
		{ 
			// perform steps to find a flight
			FindFlights.login("James", "Flight777"); 

			// FindFlights.Logout returns LoginPage
			Login = FindFlights.Logout(); 
		}

	}

	//Insurance Page
	@Test(enabled =false, priority = 3)
	public void aboutPage(){
		Aboutpage aboutPage = new Aboutpage(driver);
		aboutPage.clickaboutlink();
		aboutPage.getauthorname();

	}

	@Test(enabled= false, priority = 4)
	public void automobilePage(){
		AutomobilePage automobilePage = new AutomobilePage(driver); 
		automobilePage.clickAccount();
		automobilePage.clickContact();
		automobilePage.clickOpty();
		automobilePage.clicksignup();
	}

	@Test(enabled = false, priority = 5)
	public void automobileQuotePage(){
		AutomobileQuote automobileQuote = new AutomobileQuote(driver);
		automobileQuote.enterZip();
		automobileQuote.ClickingGender();
		automobileQuote.launchapp();

	}

	@Test(enabled= false, priority = 6)
	public void homePage(){
		HomePage homePage = new HomePage(driver);
		homePage.enterZip();
		homePage.getHomePageLocatorText();
		homePage.getHomePageLocatorText();

	}

	@Test(enabled =false, priority = 7)
	public void loginInsurancePage(){
		LoginInsurancePage loginInsurancePage = new LoginInsurancePage(driver);

		String userName = "";
		loginInsurancePage.setUserName(userName);
		String password1 = "";
		loginInsurancePage.setPassword(password1);

		loginInsurancePage.validateErrorMessage();

	}

	@Test(enabled= false, priority = 8)
	public void registrationpage(){
		Registrationpage registrationpage = new Registrationpage (driver);
		registrationpage.ClickingGender();
		String uname = "";
		registrationpage.typefirstname(uname );

		String lstname ="";
		registrationpage.typelastname(lstname );

		String date = "";
		registrationpage.selectdate(date);

		String month= "";
		registrationpage.selectmonth(month);

		String yea= "";
		registrationpage. selectyear(yea);

		String remailid = "";
		registrationpage.typeremail(remailid );

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();

	}
}
