package window;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindows {

	static WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() {
		driver = new FirefoxDriver();
		// It will open Naukri website with multiple windows
		driver.get("http://www.naukri.com/");

		// To get the main window handle
		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle(driver);
		
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
	}

	public String getMainWindowHandle(WebDriver driver) {
		System.out.println("Main window  : " + driver.getWindowHandle());
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		System.out.println("Main window title " + windowTitle );
		return windowTitle;
	}

	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindow) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All window :  " + allWindowHandles);
		
		//Keep main window and close open windows
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(openWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close();
			}
		}

		//switch back to main window
		driver.switchTo().window(openWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}


}
