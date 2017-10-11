package communication.udpCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSendThread implements Runnable{
	
	private String address;
	private int port;
	private String message = "default";
	
	public UdpSendThread(String address, int port) {
		super();
		this.address = address;
		this.port = port;
	}
	
	@Override
	public void run() {
		try {
			byte[] data = message.getBytes();
			DatagramPacket pack = new DatagramPacket(data, data.length,InetAddress.getByName(address), port);
			DatagramSocket socket = new DatagramSocket();
			
			while(true)
			{
					socket.send(pack);
					
					System.out.println("message has been send");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		
		
	}

}
