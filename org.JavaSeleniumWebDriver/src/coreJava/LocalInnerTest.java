package coreJava;

public class LocalInnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();

		a.methodTwo();
	}

}

class A {
	void methodOne() {
		class LocalInnerClass {
			int i = 20;
		}

	}

	void methodTwo() {
		//compile time error. Local Inner class can not be used outside the method in which it is declared.
		System.out.println(new LocalInnerClass().i);
	}
}