package coreJava;

public class OverloadingMethods {
	void method(int i) {
		System.out.println(1);
	}

	void method(Integer I) {
		System.out.println(2);
	}

	void method(Number N) {
		System.out.println(3);
	}

	void method(Object O) {
		System.out.println(4);
	}

	void method(double d) {
		System.out.println(5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadingMethods t = new OverloadingMethods();
		t.method(10.04f);
		t.method(new Short("10"));
		t.method("JAVA");
		t.method(new Double(54.23));
		t.method('J');

	}

}
