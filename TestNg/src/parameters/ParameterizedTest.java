package parameters;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

	@Test
	//parameters of  xml or properties
	@Parameters({"para1","para2", "para3", "para4"})
	public void passInput(String param1, String param2, String param3, double param4) throws InterruptedException {
		System.out.println("Parameterized value is : " + param1 + " " + param2
		+ " " +  param3 + " "+param4		);

	}
}