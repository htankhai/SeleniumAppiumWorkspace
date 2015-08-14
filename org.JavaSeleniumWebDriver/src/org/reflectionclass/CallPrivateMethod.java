package org.reflectionclass;
import java.lang.reflect.Method; 

public class CallPrivateMethod {
	public static void main(String[] args)throws Exception{  

		//load the class
		Class c = Class.forName("org.reflectionclass.A");  
		//Class c=A.class;
		System.out.println(c.getName());
		
		//create new instance of the class
		Object obj= c.newInstance();  
		
		//declare method class instance
		Method m =c.getDeclaredMethod("message", null);  
		
		//set access of the method
		m.setAccessible(true);  
		
		//invoke the method
		m.invoke(obj, null);  
	}  
}


//public Method getDeclaredMethod(String name,Class[] parameterTypes)
//public Object invoke(Object method, Object... args)