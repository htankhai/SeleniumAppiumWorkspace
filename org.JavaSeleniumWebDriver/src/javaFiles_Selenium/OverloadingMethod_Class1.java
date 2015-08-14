package javaFiles_Selenium;

public class OverloadingMethod_Class1 {
	void probe(int... x) { 
		System.out.println("In int...");
	}

	void probe(Integer  x) { 
		System.out.println("In Integer ");
	}

	void probe(long  x) { 
		System.out.println("In long ");}

	void probe(Long  x) { 
		System.out.println("In Long ");
	}

	public static void main (String[] args) {
		Integer a = 4;
		new OverloadingMethod_Class1().probe(a);

		int b = 4; 
		new OverloadingMethod_Class1().probe(b);

		int[] c ={ 4,  20}; 
		new OverloadingMethod_Class1().probe(c);

	}
}
