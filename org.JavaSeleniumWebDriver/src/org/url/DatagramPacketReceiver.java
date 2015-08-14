package org.url;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramPacketReceiver {
	public static void main(String[] args) throws IOException {
		// create socket
		DatagramSocket ds = new DatagramSocket(3004); 
		
		byte[] buf = new byte[1024];  
		
		//create receiving DatagramPacket
		DatagramPacket dp = new DatagramPacket(buf, 1024);  
		ds.receive(dp);  
		
		String str = new String(dp.getData(), 0, dp.getLength());  
		System.out.println(str);  
		ds.close();  
		
	}
}
