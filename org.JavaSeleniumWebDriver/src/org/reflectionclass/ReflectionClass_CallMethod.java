package org.reflectionclass;

class Simple5{  
	 void message(){System.out.println("Hello Java");}  
	} 

public class ReflectionClass_CallMethod {
	public static void main(String args[]){  
		try{  
			Class c=Class.forName("org.reflectionclass.Simple5");  
			//Class c = Simple5.class;
			Simple5 s=(Simple5)c.newInstance();  
			s.message();  

		}catch(Exception e){System.out.println(e);}  

	}  
}
