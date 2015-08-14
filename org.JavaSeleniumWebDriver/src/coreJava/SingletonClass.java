package coreJava;

public class SingletonClass {

	private static SingletonClass object = null;

	private SingletonClass() {
		//private constructor
	}

	public SingletonClass getObject() {
		if(object == null) {
			object = new SingletonClass();   //Creating object using private constructor
		}

		return object;
	}
}