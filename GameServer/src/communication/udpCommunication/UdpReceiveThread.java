package communication.udpCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveThread implements Runnable{

	@Override
	public void run() {
		try {
			
			byte[] buf=new byte[1024*64];  
			DatagramSocket socket = new DatagramSocket();;
			DatagramPacket pack=new DatagramPacket(buf,buf.length);   
			
			while(true)
			{
				System.out.println("is waiting...");
				socket.receive(pack);
				System.out.println("receive : " +new String(buf,0,pack.getLength()));
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
