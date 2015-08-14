package org.reflectionclass;
import java.lang.reflect.*;
public class CallPrivateMethod2 {
	public static void main(String args[])throws Exception{  
		Class c=A.class;  
		System.out.println(c.getName());

		Object obj=c.newInstance();  

		Method m=c.getDeclaredMethod("cube",new Class[]{int.class});  
		m.setAccessible(true);  
		m.invoke(obj,4);  
	}
}


//public Method getDeclaredMethod(String name,Class[] parameterTypes)
//public Object invoke(Object method, Object... args)