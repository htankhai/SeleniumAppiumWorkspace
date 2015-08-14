package javaFiles_Selenium;
/** 
   This program asks the user to enter first, middle, and last names.
 */
import java.io.*;
import java.util.Scanner;

public class KeyboardInput{
	public static void main(String[] args) throws IOException	{
		String firstName,    // The user's first name
		middleName,   // The user's middle name
		lastName;     // The user's last name

		// Create the necessary objects to read keyboard input.
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(reader);

		// Ask the user to enter his or her first name.
		System.out.print("Enter your first name: ");
		firstName = keyboard.readLine();

		// Ask the user to enter his or her middle name.
		System.out.print("Enter your middle name: ");
		middleName = keyboard.readLine();

		// Ask the user to enter his or her last name.
		System.out.print("Enter your last name: ");
		lastName = keyboard.readLine();

		// Display a greeting.
		System.out.println("Hello " + firstName + " " + lastName);


		
		//Scanner class
		/*String firstName,    // The user's first name
		middleName,   // The user's middle name
		lastName;     // The user's last name

		Scanner keyboard = new Scanner(System.in);

		// Ask the user to enter his or her first name.
		System.out.print("Enter your first name: ");
		firstName = keyboard.nextLine();

		// Ask the user to enter his or her middle name.
		System.out.print("Enter your middle name: ");
		middleName = keyboard.nextLine();

		// Ask the user to enter his or her last name.
		System.out.print("Enter your last name: ");
		lastName = keyboard.nextLine();

		// Display a greeting.
		System.out.println("Hello " + firstName + " " + lastName);*/
		
		
		
		
		/*String name;   // To hold the user's name
		int age;       // To hold the user's age
		double monthlyIncome; // To hold the user's income

		// Create a Scanner object to read input.
		Scanner keyboard = new Scanner(System.in);

		// Get the user's name.
		System.out.print("What is your name? ");
		name = keyboard.nextLine();

		// Get the user's age.
		System.out.print("What is your age? ");
		age = keyboard.nextInt();

		// Get the user's income
		System.out.print("What is your annual income? ");
		monthlyIncome = keyboard.nextDouble();

		// Consume the remaining newline.
		keyboard.nextLine();

		// Display the information back to the user.
		System.out.println("Hello " + name + ", your age is " +
				age + " and your income is $" +
				monthlyIncome + " per month. -:)");*/
		

	}
}
