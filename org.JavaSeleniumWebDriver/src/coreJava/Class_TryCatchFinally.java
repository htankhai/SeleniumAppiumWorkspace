package coreJava;

public class Class_TryCatchFinally {
	static
	{
		try {
			throw new Exception();
		}
		catch(Exception ex) {
			System.out.println(1);
		}
		finally {
			System.out.println(2);
		}
	}

	public static void main(String[] args) {
		Class_TryCatchFinally  ctcf = new Class_TryCatchFinally();
	}
}
