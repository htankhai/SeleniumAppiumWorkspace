package sort_search;
// Demonstrate the selectionSort method in the Array
public class SelectionSort_{
   public static void main(String[] arg)   {
      int[] values = {5, 7, 2, 8, 9, 1};

      // Display the unsorted array.
      System.out.println("The unsorted values are:");
      for (int i = 0; i < values.length; i++)
         System.out.print(values[i] + " ");
      System.out.println();

      // Sort the array.
      selectionSort(values);

      // Display the sorted array.
      System.out.println("The sorted values are:");
      for (int i = 0; i < values.length; i++)
         System.out.print(values[i] + " ");
      System.out.println();

   }

   /**
      The selectionSort method performs a selection sort on an int array. 
      The array is sorted in ascending order.
      @param array The array to sort.
   */
   public static void selectionSort(int[] array)   {
      int startScan, index, minIndex, minValue;

      for (startScan = 0; startScan < (array.length-1); startScan++) {
    	  
         minIndex = startScan;
        
         //assign value as min value
         minValue = array[startScan];
         
         //index start counting from next to start scan to last index
         for(index = startScan + 1; index < array.length; index++) {
            if (array[index] < minValue) {
            	
            	//assign value of array [index] to min Value
               minValue = array[index];
               
               //assign index to min index
               minIndex = index;
            }
         }
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
      }
   }
}
