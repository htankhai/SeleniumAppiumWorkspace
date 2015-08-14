package org.singleton;
//the singleton instance is created when the getInstance() method is called for the first time. 
//That ensures that singleton instances are created only when needed.
class Singleton {
	
	private static Singleton singleton = null ;
	//private static Singleton singleton =new Singleton();

	
	private Singleton(){} 

	// Static  method 
	//Calling static getInstance method creates the instance of singleton when needed.
	public static Singleton getInstance(){
		if(singleton == null){ 
			singleton = new Singleton();
			System.out.println("Create singeton instance");
		} 
		return singleton;
	}

	// Other protected methods  by singleton 
	protected static void demoMethod(){
		System.out.println("demoMethod for singleton"); 
	}
} 

