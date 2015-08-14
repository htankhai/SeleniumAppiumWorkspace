package coreJava;

public class StaticInitializerClass {
	 static
	    {
		 //Initializers should not return the control.
		 //compile time error
	        return;
	    }
}
