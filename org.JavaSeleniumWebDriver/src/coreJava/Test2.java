package coreJava;
//Use instance variable of abstract class as parameter of method
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Y().methodTwoOfX(new Y().methodOneOfX());
	}

}

abstract class X {
	int i = 11;

	int methodOneOfX() {
		return i *= i /= i;
	}

	abstract void methodTwoOfX(int i);
}

class Y extends X {
	@Override
	void methodTwoOfX(int i) {
		System.out.println(i);
	}
}