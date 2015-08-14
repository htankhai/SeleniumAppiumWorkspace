package coreJava;

public class UserDefinedClass_Field {
	public static void main(String[] args) {
		class B extends A9		{
			//A9 object need to initialized
			A9 a;

			public B(int i) {
				super(i);
			}
		}

		System.out.println(new B(50).a.i);
	}
}

class A9 {
	int i;

	public A9(int i) {
		this.i = i;
	}
}