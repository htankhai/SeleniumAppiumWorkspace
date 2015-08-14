package coreJava;

import java.util.Scanner;

/*There are two numbers ‘a’ and ‘b’.
 * print ‘a’ if ‘a’ is bigger than ‘b’ by 2 or more or should print ‘b’ if ‘b’ is bigger than ‘a’ by 2 or more. 
 * Otherwise, it should print “INCONCLUSIVE”
 */

public class LargerNumber {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First number");

		int a = sc.nextInt();

		System.out.println("Enter Second Number");

		int b = sc.nextInt();

		if((a > b) && (a - b) >= 2)
		{
			System.out.println(a);
		}
		else if ((b > a) && (b - a) >=2)
		{
			System.out.println(b);
		}
		else
		{
			System.out.println("INCONCLUSIVE");
		}
	}
}
