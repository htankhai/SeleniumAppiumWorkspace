package javaFiles_Selenium;
/**
   This program reads UTF-8 encoded strings from a binary file.
opens a binary file and writes a series
 */
import java.io.*;

public class IO_ReadWriteUTF{
	public static void main(String[] args) throws IOException  {
		ReadUTF();
		WriteUTF();
	}

	public static void ReadUTF() throws IOException{
		String name;
		boolean endOfFile = false;

		// Create the input objects.
		FileInputStream fstream =
				new FileInputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\UTFnames.dat");
		DataInputStream inputFile =
				new DataInputStream(fstream);

		System.out.println("Reading the names from the file:");

		// Read the contents of the file.
		while (!endOfFile)      {
			try {
				name = inputFile.readUTF();
				System.out.print(name + " ");
			}
			catch (EOFException e) {
				endOfFile = true;
			}
		}

		System.out.println("Done.");

		// Close the file.
		inputFile.close();     
	}

	public static void WriteUTF() throws IOException{

		String names[] = { "Warren", "Becky", "Holly", 
				"Zach", "Chloe" };

		// Create the output objects.
		FileOutputStream fstream =
				new FileOutputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\UTFnames.dat");
		DataOutputStream outputFile =
				new DataOutputStream(fstream);

		System.out.println("Writing the names to the file...");

		// Write the array elements to the file.
		for (int i = 0; i < names.length; i++)
			outputFile.writeUTF(names[i]);

		System.out.println("Done.");

		// Close the file.
		outputFile.close();     
	}
}
