package org.url;
// get source code of google home page
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class URLReader {
	static String inputLine = "";

	public static void main(String[] args)throws Exception	{
		URL myURL = new URL("http://www.google.com//");
		BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
		String inputLine;

		while((inputLine=in.readLine())!=null)		{
			System.out.println(inputLine);
		}
		in.close();
	}
}
