package coreJava;

public class MainClass {
	static int i = 1;

	static { i = i-- + --i; } //i = 1 + -1 = 0

	{ 	i = i++ - ++i;	} // i = 0 - 2 = -2 

	int methodOfTest() {
		return i + i - i * i / i;
	} // -2  + -2 - (-2*-2)/(-2) = -4 - (-4)/-2 = -4 - (-2) = -2

	public static void main(String[] args) {
		System.out.println(new MainClass().methodOfTest());
	}
}
