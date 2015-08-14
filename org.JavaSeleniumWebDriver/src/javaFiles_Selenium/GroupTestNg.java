package javaFiles_Selenium;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.testng.annotations.Test;

public class GroupTestNg {

	//program reads the first and second line from a file.

	@Test(enabled=false)
	public void ReadFirstSecondLine() throws IOException
	{
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		 /*// Create the necessary objects for keyboard input.
	      InputStreamReader reader = new InputStreamReader(System.in);
	      BufferedReader keyboard = new BufferedReader(reader);
		// Get the number of lines.
	      System.out.print("How many students do you have? ");
	    String  input = keyboard.readLine();
	    int   numlines = Integer.parseInt(input);*/
	      
		// Get the file name.
		System.out.print("Enter the name of a file: ");
		String filename = keyboard.nextLine();

		// Open the file.connect and read the file.
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		// Read the first line from the file.
		String line = inputFile.nextLine();

		// Display the line.
		System.out.println("The first line in the file is :");
		System.out.println(line);

		// Read the first line from the file.
		String line2 = inputFile.nextLine();

		// Display the line.
		System.out.println("The second line in the file is :");
		System.out.println(line2);

		// Read lines from the file until no more are left.
		while (inputFile.hasNext())
		{
			System.out.println(inputFile.nextLine());
		}

		// Close the file.
		inputFile.close();
	}


	/*write a program for binary search taken 5 i/p from user as binary elements*/
	@Test(enabled= false)
	public void BinarySearch() {
		int[] numArray = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter five numbers: ");
		for (int i = 0; i < 5 && sc.hasNextInt(); i++) {
			numArray[i] = sc.nextInt();
			System.out.println(numArray[i]);
		}

		System.out.println("Enter the search number: ");
		int searchNum = sc.nextInt();
		System.out.println( searchNum+ " ");

		for(int i=0; i < numArray.length-1;i++){
			for(int j=0;j < numArray.length-i-1;j++){
				//System.out.println(numArray[j]);
				if(numArray[j] > numArray[j+1]){
					int swap = numArray[j];
					numArray[j] = numArray[j+1];
					numArray[j+1] = swap;
				}				
			}			
		}

		int lowNumber = 0;
		int highNumber = numArray.length;
		Boolean Found = true;

		while(lowNumber < highNumber) {
			int midNumber = (lowNumber+highNumber) / 2;
			if(searchNum == numArray[midNumber]){

				System.out.println("Number list exists " + searchNum +".");	
				Found = false;
				break;
			}
			else if(searchNum > numArray[midNumber]){
				lowNumber= midNumber+1;	
			}
			else{
				highNumber= midNumber-1;
			} 			
		}


		if(Found) {
			System.out.println("Number list exists " + searchNum +".");
		}
	}



	// write a program to bubble sort. And 6 i/p has to take from user as bubble elements.
	//@Test(priority=0)
	public void BubbleSort(){
		int[] array = {12,13,14,15,16,17, 18, 19 , 20 ,11, };

		//Scanner sc = new Scanner(System.in);
		//for (int i = 0; i < array.length && sc.hasNextInt(); i++) {
		//	array[i] = sc.nextInt(); }	

		/*for(int i=0; i<array.length-1; i++){
			for(int j=0; j<array.length-i-1; j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]= temp;
				}				
			}			
		}*/

		Arrays.sort(array);

		System.out.print("Sorted list : ");
		for(int sortedStr : array){
			System.out.print(sortedStr+" ");
		}
	}


	//  write a program for linear search. And 5 i/p has to take from user as linear elements.
	//@Test(dependsOnMethods={"BubbleSort"})
	public void LinearSearch(){
		//Scanner sc = new Scanner(System.in);

		int[] numArray = {23,24,25,26,28};
		System.out.print("Enter 5 numbers :" );
		for (int i = 0; i < numArray.length ; i++) {
			System.out.print( " " +numArray[i]);
		}

		System.out.println();

		int searchNumber = 30; 
		boolean numberFound = true; 
		System.out.println("search number : " + searchNumber);

		for(int i=0; i < numArray.length; i++){
			if(numArray[i] == searchNumber){
				System.out.println(searchNumber+ " exists in the list");
				//	numberFound = false;
				break;
			}

		}if(numberFound){
			System.out.println(searchNumber+" does not exist in the list");}

	}


	//	@Test(priority=2)
	public void Palindrome() {
		String str="abbalevelabba";
		char[] str1 = str.toCharArray();
		Boolean result = true;

		for(int i=0, j= str.length() -1 ; i < str.length(); i++,j--)
			if (str1[i] == str1[j]){
				continue;
			}
			else { 
				result= false;
				break; 
			} 

		if (result) { 
			System.out.println( str + " is a Palindrome.");} 
		else { 
			System.out.println( str + " is not a Palindrome.");
		}
	}


