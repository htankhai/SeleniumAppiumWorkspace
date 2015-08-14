package coreJava;

public class OverloadingMethodTest {
	void methodOfTest(int i) {
		System.out.println(1);
	}

	void methodOfTest(Integer I) {
		System.out.println(2);
	}

	void methodOfTest(Object o) {
		System.out.println(3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadingMethodTest t = new OverloadingMethodTest();

		t.methodOfTest(10);

		t.methodOfTest(10.25);

		t.methodOfTest(new Double("25.25"));
	}

}
