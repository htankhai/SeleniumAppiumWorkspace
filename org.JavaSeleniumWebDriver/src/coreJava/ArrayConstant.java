package coreJava;

public class ArrayConstant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static final constant can't be reassigned
		a = new int[5];
	}

	static final int[] a;

	static
	{
		a = new int[] {1, 2, 3};
	}
}
