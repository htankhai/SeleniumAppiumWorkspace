package testScript;
import org.BaseFunction.CommonFunctions;
import org.ImplementingLogIn_Logout.CommonFunctions2;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
public class FBLogin extends CommonFunctions {

	 
	 @BeforeTest
	 public void StartBrowser_NavURL() throws IOException {
	  initData();  
	 }
	 
	 @AfterTest
	 public void ClosingBrowser() {  
	  closeBrowser();  
	 }


	@Test
	 public void OpenBrowserAndURL(){
	  initBrowser();
	  driver.get("https://www.facebook.com/");
	  //Enter your real Userd ID and Password of FB bellow.
	  logIn("YouruserID", "yourpassword");
	  logOut();
	 }
}
