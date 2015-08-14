package org.url;
//Sending packet
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramPacketSender {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket ds = new DatagramSocket(); 
		
	    String str = "Welcome java"; 
	    
	    InetAddress ip = InetAddress.getByName("127.0.0.1");  
	     
	    //Sending packet
	    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3001);  
	    ds.send(dp);  
	    ds.close();
	    System.out.println("Success sending");
	}

}
