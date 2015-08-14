package sort_search;
import java.util.Arrays;
import java.util.Scanner;

class BinarySearch_Number {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		Arrays.sort(array); //binary search will work on sorted array only so sort first
		
		int first, last, middle;
		first=0;
		last = size-1;
		middle = (first+last)/2;
		int i=0;
		for(; i<size; i++){
			if(search>array[middle]){
				first = middle+1;
			}else if(search<array[middle]){
				last = middle-1;
			}else{
				printArray(array);
				System.out.println("Element "+search+" found in the array.");
				break;
			}
			middle= (first+last)/2;
		}

		if(i==size){
			printArray(array);
			System.out.println("Element "+search+" is not found in the array");
		}
	}
	
	public static void printArray(int[] a){
		System.out.println("Array of elements: ");
		System.out.print("{");
		for(int i:a){
			System.out.print(i+",");
		}
		System.out.println("}");
	}
}


