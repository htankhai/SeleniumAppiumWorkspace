package pageObjects;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;*/

public class HomePage implements SuperPages {

	WebDriver driver;
	
 	private int invalidImageCount;


	//Get a Quote
	//Text box
	//Auto Select WebElement
	@FindBy(xpath ="//*[@id='sType']")
	WebElement selectQuote;

	//zip code text box WebElement
	@FindBy(name = "zipCode")
	WebElement zipCode;

	//Go button
	@FindBy(id = "getAQuoteGo")
	WebElement goButton;

	//Contact Us
	//zip code WebElement

	//Manage Claims
	//Auto Select WebElement


	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#homePageTitle()
	 */
	@Override
	@Test
	public void homePageTitle()
	{
		String title  = driver.getTitle();
		System.out.println(title);
	}



	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#validateInvalidImages()
	 */
	@Override
	public void validateInvalidImages() {
		try {

			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#verifyimageActive(org.openqa.selenium.WebElement)
	 */
	@Override
	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//Select "Auto" or "Homeowners" and enter zipcode value getting quote
	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#Auto_Homeonwers_Quote_selectOptionByText(org.openqa.selenium.WebElement, java.lang.String, java.lang.String)
	 */
	@Override
	public void Auto_Homeonwers_Quote_selectOptionByText(WebElement element, String textOptionToSelect, String zipCodeValue) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(textOptionToSelect);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}

		//enter zipcode and click on go button
		zipCode.sendKeys(zipCodeValue);
		goButton.click();

	}

	//option save quote
	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#saveGetQuote_selectOptionByText(org.openqa.selenium.WebElement, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveGetQuote_selectOptionByText(WebElement element, String textOptionToSelect, String zipCodeValue, String emailValue) throws InterruptedException {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(textOptionToSelect);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}

		//enter zipcode and click on go button
		zipCode.sendKeys(zipCodeValue);

		Thread.sleep(1000);
		
		WebElement saveQuote  = driver.findElement(By.cssSelector(".swapBlock")); 
		saveQuote.click();
		
		
		WebElement emailElement = driver.findElement(By.id("sQuoteEmail"));
		emailElement.sendKeys(emailValue); 
		
		WebElement goButton = driver.findElement(By.id("continueQuoteGo"));
		goButton.click(); 
	}

	//life, health, long-term care quote
	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#Life_Health_Long_TermCare_Quote_selectOptionByText(org.openqa.selenium.WebElement, java.lang.String, org.openqa.selenium.WebElement, java.lang.String)
	 */
	@Override
	public void Life_Health_Long_TermCare_Quote_selectOptionByText(WebElement element1, String textOptionToSelect1, WebElement element2, String textOptionToSelect2) {
		try {
			Select select = new Select(element1);
			select.selectByVisibleText(textOptionToSelect1);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}
		
		try {
			Select select = new Select(element2);
			select.selectByVisibleText(textOptionToSelect2);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}

		//enter zipcode and click on go button
		goButton.click();

	}


	//Action's mouse hover
	/* (non-Javadoc)
	 * @see pageObjects.SuperPages#homePage_SwitchMenu()
	 */
	@Override
	public void homePage_SwitchMenu(){
		System.out.println(" in home page switch menu method");
		Actions actions = new Actions(driver);

		//Insurance Menu
		WebElement insuranceMenu = driver.findElement(By.cssSelector(".nav-label"));
		actions.moveToElement(insuranceMenu);

		//Auto sub menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id='insurance']/div[1]/ul/li[1]/a"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();

	}

	


}
