package coreJava;
//Interfaces shouldn’t have static initialization block, instance initialization block and constructors.
public interface MyInterface {
	static
    {
        System.out.println("Static Initialization Block");
    }
 
    {
        System.out.println("Instance Initialization Block");
    }
 
    MyInterface()
    {
        System.out.println("Constructor");
    }
}
