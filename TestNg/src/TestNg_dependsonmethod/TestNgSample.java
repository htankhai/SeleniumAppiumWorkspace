package TestNg_dependsonmethod;
//Sequence Test Cases
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNgSample {
	//sequence of test cases
	
	@Test
	public void TestLogin(){
		System.out.println(" in login method");
		String ex = "Hello";
		String xy = "hello";

		//Assertion TestNg
		//Assert.assertEquals(ex, xy);
		//Assert.assertEquals("Hello" , "hello");

		//Assert.assertTrue(2>10, " Any error msg");
		Assert.assertFalse(2>10, " No error msg");
	}
	
	
	@Test
	public void check1(){
		System.out.println(" Check1");
	}
	
	@Test(dependsOnMethods={"check1"})
	public void method1(){
		System.out.println(" Method 1");

	}
	@Test(dependsOnMethods={"check1" , "method1"})
	public void method2(){
		throw new SkipException("Skip Exception ");//skip test case
		//System.out.println(" Method 2");
	}
}
