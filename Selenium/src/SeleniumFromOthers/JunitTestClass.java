package SeleniumFromOthers;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class JunitTestClass {
	WebDriver selenium ;

	@Before
	public void setUp(){
		selenium = new FirefoxDriver();
	}
}