	//@Test(enabled=false)
	public void ConsecutiveNumber(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number");
		int number = sc.nextInt();
		System.out.println("Entered number :" + number);

		//int number = 9;

		System.out.println("Consecutive numbers : ");
		for(int i=1; i < number; i++){
			int sum = 0;
			for(int j=i; j < number; j++){
				sum = sum + j;
				if(sum == number){
					for(int k=i; k <=j ; k++){
						if(k == i){
							System.out.print(k);
						}
						else{
							System.out.print(" + " +k);
						}
					}
					System.out.println();
				}
				else if(sum > number){
					break;
				}
			}
		}
	}


	//Find the shortest and the longest word in a sentence and 
	//print them along with their length.
	//@Test(priority=4)
	public void CountofWords(){
		//Scanner scan = new Scanner(System.in);
		//String str = "";

		int shortWord = 0, longWord = 0;
		String str = "I learn Java";

		//str = sc.nextLine();

		String[] strArray = str.split(" ");

		/*for(int i=0; i < strArray.length; i++){
				for(int j=0; j < strArray.length-i-1; j++){
					if(strArray[j].length() > strArray[j+1].length()){
						String swap =strArray[j];
						strArray[j] = strArray[j+1];
						strArray[j+1] = swap;
					}
				}
			}*/

		Arrays.sort(strArray);

		System.out.println("Shortest word : "+strArray[0]);
		System.out.println("Shortest word length : "+strArray[0].length());
		System.out.println("Longest word : "+strArray[strArray.length-1]);
		System.out.println("Longest word length : "
				+strArray[strArray.length-1].length());

	}


	// Input a number. Count and print the frequency of each digit 
	//present in that number.
	//@Test(priority=5)
	public void FrequentOfDigits(){
		//Scanner sc=new Scanner(System.in);
		//int inputNum = sc.nextInt();

		int inputNum = 445;
		int[] outputArray = new int[10];
		int Modu =0;

		while(inputNum != 0){
			Modu = inputNum % 10; 
			inputNum = inputNum/10; 
			outputArray[Modu]++;
			System.out.print("Frequency of modulus elements outputArray  : " );
			System.out.println(outputArray[Modu]);
			//5 is 1 time, 4 is 1 time and another 4 is one more time ie., 2.
		}
		System.out.println();

		for(int i=0; i < outputArray.length; i++){
			if(outputArray[i] != 0){
				System.out.println(outputArray[i] +" frequent of " +  i);
			}
		}		
	}


	//Find the Least Common Multiple (L.C.M.) of two numbers entered by the user.
	//@Test(priority=6)
	public void LeastCommonMultiple(){
		//Scanner sc=new Scanner(System.in);
		//System.out.print("Enter the first number: ");
		int input1 = 336;
		//System.out.print("Enter the second number: ");
		int input2 = 224;
		int lcm = 1;
		System.out.println();
		System.out.print("Least Common Multiple : ");
		for(int i=2 ; i < input1 && i < input2; i++) {
			if(input1 % i == 0 && input2 % i == 0){
				input1 = input1 / i;
				input2 = input2 / i;
				lcm = lcm * i;
				i--;
			}
		}

		lcm = lcm * input1 * input2; 
		System.out.println(lcm);
	}



	//@Test(priority=7)
	public void PatternString(){
		//String date = "01/27/2015";
		String date = "JAN/27/2015";
		String[] strArray = date.split("/");

		System.out.print("The Month is "+ strArray[0] + ",");
		System.out.print(" the Day is " + strArray[1] + ", and");
		System.out.print(" the Year is " + strArray[2]+"."); 

		System.out.println();

		String pattern = "MM-dd-yyyy";   
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		System.out.println(formatter.format(new Date()));
	}


	// Write a function to find out longest palindrome in a given string.
	@Test(enabled=false)
	public void LongestPalindrome(){
		Scanner sc= new Scanner(System.in);
		System.out.print("pleae enter a string : ");
		String str = sc.nextLine();
		longestPalindrome(str);
	}

	private static Boolean isPalindrome(String str) {
		StringBuffer strBuff = new StringBuffer(str);
		strBuff.reverse();
		if(str.contentEquals(strBuff)){
			return true;
		}
		else
			return false;
	}	
	public static void longestPalindrome(String str){
		String subStr = new String();
		String newStr = "";
		String longStr = new String();

		char c;
		int index = 0, count = 0;
		Boolean isTrue = true;

		for (int i = 0; i < str.length(); i++) {
			subStr =str.substring(i, str.length()); 
			while (subStr.length()>0){ 
				c = subStr.charAt(0);				
				if ( subStr.lastIndexOf(c) >= 0) {
					index=subStr.lastIndexOf(c);
					subStr = subStr.substring(0, index);
					newStr = subStr+c;	
					if(isPalindrome(subStr+c)){
						if(count<newStr.length()){
							count=newStr.length();
							longStr =newStr;
						}
						isTrue =false;
					}
					else{
						isTrue =true;
					}					

				} else {
					break;
				}
			}
		}
		if(isTrue){
			System.out.println("The given string has no palindrome");	
		}else{
			System.out.println("Longest Palindrome : "+longStr);
		}

	}


