package javaFiles_Selenium;
import java.util.Arrays;
public class Array_arrayCopy_copyofRange_App {
	public static void main(String[] args) 	{
		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
				'i', 'n', 'a', 't', 'e', 'd' };
		char[] copyTo = new char[8];

		System.arraycopy(copyFrom, 2, copyTo, 1, 7);
		System.out.println("copyTo :" + new String(copyTo)); 

		char[] copyTo2 = Arrays.copyOfRange(copyFrom, 2, 9);
		System.out.println("copyTo2 :" + new String(copyTo2));
	}
}