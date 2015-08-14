package testng_simple;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_Simple {
	@BeforeClass
	//@BeforeMethod
	public static void launchBrowser(){
		System.out.println("launching Browser..");
	}

	@Test
	public static void firstScript(){
		System.out.println("Running my first script...");
		String expt = "Hello";

		System.out.println("Before assert...");

		try{
			Assert.assertEquals("Hello", expt);
		} 
		catch(Throwable t){
			System.out.println(t);
		}

		System.out.println("After assert...");
	}

	@Test
	public static void secondScript(){
		System.out.println("Running my Second script...");
	}

	@Test
	public static void thirdScript(){
		System.out.println("Running my third script...");
	}
}
