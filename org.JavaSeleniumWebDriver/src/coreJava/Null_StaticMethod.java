package coreJava;

public class Null_StaticMethod {
	public static void main(String[] args) {
		A12 a = null;

		a.staticMethod();
	}
}

class A12 {
	static void staticMethod() {
		System.out.println("Static Method");
	}
}