package coreJava;
//extend the InnerClass of OuterClass
//The constructor of a class which is extending InnerClass must give a call to constructor of InnerClass explicitly through OuterClass instance. 

public class A2 extends OuterClass.InnerClass{

	public A2() {
        new OuterClass().super();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class OuterClass {
    class InnerClass {
        //Inner Class
    }
}