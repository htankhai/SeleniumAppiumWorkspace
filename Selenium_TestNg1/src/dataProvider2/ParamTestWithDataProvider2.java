package dataProvider2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ParamTestWithDataProvider2 
{
	//calling data provider
	@Test(dataProvider = "test2")
	public void testMethod(Bean myBean) {
		System.out.println(myBean.getVal() + " " + myBean.getI());//calls in order
	}

	//Declare data provider
	@DataProvider(name = "test2")
	public static Object[][] primeNumbers() {
		return new Object[][] { { new Bean("hi I am the bean", 101)} 
		};
	}

}
