package datePicker_Jquery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DatePickonTrip {
	WebDriver driver = new FirefoxDriver();
	String baseUrl = "http://www.tripadvisor.com/";

	By flightsRadioButton = By.xpath("//*[@id='rdoFlights']/img");

	//Departure 
	By locationFrom = By.xpath("//*[@id='metaFlightFrom']");

	//location depart from
	String flightFrom = "Dallas/Fort Worth, TX - Dallas/Fort Worth International Airport (DFW)";


	//Arrival
	By locationTo = By.xpath("//*[@id='metaFlightTo']");

	//Flight to 
	String flightTo = "Los Angeles, CA - Los Angeles International Airport (LAX)";

	//chech-in 
	By check_inTextBox = By.xpath("//*[@id='checkIn']");

	String check_inDate = "08/21/2015";

	//check-out
	By check_outTextBox = By.xpath("//*[@id='checkOut']");
	
	String checkoutDate = "09/01/2015"; 
	
	//Find Flight button
	By findFlightButton = By.xpath("//*[@id='SUBMIT_VRS']");

	@Test
	public void scheduleFight(){
		driver.get(baseUrl);

		//click on Flights radio button
		driver.findElement(flightsRadioButton ).click();

		//enter departure location
		driver.findElement(locationFrom ).sendKeys(flightFrom);

		//enter arrival airport location
		driver.findElement(locationTo).sendKeys(flightTo );

		
		//check-in
		driver.findElement(check_inTextBox ).sendKeys(check_inDate );
		
		//check-out
		driver.findElement(check_outTextBox ).sendKeys(checkoutDate );
		

		driver.findElement(findFlightButton ).click();
	}

}
