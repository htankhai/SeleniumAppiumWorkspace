package coreJava;

public class Null_ {
	public static void main(String[] args) {
	//Compile is successful. NullPointerException at run time
		Integer i = new Integer(null);

		//ambiguous situation call of constructors at compile time
		//String s = new String(null);

		
		
	}

}


//String(String original)
//String(StringBuffer buffer)
//String(StringBuilder builder)
