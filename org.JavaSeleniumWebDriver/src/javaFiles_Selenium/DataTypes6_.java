package javaFiles_Selenium;

public class DataTypes6_ {

	public static int getSwitch(String str){
		return (int) Math.round (Double.parseDouble(str.substring(1,str.length()-1)));
	}

	public static void main(String[] args)   {
		switch (getSwitch(args[0])){
		case 0: System.out.println("Hello");
		case 1: System.out.println("World"); break;
		default: System.out.println("Good Bye");
		}
	}
}