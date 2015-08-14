package coreJava;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
	}

}

class A
{
	static String s = "AAA";

	static
	{
		s = s + "BBB";
	}

	{
		s = "AAABBB";
	}
}

class B extends A
{
	static
	{
		s = s + "BBBAAA";
	}

	{
		System.out.println(s);
	}
}