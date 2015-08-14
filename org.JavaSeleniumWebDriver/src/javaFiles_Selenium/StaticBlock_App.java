package javaFiles_Selenium;

class StaticBlock_App {
	public static void main(String[] args) {
		System.out.println("Main method will always execute, after execution of all the static blocks which are there in the class.");
	}

	static{
		System.out.println("1st This will execute before main method");
	}

	static{
		System.out.println("2nd This will execute before main method");
	}

}
