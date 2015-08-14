package coreJava;

public class MainMethod {
	/*public static void main(String[] args) {
		System.out.println("Execution starts from this method");
	}

	void main(int args) {
		System.out.println("Another main method");
	}

	double main(int i, double d) {
		System.out.println("Another main method");

		return d;
	}*/

	//public the main() method is accessible to JVM.
	//compilation will be successful but you will get run time error as no main method found.
	/*private static void main(String[] args) {
        //Run time error
    }*/

	/*public void main(String[] args)  {
        System.out.println(1);        
        //Run time error without static modifier
    }*/

	//can't change the return type void in main method
	/*public static int main(String[] args) {
		return 1;    //run time error : No main method found
	}*/

	//can accept var args as parameter
	public static void main(String... args)
    {
        //Var args as an argument
    }

}
