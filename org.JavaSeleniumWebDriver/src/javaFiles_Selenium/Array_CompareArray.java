package javaFiles_Selenium;
//compare the content of the two arrays with equals method
import java.util.Scanner;

class Array_CompareArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of string array: ");
		int size = in.nextInt();

		String[] array1 = new String[size];
		String[] array2 = new String[size];

		System.out.println("enter the element of 1st string array: ");
		for(int i=0; i<size; i++){
			array1[i] = in.next();
		}

		System.out.println("enter the element of 2nd string array: ");
		for(int i=0; i<size; i++){
			array2[i] = in.next();
		}

		String s1="", s2 ="";
		for(int i=0; i<size; i++){
			s1 = s1+array1[i];
			s2 = s2+array2[i];
		}

		if(s1.equals(s2)){
			System.out.println("both the array have same elements.");
			System.out.println(s1);
			System.out.println(s2);
		}else{
			System.out.println("both the array does not have the same elements.");
			System.out.println(s1);
			System.out.println(s2);
		}
	}

}
