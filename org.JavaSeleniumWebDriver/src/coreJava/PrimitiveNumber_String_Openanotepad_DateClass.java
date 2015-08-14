package coreJava;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimitiveNumber_String_Openanotepad_DateClass {
	public static void main(String args[]) {
		int i = (byte) + (char) - (int) + (long) - 1;

		System.out.println(i);

		System.out.println(1);

		//http is as label and the rest part as commented.
		http://javaconceptoftheday.com/

			System.out.println(2);


		String[] s1 = {"ONE", "TWO", "THREE", "FOUR"};

		String[] s2 = {"THREE", "TWO", new String("ONE")};

		System.out.println(s1[0] == s2[2]);

		System.out.println(s1[1] == s2[1]);

		System.out.println(s1[2] == s2[0]);

		//Open a notepad in your system through a java program
		try        {
			Runtime.getRuntime().exec("notepad.exe");
		}
		catch (IOException e)        {
			e.printStackTrace();
		}

		//Date
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(formatter.format(date));
	}
}
