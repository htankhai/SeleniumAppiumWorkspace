package sort_search;

//  write a program for linear search taken 5 i/p from user as linear elements.
import java.util.Scanner;
public class LinearSearchNumberApp {
	private static Object num;
	public static void main (String[] args) {

	
		Scanner s1 = new Scanner(System.in);
		int array[] = {};
		array = acceptIntArray();
		System.out.println("\nEnter the value to be searched:\t");
		num = s1.nextInt();
		linearSearch(array, (int) num);


	}

	public static int[] acceptIntArray() {
		int num;
		System.out.println("\nHow many numbers do you want to enter?");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		int numbers[] = new int[num];
		for (int i=0; i<num; i++) {
			System.out.println("\nPlease enter number " + (i+1) + "\t");
			numbers[i]= input.nextInt();
		}
		System.out.println("The entered numbers are: ");
		for (int i=0; i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		return numbers;
	}

	public static void linearSearch(int[] array, int search) {
		int i;
		for( i=0; i<array.length; i++) {
			if(array[i] == search) {
				System.out.println(search + " found at position " + (i+1) + " of the list.");
				break;
			}
		}
		if (i==array.length){
			System.out.println("The " + search + " does not exist in the list.");
		}
	}

}


