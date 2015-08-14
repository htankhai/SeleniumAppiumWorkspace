package coreJava;

import java.util.Scanner;

public class NearestNumber200 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First Number");
		int input1 = sc.nextInt();

		System.out.println("Enter Second Number");
		int input2 = sc.nextInt();

		System.out.println("Nearest to 200  : ");
		System.out.println(nearestTo200(input1, input2));
	}

	
	static int nearestTo200(int input1, int input2) {
		int diff1 = Math.abs(200 - input1);

		int diff2 = Math.abs(200 - input2);

		if(diff1 < diff2) {
			return input1;
		}
		else if (diff2 < diff1) {
			return input2;
		}
		else {
			return input1;
		}
	}
	
	}
