package group;
import org.testng.annotations.Test;

public class GroupDemo {

	@Test (groups={"Regression"})
	public void register(){
		System.out.println("Registration done");
	}
	
	@Test (groups={"Smoke"})
	public void login(){
		System.out.println("Login done");
		System.out.println("Smoke Scenario passed");
	}
}


