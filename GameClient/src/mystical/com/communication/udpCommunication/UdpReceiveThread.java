package mystical.com.communication.udpCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UdpReceiveThread extends Thread{

	private int port;
	
	public UdpReceiveThread(int port)
	{
		super();
		this.port = port;
		this.setName("UdpReceiveThread");
	}
	@Override
	public void run() {
		try {
			
			byte[] buf=new byte[1024*64];  
			DatagramSocket socket = new DatagramSocket(port);;
			DatagramPacket pack=new DatagramPacket(buf,buf.length);   
			
			while(!this.isInterrupted())
			{
//				System.out.println("is waiting...");
				socket.receive(pack);
//				System.out.println("Udp receive : " +new String(buf,0,pack.getLength()));
				UdpCommunnication.setMessage(new String(buf,0,pack.getLength()));
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
