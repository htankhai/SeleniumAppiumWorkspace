package coreJava;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//== operator
		Operators  operator1 = new Operators(); 
		operator1.operator();

		//equals method
		Operators  operator_equals = new Operators(); 
		operator_equals.equalsMethod();

	}


	public void operator(){
		//Creating A-type object and assigning it to a1
		AA a1 = new AA();

		//Making a2 to point to same object as a1
		AA a2 = a1;

		//Applying "==" operator on a1 and a2. 
		System.out.println(a1 == a2);           

		//This will return true as a1 and a2 are pointing to same object in the memory.

		//Creating a new A-type object and assigning it to a2
		a2 = new AA();

		//Now, applying "==" opeartor on a1 and a2
		System.out.println(a1 == a2);        

		//Now, this will return false as a1 and a2 are pointing to different objects in the memory

	}

	class AA	{
		int i = 111;

		int j = 222;
	}


	class A {
		int i;

		int j;

		public A(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public boolean equals(Object obj) {
			A a = (A) obj;
			return this.i == a.i && this.j == a.j;
		}
	}

	public void equalsMethod(){
		//Creating A-type object and assigning it to a1
		A a1 = new A(10, 20);

		//Creating another A-type object and assigning it to a2
		A a2 = new A(10, 20);

		//comparing a1 and a2 using equals() method 
		System.out.println(a1.equals(a2));

		//This will return true as a1 and a2 satisfy the condition kept in equals method
		//Creating another A-type object and assigning it to a3

		A a3 = new A(30, 40);

		//comparing a1 and a3 using equals() method 
		System.out.println(a1.equals(a3));
		//Now, this will return false as a1 and a3 doesn't satisfy the condition used in equals method

	}
}
