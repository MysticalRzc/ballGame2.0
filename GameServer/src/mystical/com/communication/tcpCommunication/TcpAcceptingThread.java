package mystical.com.communication.tcpCommunication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpAcceptingThread extends Thread{
	
	/**
	 *Tcp wait thread 
	 *is running on server only
	 *build a server if client connect it will return an socket to Tcpcommunitation
	 */
	
	final private ServerSocket ssocket;
	
	public TcpAcceptingThread() throws IOException
	{
		ssocket = new ServerSocket(5678);
	}
	@Override
	public void run()
	{
		while(true)
		{
			try {
				System.out.println("accept...");
				Socket socket = ssocket.accept();
				
//				OutputStream out = socket.getOutputStream();
//				out.write('s');
				
				TcpCommunication.buildClientAlert(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
