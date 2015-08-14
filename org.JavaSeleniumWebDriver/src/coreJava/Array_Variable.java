package coreJava;

public class Array_Variable {
	public static void main(String[] args) {
        D[][][][] d = {{{{new D()}}}};
 
        System.out.println(d[0][0][0][0].c.b.a.i);
        
        
        int[] a = {1};
        
        int[] b[] = {{1}};
 
        int[][] c[] = {{{1}}};
 
        int[][] dd [][] = {{{{1}}}};
        System.out.println("Succeed run in arrays");
               
    }
}

class A10 {
    int i = 55;
}
 
class B10 {
    A10 a = new A10();
}
 
class C10 {
    B10 b = new B10();
}
 
class D {
    C10 c = new C10();
}