	//a program to print all permutations of String
	//@Test(priority=8)
	public void Permutation(){
		System.out.println("Enter String");
		Scanner s=new Scanner(System.in);
		String st = s.nextLine();
		combString(st);
		s.close();
	}

	public static void combString(String s) {
		// Print initial string, as only the alterations will be printed later
		System.out.println(s);   
		char[] a = s.toCharArray();
		int n = a.length;

		int[] p = new int[n];  // Index control array initially all zeros
		int i = 1;
		while (i < n) {
			if (p[i] < i) {
				int j = ((i % 2) == 0) ? 0 : p[i];
				swap(a, i, j);
				// Print current
				System.out.println(join(a));
				p[i]++;
				i = 1;
			}
			else {
				p[i] = 0;               
				i++;
				System.out.println("******in else****" + i);
			}
		}
	}

	private static String join(char[] a) {
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}

	private static void swap(char[] a, int i, int j) {
		char tempChar = a[i];
		a[i] = a[j];
		a[j] = tempChar;

	}


	//@Test(priority=9)
	public void StringPermutations(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the string to permute : ");
		String str= sc.nextLine();
		permuteString(str);

	}

	public static void permuteString(String str) {
		int k = 1;
		char[] charArray = str.toCharArray();		
		char[] copyArray = new char[charArray.length]; 

		//copy values of charArray to copyArray
		copyToCharArray(charArray,copyArray);

		// if the string length is 1, printing the character
		if(str.length() == 1){
			System.out.println(str);
		}
		//checking if the string length is 2 then printing the string and reversed string
		else if (str.length() == 2) {	
			System.out.println(str);
			System.out.print(str.charAt(1));
			System.out.println(str.charAt(0));
		} 
		// string length is more than 2 then perform the permutation
		else {	
			System.out.println(String.valueOf(copyArray));
			for (int i = 0; i < copyArray.length * (copyArray.length - 1); i++) {
				for (int j = 1; j < copyArray.length - 1; j++) {

					//swapping the characters
					swap2(copyArray, j, j+1);

					// checking if the string of charArray is same as the copyArray
					if (String.valueOf(charArray).equals(String.valueOf(copyArray))) {
						//checking the charArray length is not greater than k value, 
						//otherwise it will throw an arrayoutofbound exception
						if (k > charArray.length - 1) {
							break;
						}

						// swapping the first character of a string with the adjacent character
						swap2(copyArray, 0, k);
						k++;

						//coping the value of copyArray to charArray
						copyToCharArray(copyArray, charArray);											
					}
					// printing the result
					System.out.println(String.valueOf(copyArray));
				}

			}
		}

	}

	public static void swap2(char[] charArray,int index1, int index2){
		char swap = charArray[index1];
		charArray[index1] = charArray[index2];
		charArray[index2] = swap;
	}

	public static void copyToCharArray(char[] originalArray, char[] copyToArray){
		for(int i=0; i<originalArray.length; i++){
			copyToArray[i] = originalArray[i];
		}

	}


	//@Test(priority=10)
	public void array(){
		Scanner s = new Scanner(System.in);

		/* 2 D array */
		String[][] cities = new String[2][3];

		//rows and columns
		int iRowcount = cities.length;
		int iColumnCount = cities[0].length;
		System.out.println("Row count in cities Array is : " + iRowcount);
		System.out.println("Column count for zeroth row for cities Array is : " 
				+ iColumnCount);

		System.out.print("Please enter the names of the 6 cities \n");

		//each row and column
		for(int j1 = 0; j1< iRowcount; j1++){
			for(int i =0; i <iColumnCount ; i ++){
				cities[j1][i] = s.nextLine();
			}
		}

		System.out.println("Cities names are :");
		for(int j1 = 0; j1< iRowcount; j1++){
			for(int i =0; i <iColumnCount ; i ++){
				System.out.println(cities[j1][i]);
			}
		}

		//Array
		System.out.println("Array : \n" + "Enter Names for 5 people ");
		String[] names = new String[5];

		for(int j = 0 ; j < names.length; j++){
			names[j]= s.nextLine();
		}

		System.out.println("Names are");

		for(int j = 0; j < names.length; j++ ){
			System.out.println(names[j]);
		}

		//<Data type> <Name of an array > = new <Data type>[Length]
	}


}


