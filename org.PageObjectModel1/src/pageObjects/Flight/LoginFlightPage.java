package pageObjects.Flight;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFlightPage {
	private final WebDriver driver;

	//Create private Web elements by FindBy and By
	@FindBy(xpath="//*[@id='username']")
	private WebElement usernameField;

	@FindBy(xpath="//*[@id='password']")
	private WebElement passwordField;

	@FindBy(id= "send2")
	WebElement loginButton;


	public LoginFlightPage(WebDriver driver) {
		this.driver = driver;

		/*// verify if page is valid
        if (driver.getTitle() != "Welcome: Mercury Tours")
            throw new NoSuchWindowException("This is not the Login page");*/

		PageFactory.initElements(driver, this);

	}

	// return FindFlightsPage PageObject
	public FindFlightsPage login(String string, String string2)
	{

		usernameField.sendKeys(string);
		passwordField.sendKeys(string2);
		loginButton.click();

		return new FindFlightsPage(driver);
	}
}