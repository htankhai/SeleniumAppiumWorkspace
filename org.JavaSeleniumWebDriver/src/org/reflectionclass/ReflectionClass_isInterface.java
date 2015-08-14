package org.reflectionclass;

class Simple4{}  

interface My4{} 

public class ReflectionClass_isInterface {
	public static void main(String args[]){  
		try{  
			Class c2=Class.forName("org.reflectionclass.My4");  
			//Class c2 =My4.class;
			System.out.println(c2.isInterface());  

			Class c=Class.forName("org.reflectionclass.Simple4"); 
			//Class c = Simple4.class;
			System.out.println(c.isInterface());  


		}catch(Exception e){
			System.out.println(e);}  

	}  
}
