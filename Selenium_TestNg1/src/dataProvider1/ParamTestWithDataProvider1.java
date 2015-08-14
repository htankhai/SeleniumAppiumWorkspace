package dataProvider1;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ParamTestWithDataProvider1 {
	private PrimeNumberChecker primeNumberChecker;

	@BeforeMethod
	public void initialize() {
		primeNumberChecker = new PrimeNumberChecker();
	}

	//Declare data provider.// parameters of xml or database. returns  2 D Object
	@DataProvider(name = "test1")
	public static Object[][] primeNumbers() {
		return new Object[][] { { 2, true }, { 6, false }, { 19, true },
				{ 22, false }, { 23, true } };
	}

	// This test will run 5 times since we have 5 parameters defined.//attribute dataProvider is mapped to test1
	//calling data provider
	@Test(dataProvider = "test1")
	public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
		System.out.println(inputNumber + " " + expectedResult);
		Assert.assertEquals(expectedResult,
				primeNumberChecker.validate(inputNumber));
	}
}

