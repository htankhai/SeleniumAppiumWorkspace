package coreJava;

public class ArrayObjectType {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//arrayObject1();
		arrayObject2();
	}

	public static void arrayObject1(){
		int[] a = new int[3];

		a[1] = 50;

		Object o = a;

		int[] b = (int[])o;

		b[1] = 100000;

		System.out.println(a[1]);

		((int[])o)[1] = 500000;

		System.out.println(a[1]);

	}

	public static void arrayObject2(){
		int[][] a = {{1,2,}, {3,4}};

		//1D array
		int[] b = (int[]) a[1];

		Object o1 = a;

		int[][] a2 = (int[][]) o1;

		//2D array
		int[][] b2 = (int[][]) o1;

		System.out.println(b[1]);
	}
}
