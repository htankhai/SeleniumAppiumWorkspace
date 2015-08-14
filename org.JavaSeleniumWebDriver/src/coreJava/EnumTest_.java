package coreJava;

public class EnumTest_ {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E.A.method();
		E.B.method();
		E.C.method();
	}

}

enum E {
	A(10) {
		@Override
		void method() {
			System.out.println("2");
		}
	},

	B(10, 20), C("Name");

	E(int a) {
		System.out.println(a);
	}

	E(int a, int b) {
		System.out.println(a);

		System.out.println(b);
	}

	E(String name) {
		System.out.println(name);
	}

	void method() {
		System.out.println("1");
	}
}