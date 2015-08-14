package datePicker_Jquery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DatePicker {
	WebDriver driver = new FirefoxDriver();
	By frameLocator = By.id( "datepicker") ;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	@Test
	public void jQueryCalendarMultipleMonths() {
		driver.navigate().to("http://jqueryui.com/resources/demos/datepicker/other-months.html");
		WebElement calElement=driver.findElement(frameLocator );
		wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator ));
		calElement.click();
		selectDatefromMultiDate("30");
	}

	public void selectDatefromMultiDate(String date) {
		By calendarXpath=By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+date+"']");
		//By calendarXpath=By.xpath("table//td/a[text()='"+date+"']");
		driver.findElement(calendarXpath).click();
	}

	}
