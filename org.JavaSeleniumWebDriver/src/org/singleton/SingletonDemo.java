package org.singleton;
 class SingletonDemo {
	public static void main(String[] args)	{ 
		Singleton single = Singleton.getInstance(); 
		
		Singleton.getInstance(); 
		
		single.demoMethod(); 
		
		Singleton.demoMethod();
	}
}
