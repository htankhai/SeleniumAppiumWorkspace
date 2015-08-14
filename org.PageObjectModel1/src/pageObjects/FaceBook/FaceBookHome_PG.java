package pageObjects.FaceBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FaceBookHome_PG {
	WebDriver driver;

	//UI components
	//My Account link
	//@FindBy(xpath = ".//*[@id='account']/a")
	//public WebElement lnk_MyAccount;

	//Navigate to log out button
	@FindBy(xpath = "//*[@id='userNavigationLabel']")
	public WebElement navtoLogout;

	//log out button
	@FindBy(xpath = "//*[@id='u_h_1']/div/div/div[1]/div/div/ul/li[12]/a/span/span")
	public WebElement lnk_LogOut;


	//  a constructor // every page need a base driver to find web elements
	public FaceBookHome_PG(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void printHomePage(){
		System.out.println("Welcom to Home Page");
	}

	public void logout_Button(){
		//Navigate to log out button
		navtoLogout.click();

		//click on log out of Home Page
		lnk_LogOut.click();

	}

}
