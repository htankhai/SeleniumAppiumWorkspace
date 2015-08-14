package coreJava;

public class MethodCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(methodOne(11));
	}

	static int methodOne(int i) {
		return methodTwo(i *= 11);
	}//i = 121

	static int methodTwo(int i) {
		return methodThree(i /= 11);
	} //i = 11

	static int methodThree(int i) {
		return methodFour(i -= 11);
	} //i = 0

	static int methodFour(int i) {
		return i += 11;
	} // i = 11
}
