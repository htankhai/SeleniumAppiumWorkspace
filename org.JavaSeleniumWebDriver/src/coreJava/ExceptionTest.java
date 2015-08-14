package coreJava;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A6[] a = {new A6(), new C6(), new B6(), new C6(), new A6()};

		// java.lang.ArrayStoreException
		B6[] b = new B6[a.length];

		System.arraycopy(a, 0, b, 0, a.length);
	}

}

class A6
{
	int i = 10;
}

class B6 extends A6
{
	int j = 20;
}

class C6 extends B6
{
	int k = 30;
}