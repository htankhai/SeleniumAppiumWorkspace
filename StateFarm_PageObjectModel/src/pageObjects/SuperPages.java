package pageObjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public interface SuperPages {

	public abstract void homePageTitle();

	public abstract void validateInvalidImages();

	public abstract void verifyimageActive(WebElement imgElement);

	//Select "Auto" or "Homeowners" and enter zipcode value getting quote
	public abstract void Auto_Homeonwers_Quote_selectOptionByText(
			WebElement element, String textOptionToSelect, String zipCodeValue);

	//option save quote
	public abstract void saveGetQuote_selectOptionByText(WebElement element,
			String textOptionToSelect, String zipCodeValue, String emailValue)
			throws InterruptedException;

	//life, health, long-term care quote
	public abstract void Life_Health_Long_TermCare_Quote_selectOptionByText(
			WebElement element1, String textOptionToSelect1,
			WebElement element2, String textOptionToSelect2);

	//Action's mouse hover
	public abstract void homePage_SwitchMenu();

}