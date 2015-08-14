package org.ImplementingLogIn_Logout;

import org.BaseFunction.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class CommonFunctions2 extends CommonFunctions {
	WebDriver driver;
	public boolean isAlreadyLogIn=false;

	//Can accept userID and password as a string
	public void logIn(CharSequence[] userID, CharSequence[] password){
		//To check If already login previously then don't execute this function.
		if(!isAlreadyLogIn){
			//If Not login then login In to your account.
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(userID);
			driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
			isAlreadyLogIn=true;
		}
	}

	public void logOut(){
		driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		driver.findElement(By.xpath("//input[@value='Log Out']")).click();   
		isAlreadyLogIn=false;
	}

	//@AfterClass 
	public void closeBrowser(){
		driver.quit();  
	}

}
