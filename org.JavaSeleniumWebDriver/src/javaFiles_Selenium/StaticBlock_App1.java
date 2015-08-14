package javaFiles_Selenium;

class Super{
	static String ID = "Bank";
	}

class Sub extends Super{
	static {System.out.println("In Sub static");
	}

	{System.out.println("In Sub");}

	Sub(){
		System.out.println("constructor in Sub");

	}

	public String toString(){

		return "Return Static block and constructor";
	}

}

public class StaticBlock_App1 {
	public static void main(String[] args){
		System.out.println(Sub.ID);
		System.out.println(Super.ID);

		System.out.println(new Sub());
	}

}
