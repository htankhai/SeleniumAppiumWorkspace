package coreJava;

public class superKeyword2 implements MyInterface {
	int i = 20;

	@Override
	public void myMethod() {
		//can’t access static fields through super keyword.
		System.out.println(super.i);
	}

}

interface MyInterface {
	int i = 10;

	void myMethod();
}