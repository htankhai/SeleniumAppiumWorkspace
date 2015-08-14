package Log4JGoogle;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLog   {
	public static void main(String[] args){{
		// Here we need to create logger instance so we need to pass Class name for which we want to create log file in my case Google is classname
		Logger logger=Logger.getLogger("Google.class");

		PropertyConfigurator.configure("Log4j.properties");

		WebDriver driver = new HtmlUnitDriver();
		logger.info("Browser Opened");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Implicit wait given");

		driver.get("https://www.google.com/?gws_rd=ssl");
		logger.info("Url opened");

		driver.findElement(By.name("q")).sendKeys("Selenium");
		logger.info("keyword type");   

		logger.trace("Trace Message!");
		logger.debug("Debug Message!");
		logger.info("Info Message!");
		logger.warn("Warn Message!");
		logger.error("Error Message!");
		logger.fatal("Fatal Message!");

		/*driver.findElement(By.id("text1")).sendKeys("My First Name");
		logger = Logger.getLogger(Google.class);
		logger.info("Type In Text field.");
		Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
		mydrpdwn.selectByVisibleText("Audi");
		logger = Logger.getLogger(Google.class);
		logger.info("Select value from drop down.");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));*/

	}
	}
}


//public static Logger getLogger(String name);//returns the application instance's root logger//passing the name of the logger usually a class or a package name