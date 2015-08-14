package expectedException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedExceptionTestAnnotation {
    String message = "Htan";	
    MessageUtil messageUtil = new MessageUtil(message);
	   
    @Test (expectedExceptions = ArithmeticException.class)
    public void testPrintMessage() {	
    	 System.out.println("Inside testPrintMessage()");     
        messageUtil.printMessage();     
   }
  
    @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Htan";
      Assert.assertEquals(message,messageUtil.salutationMessage());
   }
}