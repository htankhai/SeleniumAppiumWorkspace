package javaFiles_Selenium;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
   This program demonstrates a two-dimensional array.
 */
public class CorpSales{
	public static void main(String[] args)	{
		final int DIVS = 2; // Two divisions in the company
		final int QTRS = 4; // Four quarters
		double totalSales = 0.0;  // Accumulator

		// Create an array to hold the sales for each division, for each quarter.
		double[][] sales = new double[DIVS][QTRS];

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		System.out.println("This program will calculate the total sales of");
		System.out.println("all the company's divisions. " +"\nEnter the following sales data:");

		// Nested loops to fill the array with quarterly sales figures for each division. individual element of array
		for (int div = 0; div < DIVS; div++)		{
			for (int qtr = 0; qtr < QTRS; qtr++)			{
				System.out.print("Division " + (div + 1) +
						", Quarter " + (qtr + 1) + ": $");
				sales[div][qtr] = keyboard.nextDouble();
				System.out.println("\t\t $" +sales[div][qtr] );
			}

			System.out.println(); 
		}


		//Sales in table range
		System.out.println("Sales in two divisions ");
		//display sales in array
		for (int div = 0; div < DIVS; div++) {
			for (int qtr = 0; qtr < QTRS; qtr++)
				System.out.print(sales[div][qtr] + "\t");
			System.out.println();
		}


		//total sales in the company
		// Nested loops to add all the elements of the array.
		for (int div = 0; div < DIVS; div++)
		{
			for (int qtr = 0; qtr < QTRS; qtr++)
			{
				totalSales += sales[div][qtr];
			}
		}

		// Create a DecimalFormat object to format output.
		DecimalFormat dollar = new DecimalFormat("#,##0.00");

		// Display the total sales.
		System.out.println("The total sales for the company " +
				"are $" + dollar.format(totalSales));

		showArray(sales);
		arrayTotal(sales);
	}

	//Sales in two division display in array
	private static void showArray(double[][] array) {
		for (int row = 0; row < array.length; row++)		{
			for (int col = 0; col < array[row].length; col++)
				System.out.print(array[row][col] + " ");
			System.out.println();
		}
	}

	private static int arrayTotal(double[][] sales)	{
		int total = 0;   // Accumulator

		for (int row = 0; row < sales.length; row++) {
			for (int col = 0; col < sales[row].length; col++)
				total += sales[row][col];
		}

		return total;
	}
}