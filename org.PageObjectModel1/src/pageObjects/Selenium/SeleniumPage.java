package pageObjects.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {
	static WebDriver driver;

	@FindBy(xpath = "//*[@id='menu_download']/a")
	WebElement lnkDownload;

	public SeleniumPage() {

	}

	public SeleniumPage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}


	public void enabledLnkDownload(){
		lnkDownload.isEnabled();
		System.out.println("click on Selenium link button");
	}

}
