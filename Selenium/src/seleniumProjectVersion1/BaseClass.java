package seleniumProjectVersion1;
// package Selenium Day4
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass extends projectFunction{

	public static void main(String[] args) throws InterruptedException, IOException {

		startReport("LoginErrorMessage", "C:/Users/htan/Desktop/SeleniumFramework/Report/");
		TestScript.LoginErrorMessage();
		bw.close();

		startReport("loginToSFDC", "C:/Users/htan/Desktop/SeleniumFramework/Report/");
		TestScript.loginToSFDC();
		bw.close();

		startReport("ValidateErrorMessage", "C:/Users/htan/Desktop/SeleniumFramework/Report/");
		TestScript.ValidateErrorMessage();
		bw.close();


	}

}
