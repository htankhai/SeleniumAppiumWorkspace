package coreJava;

public class ArrayasParameter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];

		method_One(a);
		System.out.println(a.length);
		
		
		//Create array and pass as parameter of method
		 Double[] D = {10.55, 25.36, 58.29, 74.32, 32.21};
		 	        D = methodOne(D);
	 	        System.out.println("First element of D in main method is " +D[1]);
	}

	static void method_One(int[] a) {
		int[] b = new int[5];
		a = b;

		System.out.print(a.length);
		System.out.print(b.length);
	}
	
	
	static Double[] methodOne(Double[] D) {
        D[1] = 36.25;
        System.out.println("First element of D is " +D[1]);
        return methodTwo(D);
    }
 
    static Double[] methodTwo(Double[] D) {
        D[1] = 62.36;
        System.out.println("First element of D is " +D[1]);
        return methodThree(D);
    }
 
    static Double[] methodThree(Double[] D) {
        D[1] = 93.58;
        System.out.println("First element of D is " +D[1]);
        return D;
    }
 
}
