package javaFiles_Selenium;
import java.io.*;

/**This program demonstrates reading a file using only a FileReader object 
 * writing to a file using only a FileWriter object.*/

public class IO_FileReaderWriter{
	public static void main(String[] args)  {
		FileReader();
		FileWriter();
		
	}
		public static void FileReader(){
		int rawData;        // To hold a character code
		char ch;            // To hold a character

		try
		{
			// Open the file.
			FileReader freader =
					new FileReader("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\FileReader.txt");
							
									
			// Read a character code from the file.
			rawData = freader.read();
			while (rawData != -1)
			{
				// Convert the code to a character.
				ch = (char) rawData;
				// Print the character.
				System.out.print(ch);
				
				// Get the next code from the stream.
				 rawData = freader.read();
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: " +
					e.getMessage());
		}
	}
		
		public static void FileWriter(){
			 			      // A string to write to the file.
			      String output = "To thine own self be true.";
			      int rawData;        // To hold a character code

			      try
			      {
			         // Open the file.
			         FileWriter fwriter =
			                new FileWriter("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\WriterFile.txt");

			         // 
			         for (int i = 0; i < output.length(); i++)
			         {
			            // Convert a character to Unicode.
			            rawData = (int) output.charAt(i);
			            
			            // Write the Unicode.
			            fwriter.write(rawData);
			         }
			         
			         System.out.println("Succeed writing the file");
			         
			         // Close the file.
			         fwriter.close();
			      }
			      catch (IOException e)
			      {
			         System.out.println("Error: " +
			                            e.getMessage());
			      }
		}
}