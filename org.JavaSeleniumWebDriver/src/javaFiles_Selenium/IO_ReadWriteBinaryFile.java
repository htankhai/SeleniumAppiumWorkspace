package javaFiles_Selenium;
import java.io.*;

/** This program opens a binary file, reads and displays the contents.
 * opens a binary file and writes the contents of an int array to the file.
*/

public class IO_ReadWriteBinaryFile {
   public static void main(String[] args) throws IOException   {
	   ReadInt_BinaryFile();
	   WriteBinaryFile();
   }
   
   public static void ReadInt_BinaryFile() throws IOException{
      int number; // A number read from the file
      boolean endOfFile = false;     // EOF flag
      
      // Create the binary file input objects.
      FileInputStream fstream =
                new FileInputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\Numbers.dat");
      DataInputStream inputFile =
               new DataInputStream(fstream);
    
      System.out.println("Reading numbers from the file:");

      // Read the contents of the file.    
      while (!endOfFile)
      {
         try
         {
            number = inputFile.readInt();
            System.out.print(number + " ");
         }
         catch (EOFException e)
         {
            endOfFile = true;
         }
      }

      System.out.println("Done.");
      
      // Close the file.
      inputFile.close();   
   }
   
  public static void WriteBinaryFile() throws IOException{
   // An array to write to the file
   int[] numbers = { 2, 4, 6, 8, 10, 12, 14,35,45,55,65,75,80,100 };
   
   // Create the binary output objects.
   FileOutputStream fstream =
            new FileOutputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\Numbers.dat");
   DataOutputStream outputFile =
            new DataOutputStream(fstream);
 
   System.out.println("Writing the numbers to the file...");

   // Write the array elements to the file.    
   for (int i = 0; i < numbers.length; i++)
      outputFile.writeInt(numbers[i]);
 
   System.out.println("Succeed writing the file.");
   
   // Close the file.
   outputFile.close();   
  }
}