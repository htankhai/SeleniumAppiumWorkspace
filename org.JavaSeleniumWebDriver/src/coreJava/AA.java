package coreJava;

public class AA {
	int m;

	double n;

	public AA(int i) {
		m = i;
	}

	public AA(double d) {
		n = d;
	}

	{
		System.out.println(m);

		System.out.println(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA a1 = new AA(500);

		AA a2 = new AA(50.0);

		System.out.println(a1.m+" : "+a1.n);

		System.out.println(a2.m+" : "+a2.n);
	}

}
