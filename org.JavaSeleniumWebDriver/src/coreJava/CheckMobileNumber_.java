package coreJava;
//checks whether mobile number entered by user has 10 digits only.
import java.util.Scanner;

public class CheckMobileNumber_ {
	public static void main(String[] args) {
		System.out.println("Enter your mobile number : ");

		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		if(UtilityNumber.isNumber(input) && (input.length() == 10)) {
			System.out.println("Good!!! You have entered valid mobile number");
		}
		else {
			System.out.println("Sorry!!!! You have entered invalid mobile number. Try again...");
		}
	}
}

class UtilityNumber {
	static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
		}
		catch(NumberFormatException ex) {
			return false;
		}
		return true;
	}
}