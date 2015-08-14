package org.reflectionclass;

class Simple2{} 

class CodeSimple{}

public class ReflectionClass_getClass {
	void printName(Object obj){  
		Class c = obj.getClass();    
		System.out.println(c.getName());  

	}  

	public static void main(String args[]){  
		Simple2 s=new Simple2();  
		CodeSimple cs= new CodeSimple();

		ReflectionClass_getClass t=new ReflectionClass_getClass ();  
		t.printName(s);  


		t.printName(cs);

	}  
}

//getClass() method of Object class returns the instance of Class class. It should be used if you know the type
// used with primitives