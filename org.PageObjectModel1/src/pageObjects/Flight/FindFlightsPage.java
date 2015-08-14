package pageObjects.Flight;
import java.io.Console;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFlightsPage
{
    private final WebDriver driver;
    
    @FindBy(id="SIGN-OFF")
	private WebElement signoffField;
    
    @FindBy(id="Home")
  	private WebElement homeField;
 
    public FindFlightsPage(WebDriver driver)  { 
        this.driver = driver;
        PageFactory.initElements(driver, FindFlightsPage.class);
        
        //  verify if page is valid
        if (driver.getTitle() != "Find a Flight: Mercury Tours:")
            throw new NoSuchWindowException("This is not the FindFlights page");
    }
 
   
   
    public void login(String CustomerName,String FlightNumber) {
        System.out.println("In FindFlightsPage.Do [Checking for Flights] for "+
    "Customer Name " + 	CustomerName +  " Flight Number" +FlightNumber );
    }
   
    // returns LoginPage PageObject
    public LoginFlightPage Logout() {
      
    	signoffField.click();
        homeField.click();
 
      
        return new LoginFlightPage(driver);
    }
}