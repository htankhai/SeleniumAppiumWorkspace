package coreJava;

public class StaticInstanceInitializationBlock {
	public static void main(String[] args) {
		B13 b = new B13();

		System.out.println(b.i);
	}
}

class A13 {
	static int i = 1111;

	static {
		i = i-- - --i;
		System.out.println("i in static A13 " + i);
	}//i = 1111 - 1109 = 2 

	{
		i = i++ + ++i;
		System.out.println("i in instance initialize block " + i );
	} // i = 0 +  2 = 2  
}

class B13 extends A13 {
	static {
		i = --i - i--;
		System.out.println("B13 static i is " + i );
	} // i = 1 - 1 = 0

	{
		i = ++i + i++;
		System.out.println("Final i value in B13 is " + i );
	} // i = 3 + 3 = 6
}