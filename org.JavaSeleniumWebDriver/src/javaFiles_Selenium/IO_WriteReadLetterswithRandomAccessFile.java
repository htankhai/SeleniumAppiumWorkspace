package javaFiles_Selenium;
import java.io.*;

/**
   This program uses a RandomAccessFile object to create the file Letters.dat. The letters of the
   alphabet are written to the file.
   uses the RandomAccessFile class to open the file Letters.dat and randomly read letters from
   different locations.
 */

public class IO_WriteReadLetterswithRandomAccessFile {
	public static void main(String[] args) throws IOException  {
		WriteLetters();
		ReadLetters();
	}
	
	public static void WriteLetters() throws IOException{
		// The letters array has all 26 letters.
		char[] letters = {
				'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z' };

		System.out.println("Opening the file.");

		// Open a file for reading and writing.
		RandomAccessFile randomFile =
				new RandomAccessFile("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\Letters.dat", "rw");

		System.out.println("Writing data to the file...");

		// Sequentially write the letters array to the file.
		for (int i = 0; i < letters.length; i++)
			randomFile.writeChar(letters[i]);

		// Close the file.
		randomFile.close();

		System.out.println("Done.");
	}
	
	public static void ReadLetters() throws IOException{
		       final int CHAR_SIZE = 2;// 2 byte characters
		      long byteNum;         
		      char ch;              
		      
		      // Open the file for reading.
		      RandomAccessFile randomFile =
		                  new RandomAccessFile("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\Letters.dat", "r");
		      
		      // Move to the character 5. This is the 6th 
		      // character from the beginning of the file.
		      byteNum = CHAR_SIZE * 5;
		      randomFile.seek(byteNum);
		      
		      // Read the character stored at this location and display it. Should be the letter f.
		      ch = randomFile.readChar();
		      System.out.println(ch);
		      
		      // Move to character 10 (the 11th character), read the character, and display it.
		      // Should be the letter k.
		      byteNum = CHAR_SIZE * 10;
		      randomFile.seek(byteNum);
		      ch = randomFile.readChar();
		      System.out.println(ch);
		      
		      // Move to character 3 (the 4th character), read the character, and display it.
		      // Should be the letter d.
		      byteNum = CHAR_SIZE * 3;
		      randomFile.seek(byteNum);
		      ch = randomFile.readChar();
		      System.out.println(ch);
		      
		      // Close the file.
		      randomFile.close();
	}
}