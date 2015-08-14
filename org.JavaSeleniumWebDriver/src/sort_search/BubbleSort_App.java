package sort_search;
// write a program to bubble sort taken 6 i/p from user as bubble elements.

public class BubbleSort_App {
	public static void main (String[] args){

		int[] intArray = {22,44,56,33,12,35};
		BubbleSort(intArray);
	}

	public static void BubbleSort(int[] array) {
		int temp,l;
		l = array.length;

		for(int i=0;i<l-1;i++) {
			for(int j=0;j<l-1;j++) {
				if(array[j]> array[j+1]) {
					temp= array[j];
					array[j]= array[j+1];
					array[j+1]=temp;
				}
			} 
		}

		System.out.println("The bubble sorted numbers are: ");
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i] + "\t");
		}
	}

}
