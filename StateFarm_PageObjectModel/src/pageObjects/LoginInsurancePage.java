package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInsurancePage implements Pages{

	WebDriver driver;

	//Create private Web elements with By only once
	//username
	@FindBy(xpath=("//*[@id='username']"))
	WebElement userNameField;

	//pasword
	@FindBy (xpath=("//*[@id='password']"))
	WebElement pwdField;

	//Login page title
	@FindBy(className=("barone"))
	WebElement titleText;
	//define HTML element as Web elements locator by By only once

	//login button
	@FindBy(name=("send2"))
	WebElement loginButton;

	//constructor. 
	//Initialize and create Web Elements by PageFactory.initElements method
	public LoginInsurancePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);

		}

	public void setUserName(String userName){
		userNameField.sendKeys(userName);
	}

	public void setPassword(String password1){
		pwdField.sendKeys(password1);
	}

	public void login(String email, String password1) {
		this.setUserName(email);
		this.setPassword(password1);
		this.loginClick();
	}

	//Get the title of Login Page
	public String getLoginTitle(){
	return    this.titleText.getText();
	}

	//public access methods to reach private fields in the Page Class
	public void launchapp(){

	}

	public void loginClick() {
		loginButton.click();
	}
	
	@Override
	public void clickaboutlink() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void typeemail(String emailid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void typeremail(String remailid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void typenewPassword(String newpassrd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clicksignup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOpty() {
		// TODO Auto-generated method stub
		
	}

		@Override
	public void validateErrorMessage() {
		// TODO Auto-generated method stub
		
	}

}