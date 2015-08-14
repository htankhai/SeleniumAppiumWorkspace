package coreJava;
// super() and then instance initializers are executed before any statements in the constructors at first.
public class ExceptionTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A7 a = new A7("123");
	}

}

class A7 {
	int i;

	String s;

	{
		try
		{
			//java.lang.NumberFormatException
			this.i = Integer.parseInt(s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public A7(String s) {
		this.s = s;
	}
}