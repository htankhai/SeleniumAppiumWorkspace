package coreJava;
//Cyclic hierarchy is not allowed in java.
public class CyclicHierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class A11 extends C
{

}

class B extends A11
{

}

class C extends B
{

}