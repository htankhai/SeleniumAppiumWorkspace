package org.url;
import java.net.HttpURLConnection;
import java.net.URL;

public class URL_HttpURLConnectionDemo {
	public static void main(String[] args){    

		try{    
			//URL url=new URL("http://www.javatpoint.com/java-tutorial");  
			//URL url=new URL("file:///C:/Users/htan/Desktop/Link/Link.html");
			//URL url=new URL("https://www.google.com/");

			URL url=new URL("https://www.facebook.com/");
			System.out.println("Protocol: "+url.getProtocol());  
			System.out.println("Host Name: "+url.getHost());  
			System.out.println("Port Number: "+url.getPort());  
			System.out.println("Query: "+ url.getQuery());
			System.out.println("File Name: "+url.getFile());  


			HttpURLConnection huc=(HttpURLConnection)url.openConnection();  

			for(int i=1;i<=8;i++){  
				System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));  
			}  
			huc.disconnect();   
		}
		catch(Exception e){
			System.out.println(e);
		}  
		
		
	} 
}
