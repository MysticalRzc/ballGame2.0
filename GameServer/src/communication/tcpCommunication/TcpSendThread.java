package communication.tcpCommunication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TcpSendThread implements Runnable{
	
	private String address;
	private int port;
	private String message = "default";
	
	public TcpSendThread(String address, int port) {
		super();
		this.address = address;
		this.port = port;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(30000);
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println(" hello is server");
			while(true)
			{
				ps.println(" hello is server");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
