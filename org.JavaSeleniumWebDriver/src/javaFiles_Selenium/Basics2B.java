package javaFiles_Selenium;
//static and instance block

class Basics2A {
	public Basics2A(){
		System.out.println("basics2A default constructor");
	}
	public Basics2A(int i)
	{
		System.out.println(i);
	}
}

class Basics2B {
	static  Basics2A s1 = new Basics2A(1);
	Basics2A a = new Basics2A(2);

	public static void main(String[] args){
		Basics2B b =new Basics2B();
		Basics2A a = new Basics2A(3);
	}
	static Basics2A s2 = new Basics2A(4);
}