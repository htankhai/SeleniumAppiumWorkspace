package selenium.screenshoot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;

class ScreenshootApp_ {
	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://aroraglobalservices.blogspot.in/");
		
		WebElement element = driver.findElement(By.xpath("//*[@id='Header1_headerimg']"));
		WrapsDriver wrapsDriver = (WrapsDriver) element;

		//Get the entire Screenshot from the driver of passed WebElement
		File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);

		//Create an instance of Buffered Image from captured screenshot
		BufferedImage img = ImageIO.read(screen);

		// Get the Width and Height of the WebElement using
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		System.out.println("width"+ width + "height" + height);

		//Create a rectangle using Width and Height
		Rectangle rect = new Rectangle(100, 100);

		//Get the Location of WebElement in a Point.
		//This will provide X & Y co-ordinates of the WebElement
		Point p = element.getLocation();

		//Create image by for element using its location and size.
		//This will give image data specific to the WebElement
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

		//Write back the image data for element in File object
		ImageIO.write(dest, "png", screen);
		FileUtils.copyFile(screen, new File("C:\\Users\\htan\\Screenshoot\\test.png"));
		
	}
}
