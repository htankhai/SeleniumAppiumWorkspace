package listener_;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest {
	 @Test
	 public void loginwithvalidusername(){
	  System.out.println("Login with valid username");
	 }
	 @Test
	 public void loginwithinvalidusername(){
	  System.out.println("Login with invalid username");
	  //Use assertion and delibrately failed this
	 Assert.assertEquals("Equal", "NotEqual");
	 }

}
