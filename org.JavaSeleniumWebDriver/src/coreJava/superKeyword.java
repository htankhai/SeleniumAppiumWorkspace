package coreJava;

public class superKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B8 b = new B8(100);

		System.out.println(b.i);
	}

}

class A8 {
	int i;

	public A8 (int i) {
		this.i = i;
	}
}

class B8 extends A8 {
	int i = 20;

	public B8(int i) {
		super(i);
	}

	{
		this.i = super.i;
	}
}