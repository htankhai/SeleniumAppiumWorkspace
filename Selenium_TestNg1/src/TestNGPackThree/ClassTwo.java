package TestNGPackThree;

import org.testng.annotations.Test;

public class ClassTwo extends TestNGPackOne.BaseClassOne{
	  
	 @Test
	  public void testmethodone() {
	  driver.navigate().to("https://www.yahoo.com/");
	  String title = driver.getTitle();
	  System.out.print("\nCurrent page title is : "+title);
	 
	  String Workdir = System.getProperty("user.dir");
	  String Classpackname = this.getClass().getName();
	  System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
	  }

}
