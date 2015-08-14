package pageObjects.FaceBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLogIn_PG {
	WebDriver driver;

	//UI components
	//username text filed
	@FindBy(xpath = "//*[@id='email']")
	public WebElement txt_UserName1;

	//password text field
	@FindBy(id = "pass")
	public WebElement txt_Password1;

	//login button
	@FindBy(xpath = "//*[@id='u_0_x']")
	public WebElement btn_Login1 ;

	// a constructor//every page need a base driver to find web elements

	public FaceBookLogIn_PG(WebDriver driver){ 
		PageFactory.initElements(driver, this); 

	} 


	//This method will take two arguments ( Username nd Password)
	public void LogIn_Button(String username1, String password1){
		System.out.println("In Login in action ");
		txt_UserName1.sendKeys(username1);
		txt_Password1.sendKeys(password1);
		btn_Login1.click();
		System.out.println("Exit from Log in Action");
	}

	public void login_TransitingGooglePage(WebDriver driver){

		System.out.println("Enter Login and Switch to Google Page");

	}
}
