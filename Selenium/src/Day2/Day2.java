package Day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day2 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//for(int i = 0; i < 1; i ++){
		driver = new FirefoxDriver(); // Launch Fire fox Browser
		//Thread.sleep(1000);
		driver.get("https://login.salesforce.com/"); // Get the URL
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		// FireBug read the application properties
		// Fire path read object properties
		//Text Box. Xpath attributes by Selenium IDE.
		/*Get XPath from firepath. perform the field.*/
		String un = "htankkhai2014@gmail.com";
		String unXpath = "//*[@id='username']";

		String pw = "salesforcedemo123";
		String pwdXpath = "//*[@id='password']";

		/**if(driver.findElement(By.xpath(unXpath)).isDisplayed()){
		driver.findElement(By.xpath(unXpath)).clear();
		driver.findElement(By.xpath(unXpath)).sendKeys(un);
		System.out.println("Pass:  " + User Name + " "+ un + " is entered in " + username + " field");
		}else{
		System.out.println("Fail: " + userName +  " field does not exist in the application");
		}*/

		// Enter text into username field
		enterText( unXpath,  un,  "User Name");

		// Enter password
		enterText(pwdXpath, pw, "Password");

		//Click Login
		//driver.findElement(By.xpath("//*[@id='Login']")).click();	
		//Thread.sleep(4000);
		
		String loginXpath = "//*[@id='Login']" ;
		clickButton(loginXpath , "Login");
		Thread.sleep(1000);
		// Close the browser
		driver.close();
	}

	/* Name of the method: enterText
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, enterValue --> value to be entered, objectName --> Name of the textbox
	 * Created by: Htan
	 * Creation Date: Mar 14 2014
	 * Last modified: Mar 14 2014
	 * */
	public static void enterText(String objXpath, String enterValue, String objectName){

		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			driver.findElement(By.xpath(objXpath)).clear();
			driver.findElement(By.xpath(objXpath)).sendKeys(enterValue);
			System.out.println("Pass:  " + objectName + " "+ enterValue + " is entered in " + objectName + " field");
		}else{
			System.out.println("Fail: " + objectName +  " field does not exist in the application");
		}
	}

	/* Name of the method: clickButton
	 * Method Description: Click the button
	 * Arguments: objXpath --> Xpath of object, objectName --> Name of the Button
	 * Created by: Htan
	 * Creation Date: Mar 14 2014
	 * Last modified: Mar 14 2014
	 * */

	public static void clickButton(String objXPath, String objectName) throws InterruptedException
	{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())
		{
			driver.findElement(By.xpath(objXPath)).click();
			System.out.println("Pass: "+objectName+" button clicked");
		}
		else
		{
			System.out.println("Fail: "+objectName+" button does not exist, please check the application");
		}
	}

}


