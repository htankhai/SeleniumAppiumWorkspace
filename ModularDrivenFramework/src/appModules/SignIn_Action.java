package appModules;
import org.openqa.selenium.WebDriver;

import pageObjects.Home_Page;

import pageObjects.LogIn_Page;
public class SignIn_Action {
	 public static void Execute(WebDriver driver){
		 //Click on the My Account link.
		   Home_Page.lnk_SignIn(driver).click(); 
		 
		   LogIn_Page.txtbx_UserName(driver).sendKeys("testuser_1");
		 
		   LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");
		 
		   LogIn_Page.btn_LogIn(driver).click();
		 
		   }
}
