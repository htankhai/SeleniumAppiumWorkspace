package javaFiles_Selenium;
import java.util.Scanner;

class FloydTriangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows which you want in your Floyd Triangle: ");
        int rows = in.nextInt();
       
        int n=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                System.out.print(++n + " ");
            }
            System.out.println();
        }
	}
}