package coreJava;

public class MethodsTest {
	public static void main(String[] args) {
		A3 a = new A3();

		System.out.println(a.methodOne(a.methodTwo(21.71)));
	}
}

class A3 {
	byte methodOne(long l) 	{
		return (byte)methodTwo(l);
	}

	long methodTwo(double d) {
		return (long)d;
	}
}