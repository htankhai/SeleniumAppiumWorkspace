package array;
public class Arrayintegerdouble 
{
	public static void main(String[] args) 
	{
		//Create, initialize and process arrays
		double[] myList ={1.9,2.9,3.4,3.5}; 

		// Print all the array elements 
		System.out.println("Double elements :");
		for(int i =0; i < myList.length; i++){
			System.out.print(myList[i]+" ");
		} 
		System.out.println();

		// Print all the array elements with enhanced for loop
		System.out.print("Double elements in for loop : ");
		for(double element: myList){ 
			System.out.print(element + " ");
		}

		System.out.println();
		
		printArray(new int[]{3,1,2,6,4,2});
		System.out.println();

		// Summing all elements 
		double total = 0; 
		for(int i =0; i < myList.length; i++){
			total += myList[i];
		} 
		System.out.println("\nTotal is "+ total); 

		// Finding the largest element 
		double max = myList[0]; 
		for(int i =1; i < myList.length; i++){ 
			if(myList[i]> max) 
				max = myList[i];
		} 
		System.out.println("Max number is "+ max);
	}

	public static void printArray(int[] array){
		System.out.println("Integer elements : ");
		for(int i =0; i < array.length; i++){ 
			System.out.print( array[i]+" "); 
		}
	}

}
