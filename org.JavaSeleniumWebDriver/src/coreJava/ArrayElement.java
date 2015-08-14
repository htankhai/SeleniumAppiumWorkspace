package coreJava;

public class ArrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[1];
		System.out.println(x[0]);

		//multi inheritance
		A[] a = {new A(), new B(), new C(), new D()};
		System.out.println(a[3].i);

		System.out.println(a[2].j);

		System.out.println(a[1].k);

		System.out.println(a[0].m);
	}

}


class A {
	int i = 10;
	int j = 30;
	int k = 50;
	int m = 60;
}

class B extends A {
	int j = 20;
}

class C extends B {
	int k = 30;
}

class D extends C {
	int m = 40;
}