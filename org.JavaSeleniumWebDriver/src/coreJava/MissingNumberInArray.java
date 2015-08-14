package coreJava;

public class MissingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;

		int[] a = {1, 4, 5, 3, 7, 8, 6};

		int sumOfNnumbers = sumOfNnumbers(n);

		int sumOfElements = sumOfElements(a);

		int missingNumber = sumOfNnumbers - sumOfElements;

		System.out.println("Missing Number is = "+missingNumber);

	}

	//Method to calculate sum of 'n' numbers

	static int sumOfNnumbers(int n) {
		int sum = (n * (n+1))/ 2;

		return sum;
	}//72/2

	//Method to calculate sum of all elements of array

	static int sumOfElements(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) 	{
			sum = sum + array[i];
		}

		return sum;
	}
}
