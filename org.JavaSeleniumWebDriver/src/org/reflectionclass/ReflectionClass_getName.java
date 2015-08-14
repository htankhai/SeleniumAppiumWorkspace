package org.reflectionclass;
class Simple {

}


class ReflectionClass_getName {
	public static void main(String args[]) throws ClassNotFoundException{  
		Class c=Class.forName("org.reflectionclass.Simple"); 
		// Class c= Simple.class;
		System.out.println(c.getName()); 
		
		Class c2 = boolean.class;   
		System.out.println(c2.getName());  

		Class c3 = ReflectionClass_getName.class;   
		System.out.println(c3.getName());  
		
	}  
}  

//forName() method of Class class
//is used to load the class dynamically.
//returns the instance of Class class.
//It should be used if you know the fully qualified name of class.This cannot be used for primitive types.
