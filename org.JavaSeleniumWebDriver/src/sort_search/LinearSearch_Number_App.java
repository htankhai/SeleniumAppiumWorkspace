package sort_search;
import java.util.Scanner;

class LinearSearch_Number_App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the array which should be greater than zero else it will throw InputMismatchException : ");
		int size = in.nextInt();
		int[] array = new int[size];

		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<size; i++){   
			array[i] = in.nextInt();
		}

		System.out.println("Enter the search element: ");
		int search = in.nextInt();

		int i=0;
		for(; i<size; i++){
			if(search==array[i]){
				printArray(array);
				System.out.println("Element "+search +" found in the array.");
				break;
			}
		}  

		//search element is not in the array element
		if(i==size){
			printArray(array);
			System.out.println("Element "+search +" is not found in the array.");
		}

	}
	
	public static void printArray(int[] a){
		System.out.print("Array of elements: {");
		for(int i:a){
			System.out.print(i+",");
		}

		System.out.println("}");
	}

}
