package coreJava;

public class ReThrowExceptionTest {
	public static void main(String[] args)
	   {
	      A5 a = new A5();
	 
	      a.methodOfA();
	 
	      System.out.println("Done");
	   }
}

class A5{
    void methodOfA()
    {
        try
        {
            int[] a = new int[-5];
        }
        catch(Exception ex)
        {
        	// re-thrown exception is not caught.
            throw ex;
        }
    }
}