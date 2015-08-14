package pageObjects.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Selenium.SeleniumPage;

public class GooglePage {
	static WebDriver driver;

	@FindBy(className = "gsfi")
	WebElement searchText ;

	@FindBy(name = "btnG")
	WebElement searchButton; 
	
	@FindBy(xpath= "//*[@id='rso']/div[2]/div[1]/div/h3/a")
	WebElement lnkSelenium;
	

	public GooglePage() {
		System.out.println("constructor in  Google Page");

	}

	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void SearchTextGoogle(String sendText){
		System.out.println("In search text google ");
		searchText.sendKeys(sendText);
		

	}

	public void clickonSearchButton(){
		System.out.println("In click on search button");
		searchButton.click();
		
		
	}
	

	public SeleniumPage clickonLinkSelenium(){
		lnkSelenium.click();
		return new SeleniumPage();
	}
	
	public void enabledLnkDownload(){
		System.out.println("Enable download link");
	}

}
