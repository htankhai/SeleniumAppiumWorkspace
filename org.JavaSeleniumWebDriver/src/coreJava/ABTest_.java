package coreJava;

public class ABTest_ {
	public static void main(String[] args) {
	       A4 a = new A4();
	 
	       B4 b = new B4();
	 
	       a.b = b;
	 
	       b.a = a;
	 
	       System.out.println(a.b.a.b.a.i);
	 
	       System.out.println(b.a.b.a.b.i);
	   }
}

class A4 {
    B4 b;
 
    int i = 10;
}
 
class B4 {
    A4 a;
 
    int i = 20;
}
 