package pageObjects;
//write all the Webelements and functions. This is only registration page but it Depends on 
//application How many pages your application contains.

//write code for Registration page.
//Make Webdriver driver as null
//You need to define all elements according to ui whether it is radiobutton/textboxes.Just you need to define the all webelemets on which you want to perform action.
//Create a Constuctor of Your class and Pass WebDriver as Parameter 
//You need to write methods/Function for all WebElements whether you want to click/write/Select from dropdown.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registrationpage {
	//Instancing webdriver
	public  WebDriver driver;
	//Defining webelements 

	@FindBy (xpath ="//*[@value='First name']")
	WebElement firstName ;

	@FindBy (xpath ="//*[@value='Last name']")
	WebElement lastName ; 

	@FindBy(xpath = "//*[@value='Email or mobile number']")
	WebElement email;

	@FindBy(xpath = "//*[@value='Re-enter email or mobile number']")
	WebElement reemail;

	@FindBy(xpath = "//*[@value='New password']")
	WebElement newPassword ;

	By mont =  By.xpath("//*[@id='month']");

	By day = By.xpath("//*[@id='day']");

	By year = By.xpath("//*[@id='year']");

	@FindBy(xpath = "//*[@id='u_0_d']")
	WebElement femaleradiobutton;

	@FindBy(xpath="//button[@name='websubmit']")
	WebElement signup ;


	// Instantiate class
	public Registrationpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// Type firstname
	public void typefirstname(String uname) 
	{
		//Create a method which will enter firstname
		firstName.sendKeys(uname);  
	}

	// Type lastname
	public void typelastname(String lstname) {
		//Create a method which will enter lastname
		lastName.sendKeys(lstname);
	}

	// Type email
	public void typeemail(String emailid) {
		//Create a method which will enter emailid
		email.sendKeys(emailid);
	}

	//Typereemail
	public void typeremail(String remailid) {
		//Create a method which should type email
		reemail.sendKeys(remailid);
	}

	//typenewpassword
	public void typenewPassword(String newpassrd) {
		//Create method will enter password
		newPassword.sendKeys(newpassrd);
	}
	//selectmonth
	public void selectmonth(String month){
		Select mon = new Select(driver.findElement(mont));
		mon.selectByVisibleText(month);
	}

	//Select date 
	public void selectdate(String date){
		Select datebirth = new Select(driver.findElement(day));
		datebirth .selectByVisibleText(date);
	}
	//selecting year
	public void selectyear(String yea){
		Select yearsel = new Select(driver.findElement(year));
		yearsel .selectByVisibleText(yea);
	}

	//clicking sign up button     
	public void clicksignup(){
		signup.click();
	} 
}
