package jcpenney;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestScript extends projectFunction{

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void LoginJcp() throws IOException, InterruptedException {
		driver = new FirefoxDriver();
		String recData[][] = null;
		String DataTablePath = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/GlobalDataSheet.xls";
		recData = projectFunction.readSheet(DataTablePath, "Sheet1");

		String URL = recData[1][1];
		String UN = recData[1][2];
		String pwd = recData[1][3];
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		clickObject("//*[@id='coldState']/ul/li[5]/a","Sign in");

		//enter email
		enterText("//*[@id='emailidLogin']", UN , "emailidLogin");

		/*Enter Password*/
		enterText("//*[@id='mypasswdLogin']", pwd, "mypasswdLogin");

		/*Click Login*/
		clickObject("//*[@id='loginSubmit']", "loginSubmit");

		driver.quit();
	}

	public static void SearchShirts() throws IOException, InterruptedException{
		//Launch URL
		String recData1[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/GlobalDataSheet.xls";
		recData1 = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String URL = recData1[1][1];
		String UN = recData1[1][2];
		String pwd = recData1[1][3];

		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Update_Report("Pass", "Launch URL", "Launch URL");

		//Search product
		String recData2[][] = null;
		String DataTablePath2 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/SearchShirts.xls";
		recData2 = projectFunction.readSheet(DataTablePath2, "Sheet1");
		String shirts = recData2[1][1];

		//Search shirts
		enterText("//input[@id='searchTerm']", shirts, "searchTerm");
		clickObject("//*[@id='searchbutton']","searchbutton");	

		Alert newAlert =  driver.switchTo().alert();
		newAlert.dismiss();
		//Gender-mens shirts
		clickObject("//*[@id='507']", "Gender mens");

		//Product type- shirts + tops
		clickObject("//*[@id='4294965755']", "shirts + tops");

		//Item Type of shirts and tops product
		clickObject("//*[@id='4294964845']", "button-front");
		
		//size range of product
		clickObject("//*[@id='1750']", "regular");
		
		//particular size of product
		clickObject("//*[@id='405']", "Medium");
		
		//color of product
		clickObject("//*[@id='1402']","blue");
		
		//Brand of product
		clickObject("//*[@id='281']", "Van Heusen");
		
		//Sleeve Length- long or short
		clickObject("//*[@id='2119']", "long sleeve");
		
		//Pattern of product
		clickObject("//*[@id='4294966859']", "Plaid Pattern");
		
		//Price-range of product 
		clickObject("//*[@id='1511']", "$10-$19");
		
		//Averagae-rating
		clickObject("//*[@id='909']", "5-rating");
		
		//Available
		clickObject("//*[@id='834']","Available online");
		driver.close();
	}

	public static void SearchMensShirts() throws IOException, InterruptedException{
		//Launch URL
		String recData1[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/GlobalDataSheet.xls";
		recData1 = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String URL = recData1[1][1];
		String UN = recData1[1][2];
		String pwd = recData1[1][3];

		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Update_Report("Pass", "Launch URL", "Launch URL");

		//Search item
		String recData2[][] = null;
		String DataTablePath2 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/SearchMensShirts.xls";
		recData2 = projectFunction.readSheet(DataTablePath2, "Sheet1");
		String Mensshirts = recData2[1][1];

		//Search shirts
		enterText("//input[@id='searchTerm']", Mensshirts, "searchTerm");
		clickObject("//*[@id='searchbutton']","searchbutton");	

		//Product type- sweater
		clickObject("//*[@id='4294964228']", "sweater");

		//Item Type
		clickObject("//*[@id='4294964229']", "cardigan");

		//size range
		clickObject("//*[@id='1750']", "regular");

		//particular size
		clickObject("//*[@id='412']", "large");

		//color
		clickObject("//*[@id='1402']","blue");

		//Brand
		clickObject("//*[@id='146']", "Arizona");

		//Price-range
		clickObject("//*[@id='1512']", "$20-$29");

		//Averagae-rating
		clickObject("//*[@id='910']", "4-rating");

		//Available
		clickObject("//*[@id='834']","Available online");

		driver.close();



	}

	public static void CheckMens() throws InterruptedException, IOException{ 
		//Launch URL
		String recData1[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/GlobalDataSheet.xls";
		recData1 = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String URL = recData1[1][1];
		String UN = recData1[1][2];
		String pwd = recData1[1][3];

		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Update_Report("Pass", "Launch URL", "Launch URL");

		//Men Category
		clickObject("//*[@id='topmenu']/li[5]/a", "men section");


		//Shop Clothing
		clickObject("//*[@id='side_navigation']/ul/li[8]/a", "casual button down shirt");

		//regular 
		clickObject("//*[@id='1750']", "regular");
		
		//medium
		clickObject("//*[@id='405']", "Medium");

		//sleeve-length
		clickObject("//*[@id='2119']", "long sleeve");

		//Brand
		clickObject("//*[@id='1260']", "claiborne");

		//Color
		clickObject("//*[@id='1405']","white");

		//sales and promotion
		clickObject("//*[@id='1850']", "sale");

		//price range
		clickObject("//*[@id='1511']", "$10-$19");

		driver.quit();


	}


	public static void CheckCategories() throws IOException, InterruptedException{
		//Launch URL
		String recData1[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/JcpenneyFramework/DataFolder/GlobalDataSheet.xls";
		recData1 = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String URL = recData1[1][1];
		String UN = recData1[1][2];
		String pwd = recData1[1][3];

		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Update_Report("Pass", "Launch URL", "Launch URL");

		//for the home category
		clickObject("//*[@id='first_department']", "for the home");

		//furniture section 
		clickObject("//*[@id='side_navigation']/ul/li[3]/a", "furniture");

		//sofa product
		clickObject("//*[@id='side_navigation']/ul/li[3]/a", "sofa");

		//leather of product
		clickObject("//*[@id='4294966445']", "leather");

		//brown of sofa
		clickObject("//*[@id='1407']","brown");

		//features of sofa
		clickObject("//*[@id='4294966903']","upholstered");

		//price range of sofa
		clickObject("//*[@id='1519']", "over $699");

		//Deals and promotions shopping 
		clickObject("//*[@id='1850']","sale");

		clickObject("//*[@id='ppThumbnailImagepp5003560835']", "Leather Possibilities Track-Arm 84");
		clickObject("//*[@id='img3pp5003560835']/a/img", "Mink color");
		
		//Bed and Bath Category
		clickObject("//*[@id='topmenu']/li[2]/a", "bed and bath");

		//BATH TOWELS Section
		clickObject("//*[@id='side_navigation']/ul/li[17]/a", "bath towels");

		//bath towels product
		clickObject("//*[@id='4294964869']","bath towels");

		//color
		clickObject("//*[@id='1411']","beige");

		//Features of product
		clickObject("//*[@id='4294965330']","monogrammable ");

		//Brand of product
		clickObject("//*[@id='1584']","jcpenney home");

		//Average Rating of product
		clickObject("//*[@id='910']","4ratings");
		clickObject("//*[@id='ppThumbnailImagepp5002351376']","choose from img");
		clickObject("//*[@id='img9pp5002351376']/a/img", "Linen");
			driver.quit();

	}
}
