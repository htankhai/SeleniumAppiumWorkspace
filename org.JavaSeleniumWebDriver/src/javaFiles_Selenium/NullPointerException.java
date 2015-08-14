package javaFiles_Selenium;

public class NullPointerException {
	public static void main (String args[]) throws Exception{
		int[]  a = null;
		int i = a [m1()];

		
		//java.lang.NullPointerException
		/*try {
			RuntimeException re = null;
			throw re;
		}
		catch (Exception e){
			System.out.println(e);
		}*/

	}

	public static int m1() throws Exception{
		throw new Exception ("Some Exception");
	}

}