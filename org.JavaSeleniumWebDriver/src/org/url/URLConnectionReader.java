package org.url;
//get the source code of a web page
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class URLConnectionReader {
	static String inputLine = "";

	public static void main(String[] args)throws Exception 	{
		URL myURL = new URL("http://www.google.com//");
		URLConnection yc = myURL.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

		while(inputLine!=null) 		{
			inputLine = in.readLine();
			System.out.println(inputLine);
		}
		in.close();
	}
}
