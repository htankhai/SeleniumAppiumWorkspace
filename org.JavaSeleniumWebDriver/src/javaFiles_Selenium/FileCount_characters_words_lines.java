package javaFiles_Selenium;
/*count number of letters, lines,and words in a text file */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileCount_characters_words_lines {
	public static void main(String[] args) throws FileNotFoundException	{
		Scanner reader;
		reader = 
		new Scanner(new FileInputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\OverloadingMethod_Class1.java"));
		
		//word, character and line
		int line = 0, word=0,character=0;
		
		//Count line
		while(reader.hasNextLine())
		{
		line++;
		reader.nextLine();
		}
		reader.close();
		
		
		reader =
		new Scanner(new FileInputStream("C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\OverloadingMethod_Class1.java"));
		
		//count number of word and characters
		while(reader.hasNext())
		{
		String s=reader.next();
		word++;
		character=character+s.length();
		}

		//number of lines
		while(reader.hasNextLine())
		{
		line++;
		reader.nextLine();
		}
		
		reader.close();
		
		System.out.println("Word:"+word);
		System.out.println("Char:"+character);
		System.out.println("Lines:"+line);

	}

}
